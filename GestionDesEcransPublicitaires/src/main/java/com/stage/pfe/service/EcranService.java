package com.stage.pfe.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stage.pfe.dao.HibernateUtil;
import com.stage.pfe.dao.EcranHome;
import com.stage.pfe.persistance.Ecran;


public class EcranService {
	private EcranHome dao;
	
	
	public EcranService()
	{dao=new EcranHome();}
	
	public List<Ecran> rechercheTousEcran() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Ecran> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Ecran>) dao.findAll();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}


	public void ajouterEcran(Ecran u) {
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


	public void suprimerEcran(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {Ecran u=new Ecran();
		u.setIdEcran(id);
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

	public void modifierEcran(Ecran u) {
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
