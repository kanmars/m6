package cn.kanmars.dao.base;

public interface IBaseOperateobjectDAO extends IQueryObj, IProcessObj {

	public abstract Class getReferenceClass();

	public abstract cn.kanmars.dao.Operateobject get(cn.kanmars.dao.OperateobjectPK key);

	public abstract cn.kanmars.dao.Operateobject load(cn.kanmars.dao.OperateobjectPK key);

    public abstract cn.kanmars.dao.OperateobjectPK save(cn.kanmars.dao.Operateobject operateobject);

    public abstract void saveOrUpdate(cn.kanmars.dao.Operateobject operateobject);

    public abstract void update(cn.kanmars.dao.Operateobject operateobject);

    public abstract void delete(cn.kanmars.dao.OperateobjectPK id);

    public abstract void delete(cn.kanmars.dao.Operateobject operateobject);

    public abstract void refresh (cn.kanmars.dao.Operateobject operateobject);

}