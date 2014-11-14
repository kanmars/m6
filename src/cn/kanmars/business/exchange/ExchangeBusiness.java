package cn.kanmars.business.exchange;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kanmars.dao.dao.IExchangeDAO;
import cn.kanmars.dao.dao.IOperateobjectDAO;
import cn.kanmars.dao.dao.IUserDAO;
@Component("exchangeBusiness")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class ExchangeBusiness {
	private IExchangeDAO exchangeDAO;
	private IOperateobjectDAO operateobjectDAO;
	private IUserDAO userDAO;
	/**
	 * 返回一个数组，数组第一位是一个list,是一个数量为pageSize的list,储存数据库中的数据
	 * 第二位是pagenumber,是第几页，第三位是pagecount,指页面有多少页
	 * @param pageSize	每页显示多少条
	 * @param pagenumber 当前页数
	 * @return Object[] s
	 */
	public Object[] getpage(String userid,int pageSize,int pagenumber,String startTime,String endTime){
		/**
		 * 查询总页数
		 */
		/**
		 * 初始化hql语句
		 */
		StringBuilder hql_=new StringBuilder("from Exchange where Operatepeople='"+userid+"'");
		boolean st=(startTime!=null);
		boolean ed=(endTime!=null);
		if(st||ed)hql_.append(" and ");
		if(st)hql_.append(" Happentime > " + startTime);
		if(st&&ed)hql_.append(" and ");
		if(ed)hql_.append(" Happentime < " + endTime);
		/**
		 * 增加select count头
		 */
		long allcount_l=(Long)exchangeDAO.find("select count(*) "+hql_.toString()).get(0);
		
		int allcount=(int)(allcount_l);
		int pagecount=allcount/pageSize+(allcount%pageSize>0?1:0);
		/**如果页数小与等于0，则显示第一页*/
		if(pagenumber<=0)pagenumber=1;
		/**如果页数超出，则显示最后一页 */
		if(pagenumber>pagecount)pagenumber=pagecount;
		/**
		 * 查询相应内容
		 */
		Object [] s=new Object[3];
		/**
		 * 增加排序
		 */
		hql_.append(" order by Happentime desc");
		
		Query query=exchangeDAO.getQuery(hql_.toString());
		query.setMaxResults(pageSize);
		query.setFirstResult((pagenumber-1)*pageSize);
		List result=query.list();
		
		s[0]=result;
		s[1]=pagenumber;
		s[2]=pagecount;
		return s;
	}
	
	public IExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}
	@Resource(name="exchangeDAO")
	public void setExchangeDAO(IExchangeDAO exchangeDAO) {
		this.exchangeDAO = exchangeDAO;
	}
}
/**
select * from (select * from (select no,rowno from people order by datetime) order by no) where no between 20 and 30 
 */
