package cn.kanmars.dao.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user"
 */

public abstract class BaseUser  implements Comparable, Serializable {

	public static String REF = "User";
	public static String PROP_NAME = "Name";
	public static String PROP_BIRTHDAY = "Birthday";
	public static String PROP_IDCARD = "Idcard";
	public static String PROP_EMAIL = "Email";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_ID = "Id";
	public static String PROP_SEX = "Sex";


	// constructors
	public BaseUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUser (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String account;
	private java.util.Date birthday;
	private java.lang.String email;
	private java.lang.String idcard;
	private java.lang.String name;
	private java.lang.String password;
	private java.lang.String sex;



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
	 * Return the value associated with the column: ACCOUNT
	 */
	public java.lang.String getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: ACCOUNT
	 * @param account the ACCOUNT value
	 */
	public void setAccount (java.lang.String account) {
		this.account = account;
	}



	/**
	 * Return the value associated with the column: BIRTHDAY
	 */
	public java.util.Date getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: BIRTHDAY
	 * @param birthday the BIRTHDAY value
	 */
	public void setBirthday (java.util.Date birthday) {
		this.birthday = birthday;
	}



	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: IDCARD
	 */
	public java.lang.String getIdcard () {
		return idcard;
	}

	/**
	 * Set the value related to the column: IDCARD
	 * @param idcard the IDCARD value
	 */
	public void setIdcard (java.lang.String idcard) {
		this.idcard = idcard;
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
	 * Return the value associated with the column: PASSWORD
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: PASSWORD
	 * @param password the PASSWORD value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: SEX
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: SEX
	 * @param sex the SEX value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cn.kanmars.dao.User)) return false;
		else {
			cn.kanmars.dao.User user = (cn.kanmars.dao.User) obj;
			if (null == this.getId() || null == user.getId()) return false;
			else return (this.getId().equals(user.getId()));
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