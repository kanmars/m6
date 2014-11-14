package cn.kanmars.action.page;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import cn.kanmars.business.page.DefrayPageBusiness;
import cn.kanmars.constant.$;
import cn.kanmars.dao.User;

@Component("defrayPageAction")
@SuppressWarnings("rawtypes")
public class DefrayPageAction {
	public DefrayPageBusiness defrayPageBusiness;

	public List ABOperateObject;
	public List AOperateObject;
	public List BOperateObject;

	public String happenTime;

	public String execute() {
		User u = (User) ServletActionContext.getRequest().getSession()
				.getAttribute($.SESSIONUSER);
		ABOperateObject = defrayPageBusiness.getOOListAB(u.getId());
		AOperateObject = defrayPageBusiness.getOOListA(u.getId());
		BOperateObject = defrayPageBusiness.getOOListB(u.getId());
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

	public DefrayPageBusiness getDefrayPageBusiness() {
		return defrayPageBusiness;
	}

	@Resource(name = "defrayPageBusiness")
	public void setDefrayPageBusiness(DefrayPageBusiness defrayPageBusiness) {
		this.defrayPageBusiness = defrayPageBusiness;
	}

}
