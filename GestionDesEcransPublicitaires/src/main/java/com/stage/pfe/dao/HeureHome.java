package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Heure;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Heure.
 * @see com.Heure.supervision.dao.Heure
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class HeureHome {

//	private static final Log log = LogFactory.getLog(HeureHome.class);

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

	public void persist(Heure transientInstance) {
		//log.debug("persisting Heure instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Heure instance) {
		//log.debug("attaching dirty Heure instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Heure instance) {
		//log.debug("attaching clean Heure instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Heure persistentInstance) {
		//log.debug("deleting Heure instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Heure merge(Heure detachedInstance) {
		//log.debug("merging Heure instance");
		try {
			Heure result = (Heure) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Heure findById(Integer id) {
		//log.debug("getting Heure instance with id: " + id);
		try {
			Heure instance = (Heure) sessionFactory
					.getCurrentSession().get(
							Heure.class, id);
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

	public List<Heure> findByExample(Heure instance) {
		//log.debug("finding Heure instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Heure> results = (List<Heure>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Heure")
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
	public List<Heure> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Heure.class);
	return (List<Heure>)crit.list(); 
	}

	
	
	
	
	
	
}



