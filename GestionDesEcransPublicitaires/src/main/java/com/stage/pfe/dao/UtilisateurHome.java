package com.stage.pfe.dao;

// Generated 11 avr. 2014 14:37:50 by Hibernate Tools 3.4.0.CR1

import java.util.List;



//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;





import com.stage.pfe.persistance.Utilisateur;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Utilisateur.
 * @see com.cimf.supervision.dao.Utilisateur
 * @author Hibernate Tools
 */
public class UtilisateurHome {

//	private static final Log log = LogFactory.getLog(UtilisateurHome.class);

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

	public void persist(Utilisateur transientInstance) {
		//log.debug("persisting Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Utilisateur instance) {
		//log.debug("attaching dirty Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Utilisateur instance) {
		//log.debug("attaching clean Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Utilisateur persistentInstance) {
		//log.debug("deleting Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Utilisateur merge(Utilisateur detachedInstance) {
		//log.debug("merging Utilisateur instance");
		try {
			Utilisateur result = (Utilisateur) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Utilisateur findById(Integer id) {
		//log.debug("getting Utilisateur instance with id: " + id);
		try {
			Utilisateur instance = (Utilisateur) sessionFactory
					.getCurrentSession().get(
							Utilisateur.class, id);
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

	public List<Utilisateur> findByExample(Utilisateur instance) {
		//log.debug("finding Utilisateur instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Utilisateur> results = (List<Utilisateur>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Utilisateur")
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
	public List<Utilisateur> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Utilisateur.class);
	return (List<Utilisateur>)crit.list(); 
	}

	
	
	//Verification d'utilisateur
	@SuppressWarnings("unchecked")
	public List<Utilisateur> findByLoginPassWord(String login, String mdp)
	{
		
		List<Utilisateur> results = (List<Utilisateur>) sessionFactory
				.getCurrentSession()
				.createCriteria(Utilisateur.class)
				.add(Restrictions.like("login",login))
				.add(Restrictions.like("mdp",mdp))
				.list();
			return results;
	}

	public Utilisateur findByLogin(String login) {

		
		Utilisateur results = (Utilisateur) sessionFactory
				.getCurrentSession()
				.createCriteria(Utilisateur.class)
				.add(Restrictions.like("login",login)).uniqueResult();
			return results;
		
	}
	
	
	
	
}
