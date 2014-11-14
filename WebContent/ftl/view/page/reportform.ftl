<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="报表页面" scripts=["reportform.js"]>
<div>
<div id="typeselect">
<input id="type1" name="typeselect" type="radio" value="tp1" checked="checked"/>单图模式&nbsp;&nbsp;
<input id="type2" name="typeselect" type="radio" value="tp2"/>多图模式
</div>
<input id="qzrqtbt" type="button" value="起止日期图"/>
<input id="monthbt" type="button" value="月份报表图"/>
</div>
<div id="qzrqt" style="display:none">
<table>
	<tr><td><input id="radio1" type="radio" name="qzrqt" value="Pie" checked="checked"/>饼图&nbsp;&nbsp;<input id="radio2" type="radio" name="qzrqt" value="Axis"/>柱形图&nbsp;&nbsp;<td></tr>
	<tr>
	<td>开始时间:<input id="startTime" value="20120101" /><br></td>
	</tr>
	<tr>
	<td>结束时间:<input id="endTime" value="20120101"/><br></td>
	</tr>
	<script>
		var date = new Date();
		var year = date.getFullYear();
		var nowMonth_ = date.getMonth()+1;
		var nextMonth_ = nowMonth_+1;
		var nowMonth= nowMonth_<10?"0"+nowMonth_:""+nowMonth_
		var nextMonth= nextMonth_<10?"0"+nextMonth_:""+nextMonth_
		$("#startTime").val(year+nowMonth+"01");
		$("#endTime").val(year+nextMonth+"01");
		$(function(){
			$("#endTime").keyup()
		})
	</script>
</table>
<img id="piepic" src=""/>
</div>
<div id="month" style="display:none">
请输入年份：<input id="monthyear" value="2012"/>年
<br>
<img id="monthpic" src="jFreeChartAxisMonthAction.action?year=2012"/>
</div>
</@f.frame>