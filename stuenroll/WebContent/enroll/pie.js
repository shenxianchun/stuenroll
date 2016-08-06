
$(document).ready(function(){
	$.ajax({
		url:"/stuenroll/specialty/Specialtyenrollcount",
		success:function(response){
			console.log(response);
			var list=response.data_1;
			var data1=[];
			for(var i=0;i<list.length;i++){
				var one=list[i];
				var name1=one.NAME;
				var num=one.specialty_num;
				var item={
						value:num,
						name:name1
				};
				data1.push(item);
			}
			
			option = {
					title:{
						text: '专业比例',
						x:'center',				//位置
						subtext: '纯属虚构'		//副标题
				},
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
//			    toolbox: {
//			        show : true,
//			        feature : {
//			            mark : {show: true},
//			            dataView : {show: true, readOnly: false},
//			            magicType : {
//			                show: true, 
//			                type: ['pie', 'funnel'],
//			                option: {
//			                    funnel: {
//			                        x: '25%',
//			                        width: '50%',
//			                        funnelAlign: 'center',
//			                        max: 1548
//			                    }
//			                }
//			            },
//			            restore : {show: true},
//			            saveAsImage : {show: true}
//			        }
//			    },
			    calculable : true,
			    series : [
			        {
			            name:'专业比例',
			            type:'pie',
			            radius : ['50%', '70%'],
			        //    center:['50%', '60%'],
			          //  selectedMode:'single',	//选中模式，默认关闭，可选single，multiple
			            itemStyle : {
			                normal : {
			                    label : {
			                        show : true
			                    },
			                    labelLine : {
			                        show : true
			                    }
			                },
			                emphasis : {
			                    label : {
			                        show : true,
			                        position : 'center',
			                        textStyle : {
			                            fontSize : '30',
			                            fontWeight : 'bold'
			                        }
			                    }
			                }
			            },
			            data:data1
			        }
			    ]
			};
			var piechart=echarts.init(document.getElementById("piechart"),"macarons");
			piechart.setOption(option);
			
			
		}
	});
});









