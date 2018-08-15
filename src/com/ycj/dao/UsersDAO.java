package com.ycj.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 	* A data access object (DAO) providing persistence and search support for Users entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.ycj.dao.Users
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
    @Repository("UsersDAO")
public class UsersDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);
		//property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";
	public static final String SEX = "sex";

	public static final String PHONENUMBER = "phonenumber";
	public static final String EMAIL = "email";
	public static final String CITY = "city";
	public static final String URL = "url";


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
   

    public void save(Users transientInstance) {
        log.debug("saving Users instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Users persistentInstance) {
        log.debug("deleting Users instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Users findById( java.lang.Integer id) {
        log.debug("getting Users instance with id: " + id);
        try {
            Users instance = (Users) getCurrentSession()
                    .get("com.ycj.dao.Users", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Users instance) {
        log.debug("finding Users instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.ycj.dao.Users") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Users instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Users as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findBySex(Object sex
	) {
		return findByProperty(SEX, sex
		);
	}
	
	public List findByPhonenumber(Object phonenumber
	) {
		return findByProperty(PHONENUMBER, phonenumber
		);
	}
	
	public List findByEmail(Object email
	) {
		return findByProperty(EMAIL, email
		);
	}
	
	public List findByCity(Object city
	) {
		return findByProperty(CITY, city
		);
	}
	
	public List findByUrl(Object url
	) {
		return findByProperty(URL, url
		);
	}
	

	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Users merge(Users detachedInstance) {
        log.debug("merging Users instance");
        try {
            Users result = (Users) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Users instance) {
        log.debug("attaching dirty Users instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Users instance) {
        log.debug("attaching clean Users instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static UsersDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (UsersDAO) ctx.getBean("UsersDAO");
	}
}