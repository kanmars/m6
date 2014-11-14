package cn.kanmars.jfreechart.datebase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.dao.dao.IExchangeDAO;
import cn.kanmars.dao.dao.IOperateobjectDAO;
import cn.kanmars.dao.dao.IUserDAO;

@Component("jFreeChartDataSet")
@Scope("prototype")
public class JFreeChartDataSet {
	private IExchangeDAO exchangeDAO;
	private IOperateobjectDAO operateobjectDAO;
	private IUserDAO userDAO;
	private double sumAllExchange;

	/**
	 * 传入一个piedataset集合，用户编号，开始结束时间，对集合进行加工，成为可用的对象
	 * 
	 * @param defaultPieDataset
	 *            待加工的饼图值集
	 * @param userid
	 *            交易所属人
	 * @param aspect
	 *            交易方向 A转账,B消费,C入账
	 * @param startTime
	 *            开始时间，可为空
	 * @param endTime
	 *            结束时间，可为空
	 * @return defaultPieDataset 加工好的饼图值集
	 */
	public DefaultPieDataset setPieDataset(DefaultPieDataset defaultPieDataset,
			String userid, String aspect, String startTime, String endTime) {
		Object[] ol;// 交易名称和交易值的对应
		String name;// 交易名称的变量
		double value;// 交易的值和总和
		sumAllExchange = 0;
		List list = list = resList(userid, aspect, startTime, endTime);
		list = accumulate(list);
		for (int i = 0, j = list.size(); i < j; i++) {
			ol = (Object[]) list.get(i);
			name = (String) ol[0];
			value = (Double) ol[1];
			if(sumAllExchange!=0)
			defaultPieDataset.setValue(name + value + "元"
					+ change2(change4(value / sumAllExchange) * 100) + "%", value);
		}
		return defaultPieDataset;
	}

	/**
	 * 传入一个柱状图DefaultCategoryDataset,返回一个加工好的DefaultCategoryDataset
	 * 
	 * @param defaultCategoryDataset
	 *            待加工的defaultCategoryDataset
	 * @param userid
	 *            用户id
	 * @param userid
	 *            交易所属人
	 * @param aspect
	 *            交易方向 A转账,B消费,C入账
	 * @param startTime
	 *            开始时间，可为空
	 * @param endTime
	 *            结束时间，可为空
	 * @return defaultCategoryDataset 加工好的柱状图值集
	 */
	public DefaultCategoryDataset setDefaultCategoryDataset(
			DefaultCategoryDataset defaultCategoryDataset, String userid,
			String aspect, String startTime, String endTime) {
		Object[] ol;// 交易名称和交易值的对应
		String name;// 交易名称的变量
		double value;// 交易的值和总和
		sumAllExchange = 0;
		List list = resList(userid, aspect, startTime, endTime);
		list = accumulate(list);
		for (int i = 0; i < list.size(); i++) {
			ol = (Object[]) list.get(i);
			value = Math.abs((Double) ol[1]);
			name = (String) ol[0];
			if(sumAllExchange!=0)
			defaultCategoryDataset.setValue(value, name + value+"元"+change2(change4(value / sumAllExchange) * 100)+"%", name);
		}
		return defaultCategoryDataset;
	}

	/**
	 * 传入一个空白柱状图DefaultCategoryDataset,返回一个加工好的DefaultCategoryDataset，月份记录
	 * 
	 * @param defaultCategoryDataset
	 *            待加工的defaultCategoryDataset
	 * @param userid
	 *            用户id
	 * @param userid
	 *            交易所属人
	 * @param aspect
	 *            交易方向 A转账,B消费,C入账
	 * @return defaultCategoryDataset 加工好的柱状图值集
	 */
	public DefaultCategoryDataset setMonthDefaultCategoryDataset(
			DefaultCategoryDataset defaultCategoryDataset, String userid,
			String aspect,String year) {
		Object[] ol;// 交易名称和交易值的对应
		String name;// 交易名称的变量
		double value;// 交易的值和总和
		sumAllExchange = 0;
		List list = resList(userid, aspect, year+"0101", year+"1232");//此处放1232是考虑到12月31日的边界问题
		double[] perMonth=accumulateMonth(list);
		for (int i = 0; i < perMonth.length;i++) {
			if(sumAllExchange!=0)
			defaultCategoryDataset.setValue(perMonth[i], (i+1)+"月"+perMonth[i]+"元"+change2(change4(perMonth[i]/sumAllExchange)*100)+"%", (i+1)+"月");
		}
		return defaultCategoryDataset;
	}
	
	/**
	 * 传入userid,交易方向，开始时间和结束时间，获取到该段时间的交易列表
	 * 
	 * @param userid
	 *            用户id
	 * @param aspect
	 *            交易方向
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return list<Object[]>返回Object[0]=name,Object[1]=value;
	 */
	private List resList(String userid, String aspect, String startTime,
			String endTime) {
		List result = new ArrayList();
		StringBuilder sb = new StringBuilder();
		sb.append("select Name,Aspectsum,Happentime from Exchange where operatepeople='");
		sb.append(userid);
		sb.append("' and aspect='" + aspect + "'");
		boolean st = startTime != null;
		boolean et = endTime != null;
		if (st | et)
			sb.append(" and ");
		if (st)
			sb.append("Happentime>= '" + startTime + "' ");
		if (st && et)
			sb.append(" and ");
		if (et)
			sb.append("Happentime< '" + endTime + "'");
		List list = exchangeDAO.find(sb.toString());

		return list;
	}

	/**
	 * 传入一个待累加的list，返回一个累加后的结果，并在过程中计算总值赋值给sumAllExchange
	 * 
	 * @param list
	 * @return
	 */
	public List accumulate(List list) {
		List result = new ArrayList();
		HashMap hashmap = new HashMap();
		Iterator ite = list.iterator();
		while (ite.hasNext()) {
			Object[] o = (Object[]) ite.next();
			String name = (String) o[0];
			double aspectsum = (Double) o[1];
			// 取绝对值，负数不可用
			aspectsum = Math.abs(aspectsum);
			/**
			 * 取总值
			 */
			sumAllExchange = change2(sumAllExchange+aspectsum);

			if (hashmap.get(name) == null) {
				hashmap.put(name, aspectsum);
			} else {
				double sum = (Double) hashmap.get(name);
				sum = change2(sum+aspectsum);
				hashmap.put(name, sum);
			}
		}
		ite = hashmap.entrySet().iterator();
		while (ite.hasNext()) {
			Entry<String, Double> es = (Entry<String, Double>) ite.next();
			result.add(new Object[] { (String) es.getKey(),
					(double) es.getValue() });
		}
		return result;
	}
	/**
	 * 传入一个list,返回一个长度为12的double数组，其中储存每个月的消费，总值记录入sumAllExchange
	 * 
	 * @param list
	 * @return	List
	 */
	public double[] accumulateMonth(List list) {
		double[] result=new double[]{0,0,0,0,0,0,0,0,0,0,0,0};
		Object[] ol;
		String name;
		double value;
		String happentime;
		sumAllExchange=0;
		Iterator ite=list.iterator();
		while(ite.hasNext()){
			ol=(Object[])ite.next();
			name=(String)ol[0];
			value=Math.abs((Double)ol[1]);
			happentime=(String)ol[2];//12345678,月份为56
			sumAllExchange=change2(sumAllExchange+value);
			int xiabiao=Integer.parseInt(happentime.substring(4, 6))-1;
			result[xiabiao]=change2(result[xiabiao]+value);
		}
		return result;
	}

	/**
	 * 对double型的数据进行小数点后两位四舍五入，避免出现小数点后8位的情形
	 * 
	 * @return
	 */
	private double change2(double d) {
		BigDecimal b = new BigDecimal(d);
		d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return d;
	}
	/**
	 * 对double型的数据进行小数点后五位四舍五入，避免出现小数点后8位的情形
	 * @return
	 */
	private double change4(double d){
		BigDecimal b = new BigDecimal(d);
		d = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		return d;
	}

	public IExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}

	@Resource(name = "exchangeDAO")
	public void setExchangeDAO(IExchangeDAO exchangeDAO) {
		this.exchangeDAO = exchangeDAO;
	}

	public IOperateobjectDAO getOperateobjectDAO() {
		return operateobjectDAO;
	}

	@Resource(name = "operateobjectDAO")
	public void setOperateobjectDAO(IOperateobjectDAO operateobjectDAO) {
		this.operateobjectDAO = operateobjectDAO;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public double getSumAllExchange() {
		return sumAllExchange;
	}

	public void setSumAllExchange(double sumAllExchange) {
		this.sumAllExchange = sumAllExchange;
	}

}
