package cn.kanmars.util;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.kanmars.dao.dao.IExchangeDAO;
import cn.kanmars.dao.dao.IOperateobjectDAO;
import cn.kanmars.dao.dao.IUserDAO;

@Component("seqUtil")
public class SeqUtil {
	private static IExchangeDAO exchangeDAO;
	private static IOperateobjectDAO operateobjectDAO;
	private static IUserDAO userDAO;

	public synchronized static String getExchangeSEQ() {
		String result = null;
		List exchangelist = exchangeDAO.find("SELECT MAX(Id) from Exchange");
		StringBuffer newID = new StringBuffer();
		Date date = new Date();
		int year, month, day;
		year = date.getYear() + 1900;
		month = date.getMonth() + 1;
		day = date.getDate();
		newID.append("EX");
		newID.append(year);
		newID.append(month >= 10 ? month : ("0" + month));
		newID.append(day >= 10 ? day : ("0" + day));
		if (exchangelist.size() > 0) {
			String lastID = (String) (exchangelist.get(0));
			if (lastID.startsWith(newID.toString())) {
				String endString = lastID.substring(newID.toString().length());
				long num = Long.parseLong(endString) + 1;
				endString = StrUtil.leftAdd(num + "", "0", 10);
				newID.append(endString);
			} else {
				newID.append("0000000001");
			}
		} else {
			newID.append("0000000001");
		}
		result = newID.toString();
		return result;
	}

	public synchronized static String getOperateobjectSEQ(String userid) {
		String result = null;
		if (userid != null) {
			List operateobjectlist = operateobjectDAO
					.find("SELECT MAX(Id.Id) from Operateobject where userid='"
							+ userid + "'");
			StringBuffer newID = new StringBuffer();
			newID.append("WI");
			if (operateobjectlist.size() > 0 && operateobjectlist.get(0)!=null) {
				String lastID = (String) (operateobjectlist.get(0));
				String endString = lastID.substring(2);
				long num = Long.parseLong(endString) + 1;
				endString = StrUtil.leftAdd(num + "", "0", 8);
				newID.append(endString);
			} else {
				newID.append("00000001");
			}
			result = newID.toString();
		}
		return result;
	}
	
	public synchronized static String getProjectSEQ(String userid) {
		String result = null;
		if (userid != null) {
			List projectList = operateobjectDAO
					.find("SELECT MAX(Id) from Project ");
			StringBuffer newID = new StringBuffer();
			newID.append("PRO");
			if (projectList.size() > 0 && projectList.get(0)!=null) {
				String lastID = (String) (projectList.get(0));
				String endString = lastID.substring(3);
				long num = Long.parseLong(endString) + 1;
				endString = StrUtil.leftAdd(num + "", "0", 17);
				newID.append(endString);
			} else {
				newID.append("00000000000000001");
			}
			result = newID.toString();
		}
		return result;
	}

	public IExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}

	@Resource(name = "exchangeDAO")
	public void setExchangeDAO(IExchangeDAO exchangeDAO_) {
		exchangeDAO = exchangeDAO_;
	}

	public IOperateobjectDAO getOperateobjectDAO() {
		return operateobjectDAO;
	}

	@Resource(name = "operateobjectDAO")
	public void setOperateobjectDAO(IOperateobjectDAO operateobjectDAO_) {
		operateobjectDAO = operateobjectDAO_;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(IUserDAO userDAO_) {
		userDAO = userDAO_;
	}
}
