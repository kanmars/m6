package cn.kanmars.dao;

import cn.kanmars.dao.base.BaseExchange;



public class Exchange extends BaseExchange {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Exchange () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Exchange (java.lang.String id) {
		super(id);
	}

	@Override
	public String toString() {
		return "Exchange:Id=" + getId() + ", Aspect=" + getAspect()
				+ ", Aspectsum=" + getAspectsum() + ", Happentime="
				+ getHappentime() + ", Name=" + getName()
				+ ", Operatecontent=" + getOperatecontent()
				+ ", Operateobjectfrom=" + getOperateobjectfrom()
				+ ", Operateobjectto=" + getOperateobjectto()
				+ ", Operatepeople=" + getOperatepeople()
				+ ", Opinion=" + getOpinion() + ", Recordtime="
				+ getRecordtime() + ", Updatetime=" + getUpdatetime()
				+ "]";
	}

/*[CONSTRUCTOR MARKER END]*/
	

}