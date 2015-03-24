package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Ecran;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Ecran.
 * @see com.Ecran.supervision.dao.Ecran
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class EcranHome {

//	private static final Log log = LogFactory.getLog(EcranHome.class);

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

	public void persist(Ecran transientInstance) {
		//log.debug("persisting Ecran instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ecran instance) {
		//log.debug("attaching dirty Ecran instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Ecran instance) {
		//log.debug("attaching clean Ecran instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ecran persistentInstance) {
		//log.debug("deleting Ecran instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Ecran merge(Ecran detachedInstance) {
		//log.debug("merging Ecran instance");
		try {
			Ecran result = (Ecran) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Ecran findById(Integer id) {
		//log.debug("getting Ecran instance with id: " + id);
		try {
			Ecran instance = (Ecran) sessionFactory
					.getCurrentSession().get(
							Ecran.class, id);
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

	public List<Ecran> findByExample(Ecran instance) {
		//log.debug("finding Ecran instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Ecran> results = (List<Ecran>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Ecran")
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
	public List<Ecran> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Ecran.class);
	return (List<Ecran>)crit.list(); 
	}

	
	
	
	
	
	
}



