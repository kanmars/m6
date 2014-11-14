package cn.kanmars.business.page;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kanmars.dao.dao.IProjectDAO;

@Component("transferPageBusiness")
@Scope("prototype")
@SuppressWarnings("rawtypes")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class TransferPageBusiness {
	public IProjectDAO projectDAO;
	
	public static final String SELECTOOAB="select Id,Name from Operateobject where Userid='";;
	public static final String SELECTOOA="select Id,Name from Operateobject where Owner='A' and Userid='";;
	public static final String SELECTOOB="select Id,Name from Operateobject where Owner='B' and Userid='";;
	
	
	public List getABOperateObject(String userid) {
		List ABOperateObject =null;
		ABOperateObject=projectDAO.find(SELECTOOAB+userid+"'");
		return ABOperateObject;
	}

	public List getAOperateObject(String userid) {
		List AOperateObject =null;
		AOperateObject=projectDAO.find(SELECTOOA+userid+"'");
		return AOperateObject;
	}

	public List getBOperateObject(String userid) {
		List BOperateObject =null;
		BOperateObject=projectDAO.find(SELECTOOB+userid+"'");
		return BOperateObject;
	}


	public IProjectDAO getProjectDAO() {
		return projectDAO;
	}
	@Resource(name="projectDAO")
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	
}
