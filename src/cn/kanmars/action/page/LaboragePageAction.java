package cn.kanmars.action.page;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.business.page.LaboragePageBusiness;
import cn.kanmars.constant.$;
import cn.kanmars.dao.User;

@Component("laboragePageAction")
@Scope("prototype")
@SuppressWarnings("rawtypes")
public class LaboragePageAction {

	public LaboragePageBusiness laboragePageBusiness;

	public List ABOperateObject;
	public List AOperateObject;
	public List BOperateObject;
	public String happenTime;

	public String execute() {
		User u = (User) ServletActionContext.getRequest().getSession()
				.getAttribute($.SESSIONUSER);
		String userid = u.getId();
		ABOperateObject = laboragePageBusiness.getABOperateObject(userid);
		AOperateObject = laboragePageBusiness.getAOperateObject(userid);
		BOperateObject = laboragePageBusiness.getBOperateObject(userid);
		Date today = new Date();
		happenTime = (today.getYear()+1900)
				+ ""
				+ ((today.getMonth() + 1) < 10 ? "0" + (today.getMonth() + 1)
						: (today.getMonth() + 1))
				+ (today.getDate() < 10 ? "0" + today.getDate() : today
						.getDate());
		return "success";
	}

	public List getABOperateObject() {
		return ABOperateObject;
	}

	public void setABOperateObject(List aBOperateObject) {
		ABOperateObject = aBOperateObject;
	}

	public List getAOperateObject() {
		return AOperateObject;
	}

	public void setAOperateObject(List aOperateObject) {
		AOperateObject = aOperateObject;
	}

	public List getBOperateObject() {
		return BOperateObject;
	}

	public void setBOperateObject(List bOperateObject) {
		BOperateObject = bOperateObject;
	}

	public String getHappenTime() {
		return happenTime;
	}

	public void setHappenTime(String happenTime) {
		this.happenTime = happenTime;
	}

	public LaboragePageBusiness getLaboragePageBusiness() {
		return laboragePageBusiness;
	}

	@Resource(name = "laboragePageBusiness")
	public void setLaboragePageBusiness(
			LaboragePageBusiness laboragePageBusiness) {
		this.laboragePageBusiness = laboragePageBusiness;
	}

}
