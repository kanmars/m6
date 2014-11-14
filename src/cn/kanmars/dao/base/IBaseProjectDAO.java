package cn.kanmars.dao.base;

public interface IBaseProjectDAO extends IQueryObj, IProcessObj {

	public abstract Class getReferenceClass();

	public abstract cn.kanmars.dao.Project get(java.lang.String key);

	public abstract cn.kanmars.dao.Project load(java.lang.String key);

    public abstract java.lang.String save(cn.kanmars.dao.Project project);

    public abstract void saveOrUpdate(cn.kanmars.dao.Project project);

    public abstract void update(cn.kanmars.dao.Project project);

    public abstract void delete(java.lang.String id);

    public abstract void delete(cn.kanmars.dao.Project project);

    public abstract void refresh (cn.kanmars.dao.Project project);

}