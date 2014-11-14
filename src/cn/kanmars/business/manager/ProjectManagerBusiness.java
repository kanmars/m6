package cn.kanmars.business.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kanmars.dao.Project;
import cn.kanmars.dao.dao.IProjectDAO;
import cn.kanmars.util.SeqUtil;

@Component("projectManagerBusiness")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class ProjectManagerBusiness {
	private IProjectDAO projectDAO;

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public Object[] getABCProjectList(String userid,int pageSize,int pageNum){
		Object [] ol=new Object[4];
		HashMap hashmap=new HashMap();
		hashmap.put("Userid", userid);
		ol[0]=projectDAO.findByNamedQuery("query_projectListShowDAO_By_Userid",hashmap,(pageNum-1)*pageSize, pageSize);
		ol[1]=pageSize;
		ol[2]=pageNum;
		long l=(Long)projectDAO.findByNamedQuery("query_projectListCountDAO_By_Userid",hashmap).get(0);
		int count=(int)(l/pageSize+(l%pageSize>0?1:0));
		ol[3]=count;
		return ol;
	}
	
	public void deleteProject(String id,String userid){
		Project pro=projectDAO.get(id);
		if(pro.getUserid().equals(userid)){
			projectDAO.delete(pro);
		}
	}
	
	public void saveProject(Project project, String userid) {
		if(project.getName()!=null){
			project.setId(SeqUtil.getProjectSEQ(userid));
			project.setUserid(userid);
			project.setUpdopr(userid);
			project.setUpdtime(new Date());
			projectDAO.save(project);
		}
	}
	public Project ProjectUpdGet(Project project,String userid){
		String id=project.getId();
		if(id!=null){
			Project pro=null;
			pro=projectDAO.get(id);
			if(pro.getUserid().equals(userid))return pro;
		}
		return null;
	}
	public void ProjectUpdSet(Project project,String userid){
		String id=project.getId();
		if(id!=null){
			Project pro=null;
			pro=projectDAO.get(id);
			if(pro.getUserid().equals(userid)){
				pro.setName(project.getName());
				pro.setAspect(project.getAspect());
				pro.setUpdopr(userid);
				pro.setUpdtime(new Date());
				projectDAO.update(pro);
			}
		}
	}
	
	public IProjectDAO getProjectDAO() {
		return projectDAO;
	}

	@Resource(name="projectDAO")
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	
	
	
}
