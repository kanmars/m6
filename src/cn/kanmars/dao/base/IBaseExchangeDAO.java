package cn.kanmars.dao.base;

import org.hibernate.Query;


public interface IBaseExchangeDAO extends IQueryObj, IProcessObj {

	public abstract Class getReferenceClass();

	public abstract cn.kanmars.dao.Exchange get(java.lang.String key);

	public abstract cn.kanmars.dao.Exchange load(java.lang.String key);

    public abstract java.lang.String save(cn.kanmars.dao.Exchange exchange);

    public abstract void saveOrUpdate(cn.kanmars.dao.Exchange exchange);

    public abstract void update(cn.kanmars.dao.Exchange exchange);

    public abstract void delete(java.lang.String id);

    public abstract void delete(cn.kanmars.dao.Exchange exchange);

    public abstract void refresh (cn.kanmars.dao.Exchange exchange);
    
    /**
     * 用户添加的方法
     */
    public Query getQuery(String hql);

}