package cn.kanmars.dao.base;



/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseExchangeDAO extends _BaseRootDAO implements IBaseExchangeDAO {

	// query name references


	public Class getReferenceClass () {
		return cn.kanmars.dao.Exchange.class;
	}


	public cn.kanmars.dao.Exchange get(java.lang.String key)
	{
		return (cn.kanmars.dao.Exchange) get(getReferenceClass(), key);
	}

	public cn.kanmars.dao.Exchange load(java.lang.String key)
	{
		return (cn.kanmars.dao.Exchange) load(getReferenceClass(), key);
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param exchange a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.String save(cn.kanmars.dao.Exchange exchange)
	{
		return (java.lang.String) super.save(exchange);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param exchange a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(cn.kanmars.dao.Exchange exchange)
	{
		super.saveOrUpdate(exchange);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param exchange a transient instance containing updated state
	 */
	public void update(cn.kanmars.dao.Exchange exchange) 
	{
		super.update(exchange);
	}


	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.String id)
	{
		super.delete(load(id));
	}


	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param exchange the instance to be removed
	 */
	public void delete(cn.kanmars.dao.Exchange exchange)
	{
		super.delete(exchange);
	}

	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (cn.kanmars.dao.Exchange exchange)
	{
		super.refresh(exchange);
	}



}