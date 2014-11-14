package cn.kanmars.business.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kanmars.dao.Operateobject;
import cn.kanmars.dao.OperateobjectPK;
import cn.kanmars.dao.dao.IOperateobjectDAO;
import cn.kanmars.util.SeqUtil;

@Component("oOManagerBusiness")
@Scope("prototype")
@SuppressWarnings("rawtypes")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class OOManagerBusiness {
	private IOperateobjectDAO operateobjectDAO;
	/**
	 * 获取某userid的所有操作对象列表
	 * 返回一个Object[4],其中Object[0]为List<Object[]>或者List&lt;Object&gt;对象,Object[1]为pageSize,Object[2]为pageNum,Object[3]为pageCount
	 * @param userid
	 * @return
	 * 
	 */
	
	public Object[] getABOperateObject(String userid,int pageSize,int pageNum) {
		Object [] ol=new Object[4];
		Map hashmap=new HashMap();
		hashmap.put("Userid", userid);
		ol[0]=operateobjectDAO.findByNamedQuery("query_oOListShowDAO_By_Userid",hashmap , (pageNum-1)*pageSize, pageSize);
		ol[1]=pageSize;
		ol[2]=pageNum;
		long l=(Long)operateobjectDAO.findByNamedQuery("query_oOListCountDAO_By_Userid",hashmap).get(0);
		ol[3]=(int)(l/pageSize+((l%pageSize>0)?1:0));
		return ol;
	}

	/**
	 * 获取某userid的所有A类操作对象列表
	 * 返回一个Object[4],其中Object[0]为List<Object[]>或者List&lt;Object&gt;对象,Object[1]为pageSize,Object[2]为pageNum,Object[3]为pageCount
	 * @param userid
	 * @return
	 * 
	 */
	public Object[] getAOperateObject(String userid,int pageSize,int pageNum) {
		Object [] ol=new Object[4];
		List simpleExpression =new ArrayList();
		simpleExpression.add(Restrictions.eq("Owner", "A"));
		ol=operateobjectDAO.findByCriteria(Operateobject.class, simpleExpression, pageSize, pageNum);
		return ol;
	}

	/**
	 * 获取某userid的所有B类操作对象列表
	 * 返回一个Object[4],其中Object[0]为List<Object[]>或者List&lt;Object&gt;对象,Object[1]为pageSize,Object[2]为pageNum,Object[3]为pageCount
	 * @param userid
	 * @return
	 * 
	 */
	public Object[] getBOperateObject(String userid,int pageSize,int pageNum) {
		Object [] ol=new Object[4];
		Map hashmap=new HashMap();
		hashmap.put("Userid", userid);
		hashmap.put("Owner", "B");
		ol[0]=operateobjectDAO.findByNamedQuery("query_oOListShowDAO_By_Userid_and_Owner",hashmap , (pageNum-1)*pageSize, pageSize);
		ol[1]=pageSize;
		ol[2]=pageNum;
		long l=(Long)operateobjectDAO.findByNamedQuery("query_oOListCountDAO_By_Userid_and_Owner",hashmap).get(0);
		ol[3]=(int)(l/pageSize+((l%pageSize>0)?1:0));
		return ol;
	}
	
	/**
	 * 通过用户userid来删除某个id的操作对象
	 * @param id
	 * @param userid
	 */
	public void deleteOperateObject(String id,String userid){
		OperateobjectPK opk=new OperateobjectPK(id, userid);
		operateobjectDAO.delete(opk);
	}
	
	/**保存Operateobject
	 * @param oo   Operateobject对象,userid必须已写入
	 */
	public void saveOperateObject(Operateobject operateobject){
		OperateobjectPK opk=null;
		String userid=null;
		if((opk=operateobject.getId())!=null&&(userid=opk.getUserid())!=null){
			if(opk.getId()==null){			
				opk.setId(SeqUtil.getOperateobjectSEQ(userid));
			}
			operateobjectDAO.save(operateobject);
		}else{
			System.out.println("没有userid");
		}
	}
	/**
	 * 更新Operateobject对象
	 * @param operateobject
	 */
	public void updOperateObject(Operateobject operateobject){
		OperateobjectPK opk=null;
		String id=null;
		String userid=null;
		if((opk=operateobject.getId())!=null&&(id=opk.getId())!=null&&(userid=opk.getUserid())!=null){
			Operateobject ooTemp=getOperateobject(operateobject.getId());
			if(ooTemp!=null){
				ooTemp.setBalance(operateobject.getBalance());
				ooTemp.setName(operateobject.getName());
				ooTemp.setOwner(operateobject.getOwner());
				ooTemp.setInfo(operateobject.getInfo());
				ooTemp.setUpdatetime(new Date());
				operateobjectDAO.update(ooTemp);
			}else{
				System.out.println("不存在该对象");
			}
		}else{
			System.out.println("主键不完整!");
		}
	}
	
	public Operateobject getOperateobject(OperateobjectPK opk){
		Operateobject oo=null;
		oo=operateobjectDAO.get(opk);
		return oo;
	}
	
	
	public IOperateobjectDAO getOperateobjectDAO() {
		return operateobjectDAO;
	}
	@Resource(name="operateobjectDAO")
	public void setOperateobjectDAO(IOperateobjectDAO operateobjectDAO) {
		this.operateobjectDAO = operateobjectDAO;
	}
	
}
