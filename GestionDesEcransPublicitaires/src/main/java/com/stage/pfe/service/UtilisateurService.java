package com.stage.pfe.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stage.pfe.dao.HibernateUtil;
import com.stage.pfe.dao.UtilisateurHome;
import com.stage.pfe.persistance.Utilisateur;


public class UtilisateurService {
	private UtilisateurHome dao;
	
	
	public UtilisateurService()
	{dao=new UtilisateurHome();}
	
	public List<Utilisateur> rechercheTousUtilisateur() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Utilisateur> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Utilisateur>) dao.findAll();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}
	
	public List<Utilisateur> RechercheParLoginMP(String log, String mp)
	{Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx = null;
	List<Utilisateur> user = null;
	try {
		tx = session.beginTransaction();

		user = (List<Utilisateur>) dao.findByLoginPassWord(log, mp);
		tx.commit();
	} catch (RuntimeException ex) {
		if (tx != null)
			tx.rollback();
		ex.printStackTrace();
	}
	return user;
	
	}

	public void ajouterUtilisateur(Utilisateur u) {
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

	public Utilisateur RechercheParLogin(String login) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Utilisateur u=null;
		try {
			tx = session.beginTransaction();
			u=dao.findByLogin(login);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return u;
	}

	public void suprimerUtilisateur(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {Utilisateur u=new Utilisateur();
		u.setIdutilisateur(id);
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

	public void modifierUtilisateur(Utilisateur u) {
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
