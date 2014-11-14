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

@Component("laborage")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class Laborage {
	private IExchangeDAO exchangeDAO;
	private IOperateobjectDAO operateobjectDAO;
	private IUserDAO userDAO;
	public void laborage(String Name,double Aspectsum,String Operateobjectto,String Operatecontent,String Operatepeople,String Happentime,String Option){
		System.out.println("增加收入交易");
		System.out.println("增加交易记录");
		Date date=new Date();
		Exchange exchange=new Exchange();
		exchange.setId(SeqUtil.getExchangeSEQ());
		exchange.setName(Name);
		exchange.setAspect("C");
		exchange.setAspectsum(Aspectsum);
		exchange.setOperateobjectto(Operateobjectto);
		exchange.setOperatecontent(Operatecontent);
		exchange.setOperatepeople(Operatepeople);
		exchange.setHappentime(Happentime);
		exchange.setRecordtime(date);
		exchange.setOpinion(Option);
		exchangeDAO.save(exchange);
		System.out.println("交易记录增加完成");
		Operateobject operateobject=operateobjectDAO.get(new OperateobjectPK(Operateobjectto, Operatepeople));
		operateobject.setBalance(change2(operateobject.getBalance()+Aspectsum));
		operateobject.setUpdatetime(new Date());
		operateobjectDAO.update(operateobject);
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
