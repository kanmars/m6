<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="新增消费记录">
	<form action="defray.action" method="post">
		<table>
			<tr>
				<td>交易名称:</td>
				<td><select name="exchange.Name">
				<#list SessionProjectABC as abc>
					<option value="${abc[1]}">${abc[1]}</option>
				</#list>
				</select>
				</td>
			</tr>
			<tr>
				<td>交易方向：</td>
				<td><select name="exchange.Aspect">
						<option value="B">花钱</option>
						<option value="A">账户内</option>
						<option value="C">发工资</option>
				</select></td>
			</tr>
			<tr>
				<td>金额(花钱请写负数):</td>
				<td><input type="text" name="exchange.Aspectsum" value="-"/>
				</td>
			</tr>
			<tr>
				<td>所出账户(A帐):</td>
				<td><select name="exchange.Operateobjectfrom">
						<option value="">无</option>
						<#list AOperateObject as a>
							<option value="${a[0].id}">${a[1]}</option>
						</#list>
				</select>
				</td>
			</tr>
			<tr>
				<td>所入账户(AB帐)：</td>
				<td><select name="exchange.Operateobjectto">
						<option value="">无</option>
						<#list ABOperateObject as ab>
							<option value="${ab[0].id}">${ab[1]}</option>
						</#list>
				</select>
				</td>
			</tr>
			<tr>
				<td>交易内容：</td>
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