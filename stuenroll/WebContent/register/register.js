//jquery的主方法
$(document).ready(function(){
	var year=new Date().getFullYear();
	for(var i=0;i<5;i++){
		$("#yearList").append("<div class='item' date-value='"+(year-i)+"'>"+(year-i)+"</div>");
	}
	//发送ajax请求获取申报专业数据
	$.ajax({
		url:"/stuenroll/specialty/searchAll",
		data:{
			"username":"god",//上传数据
			"password":"1232",
		},
		success:function(response){
			//alert(response.list.length);
			var list=response.list;
			for(var i=0;i<list.length;i++){
				var one=list[i];
				var id=one.id;
				var name=one.name;
				$("#specialtyList").append("<div class='item' data-value='"+id+"'>"+name+"</div>");
			}
		}
	});
	$.ajax({
		url:"/stuenroll/orgnization/searchAll",
		data:{},
		success:function(response){
			var list=response.list;
			for(var i=0;i<list.length;i++){
				var one=list[i];
				var id=one.id;
				var name=one.name;
				var address=one.address;
				$("#orgnizationList").append("<div class='item' data-value='"+id+"'>"+name+"</div>");
				$("#place").append("<div class='item' data-value='"+id+"'>"+address+"</div>");
			}
		}
	});
	$(".ui.dropdown").dropdown();
	$("#save").click(function(){
		//点击按钮将数据写入高速缓存
		var name=$("#name").val();
//		alert(name);
		var regName=new RegExp("^[\\u4e00-\\u9fa5]{2,8}$");
		var rsName=regName.test(name);
//		alert(rsName);
		if(rsName==false){
			$("#name").css("color","red");
		}else{
			$("#name").css("color","black");
		}
		var sex=$("#sex").val();
		var rsSex=(sex!=null&&sex!="")
		if(rsSex==false){
			alert("请选择性别");
		}
		var pid=$("#pid").val();
		var rsPid=(pid!=null&&pid!="");
		if(rsPid==false){
			alert("请填写身份证号");
		}
		
		if(rsName && rsSex && rsPid){
			$.ajax({
				url:"/stuenroll/enroll/register",
				data:{
					"name":name,
					"sex":sex,
					"pid":pid
				},
				success:function(response){
					alert("提交"+response.result);
				}
			});
			
		}
	});
	
});

