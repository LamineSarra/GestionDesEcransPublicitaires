package com.stage.pfe.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stage.pfe.dao.HibernateUtil;
import com.stage.pfe.dao.PlanMsgHome;
import com.stage.pfe.persistance.PlanMsg;


public class PlanMsgService {
	private PlanMsgHome dao;
	
	
	public PlanMsgService()
	{dao=new PlanMsgHome();}
	
	public List<PlanMsg> rechercheTousPlanMsg() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<PlanMsg> user = null;
		try {
			tx = session.beginTransaction();

			user = (List<PlanMsg>) dao.findAll();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return user;
	}


	public void ajouterPlanMsg(PlanMsg u) {
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


	public void suprimerPlanMsg(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {PlanMsg u=new PlanMsg();
		u.setIdPlanMsg(id);
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

	public void modifierPlanMsg(PlanMsg u) {
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
