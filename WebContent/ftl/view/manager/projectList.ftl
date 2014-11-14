<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="交易列表">
<br>
<table>
<tr>
	<td class="ooListTd1">交易ID</td>
	<td class="ooListTd2">交易名称</td>
	<td class="ooListTd3">交易方向</td>
	<td class="ooListTd6">更新日期</td>
	<td class="ooListTd7">&nbsp;</td>
	<td class="ooListTd8">&nbsp;</td>
</tr>
<#list projectABCList as abc>
<tr>
	<td>${abc.id}</td>
	<td>${abc.name}</td>
	<td>
		<#if abc.aspect="A">
			转账
		<#elseif abc.aspect="B">
			消费
		<#elseif abc.aspect="C">
			收入
		</#if></td>
	<td>${abc.updtime?string("yyyy-MM-dd HH:mm:ss")}</td>
	<td><input type="button" value="编辑" onclick="window.location.href='projectUpdGet.action?project.id=${abc.id}'"/></td>
	<td><input type="button" value="删除" onclick="window.location.href='projectDel.action?project.id=${abc.id}'"/></td>
</tr>
</#list>
<tr>
	<td>
		<@c.painnation action="projectABCList.action" pageSize=pageSize pageNum=pageNum pageCount=pageCount />
	</td>
</tr>
<tr>
	<td colspan="6">
		<input type="button" value="新建交易" onclick="window.location.href='ftl/view/manager/projectAdd.ftl'"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="返回主界面" onclick="window.location.href='main.action'"/>
	</td>
</tr>
</table>
</@f.frame>