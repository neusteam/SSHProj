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

import com.ycj.entity.Movieinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Movieinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ycj.entity.Movieinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("MovieinfoDAO")
public class MovieinfoDAO {
	private static final Logger log = LoggerFactory.getLogger(MovieinfoDAO.class);
	// property constants
	public static final String MOVIENAME = "moviename";
	public static final String DIRECTOR = "director";
	public static final String ACTOR = "actor";
	public static final String TYPE = "type";
	public static final String COUNTRY = "country";
	public static final String LANGUAGE = "language";
	public static final String PICTURE = "picture";
	public static final String AVERAGE = "average";
	public static final String MOVIEDESCRIBE = "moviedescribe";
 
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

	public void save(Movieinfo transientInstance) {
		log.debug("saving Movieinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movieinfo persistentInstance) {
		log.debug("deleting Movieinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movieinfo findById(java.lang.Integer id) {
		log.debug("getting Movieinfo instance with id: " + id);
		try {
			Movieinfo instance = (Movieinfo) getCurrentSession().get("com.ycj.entity.Movieinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movieinfo instance) {
		log.debug("finding Movieinfo instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.ycj.entity.Movieinfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Movieinfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Movieinfo as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value.toString());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByKey(String key) {
		log.debug("finding Movieinfo instance with keyword: " + key);
		try {
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter("key", "%" + key + "%");
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMoviename(Object moviename) {
		return findByProperty(MOVIENAME, moviename);
	}

	public List findByDirector(Object director) {
		return findByProperty(DIRECTOR, director);
	}

	public List findByActor(Object actor) {
		return findByProperty(ACTOR, actor);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findByLanguage(Object language) {
		return findByProperty(LANGUAGE, language);
	}

	public List findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List findByAverage(Object average) {
		return findByProperty(AVERAGE, average);
	}

	public List findByMoviedescribe(Object moviedescribe) {
		return findByProperty(MOVIEDESCRIBE, moviedescribe);
	}

	public List findAll(int count) {
		log.debug("finding all Movieinfo instances");
		try {
			int m=0;
			int n=m+count;
			String queryString = "from Movieinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult(m);
			queryObject.setMaxResults(n);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Movieinfo merge(Movieinfo detachedInstance) {
		log.debug("merging Movieinfo instance");
		try {
			Movieinfo result = (Movieinfo) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movieinfo instance) {
		log.debug("attaching dirty Movieinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movieinfo instance) {
		log.debug("attaching clean Movieinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MovieinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MovieinfoDAO) ctx.getBean("MovieinfoDAO");
	}
}