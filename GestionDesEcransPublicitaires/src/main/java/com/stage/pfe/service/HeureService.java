package com.stage.pfe.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stage.pfe.dao.HibernateUtil;
import com.stage.pfe.dao.HeureHome;
import com.stage.pfe.persistance.Heure;


public class HeureService {
	private HeureHome dao;
	
	
	public HeureService()
	{dao=new HeureHome();}
	
	public List<Heure> rechercheTousHeure() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Heure> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Heure>) dao.findAll();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}


	public void ajouterHeure(Heure u) {
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


	public void suprimerHeure(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {Heure u=new Heure();
		u.setIdHeure(id);
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

	public void modifierHeure(Heure u) {
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
