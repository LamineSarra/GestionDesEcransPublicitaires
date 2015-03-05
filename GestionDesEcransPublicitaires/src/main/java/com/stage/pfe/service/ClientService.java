package com.stage.pfe.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stage.pfe.dao.HibernateUtil;
import com.stage.pfe.dao.ClientHome;
import com.stage.pfe.persistance.Client;


public class ClientService {
	private ClientHome dao;
	
	
	public ClientService()
	{dao=new ClientHome();}
	
	public List<Client> rechercheTousClient() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Client> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Client>) dao.findAll();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}
	@SuppressWarnings("unchecked")
	public List<Client> rechercheClientValides() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Client> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Client>) dao.findByValidite(true);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> rechercheClientsInvalides() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Client> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<Client>) dao.findByValidite(false);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}
	
	
	
	public List<Client> RechercheParLoginMP(String log, String mp)
	{Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx = null;
	List<Client> user = null;
	try {
		tx = session.beginTransaction();

		user = (List<Client>) dao.findByLoginPassWord(log, mp);
		tx.commit();
	} catch (RuntimeException ex) {
		if (tx != null)
			tx.rollback();
		ex.printStackTrace();
	}
	return user;
	
	}

	public void ajouterClient(Client u) {
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

	public Client RechercheParLogin(String login) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Client u=null;
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

	public void suprimerClient(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {Client u=new Client();
		u.setIdClient(id);
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

	public void modifierClient(Client u) {
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
