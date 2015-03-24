package com.stage.pfe.dao;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Magasin;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Magasin.
 * @see com.Magasin.supervision.dao.Magasin
 * @author Hibernate Tools
 */
@SuppressWarnings("unused")
public class MagasinHome {

//	private static final Log log = LogFactory.getLog(MagasinHome.class);

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

	public void persist(Magasin transientInstance) {
		//log.debug("persisting Magasin instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Magasin instance) {
		//log.debug("attaching dirty Magasin instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Magasin instance) {
		//log.debug("attaching clean Magasin instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Magasin persistentInstance) {
		//log.debug("deleting Magasin instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Magasin merge(Magasin detachedInstance) {
		//log.debug("merging Magasin instance");
		try {
			Magasin result = (Magasin) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Magasin findById(Integer id) {
		//log.debug("getting Magasin instance with id: " + id);
		try {
			Magasin instance = (Magasin) sessionFactory
					.getCurrentSession().get(
							Magasin.class, id);
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
	
	public Magasin findByName(String nomMagasin) {
		//log.debug("getting Magasin instance with id: " + id);
		try {
			Magasin instance = (Magasin) sessionFactory
					.getCurrentSession().get(
							Magasin.class, nomMagasin);
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

	public List<Magasin> findByExample(Magasin instance) {
		//log.debug("finding Magasin instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Magasin> results = (List<Magasin>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Magasin")
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
	public List<Magasin> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Magasin.class);
	return (List<Magasin>)crit.list(); 
	}

	
	
	
	
	
	
}



