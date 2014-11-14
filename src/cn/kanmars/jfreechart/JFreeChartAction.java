package cn.kanmars.jfreechart;

import java.awt.Font;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.kanmars.constant.$;
import cn.kanmars.dao.User;
import cn.kanmars.jfreechart.datebase.JFreeChartDataSet;

@Component("jFreeChartAction")
@Scope("prototype")
public class JFreeChartAction {
	private JFreeChart chart;
	public String startTime;
	public String endTime;
	public String year;
	private JFreeChartDataSet jFreeChartDataSet;

	/**
	 * 返回某时段的元素饼状图
	 * 
	 * @return
	 */
	public String pie() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("image/jpeg");
		DefaultPieDataset dataset = new DefaultPieDataset();
		String userid=null;
		userid=getUserId();
		if(userid!=null){			
			dataset = jFreeChartDataSet.setPieDataset(dataset,userid, "B", startTime, endTime);
		}
		StringBuilder title = new StringBuilder(startTime.substring(4))
				.append("-")
				.append(endTime.substring(4))
				.append("消费图(")
				.append(jFreeChartDataSet.getSumAllExchange())
				.append("元)");
		chart = ChartFactory.createPieChart(title.toString(), dataset, true, true, true);
		
		Font fontTitle = new Font("黑体", Font.PLAIN, 20);
		Font fontPlot = new Font("宋体", Font.PLAIN, 12);
		Font fontLegend = new Font("宋体", Font.PLAIN, 12);

		TextTitle txtTitle = chart.getTitle();
		txtTitle.setFont(fontTitle);

		PiePlot pieplot = (PiePlot) chart.getPlot();
		pieplot.setLabelFont(fontPlot);

		chart.getLegend().setItemFont(fontLegend);

		return "success";
	}
	public String axis(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("image/jpeg");
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		String userid=null;
		userid=getUserId();
		if(userid!=null){
			dataset=jFreeChartDataSet.setDefaultCategoryDataset(dataset, userid, "B", startTime, endTime);
		}
		StringBuilder title = new StringBuilder(startTime.substring(4))
		.append("-")
		.append(endTime.substring(4))
		.append("消费图(")
		.append(jFreeChartDataSet.getSumAllExchange())
		.append("元)");
		chart=ChartFactory.createBarChart3D(title.toString(), "项目", "金额", dataset, PlotOrientation.VERTICAL, true, true, true);
		
		Font fontTitle = new Font("黑体", Font.PLAIN, 20);
		Font fontPlot = new Font("宋体", Font.PLAIN, 12);
		Font fontLegend = new Font("宋体", Font.PLAIN, 12);
		
		TextTitle txtTitle = chart.getTitle();
		txtTitle.setFont(fontTitle);
		
		
		CategoryPlot categoryPlot=chart.getCategoryPlot();
		//水平标题
		CategoryAxis domainAxis=categoryPlot.getDomainAxis();
		domainAxis.setLabelFont(fontPlot);
		//水平底部标题
	    domainAxis.setTickLabelFont(fontPlot);
		//垂直标题
		ValueAxis valueAxis=categoryPlot.getRangeAxis();
		valueAxis.setLabelFont(fontPlot);
		
		chart.getLegend().setItemFont(fontLegend);
		return "success";
	}
	
	public String axisByMonth(){
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		String userid=null;
		userid=getUserId();
		if(userid!=null&&year!=null){
			dataset=jFreeChartDataSet.setMonthDefaultCategoryDataset(dataset, userid, "B", year);
		}
		StringBuilder title = new StringBuilder(year)
		.append("年消费情况图(")
		.append(jFreeChartDataSet.getSumAllExchange())
		.append("元)");
		chart=ChartFactory.createBarChart3D(title.toString(), "月份", "金额", dataset, PlotOrientation.VERTICAL, true, true, true);
		
		Font fontTitle = new Font("黑体", Font.PLAIN, 20);
		Font fontPlot = new Font("宋体", Font.PLAIN, 12);
		Font fontLegend = new Font("宋体", Font.PLAIN, 12);
		
		TextTitle txtTitle = chart.getTitle();
		txtTitle.setFont(fontTitle);
		
		CategoryPlot categoryPlot=chart.getCategoryPlot();
		//水平标题
		CategoryAxis domainAxis=categoryPlot.getDomainAxis();
		domainAxis.setLabelFont(fontPlot);
		//水平底部标题
	    domainAxis.setTickLabelFont(fontPlot);
		//垂直标题
		ValueAxis valueAxis=categoryPlot.getRangeAxis();
		valueAxis.setLabelFont(fontPlot);
		
		chart.getLegend().setItemFont(fontLegend);
		return "success";
	}
	
	public String getUserId(){
		String result=null;
		result=((User)ServletActionContext.getRequest().getSession().getAttribute($.SESSIONUSER)).getId();
		return result;
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

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public JFreeChartDataSet getjFreeChartDataSet() {
		return jFreeChartDataSet;
	}

	@Resource(name = "jFreeChartDataSet")
	public void setjFreeChartDataSet(JFreeChartDataSet jFreeChartDataSet) {
		this.jFreeChartDataSet = jFreeChartDataSet;
	}

}
