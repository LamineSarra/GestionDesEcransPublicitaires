package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Plan;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Plan.
 * @see com.Plan.supervision.dao.Plan
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class PlanHome {

//	private static final Log log = LogFactory.getLog(PlanHome.class);

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

	public void persist(Plan transientInstance) {
		//log.debug("persisting Plan instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Plan instance) {
		//log.debug("attaching dirty Plan instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Plan instance) {
		//log.debug("attaching clean Plan instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Plan persistentInstance) {
		//log.debug("deleting Plan instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Plan merge(Plan detachedInstance) {
		//log.debug("merging Plan instance");
		try {
			Plan result = (Plan) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Plan findById(Integer id) {
		//log.debug("getting Plan instance with id: " + id);
		try {
			Plan instance = (Plan) sessionFactory
					.getCurrentSession().get(
							Plan.class, id);
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

	public List<Plan> findByExample(Plan instance) {
		//log.debug("finding Plan instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Plan> results = (List<Plan>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Plan")
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
	public List<Plan> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Plan.class);
	return (List<Plan>)crit.list(); 
	}

	
	
	
	
	
	
}



