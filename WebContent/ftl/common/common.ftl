<#macro HTMLTOP title>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<base href="${basehref}"/>
<script language="javascript" type="text/javascript" src="ftl/js/jquery-1.5.2.min.js"></script>
</head>
<body>
</#macro>

<#macro HTMLEND>
</body>
</html>
</#macro>

<#macro DATETIME>
	<span id="DATETIME"></span>
	<script>
	$(function(){
			var date= new Date();
			var str=(date.getYear()+1900)+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日    "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			$("#DATETIME").html(str);
		setInterval(function(){
			var date= new Date();
			var str=(date.getYear()+1900)+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日    "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			$("#DATETIME").html(str);
		},1000)
	});
	</script>
</#macro>

<#macro jfreechartpie>
<table>
	<tr>
	<td>开始时间:<input id="startTime" value="20120101" /><br></td>
	</tr>
	<tr>
	<td>结束时间:<input id="endTime" value="20120101"/><br></td>
	</tr>
</table>
<img id="pic" src="jFreeChartPieAction.action?startTime=20120101&endTime=20120101"/>
<script>
	function ck(){
		var starttime=$("#startTime").val();
		var endtime=$("#endTime").val();
		var regex=/[0-9]{8}/;
		if(regex.test(starttime)&&regex.test(endtime)){
			src="jFreeChartPieAction.action?startTime="+starttime+"&endTime="+endtime;
			$("#pic").attr("src",src);
		}
	}
	$(function(){
		$("#endTime").keyup(ck).change(ck);
	});
</script>
</#macro>
<#macro painnation action pageSize pageNum pageCount>
	<style>
		.yes{
			font-size:14px;
			color:blue;
			text-decoration:none;
		}
		.no{
			font-size:14px;
			color:silver;
			text-decoration:none;
		}
		.pageblue{
			font-size:14px;
			color:blue;
		}
		.pagered{
			font-size:14px;
			color:red;
		}
	</style>
	<script type="text/javascript" language="javascript">
	 	var pageSize=${pageSize};
		function getPageSize(){
			return $("#psinput").val();
		}
		function getPageNum(){
			return $("#jpto").val();
		}
		function jumpTo(pageSize,pageNum){
			var pageSizeReal=getPageSize();
			if(pageSizeReal!=undefined)
				window.location.href="${action}?pageSize="+pageSizeReal+"&pageNum="+pageNum;
			else
				window.location.href="${action}?pageSize="+pageSize+"&pageNum="+pageNum;
		}
		function jumpToSelectPage(){
			var pageSizeReal=getPageSize();
			if(pageSizeReal!=undefined)
				window.location.href="${action}?pageSize="+pageSizeReal+"&pageNum="+getPageNum();
			else
				window.location.href="${action}?pageSize="+pageSize+"&pageNum="+getPageNum();
		}
	</script>
	<div>
		<#if (pageNum>1)>
			<a class="yes" onclick="jumpTo(${pageSize},1)">首页</a>
			<a class="yes" onclick="jumpTo(${pageSize},${pageNum-1})">上一页</a>
		<#else>
			<a class="no">首页</a>
			<a class="no">上一页</a>
		</#if>
			<span class="pageblue">当前第<span class="pagered">${pageNum}</span>页/共<span class="pagered">${pageCount}</span>页</span>
		<#if (pageNum<pageCount)>
			<a class="yes" onclick="jumpTo(${pageSize},${pageNum+1})">下一页</a>
			<a class="yes" onclick="jumpTo(${pageSize},${pageCount})">末页</a>
		<#else>
			<a class="no">下一页</a>
			<a class="no">末页</a>
		</#if>
			<br>
			每页显示<input id="psinput" style="width:30px;height:16px" value="${pageSize}"/>条&nbsp;&nbsp;&nbsp;&nbsp;
			跳转到第<input id="jpto" style="width:30px;height:16px" value="${pageNum}"/>页<input type="button" value="跳转" onclick="jumpToSelectPage()"/>
	</div>
</#macro>
