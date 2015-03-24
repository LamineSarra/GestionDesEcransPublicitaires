package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Jour;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Jour.
 * @see com.Jour.supervision.dao.Jour
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class JourHome {

//	private static final Log log = LogFactory.getLog(JourHome.class);

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

	public void persist(Jour transientInstance) {
		//log.debug("persisting Jour instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Jour instance) {
		//log.debug("attaching dirty Jour instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Jour instance) {
		//log.debug("attaching clean Jour instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Jour persistentInstance) {
		//log.debug("deleting Jour instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Jour merge(Jour detachedInstance) {
		//log.debug("merging Jour instance");
		try {
			Jour result = (Jour) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Jour findById(Integer id) {
		//log.debug("getting Jour instance with id: " + id);
		try {
			Jour instance = (Jour) sessionFactory
					.getCurrentSession().get(
							Jour.class, id);
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

	public List<Jour> findByExample(Jour instance) {
		//log.debug("finding Jour instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Jour> results = (List<Jour>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Jour")
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
	public List<Jour> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Jour.class);
	return (List<Jour>)crit.list(); 
	}

	
	
	
	
	
	
}



