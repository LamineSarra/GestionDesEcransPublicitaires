package com.stage.pfe.dao;

// Generated 11 avr. 2014 14:37:50 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;







import com.stage.pfe.persistance.Client;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Client.
 * @see com.cimf.supervision.dao.Client
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ClientHome {

//	private static final Log log = LogFactory.getLog(ClientHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();
					
		} catch (Exception e) {
		//log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Client transientInstance) {
		//log.debug("persisting Client instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Client instance) {
		//log.debug("attaching dirty Client instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Client instance) {
		//log.debug("attaching clean Client instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Client persistentInstance) {
		//log.debug("deleting Client instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Client merge(Client detachedInstance) {
		//log.debug("merging Client instance");
		try {
			Client result = (Client) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Client findById(Integer id) {
		//log.debug("getting Client instance with id: " + id);
		try {
			Client instance = (Client) sessionFactory
					.getCurrentSession().get(
							Client.class, id);
			if (instance == null) {
			//	log.debug("get successful, no instance found");
			} else {
			//	log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			throw re;
		}
	}

	public List<Client> findByExample(Client instance) {
		//log.debug("finding Client instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Client> results = (List<Client>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Client")
					.add(create(instance)).list();
			//log.debug("find by example successful, result size: "
				//	+ results.size());
			return results;
		} catch (RuntimeException re) {
		//	log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Client> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Client.class);
	return (List<Client>)crit.list(); 
	}

	
	
	//Verification d'utilisateur
	@SuppressWarnings("unchecked")
	public List<Client> findByLoginPassWord(String login, String mp)
	{
		
		List<Client> results = (List<Client>) sessionFactory
				.getCurrentSession()
				.createCriteria(Client.class)
				.add(Restrictions.like("login",login))
				.add(Restrictions.like("motdepasse",mp))
				.list();
			return results;
	}

	public Client findByLogin(String login) {

		
		Client results = (Client) sessionFactory
				.getCurrentSession()
				.createCriteria(Client.class)
				.add(Restrictions.like("login",login)).list();
			return results;
		
	}
	
	public Client findByValidite(boolean validite) {

		
		Client results = (Client) sessionFactory
				.getCurrentSession()
				.createCriteria(Client.class)
				.add(Restrictions.like("validite",validite)).list();
			return results;
		
	}
	
	
	
	
}
