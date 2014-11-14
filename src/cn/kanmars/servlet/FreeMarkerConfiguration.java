package cn.kanmars.servlet;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FreeMarkerConfiguration {
private static final Log log = LogFactory.getLog(FreeMarkerConfiguration.class);
	
	/** memeber variable: constants. */
	private static final String BUNDLE_NAME = "app.resources.properties.freemarker";

	/** memeber variable: resource bundle . */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	/** memeber variable: pattern. */
	private final static Pattern classPattern = Pattern
			.compile("class\\{.*\\}");

	private final static Pattern stringPattern = Pattern
			.compile("string\\{.*\\}");

	/**
	 * getter config value
	 * 
	 * @param key
	 * @return
	 */
	public static Object getConfigVal(String key) throws Exception {
		try {
			String value = RESOURCE_BUNDLE.getString(key);
			if (classPattern.matcher(value).matches()) {
				value = value.substring(6, value.length() - 1);
				Class valueClass = Class.forName(value);
				return valueClass.newInstance();
			} else if (stringPattern.matcher(value).matches()) {
				value = value.substring(7, value.length() - 1);
				return value;
			} else {
				return value;
			}
		} catch (ClassNotFoundException cEx) {
			log.error("ClassNotFoundException",cEx);
			throw new RuntimeException("ClassNotFoundException",cEx);
		} catch (MissingResourceException e) {
			log.error("MissingResourceException",e);
			throw new RuntimeException("MissingResourceException",e);
		} catch (InstantiationException iEx) {
			log.error("InstantiationException", iEx);
			throw new RuntimeException("InstantiationException",iEx);
		} catch (IllegalAccessException illEx) {
			log.error("IllegalAccessException", illEx);
			throw new RuntimeException("IllegalAccessException",illEx);
		}
	}

	/**
	 * getter config keys
	 * 
	 * @return
	 */
	public static Enumeration getConfigKeys() {
		return RESOURCE_BUNDLE.getKeys();
	}
}
