package cn.kanmars.business.page;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kanmars.dao.dao.IOperateobjectDAO;
import cn.kanmars.dao.dao.IProjectDAO;
@Component("defrayPageBusiness")
@SuppressWarnings("rawtypes")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class DefrayPageBusiness {
	public IProjectDAO projectDAO;
	private IOperateobjectDAO operateobjectDAO;
	
	public static final String SELECTALL="select Id,Name from Project where Userid='";
	public static final String SELECTA="select Id,Name from Project where Aspect='A' and Userid='";
	public static final String SELECTB="select Id,Name from Project where Aspect='B' and Userid='";
	public static final String SELECTC="select Id,Name from Project where Aspect='C' and Userid='";
	public static final String SELECTOOAB="select Id,Name from Operateobject where Userid='";;
	public static final String SELECTOOA="select Id,Name from Operateobject where Owner='A' and Userid='";;
	public static final String SELECTOOB="select Id,Name from Operateobject where Owner='B' and Userid='";;
	
	
	public List getListAll(String userid){
		List listAll=null;
		listAll=projectDAO.find(SELECTALL+userid+"'");
		return listAll;
	}
	public List getListA(String userid){
		List listA=null;
		listA=projectDAO.find(SELECTA+userid+"'");
		return listA;
	}
	public List getListB(String userid){
		List listB=null;
		listB=projectDAO.find(SELECTB+userid+"'");
		return listB;
	}
	public List getListC(String userid){
		List listC=null;
		listC=projectDAO.find(SELECTC+userid+"'");
		return listC;
	}
	
	public List getOOListAB(String userid){
		List listAB=null;
		listAB=operateobjectDAO.find(SELECTOOAB+userid+"'");
		return listAB;
	}
	public List getOOListA(String userid){
		List listA=null;
		listA=operateobjectDAO.find(SELECTOOA+userid+"'");
		return listA;
	}
	public List getOOListB(String userid){
		List listB=null;
		listB=operateobjectDAO.find(SELECTOOB+userid+"'");
		return listB;
	}
	
	
	public IOperateobjectDAO getOperateobjectDAO() {
		return operateobjectDAO;
	}
	@Resource(name="operateobjectDAO")
	public void setOperateobjectDAO(IOperateobjectDAO operateobjectDAO) {
		this.operateobjectDAO = operateobjectDAO;
	}
	public IProjectDAO getProjectDAO() {
		return projectDAO;
	}
	@Resource(name="projectDAO")
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	
}
