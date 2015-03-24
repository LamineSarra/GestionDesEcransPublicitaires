package com.stage.pfe.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stage.pfe.dao.HibernateUtil;
import com.stage.pfe.dao.JourHome;
import com.stage.pfe.persistance.Jour;


public class JourService {
	private JourHome dao;
	
	
	public JourService()
	{dao=new JourHome();}
	
	public List<Jour> rechercheTousJour() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Jour> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Jour>) dao.findAll();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}


	public void ajouterJour(Jour u) {
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


	public void suprimerJour(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {Jour u=new Jour();
		u.setIdJour(id);
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

	public void modifierJour(Jour u) {
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
