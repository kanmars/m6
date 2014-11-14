	function pieck(){
		var starttime=$("#startTime").val();
		var endtime=$("#endTime").val();
		var regex=/[0-9]{8}/;
		
		if(regex.test(starttime)&&regex.test(endtime)){
			var formtype;
			$("#qzrqt :input:radio:checked").each(function(){
				formtype=$(this).val();
			})
			if(formtype!=undefined){
			src="jFreeChart"+formtype+"Action.action?startTime="+starttime+"&endTime="+endtime;
			$("#piepic").attr("src",src);
			}else{
			alert("请选择图形");
			}
		}
	}
	function inmonth(){
		var year=$("#monthyear").val();
		var regex=/[0-9]{4}/;
		if(regex.test(year)){
			src="jFreeChartAxisMonthAction.action?year="+year;
			$("#monthpic").attr("src",src);
		}
		
	}
	function show(divname){
		if($("#typeselect :input:radio:checked").val()=="tp1")hiddenalldiv();//单图模式则先清空页面
		if($("#"+divname).css("display")=="none")
			$("#"+divname).css("display","block");
		else
			$("#"+divname).css("display","none");
	}
	function hiddenalldiv(){
		$("#qzrqt").css("display","none");
		$("#month").css("display","none");
	}
	//加载完成后执行
	$(function(){
		$("#endTime").keyup(pieck);
		$("#startTime").keyup(pieck);
		$("#radio1").click(pieck);
		$("#radio2").click(pieck);
		$("#monthyear").keyup(inmonth);
		$("#qzrqtbt").click(function(){show("qzrqt")})
		$("#monthbt").click(function(){show("month")})
	});