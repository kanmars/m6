<#macro frame title scripts=[] styles=[]>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<base href="${basehref}"/>
<script language="javascript" type="text/javascript" src="ftl/js/jquery-1.5.2.min.js"></script>
<#list scripts as s>
<script language="javascript" type="text/javascript" src="ftl/js/${s}"></script>
</#list>
<#list styles as s>
<link rel="stylesheet" type="text/css" href="ftl/css/${s}" />
</#list>
</head>
<body>
欢迎你:${SessionUser.name},现在是<@c.DATETIME/>
<br><hr>
<a href="main.action">主界面</a>
<a href="defrayPageAction.action">消费记录</a>
<a href="transferPageAction.action">账户内转账</a>
<a href="laboragePageAction.action">工资</a>
<a href="exchangell.action?pagenumber=1&pageSize=20&startTime=20130101">查看记录</a>
<a href="ftl/view/page/reportform.ftl">查看报表</a>
<a href="oOList.action?pageSize=10&pageNum=1">账户管理</a>
<a href="projectABCList.action?pageSize=10&pageNum=1">交易管理</a>
<a href="logout.action">退出系统</a>
<hr>
	<#nested>
</body>
</html>
</#macro>