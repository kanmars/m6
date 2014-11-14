package cn.kanmars.business.exchange;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
/**
 * 转账交易，只允许从自己的账户转向自己的账户
 * @author Administrator
 *
 */
@Component("transfer")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class Transfer {
	private IExchangeDAO exchangeDAO;
	private IOperateobjectDAO operateobjectDAO;
	private IUserDAO userDAO;
	public void transfer(String name,double aspectsum,double handlingcharge,String operateObjectFrom,String OperateObjectTo,String operateContent,String operatePeople,String happenTime,String opinion){
		
		Operateobject operateobjectout=operateobjectDAO.get(new OperateobjectPK(operateObjectFrom, operatePeople));
		System.out.println("转出账户原状态："+operateobjectout.toString());
		Operateobject operateobjectin=operateobjectDAO.get(new OperateobjectPK(OperateObjectTo, operatePeople));
		System.out.println("转入账户原状态："+operateobjectin.toString());
		if(operateobjectout!=null&&operateobjectin!=null&&operateobjectout.getBalance()>=(aspectsum+handlingcharge)){
			Date date=new Date();
			System.out.print("系统保存交易记录......");
			//保存主交易记录
			Exchange exchange=new Exchange();
			exchange.setId(SeqUtil.getExchangeSEQ());
			exchange.setName(name);
			exchange.setAspect("A");
			exchange.setAspectsum(aspectsum);
			exchange.setOperateobjectfrom(operateObjectFrom);
			exchange.setOperateobjectto(OperateObjectTo);
			exchange.setOperatecontent(operateContent);
			exchange.setOperatepeople(operatePeople);
			exchange.setHappentime(happenTime);
			exchange.setRecordtime(date);
			exchange.setOpinion(opinion);
			exchangeDAO.save(exchange);
			//保存附属交易记录
			if(handlingcharge>0){
				Exchange handlingExchange=new Exchange();
				handlingExchange.setId(SeqUtil.getExchangeSEQ());
				handlingExchange.setName("手续费");
				handlingExchange.setAspect("B");
				handlingExchange.setAspectsum(handlingcharge);
				handlingExchange.setOperateobjectfrom(operateObjectFrom);
				handlingExchange.setOperateobjectto("WI00000012");//归类到其他，手续费
				handlingExchange.setOperatecontent("手续费");
				handlingExchange.setOperatepeople(operatePeople);
				handlingExchange.setHappentime(happenTime);
				handlingExchange.setRecordtime(date);
				exchangeDAO.save(handlingExchange);
			}
			System.out.println("系统保存交易记录成功！");
			//系统对两个账户进行互换
			System.out.println("账户资金转移开始......");
			operateobjectout.setBalance(change2(operateobjectout.getBalance()-aspectsum-handlingcharge));
			operateobjectout.setUpdatetime(new Date());
			operateobjectDAO.update(operateobjectout);
			operateobjectin.setBalance(change2(operateobjectin.getBalance()+aspectsum));
			operateobjectin.setUpdatetime(new Date());
			operateobjectDAO.update(operateobjectin);
			System.out.println("账户资金转移完毕！");
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
