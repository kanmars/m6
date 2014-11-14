<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="增加交易页面">
<form action="projectAdd.action" method="post">
<table>
	<tr>
		<td>交易类型：</td>
		<td>
			<select name="project.aspect">
				<option value="A">转账交易</option>
				<option value="B">消费交易</option>
				<option value="C">入账交易</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>交易名称：</td>
		<td>
			<input style="width:200px;" name="project.name"/>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="reset" value="重置"/><input type="submit" value="提交"/></td>
	</tr>
</table>
</form>
</@f.frame>