package cn.kanmars.action.manager;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.business.manager.ProjectManagerBusiness;
import cn.kanmars.business.user.LogBusiness;
import cn.kanmars.constant.$;
import cn.kanmars.dao.Project;
import cn.kanmars.dao.User;
import cn.kanmars.dao.dao.IProjectDAO;

@Component("projectManagerAction")
@Scope("prototype")
@SuppressWarnings({"rawtypes","unused"})

public class ProjectManagerAction {
	public int pageSize=10;
	public int pageNum=1;
	public int pageCount=1;
	public Project project;
	public List projectABCList;
	private IProjectDAO projectDAO;
	private LogBusiness logBusiness;
	
	public ProjectManagerBusiness projectManagerBusiness;
	
	public String projectABCList(){
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		Object[] ol=projectManagerBusiness.getABCProjectList(u.getId(), pageSize, pageNum);
		projectABCList=(List)ol[0];
		pageSize=(Integer)ol[1];
		pageNum=(Integer)ol[2];
		pageCount=(Integer)ol[3];
		HttpSession session=ServletActionContext.getRequest().getSession();
		logBusiness.login(u);
		return "success";
	}
	
	public String projectAdd(){
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		projectManagerBusiness.saveProject(project,u.getId());
		logBusiness.login(u);
		return "success";
	}
	public String projectDel(){
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		projectManagerBusiness.deleteProject(project.getId(), u.getId());
		logBusiness.login(u);
		return "success";
	}
	
	public String projectUpdGet(){
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		project=projectManagerBusiness.ProjectUpdGet(project, u.getId());
		logBusiness.login(u);
		return "success";
	}
	
	public String projectUpdSet(){
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		projectManagerBusiness.ProjectUpdSet(project, u.getId());
		logBusiness.login(u);
		return "success";
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List getProjectABCList() {
		return projectABCList;
	}

	public void setProjectABCList(List projectABCList) {
		this.projectABCList = projectABCList;
	}

	public ProjectManagerBusiness getProjectManagerBusiness() {
		return projectManagerBusiness;
	}

	@Resource(name="projectManagerBusiness")
	public void setProjectManagerBusiness(
			ProjectManagerBusiness projectManagerBusiness) {
		this.projectManagerBusiness = projectManagerBusiness;
	}

	public IProjectDAO getProjectDAO() {
		return projectDAO;
	}

	@Resource(name="projectDAO")
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public LogBusiness getLogBusiness() {
		return logBusiness;
	}
	@Resource(name = "logBusiness")
	public void setLogBusiness(LogBusiness logBusiness) {
		this.logBusiness = logBusiness;
	}
	
	
}
