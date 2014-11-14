package cn.kanmars.dao.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the operateobject table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="operateobject"
 */

public abstract class BaseOperateobject  implements Comparable, Serializable {

	public static String REF = "Operateobject";
	public static String PROP_NAME = "Name";
	public static String PROP_OWNER = "Owner";
	public static String PROP_ID = "Id";
	public static String PROP_INFO = "Info";
	public static String PROP_BALANCE = "Balance";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_UPDATETIME = "Updatetime";


	// constructors
	public BaseOperateobject () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOperateobject (cn.kanmars.dao.OperateobjectPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private cn.kanmars.dao.OperateobjectPK id;

	// fields
	private java.lang.String name;
	private java.lang.String owner;
	private java.lang.Double balance;
	private java.util.Date updatetime;
	private java.util.Date createtime;
	private java.lang.String info;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public cn.kanmars.dao.OperateobjectPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (cn.kanmars.dao.OperateobjectPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: OWNER
	 */
	public java.lang.String getOwner () {
		return owner;
	}

	/**
	 * Set the value related to the column: OWNER
	 * @param owner the OWNER value
	 */
	public void setOwner (java.lang.String owner) {
		this.owner = owner;
	}



	/**
	 * Return the value associated with the column: BALANCE
	 */
	public java.lang.Double getBalance () {
		return balance;
	}

	/**
	 * Set the value related to the column: BALANCE
	 * @param balance the BALANCE value
	 */
	public void setBalance (java.lang.Double balance) {
		this.balance = balance;
	}



	/**
	 * Return the value associated with the column: UPDATETIME
	 */
	public java.util.Date getUpdatetime () {
		return updatetime;
	}

	/**
	 * Set the value related to the column: UPDATETIME
	 * @param updatetime the UPDATETIME value
	 */
	public void setUpdatetime (java.util.Date updatetime) {
		this.updatetime = updatetime;
	}



	/**
	 * Return the value associated with the column: CREATETIME
	 */
	public java.util.Date getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: CREATETIME
	 * @param createtime the CREATETIME value
	 */
	public void setCreatetime (java.util.Date createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: INFO
	 */
	public java.lang.String getInfo () {
		return info;
	}

	/**
	 * Set the value related to the column: INFO
	 * @param info the INFO value
	 */
	public void setInfo (java.lang.String info) {
		this.info = info;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.kanmars.dao.Operateobject)) return false;
		else {
			cn.kanmars.dao.Operateobject operateobject = (cn.kanmars.dao.Operateobject) obj;
			if (null == this.getId() || null == operateobject.getId()) return false;
			else return (this.getId().equals(operateobject.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}