package cn.kanmars.action.manager;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.business.manager.OOManagerBusiness;
import cn.kanmars.constant.$;
import cn.kanmars.dao.Operateobject;
import cn.kanmars.dao.OperateobjectPK;
import cn.kanmars.dao.User;

@Component("oOManagerAction")
@Scope("prototype")
@SuppressWarnings("rawtypes")
public class OOManagerAction {
	public int pageSize=10;
	public int pageNum=1;
	public int pageCount=1;
	
	
	public List ABOperateObject;
	public List AOperateObject;
	public List BOperateObject;
	public OOManagerBusiness oOManagerBusiness;
	
	public Operateobject operateobject;

	public String oOList() {
		User u = (User) ServletActionContext.getRequest().getSession()
				.getAttribute($.SESSIONUSER);
		String userid = u.getId();
		Object[] oAB=oOManagerBusiness.getABOperateObject(userid, pageSize, pageNum);
		ABOperateObject = (List)(oAB[0]);
		pageCount=(Integer)(oAB[3]);
		return "success";
	}
	public String oOAdd(){
		User u = (User) ServletActionContext.getRequest().getSession()
		.getAttribute($.SESSIONUSER);
		String userid = u.getId();
		OperateobjectPK opk=new OperateobjectPK();
		opk.setUserid(userid);
		operateobject.setId(opk);
		Date now=new Date();
		operateobject.setCreatetime(now);
		operateobject.setUpdatetime(now);
		oOManagerBusiness.saveOperateObject(operateobject);
		return "success";
	}
	public String oODel(){
		User u = (User) ServletActionContext.getRequest().getSession()
		.getAttribute($.SESSIONUSER);
		String userid = u.getId();
		oOManagerBusiness.deleteOperateObject(operateobject.getId().getId(), userid);
		return "success";
	}
	public String oOUpdGet(){
		User u = (User) ServletActionContext.getRequest().getSession()
		.getAttribute($.SESSIONUSER);
		String userid = u.getId();
		operateobject=oOManagerBusiness.getOperateobject(new OperateobjectPK(operateobject.getId().getId(), userid));
		return "success";
	}
	public String oOUpdSet(){
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		String userid = u.getId();
		operateobject.getId().setUserid(userid);
		oOManagerBusiness.updOperateObject(operateobject);
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

	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Operateobject getOperateobject() {
		return operateobject;
	}
	public void setOperateobject(Operateobject operateobject) {
		this.operateobject = operateobject;
	}
	
	public OOManagerBusiness getoOManagerBusiness() {
		return oOManagerBusiness;
	}

	@Resource(name = "oOManagerBusiness")
	public void setoOManagerBusiness(OOManagerBusiness oOManagerBusiness) {
		this.oOManagerBusiness = oOManagerBusiness;
	}

}
