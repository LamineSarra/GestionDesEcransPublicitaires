package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Message;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Message.
 * @see com.Message.supervision.dao.Message
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class MessageHome {

//	private static final Log log = LogFactory.getLog(MessageHome.class);

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

	public void persist(Message transientInstance) {
		//log.debug("persisting Message instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Message instance) {
		//log.debug("attaching dirty Message instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Message instance) {
		//log.debug("attaching clean Message instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Message persistentInstance) {
		//log.debug("deleting Message instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Message merge(Message detachedInstance) {
		//log.debug("merging Message instance");
		try {
			Message result = (Message) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Message findById(Integer id) {
		//log.debug("getting Message instance with id: " + id);
		try {
			Message instance = (Message) sessionFactory
					.getCurrentSession().get(
							Message.class, id);
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

	public List<Message> findByExample(Message instance) {
		//log.debug("finding Message instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Message> results = (List<Message>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Message")
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
	public List<Message> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Message.class);
	return (List<Message>)crit.list(); 
	}

	
	
	
	
	
	
}



