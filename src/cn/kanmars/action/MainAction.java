package cn.kanmars.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.constant.$;
import cn.kanmars.dao.User;
import cn.kanmars.dao.dao.OperateobjectDAO;

@Component("mainAction")
@Scope("prototype")
public class MainAction {
	/**
	 * 自有账户
	 */
	private List objectListA;
	/**
	 * 商店账户
	 */
	private List objectListB;

	private double paysum;

	private OperateobjectDAO operateobjectDAO;

	public String execute() {
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		objectListA = operateobjectDAO
				.find("from Operateobject where Owner='A' and userid='"+u.getId()+"'");
		objectListB = operateobjectDAO
				.find("from Operateobject where Owner='B' and userid='"+u.getId()+"'");
		return "success";
	}

	public List getObjectListA() {
		return objectListA;
	}

	public void setObjectListA(List objectListA) {
		this.objectListA = objectListA;
	}

	public List getObjectListB() {
		return objectListB;
	}

	public void setObjectListB(List objectListB) {
		this.objectListB = objectListB;
	}

	public OperateobjectDAO getOperateobjectDAO() {
		return operateobjectDAO;
	}

	@Resource(name = "operateobjectDAO")
	public void setOperateobjectDAO(OperateobjectDAO operateobjectDAO) {
		this.operateobjectDAO = operateobjectDAO;
	}

}
