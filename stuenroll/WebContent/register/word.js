$(document).ready(function(){
	$("#pid").click(function(){
		//var ID=window.prompt("请输入身份证号：");
		$('.mask').fadeIn(100);
		$('.t_m').slideDown(200);
		
	});
	$('.btn .sub').click(function(){
		var ID=$(".box .b_search").val();
		$.ajax({
			url:"/stuenroll/welcome/word",
			data:{
				'pid':ID
			},
			success:function(response){
				var tt=response.result;
				if(tt==true){
					$('.mask').fadeOut(100);
					$('.t_m').slideUp(200);
					window.open("../welcome/MyWord?pid="+ID,null,null,null);
				}else{
					alert("身份证输入有误");
				}
			}
		});
	});
	
		$('.poptit .close').click(function(){
			$('.mask').fadeOut(100);
			$('.t_m').slideUp(200);
		})
		$('.btn .res').click(function(){
			$('.mask').fadeOut(100);
			$('.t_m').slideUp(200);
		})
});