<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="账户信息修改${operateobject.name}">
<form action="oOUpdSet.action" method="post">
<input type="hidden" name="operateobject.id.id" value="${operateobject.id.id}"/>
<table>
	<tr>
		<td>账户类型：</td>
		<td>
			<select name="operateobject.owner">
				<option value="A" <#if operateobject.owner="A">selected="selected"</#if>>自有账户</option>
				<option value="B" <#if operateobject.owner="B">selected="selected"</#if>>消费账户</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>账户名称：</td>
		<td>
			<input style="width:200px;" name="operateobject.name" value="${operateobject.name}"/>
		</td>
	</tr>
	<tr>
		<td>账户余额：</td>
		<td>
			<input style="width:200px;" name="operateobject.balance" value="${operateobject.balance}"/>
		</td>
	</tr>
	<tr>
		<td>账户简介：</td>
		<td>
			<input style="width:200px;" name="operateobject.info" value="${operateobject.info}"/>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="reset" value="重置"/><input type="submit" value="提交"/></td>
	</tr>
</table>
</form>
</@f.frame>