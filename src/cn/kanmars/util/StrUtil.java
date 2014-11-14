package cn.kanmars.util;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import cn.kanmars.dao.dao.IExchangeDAO;
import cn.kanmars.dao.dao.IOperateobjectDAO;
import cn.kanmars.dao.dao.IUserDAO;

public class StrUtil {
	

	/**
	 * 左补足字符
	 * 
	 * @param str
	 *            目标字符串
	 * @param character
	 *            补足字符串
	 * @param num
	 *            最终长度
	 * @return
	 */
	public static String leftAdd(String str, String character, int num) {
		StringBuffer result = new StringBuffer(str);
		while (result.length() < num) {
			result.insert(0, character);
		}
		return result.toString();
	}

	/**
	 * 右补足字符
	 * 
	 * @param str
	 *            目标字符串
	 * @param character
	 *            补足字符串
	 * @param num
	 *            最终长度
	 * @return
	 */
	public static String rightAdd(String str, String character, int num) {
		StringBuffer result = new StringBuffer(str);
		while (result.length() < num) {
			result.append(character);
		}
		return result.toString();
	}



}
