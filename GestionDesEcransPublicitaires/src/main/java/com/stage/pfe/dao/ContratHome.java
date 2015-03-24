package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Contrat;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Contrat.
 * @see com.Contrat.supervision.dao.Contrat
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class ContratHome {

//	private static final Log log = LogFactory.getLog(ContratHome.class);

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

	public void persist(Contrat transientInstance) {
		//log.debug("persisting Contrat instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Contrat instance) {
		//log.debug("attaching dirty Contrat instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Contrat instance) {
		//log.debug("attaching clean Contrat instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Contrat persistentInstance) {
		//log.debug("deleting Contrat instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Contrat merge(Contrat detachedInstance) {
		//log.debug("merging Contrat instance");
		try {
			Contrat result = (Contrat) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Contrat findById(Integer id) {
		//log.debug("getting Contrat instance with id: " + id);
		try {
			Contrat instance = (Contrat) sessionFactory
					.getCurrentSession().get(
							Contrat.class, id);
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

	public List<Contrat> findByExample(Contrat instance) {
		//log.debug("finding Contrat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Contrat> results = (List<Contrat>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Contrat")
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
	public List<Contrat> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Contrat.class);
	return (List<Contrat>)crit.list(); 
	}

	
	
	
	
	
	
}



