<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="新增消费记录(单纯向A帐转入)">
	<form action="laborage.action" method="post">
		<table>
			<tr>
				<td>收入名称:</td>
				<td><select name="exchange.Name">
						<option value="工资">工资</option>
						<option value="雅高卡">雅高卡</option>
						<option value="补助">补助</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>交易方向：</td>
				<td><select name="exchange.Aspect">
						<option value="C">发工资</option>
				</select></td>
			</tr>
			<tr>
				<td>金额:</td>
				<td><input type="text" name="exchange.Aspectsum" />
				</td>
			</tr>
			<tr>
				<td>所入账户：</td>
				<td><select name="exchange.Operateobjectto">
						<option value="">无</option>
						<#list AOperateObject as a>
							<option value="${a[0].id}">${a[1]}</option>
						</#list>
				</select>
				</td>
			</tr>
			<tr>
				<td>内容：</td>
				<td>
					<textarea id="Operatecontent" rows="7" cols="20" name="exchange.Operatecontent"></textarea>
				</td>
			</tr>
			<tr>
				<td>发生时间：</td>
				<td><input name="exchange.Happentime" value="${happenTime}" />
				</td>
			</tr>
			<tr>
				<td>总结：</td>
				<td>
					<textarea id="Opinion" rows="7" cols="20" name="exchange.Opinion"></textarea>
				</td>
			</tr>
		</table>
		<input type="reset" value="重置" /> <input type="submit" value="提交" />
	</form>
	<script>
	$(function(){
		$("#Operatecontent").val($.trim($("#Operatecontent").val()))
		$("#Opinion").val($.trim($("#Opinion").val()))
	})
	</script>
</@f.frame>