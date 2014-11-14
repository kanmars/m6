package cn.kanmars.business.exchange;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.kanmars.dao.Exchange;
import cn.kanmars.dao.Operateobject;
import cn.kanmars.dao.OperateobjectPK;
import cn.kanmars.dao.dao.IExchangeDAO;
import cn.kanmars.dao.dao.IOperateobjectDAO;
import cn.kanmars.dao.dao.IUserDAO;
import cn.kanmars.util.SeqUtil;
import cn.kanmars.util.StrUtil;

@Component("defray")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class Defray {
	private IExchangeDAO exchangeDAO;
	private IOperateobjectDAO operateobjectDAO;
	private IUserDAO userDAO;
	/**
	 * 购买东西并付款
	 * @param name	名称,建议静态常量
	 * @param aspectsum	方向数目，-20，默认方向为B，buy
	 * @param operateObjectFrom	从哪个账户支出
	 * @param OperateObjectTo	支付向哪个账户
	 * @param operateContent	支付内容
	 * @param operatePeople		操作人
	 * @param happenTime	发生时间
	 * @param opinion	回应
	 */
	public void defray(String name,double aspectsum,String operateObjectFrom,String OperateObjectTo,String operateContent,String operatePeople,String happenTime,String opinion){
		Operateobject operateobject=operateobjectDAO.get(new OperateobjectPK(operateObjectFrom, operatePeople));
		System.out.println("被操作账户原状态："+operateobject.toString());
		if(operateobject.getBalance()+aspectsum>=0){
			System.out.println("可进行操作"+aspectsum+"元");
			
			Date date=new Date();
			System.out.print("系统保存交易记录......");
			//保存交易记录
			Exchange exchange=new Exchange();
			exchange.setId(SeqUtil.getExchangeSEQ());
			exchange.setName(name);
			exchange.setAspect("B");
			exchange.setAspectsum(aspectsum);
			exchange.setOperateobjectfrom(operateObjectFrom);
			exchange.setOperateobjectto(OperateObjectTo);
			exchange.setOperatecontent(operateContent);
			exchange.setOperatepeople(operatePeople);
			exchange.setHappentime(happenTime);
			exchange.setRecordtime(date);
			exchange.setOpinion(opinion);
			exchangeDAO.save(exchange);
			System.out.println("系统保存交易记录成功！");
			//更新操作对象记录
			System.out.print("系统更新操作对象记录......");
			operateobject.setBalance(change2(operateobject.getBalance()+aspectsum));
			operateobject.setUpdatetime(date);
			operateobjectDAO.update(operateobject);
			System.out.println("系统更新操作对象记录成功！");
			//更新目标对象
			if(OperateObjectTo!=null){
				if(OperateObjectTo.equals("")){
					OperateObjectTo="WI00000012";//如果是无，则费用记作WI00000012其他费用
				}
			System.out.print("系统更新目标操作对象记录......");
			Operateobject operateobjectto=operateobjectDAO.get(new OperateobjectPK(OperateObjectTo, operatePeople));
			operateobjectto.setBalance(change2(operateobjectto.getBalance()-aspectsum));
			operateobjectDAO.update(operateobjectto);
			System.out.println("系统更新目标操作对象记录成功！");
			}
			System.out.println("交易成功!");
			
		}
	}
	/**
	 * 对double型的数据进行小数点后两位四舍五入，避免出现小数点后8位的情形
	 * @return
	 */
	private double change2(double d){
		BigDecimal b=new BigDecimal(d);
		d=b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		return d;
	}
	
	public IExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}
	@Resource(name="exchangeDAO")
	public void setExchangeDAO(IExchangeDAO exchangeDAO) {
		this.exchangeDAO = exchangeDAO;
	}
	public IOperateobjectDAO getOperateobjectDAO() {
		return operateobjectDAO;
	}
	@Resource(name="operateobjectDAO")
	public void setOperateobjectDAO(IOperateobjectDAO operateobjectDAO) {
		this.operateobjectDAO = operateobjectDAO;
	}
	public IUserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAO")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
