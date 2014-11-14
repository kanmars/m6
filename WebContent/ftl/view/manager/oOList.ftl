<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="操作对象列表">
<br>
<table>
<tr>
	<td class="ooListTd1">ID</td>
	<td class="ooListTd2">名称</td>
	<td class="ooListTd3">账户拥有者</td>
	<td class="ooListTd4">金额</td>
	<td class="ooListTd5">元</td>
	<td class="ooListTd6">更新日期</td>
	<td class="ooListTd7">&nbsp;</td>
	<td class="ooListTd8">&nbsp;</td>
</tr>
<#list ABOperateObject as ab>
<tr>
	<td>${ab.id.id}</td>
	<td>${ab.name}</td>
	<td><#if ab.owner="A">自有账户<#else>消费账户</#if></td>
	<td>${ab.balance}</td>
	<td>元</td>
	<td>${ab.updatetime?string("yyyy-MM-dd HH:mm:ss")}</td>
	<td><input type="button" value="编辑" onclick="window.location.href='oOUpdGet.action?operateobject.id.id=${ab.id.id}'"/></td>
	<td><input type="button" value="删除" onclick="window.location.href='oODel.action?operateobject.id.id=${ab.id.id}'"/></td>
</tr>
</#list>
<tr>
	<td>
		<@c.painnation action="oOList.action" pageSize=pageSize pageNum=pageNum pageCount=pageCount />
	</td>
</tr>
<tr>
	<td colspan="6">
		<input type="button" value="新建账户" onclick="window.location.href='ftl/view/manager/oOAdd.ftl'"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="返回主界面" onclick="window.location.href='main.action'"/>
	</td>
</tr>
</table>
</@f.frame>