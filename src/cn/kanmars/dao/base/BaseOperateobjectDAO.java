package cn.kanmars.dao.base;



/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseOperateobjectDAO extends _BaseRootDAO implements IBaseOperateobjectDAO {

	// query name references


	public Class getReferenceClass () {
		return cn.kanmars.dao.Operateobject.class;
	}


	public cn.kanmars.dao.Operateobject get(cn.kanmars.dao.OperateobjectPK key)
	{
		return (cn.kanmars.dao.Operateobject) get(getReferenceClass(), key);
	}

	public cn.kanmars.dao.Operateobject load(cn.kanmars.dao.OperateobjectPK key)
	{
		return (cn.kanmars.dao.Operateobject) load(getReferenceClass(), key);
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param operateobject a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public cn.kanmars.dao.OperateobjectPK save(cn.kanmars.dao.Operateobject operateobject)
	{
		return (cn.kanmars.dao.OperateobjectPK) super.save(operateobject);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param operateobject a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(cn.kanmars.dao.Operateobject operateobject)
	{
		super.saveOrUpdate(operateobject);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param operateobject a transient instance containing updated state
	 */
	public void update(cn.kanmars.dao.Operateobject operateobject) 
	{
		super.update(operateobject);
	}


	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(cn.kanmars.dao.OperateobjectPK id)
	{
		super.delete(load(id));
	}


	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param operateobject the instance to be removed
	 */
	public void delete(cn.kanmars.dao.Operateobject operateobject)
	{
		super.delete(operateobject);
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
	public void refresh (cn.kanmars.dao.Operateobject operateobject)
	{
		super.refresh(operateobject);
	}



}