package com.ycj.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ycj.entity.Actorinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Actorinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ycj.entity.Actorinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("ActorinfoDAO")
public class ActorinfoDAO {
	private static final Logger log = LoggerFactory.getLogger(ActorinfoDAO.class);
	// property constants
	public static final String ACTORNAME = "actorname";
	public static final String SEX = "sex";
	public static final String HOMETOWN = "hometown";
	public static final String OCCUPATION = "occupation";
	public static final String ACTORDESCRIBE = "actordescribe";
	public static final String URL = "url";
    @Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Actorinfo transientInstance) {
		log.debug("saving Actorinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Actorinfo persistentInstance) {
		log.debug("deleting Actorinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Actorinfo findById(java.lang.Integer id) {
		log.debug("getting Actorinfo instance with id: " + id);
		try {
			Actorinfo instance = (Actorinfo) getCurrentSession().get("com.ycj.entity.Actorinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Actorinfo instance) {
		log.debug("finding Actorinfo instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.ycj.entity.Actorinfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Actorinfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Actorinfo as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByActorname(Object actorname) {
		return findByProperty(ACTORNAME, actorname);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByHometown(Object hometown) {
		return findByProperty(HOMETOWN, hometown);
	}

	public List findByOccupation(Object occupation) {
		return findByProperty(OCCUPATION, occupation);
	}

	public List findByActordescribe(Object actordescribe) {
		return findByProperty(ACTORDESCRIBE, actordescribe);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findAll() {
		log.debug("finding all Actorinfo instances");
		try {
			String queryString = "from Actorinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Actorinfo merge(Actorinfo detachedInstance) {
		log.debug("merging Actorinfo instance");
		try {
			Actorinfo result = (Actorinfo) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Actorinfo instance) {
		log.debug("attaching dirty Actorinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Actorinfo instance) {
		log.debug("attaching clean Actorinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ActorinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ActorinfoDAO) ctx.getBean("ActorinfoDAO");
	}
}