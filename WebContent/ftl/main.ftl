<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="主界面">
	<table>
		<#assign moneyA=0>
		<#assign moneyB=0>
		<tr style="background-color:silver;color:black;font-size:20px;font-weight:900">
			<td>编号</td>
			<td>名称</td>
			<td>属性</td>
			<td>金额</td>
			<td>描述</td>
		</tr>
		<#list objectListA as object>
		<tr>
			<td>${object.id.id}</td>
			<td>${object.name}</td>
			<td>
			<#if object.owner="A">
			自有
			<#elseif object.owner="B">
			商店
			</#if>
			</td>
			<td>${object.balance}</td>
			<td>${object.info}</td>
		</tr>
		<#assign moneyA=moneyA+object.balance>
		</#list>
		<tr>
		<td colspan="5">
		自有资金为：<span style="color:green;font-size:20px;font-weight:900">${moneyA}</span>
		</td>
		</tr>
		<tr style="background-color:silver;color:black;font-size:20px;font-weight:900">
			<td>编号</td>
			<td>名称</td>
			<td>属性</td>
			<td>金额</td>
			<td>描述</td>
		</tr>
		<#list objectListB as object>
		<tr>
			<td>${object.id.id}</td>
			<td>${object.name}</td>
			<td>
			<#if object.owner="A">
			自有
			<#elseif object.owner="B">
			商店
			</#if>
			</td>
			<td>${object.balance}</td>
			<td>${object.info}</td>
		</tr>
		<#assign moneyB=moneyB+object.balance>
		</#list>
		<tr>
		<td colspan="5">
		已消费金额为：<span style="color:red;font-size:20px;font-weight:900">${moneyB}</span>
		</td>
		</tr>
		<tr>
		<td colspan="5" style="background-color:silver">
		总收入:${moneyA+moneyB}
		</td>
		</tr><tr>
		<td colspan="5" style="background-color:silver">
		资金与消费比:
			<#if moneyB=0>0<#else>${moneyA/moneyB}</#if>
		</td>
		</tr><tr>
		<td colspan="5" style="background-color:silver">
		消费占总收入比:
			<#if (moneyA+moneyB)=0>0<#else>${moneyB/(moneyA+moneyB)}</#if>
		</td>
		</tr><tr>
		<td colspan="5" style="background-color:silver">
		积累占总收入比:
			<#if (moneyA+moneyB)=0>0<#else>${moneyA/(moneyA+moneyB)}</#if>
		</td>
		</tr>
	</table>
</@f.frame>