package cn.kanmars.dao.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the exchange table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="exchange"
 */

public abstract class BaseExchange  implements Comparable, Serializable {

	public static String REF = "Exchange";
	public static String PROP_OPERATEPEOPLE = "Operatepeople";
	public static String PROP_NAME = "Name";
	public static String PROP_OPERATEOBJECTFROM = "Operateobjectfrom";
	public static String PROP_ASPECTSUM = "Aspectsum";
	public static String PROP_RECORDTIME = "Recordtime";
	public static String PROP_HAPPENTIME = "Happentime";
	public static String PROP_ASPECT = "Aspect";
	public static String PROP_ID = "Id";
	public static String PROP_OPERATEOBJECTTO = "Operateobjectto";
	public static String PROP_OPINION = "Opinion";
	public static String PROP_OPERATECONTENT = "Operatecontent";
	public static String PROP_UPDATETIME = "Updatetime";


	// constructors
	public BaseExchange () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExchange (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String aspect;
	private java.lang.Double aspectsum;
	private java.lang.String happentime;
	private java.lang.String name;
	private java.lang.String operatecontent;
	private java.lang.String operateobjectfrom;
	private java.lang.String operateobjectto;
	private java.lang.String operatepeople;
	private java.lang.String opinion;
	private java.util.Date recordtime;
	private java.util.Date updatetime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="ID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ASPECT
	 */
	public java.lang.String getAspect () {
		return aspect;
	}

	/**
	 * Set the value related to the column: ASPECT
	 * @param aspect the ASPECT value
	 */
	public void setAspect (java.lang.String aspect) {
		this.aspect = aspect;
	}



	/**
	 * Return the value associated with the column: ASPECTSUM
	 */
	public java.lang.Double getAspectsum () {
		return aspectsum;
	}

	/**
	 * Set the value related to the column: ASPECTSUM
	 * @param aspectsum the ASPECTSUM value
	 */
	public void setAspectsum (java.lang.Double aspectsum) {
		this.aspectsum = aspectsum;
	}



	/**
	 * Return the value associated with the column: HAPPENTIME
	 */
	public java.lang.String getHappentime () {
		return happentime;
	}

	/**
	 * Set the value related to the column: HAPPENTIME
	 * @param happentime the HAPPENTIME value
	 */
	public void setHappentime (java.lang.String happentime) {
		this.happentime = happentime;
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
	 * Return the value associated with the column: OPERATECONTENT
	 */
	public java.lang.String getOperatecontent () {
		return operatecontent;
	}

	/**
	 * Set the value related to the column: OPERATECONTENT
	 * @param operatecontent the OPERATECONTENT value
	 */
	public void setOperatecontent (java.lang.String operatecontent) {
		this.operatecontent = operatecontent;
	}



	/**
	 * Return the value associated with the column: OPERATEOBJECTFROM
	 */
	public java.lang.String getOperateobjectfrom () {
		return operateobjectfrom;
	}

	/**
	 * Set the value related to the column: OPERATEOBJECTFROM
	 * @param operateobjectfrom the OPERATEOBJECTFROM value
	 */
	public void setOperateobjectfrom (java.lang.String operateobjectfrom) {
		this.operateobjectfrom = operateobjectfrom;
	}



	/**
	 * Return the value associated with the column: OPERATEOBJECTTO
	 */
	public java.lang.String getOperateobjectto () {
		return operateobjectto;
	}

	/**
	 * Set the value related to the column: OPERATEOBJECTTO
	 * @param operateobjectto the OPERATEOBJECTTO value
	 */
	public void setOperateobjectto (java.lang.String operateobjectto) {
		this.operateobjectto = operateobjectto;
	}



	/**
	 * Return the value associated with the column: OPERATEPEOPLE
	 */
	public java.lang.String getOperatepeople () {
		return operatepeople;
	}

	/**
	 * Set the value related to the column: OPERATEPEOPLE
	 * @param operatepeople the OPERATEPEOPLE value
	 */
	public void setOperatepeople (java.lang.String operatepeople) {
		this.operatepeople = operatepeople;
	}



	/**
	 * Return the value associated with the column: OPINION
	 */
	public java.lang.String getOpinion () {
		return opinion;
	}

	/**
	 * Set the value related to the column: OPINION
	 * @param opinion the OPINION value
	 */
	public void setOpinion (java.lang.String opinion) {
		this.opinion = opinion;
	}



	/**
	 * Return the value associated with the column: RECORDTIME
	 */
	public java.util.Date getRecordtime () {
		return recordtime;
	}

	/**
	 * Set the value related to the column: RECORDTIME
	 * @param recordtime the RECORDTIME value
	 */
	public void setRecordtime (java.util.Date recordtime) {
		this.recordtime = recordtime;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.kanmars.dao.Exchange)) return false;
		else {
			cn.kanmars.dao.Exchange exchange = (cn.kanmars.dao.Exchange) obj;
			if (null == this.getId() || null == exchange.getId()) return false;
			else return (this.getId().equals(exchange.getId()));
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