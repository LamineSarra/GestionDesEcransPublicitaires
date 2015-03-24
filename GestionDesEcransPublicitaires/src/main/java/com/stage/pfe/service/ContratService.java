package com.stage.pfe.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stage.pfe.dao.HibernateUtil;
import com.stage.pfe.dao.ContratHome;
import com.stage.pfe.persistance.Contrat;


public class ContratService {
	private ContratHome dao;
	
	
	public ContratService()
	{dao=new ContratHome();}
	
	public List<Contrat> rechercheTousContrat() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Contrat> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Contrat>) dao.findAll();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}


	public void ajouterContrat(Contrat u) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			 dao.persist(u);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}


	public void suprimerContrat(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {Contrat u=new Contrat();
		u.setIdContrat(id);
			// Ouverture d’une transaction
			tx = session.beginTransaction();
			dao.delete(u);
			tx.commit();

		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d’erreurs
			if (tx != null)
				tx.rollback();

			ex.printStackTrace();
		}
	}

	public void modifierContrat(Contrat u) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			// Ouverture d’une transaction
			tx = session.beginTransaction();
			dao.attachDirty(u);
			tx.commit();

		} catch (RuntimeException ex) {
			// Rollback de la transaction en cas d’erreurs
			if (tx != null)
				tx.rollback();

			ex.printStackTrace();
		}
	}
	
}
