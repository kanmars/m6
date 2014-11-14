<#import "/ftl/common/common.ftl" as c>
<#import "/ftl/common/frame.ftl" as f>
<@f.frame title="交易列表">
<style>
.tdd{
	padding:0px;
	margin:0px;
	vertical-align:top;
	border-bottom: 1px solid silver;
}
</style>
<table style="padding:0px;margin:0px;">
<#list exchangeList as exchange>
<tr style="padding:0px;margin:0px;">
<td class="tdd">ID:</td><td class="tdd">${exchange.id}</td>
<td class="tdd">名称:</td><td class="tdd">${exchange.name}</td>
<td class="tdd">金额:</td><td class="tdd">${exchange.aspectsum}</td>
<td class="tdd">内容:</td><td class="tdd" style="width:300px;">${exchange.operatecontent}</td>
<td class="tdd">发生时间:</td><td class="tdd">${exchange.happentime}</td>
<td class="tdd">记录时间:</td><td class="tdd">${exchange.recordtime}</td>
</tr>
</#list>
</table>
<@c.painnation action="exchangell.action" pageSize=pageSize pageNum=pageNum pageCount=pageCount/>
</@f.frame>