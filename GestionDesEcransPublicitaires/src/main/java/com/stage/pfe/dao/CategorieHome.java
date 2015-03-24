
package com.stage.pfe.dao;


import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.stage.pfe.persistance.Categorie;
import static org.hibernate.criterion.Example.create;

/**
* Home object for domain model class Categorie.
* @see com.Categorie.supervision.dao.Categorie
* @author Hibernate Tools
*/
@SuppressWarnings("unused")
public class CategorieHome {

//	private static final Log log = LogFactory.getLog(CategorieHome.class);

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

	public void persist(Categorie transientInstance) {
		//log.debug("persisting Categorie instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Categorie instance) {
		//log.debug("attaching dirty Categorie instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
		//	log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Categorie instance) {
		//log.debug("attaching clean Categorie instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		//	log.debug("attach successful");
		} catch (RuntimeException re) {
//			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Categorie persistentInstance) {
		//log.debug("deleting Categorie instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Categorie merge(Categorie detachedInstance) {
		//log.debug("merging Categorie instance");
		try {
			Categorie result = (Categorie) sessionFactory
					.getCurrentSession().merge(detachedInstance);
		//	log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
		//	log.error("merge failed", re);
			throw re;
		}
	}

	public Categorie findById(Integer id) {
		//log.debug("getting Categorie instance with id: " + id);
		try {
			Categorie instance = (Categorie) sessionFactory
					.getCurrentSession().get(
							Categorie.class, id);
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

	public List<Categorie> findByExample(Categorie instance) {
		//log.debug("finding Categorie instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Categorie> results = (List<Categorie>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cimf.supervision.dao.Categorie")
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
	public List<Categorie> findAll ()
	{ Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Categorie.class);
	return (List<Categorie>)crit.list(); 
	}

	

	
	
}
