package cn.kanmars.dao.base;

public interface IBaseUserDAO extends IQueryObj, IProcessObj {

	public abstract Class getReferenceClass();

	public abstract cn.kanmars.dao.User get(java.lang.String key);

	public abstract cn.kanmars.dao.User load(java.lang.String key);

    public abstract java.lang.String save(cn.kanmars.dao.User user);

    public abstract void saveOrUpdate(cn.kanmars.dao.User user);

    public abstract void update(cn.kanmars.dao.User user);

    public abstract void delete(java.lang.String id);

    public abstract void delete(cn.kanmars.dao.User user);

    public abstract void refresh (cn.kanmars.dao.User user);

}