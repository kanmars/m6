package cn.kanmars.business.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kanmars.constant.$;
import cn.kanmars.dao.User;
import cn.kanmars.dao.dao.UserDAO;
@Component("logBusiness")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class LogBusiness {
	public UserDAO userDAO;
	public boolean login(User user){
		List list=userDAO.find("from User where Account='"+user.getAccount()+"' and password='"+user.getPassword()+"'");
		if(list!=null&&list.size()>0)
		{
			User u=(User)list.get(0);
			/**
			 * 绑定用户对象
			 */
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute($.SESSIONUSER, u);
			/**
			 * 绑定基本跳转地址
			 */
			session.setAttribute($.SESSIONBASEHREF, $.SESSIONBASEHREFVALUE);
			/**
			 * 绑定用户交易方向
			 */
			List listABC=userDAO.find("select Id,Name from Project where Userid='"+u.getId()+"'");
			List listA=userDAO.find("select Id,Name from Project where Userid='"+u.getId()+"' and Aspect='A'");
			List listB=userDAO.find("select Id,Name from Project where Userid='"+u.getId()+"' and Aspect='B'");
			List listC=userDAO.find("select Id,Name from Project where Userid='"+u.getId()+"' and Aspect='C'");
			
			session.setAttribute($.SESSIONPROJECTABC, listABC);
			session.setAttribute($.SESSIONPROJECTA, listA);
			session.setAttribute($.SESSIONPROJECTB, listB);
			session.setAttribute($.SESSIONPROJECTC, listC);
			
//			ServletActionContext.getRequest().getSession().setAttribute($.SESSIONUSERId, u.getId());
//			ServletActionContext.getRequest().getSession().setAttribute($.SESSIONUSERACCOUNT, u.getAccount());
//			ServletActionContext.getRequest().getSession().setAttribute($.SESSIONUSERNAME, u.getName());
//			ServletActionContext.getRequest().getSession().setAttribute($.SESSIONUSERPASSWORD, u.getPassword());
			return true;
		}
		return false;
	}
	
	public void logout(){
		HttpSession session= ServletActionContext.getRequest().getSession(false);
		if(session!=null)session.invalidate();
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
