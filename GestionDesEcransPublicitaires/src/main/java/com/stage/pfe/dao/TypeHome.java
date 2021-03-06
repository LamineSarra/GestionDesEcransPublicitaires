package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Type;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Type.
 * @see com.Type.supervision.dao.Type
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class TypeHome {

//	private static final Log log = LogFactory.getLog(TypeHome.class);

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

	public void persist(Type transientInstance) {
		//log.debug("persisting Type instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Type instance) {
		//log.debug("attaching dirty Type instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Type instance) {
		//log.debug("attaching clean Type instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Type persistentInstance) {
		//log.debug("deleting Type instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Type merge(Type detachedInstance) {
		//log.debug("merging Type instance");
		try {
			Type result = (Type) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Type findById(Integer id) {
		//log.debug("getting Type instance with id: " + id);
		try {
			Type instance = (Type) sessionFactory
					.getCurrentSession().get(
							Type.class, id);
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

	public List<Type> findByExample(Type instance) {
		//log.debug("finding Type instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Type> results = (List<Type>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Type")
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
	public List<Type> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Type.class);
	return (List<Type>)crit.list(); 
	}

	
	
	
	
	
	
}



