$(document).ready(function(){
	$.ajax({
		url:"/stuenroll/enroll/Count",
		success:function(response){
			var count=response.count;
			var num=count.COUNT0/4500;
			//num.toPrecision(3);//值的有效位数
			var data3=[Math.ceil(num)];//向上取整
			option = {
					title:{
						text:'业务指标',
						x:'center',				//位置
						subtext: '纯属虚构'		//副标题
					},
			    tooltip : {
			        formatter: "{a} <br/>{b} : {c}%"
			    },
			    
//			    toolbox: {
//			        show : true,
//			        feature : {
//			            mark : {show: true},
//			            restore : {show: true},
//			            saveAsImage : {show: true}
//			        }
//			    },
			    series : [
			        {
			            name:'业务指标',
			            type:'gauge',
			            splitNumber: 10,       // 分割段数，默认为5
			            axisLine: {            // 坐标轴线
			                lineStyle: {       // 属性lineStyle控制线条样式
			                    color: [[0.2, '#228b22'],[0.8, '#48b'],[1, '#ff4500']], 
			                    width: 8
			                }
			            },
			            axisTick: {            // 坐标轴小标记
			                splitNumber: 10,   // 每份split细分多少段
			                length :12,        // 属性length控制线长
			                lineStyle: {       // 属性lineStyle控制线条样式
			                    color: 'auto'
			                }
			            },
			            axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    color: 'auto'
			                }
			            },
			            splitLine: {           // 分隔线
			                show: true,        // 默认显示，属性show控制显示与否
			                length :30,         // 属性length控制线长
			                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
			                    color: 'auto'
			                }
			            },
			            pointer : {
			                width : 5
			            },
			            title : {
			                show : true,
			                offsetCenter: [0, '-40%'],       // x, y，单位px
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    fontWeight: 'bolder'
			                }
			            },
			            detail : {
			                formatter:'指标',
//			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
//			                    color: 'auto',
//			                    fontWeight: 'bolder'
//			                }
			            },
			            data:[{value: data3, name: '完成率'}]
			        }
			    ]
			};
			var gaugechart=echarts.init(document.getElementById("gaugechart"),"macarons");
			gaugechart.setOption(option);
			
		}
	});
});





