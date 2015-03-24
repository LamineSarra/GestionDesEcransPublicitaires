package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.PlanMsg;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PlanMsg.
 * @see com.PlanMsg.supervision.dao.PlanMsg
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class PlanMsgHome {

//	private static final Log log = LogFactory.getLog(PlanMsgHome.class);

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

	public void persist(PlanMsg transientInstance) {
		//log.debug("persisting PlanMsg instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlanMsg instance) {
		//log.debug("attaching dirty PlanMsg instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(PlanMsg instance) {
		//log.debug("attaching clean PlanMsg instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlanMsg persistentInstance) {
		//log.debug("deleting PlanMsg instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public PlanMsg merge(PlanMsg detachedInstance) {
		//log.debug("merging PlanMsg instance");
		try {
			PlanMsg result = (PlanMsg) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public PlanMsg findById(Integer id) {
		//log.debug("getting PlanMsg instance with id: " + id);
		try {
			PlanMsg instance = (PlanMsg) sessionFactory
					.getCurrentSession().get(
							PlanMsg.class, id);
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

	public List<PlanMsg> findByExample(PlanMsg instance) {
		//log.debug("finding PlanMsg instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<PlanMsg> results = (List<PlanMsg>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.PlanMsg")
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
	public List<PlanMsg> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(PlanMsg.class);
	return (List<PlanMsg>)crit.list(); 
	}

	
	
	
	
	
	
}



