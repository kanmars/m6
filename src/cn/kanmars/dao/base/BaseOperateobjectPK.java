package cn.kanmars.dao.base;

import java.io.Serializable;


public abstract class BaseOperateobjectPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String id;
	private java.lang.String userid;


	public BaseOperateobjectPK () {}
	
	public BaseOperateobjectPK (
		java.lang.String id,
		java.lang.String userid) {

		this.setId(id);
		this.setUserid(userid);
	}


	/**
	 * Return the value associated with the column: ID
	 */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the value related to the column: ID
	 * @param id the ID value
	 */
	public void setId (java.lang.String id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: USERID
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: USERID
	 * @param userid the USERID value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.kanmars.dao.OperateobjectPK)) return false;
		else {
			cn.kanmars.dao.OperateobjectPK mObj = (cn.kanmars.dao.OperateobjectPK) obj;
			if (null != this.getId() && null != mObj.getId()) {
				if (!this.getId().equals(mObj.getId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getUserid() && null != mObj.getUserid()) {
				if (!this.getUserid().equals(mObj.getUserid())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getId()) {
				sb.append(this.getId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getUserid()) {
				sb.append(this.getUserid().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}