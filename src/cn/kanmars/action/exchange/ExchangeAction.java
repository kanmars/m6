package cn.kanmars.action.exchange;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.business.exchange.Defray;
import cn.kanmars.business.exchange.ExchangeBusiness;
import cn.kanmars.business.exchange.Laborage;
import cn.kanmars.business.exchange.Transfer;
import cn.kanmars.constant.$;
import cn.kanmars.dao.Exchange;
import cn.kanmars.dao.User;

@Component("exchangeAction")
@Scope("prototype")
public class ExchangeAction {

	private Defray defray;
	private Exchange exchange;
	private Transfer transfer;
	private Laborage laborage;
	private ExchangeBusiness exchangeBusiness;
	private int pageSize = 10;
	private int pageNum = 1;
	private int pageCount=0;
	private List exchangeList=new ArrayList();
	private double handlingcharge;//手续费
	private String startTime;
	private String endTime;
	/**
	 * 所有交易
	 * @return
	 */
	public String defray() {
		System.out.println("交易支付");
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		if(exchange.getAspect().equals("B")){
			defray.defray(exchange.getName(), exchange.getAspectsum(), exchange.getOperateobjectfrom(), exchange.getOperateobjectto(), exchange.getOperatecontent(), u.getId(), exchange.getHappentime(), exchange.getOpinion());
		}
		return "success";
	}
	public String transfer() {
		System.out.println("账户内部转账");
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		if(exchange.getAspect().equals("A")){
			transfer.transfer(exchange.getName(), exchange.getAspectsum(),handlingcharge, exchange.getOperateobjectfrom(), exchange.getOperateobjectto(), exchange.getOperatecontent(), u.getId(), exchange.getHappentime(), exchange.getOpinion());
		}
		return "success";
	}
	public String laborage(){
		System.out.println("获得收入");
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		if(exchange.getAspect().equals("C")){
			laborage.laborage(exchange.getName(), exchange.getAspectsum(), exchange.getOperateobjectto(), exchange.getOperatecontent(), u.getId(), exchange.getHappentime(), exchange.getOpinion());
		}
		return "success";
	}
	public String list(){
		System.out.println("列表显示exchange");
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER);
		Object[] olist=exchangeBusiness.getpage(u.getId(), pageSize, pageNum,startTime,endTime);
		if(olist!=null){
			exchangeList=(List)olist[0];//被访问值
			pageNum=(Integer)olist[1];//当前页数,可能超出范围后转化
			pageCount=(Integer)olist[2];//总页数
			return "success";
		}
		return "fail";
	}
	

	public Defray getDefray() {
		return defray;
	}
	@Resource(name="defray")
	public void setDefray(Defray defray) {
		this.defray = defray;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	public Transfer getTransfer() {
		return transfer;
	}
	@Resource(name="transfer")
	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
	public double getHandlingcharge() {
		return handlingcharge;
	}
	public void setHandlingcharge(double handlingcharge) {
		this.handlingcharge = handlingcharge;
	}
	public Laborage getLaborage() {
		return laborage;
	}
	@Resource(name="laborage")
	public void setLaborage(Laborage laborage) {
		this.laborage = laborage;
	}
	public ExchangeBusiness getExchangeBusiness() {
		return exchangeBusiness;
	}
	@Resource(name="exchangeBusiness")
	public void setExchangeBusiness(ExchangeBusiness exchangeBusiness) {
		this.exchangeBusiness = exchangeBusiness;
	}
	public List getExchangeList() {
		return exchangeList;
	}
	public void setExchangeList(List exchangeList) {
		this.exchangeList = exchangeList;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	
	
}
