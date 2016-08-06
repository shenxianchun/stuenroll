$(document).ready(function(){
	$.ajax({
		url:"/stuenroll/enroll/CountSum",
		success:function(response){
			var value11 = response.list_11.num;
			var value12=response.list_12.num;
			var value13 = response.list_13.num;
			var value14 = response.list_14.num;
			var value15 = response.list_15.num;
			var sum16=value14+value15;
			$("#value11").append(value11);
			$("#value12").append(value12);
			$("#value13").append(value13);
			$("#value14").append(value14);
			$("#value15").append(value15);
			$("#sum16").append(sum16);
			var value21 = response.list_21.num;
			var value22 = response.list_22.num;
			var value23 = response.list_23.num;
			var value24 = response.list_24.num;
			var value25 = response.list_25.num;
			var sum26=value24+value25;
			$("#value21").append(value21);
			$("#value22").append(value22);
			$("#value23").append(value23);
			$("#value24").append(value24);
			$("#value25").append(value25);
			$("#sum26").append(sum26);
			
			
			
			var value31 = response.list_31.num;
			var value32 = response.list_32.num;
			var value33 = response.list_33.num;
			var value34 = response.list_34.num;
			var value35 = response.list_35.num;
			var sum36=value34+value35;
			$("#value31").append(value31);
			$("#value32").append(value32);
			$("#value33").append(value33);
			$("#value34").append(value34);
			$("#value35").append(value35);
			$("#sum36").append(sum36);
			
			
			
			
		}
		
	});
});