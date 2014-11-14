package cn.kanmars.action.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.business.user.LogBusiness;
import cn.kanmars.dao.User;

@Component("loginAction")
@Scope("prototype")
public class LoginAction {
	private User user;
	private LogBusiness logBusiness;

	public String execute() {
		System.out.println("执行登录模块");
		System.out.println(user);
		if (logBusiness.login(user)) {
			System.out.println("登录成功");
			return "success";
		} else {
			System.out.println("登录失败");
			return "login";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LogBusiness getLogBusiness() {
		return logBusiness;
	}

	@Resource(name = "logBusiness")
	public void setLogBusiness(LogBusiness logBusiness) {
		this.logBusiness = logBusiness;
	}

}
