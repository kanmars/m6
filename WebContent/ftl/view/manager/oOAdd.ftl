<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="增加账户页面">
<form action="oOAdd.action" method="post">
<table>
	<tr>
		<td>账户类型：</td>
		<td>
			<select name="operateobject.owner">
				<option value="A">自有账户</option>
				<option value="B">消费账户</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>账户名称：</td>
		<td>
			<input style="width:200px;" name="operateobject.name"/>
		</td>
	</tr>
	<tr>
		<td>账户余额：</td>
		<td>
			<input style="width:200px;" name="operateobject.balance" value="0.0"/>
		</td>
	</tr>
	<tr>
		<td>账户简介：</td>
		<td>
			<input style="width:200px;" name="operateobject.info"/>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="reset" value="重置"/><input type="submit" value="提交"/></td>
	</tr>
</table>
</form>
</@f.frame>