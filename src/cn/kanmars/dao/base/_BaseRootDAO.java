package cn.kanmars.dao.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;


import java.sql.*;

public abstract class _BaseRootDAO extends HibernateDaoSupport implements
		IQueryObj, IProcessObj {
	public final static int PAGESIZE=10;
	/**
	 * Return the specific Object class that will be used for class-specific
	 * implementation of this DAO.
	 * 
	 * @return the reference Class
	 */
	protected abstract Class getReferenceClass();

	/**
	 * Used by the base DAO classes but here for your modification Get object
	 * matching the given key and return it.
	 */
	protected Object get(Class refClass, Serializable key) {
		return getHibernateTemplate().get(refClass, key);
	}

	/**
	 * Used by the base DAO classes but here for your modification Load object
	 * matching the given key and return it.
	 */
	protected Object load(Class refClass, Serializable key) {
		return getHibernateTemplate().load(refClass, key);
	}

	/**
	 * Execute a query.
	 * 
	 * @param query
	 *            a query expressed in Hibernate's query language
	 * @return a distinct list of instances (or arrays of instances)
	 */
	public List find(String query) {
		return getHibernateTemplate().find(query);
	}
	/**
	 * 执行Criteria的动态查询
	 * 返回一个Object[3],其中Object[0]为List<Object[]>或者List&lt;Object&gt;对象,Object[1]为pageSize,Object[2]为pageNum
	 * 性能较findByNamedQuery(final String name, final int begin,final int count)好，实时查询没有缓存
	 * @param oneClass	获得的类
	 * @param simpleExpression	Restrictions生成的实例List
	 * @param pageSize	每页数量
	 * @param pageNum	开始页数
	 * @return
	 */
	public Object[] findByCriteria(Class oneClass,List<SimpleExpression> simpleExpression,int pageSize,int pageNum) {
		/**
		 * 参数预处理
		 */
		if(pageSize<=0)pageSize=PAGESIZE;
		if(pageNum<=0)pageNum=1;
		/**
		 * 参数最终化
		 */
		final Class _oneClass=oneClass;
		final List<SimpleExpression> _simpleExpression=simpleExpression;
		final int _pageSize=pageSize;
		final int _pageNum=pageNum;
		Object[] ol=new Object[4];
		ol[0]=getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria=session.createCriteria(_oneClass);
				for(SimpleExpression s : _simpleExpression)
				criteria.add(s);
				criteria.setFirstResult((_pageNum-1)*_pageSize);
				criteria.setMaxResults(_pageSize);
				return criteria.list();
			}
		});
		ol[1]=pageSize;
		ol[2]=pageNum;
		return ol;
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	public List findAll() {
		return getHibernateTemplate().loadAll(getReferenceClass());
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the
	 * mapping file.
	 * 
	 * @param name
	 *            the name of a query defined externally
	 * @return Query
	 */
	public List findByNamedQuery(String name) {
		return getHibernateTemplate().findByNamedQuery(name);
	}

	public List findByNamedQuery(final String name, final int begin,
			final int count) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(name);
				if (begin >= 0) {
					query.setFirstResult(begin);
					query.setMaxResults(count);
				}
				return query.list();
			}
		});
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the
	 * mapping file. Use the parameters give
	 * 
	 * @param name
	 *            the name of a query defined externally
	 * @param params
	 *            the parameter Map
	 * @return Query
	 */
	public List findByNamedQuery(final String name, final Map params) {
		return findByNamedQuery(name, params, -1, -1);
	}

	public List findByNamedQuery(final String name, final Map params,
			final int begin, final int count) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(name);
				if (null != params) {
					for (Iterator i = params.entrySet().iterator(); i.hasNext();) {
						Map.Entry entry = (Map.Entry) i.next();
						query.setParameter((String) entry.getKey(),
								entry.getValue());
					}
				}
				if (begin >= 0) {
					System.out.println(begin+" "+count);
					query.setFirstResult(begin);
					query.setMaxResults(count);
				}
				return query.list();
			}
		});
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the
	 * mapping file. Use the parameters give
	 * 
	 * @param name
	 *            the name of a query defined externally
	 * @param params
	 *            the parameter array
	 * @return Query
	 */
	public List findByNamedQuery(final String name, final Serializable[] params) {
		return findByNamedQuery(name, params, -1, -1);
	}

	public List findByNamedQuery(final String name,
			final Serializable[] params, final int begin, final int count) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(name);
				if (null != params) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				if (begin >= 0) {
					query.setFirstResult(begin);
					query.setMaxResults(count);
				}
				return query.list();
			}
		});
	}

	/**
	 * Used by the base DAO classes but here for your modification Persist the
	 * given transient instance, first assigning a enerated identifier. (Or
	 * using the current value of the identifier property if the assigned
	 * generator is used.)
	 */
	protected Serializable save(Object obj) {
		return getHibernateTemplate().save(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification Either save()
	 * or update() the given instance, depending upon the value of its
	 * identifier property.
	 */
	protected void saveOrUpdate(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification Update the
	 * persistent state associated with the given identifier. An exception is
	 * thrown if there is a persistent instance with the same identifier in the
	 * current session.
	 * 
	 * @param obj
	 *            a transient instance containing updated state
	 */
	protected void update(Object obj) {
		getHibernateTemplate().update(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification Remove a
	 * persistent instance from the datastore. The argument may be an instance
	 * associated with the receiving Session or a transient instance with an
	 * identifier associated with existing persistent state.
	 */
	protected void delete(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification Re-read the
	 * state of the given instance from the underlying database. It is
	 * inadvisable to use this to implement long-running sessions that span many
	 * business tasks. This method is, however, useful in certain special
	 * circumstances.
	 */
	protected void refresh(Object obj) {
		getHibernateTemplate().refresh(obj);
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

}