package cn.kanmars.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import cn.kanmars.dao.User;
import cn.kanmars.constant.$;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Component("loginInterceptor")
public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user=null;
			HttpSession session=ServletActionContext.getRequest().getSession();
			if(session==null)return "login";
			user=(User)session.getAttribute($.SESSIONUSER);
			if(user==null)return "login";
		return invocation.invoke();
	}
	
}
