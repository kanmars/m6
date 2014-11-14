package cn.kanmars.dao.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the project table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="project"
 */

public abstract class BaseProject  implements Comparable, Serializable {

	public static String REF = "Project";
	public static String PROP_NAME = "Name";
	public static String PROP_USERID = "Userid";
	public static String PROP_UPDOPR = "Updopr";
	public static String PROP_ASPECT = "Aspect";
	public static String PROP_ID = "Id";
	public static String PROP_UPDTIME = "Updtime";


	// constructors
	public BaseProject () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProject (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String userid;
	private java.lang.String name;
	private java.lang.String aspect;
	private java.lang.String updopr;
	private java.util.Date updtime;



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
	 * Return the value associated with the column: UPDOPR
	 */
	public java.lang.String getUpdopr () {
		return updopr;
	}

	/**
	 * Set the value related to the column: UPDOPR
	 * @param updopr the UPDOPR value
	 */
	public void setUpdopr (java.lang.String updopr) {
		this.updopr = updopr;
	}



	/**
	 * Return the value associated with the column: UPDTIME
	 */
	public java.util.Date getUpdtime () {
		return updtime;
	}

	/**
	 * Set the value related to the column: UPDTIME
	 * @param updtime the UPDTIME value
	 */
	public void setUpdtime (java.util.Date updtime) {
		this.updtime = updtime;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.kanmars.dao.Project)) return false;
		else {
			cn.kanmars.dao.Project project = (cn.kanmars.dao.Project) obj;
			if (null == this.getId() || null == project.getId()) return false;
			else return (this.getId().equals(project.getId()));
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