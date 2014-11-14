package cn.kanmars.action.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.business.user.LogBusiness;

@Component("logoutAction")
@Scope("prototype")
public class LogoutAction {
	private LogBusiness logBusiness;
	public String execute(){
		logBusiness.logout();
		return "success";
	}
	public LogBusiness getLogBusiness() {
		return logBusiness;
	}
	@Resource(name="logBusiness")
	public void setLogBusiness(LogBusiness logBusiness) {
		this.logBusiness = logBusiness;
	}
	
}
