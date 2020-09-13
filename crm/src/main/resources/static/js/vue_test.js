      // 基于准备好的dom，初始化echarts实例
	        var myChart = echarts.init(document.getElementById('main'));
	
	        // 指定图表的配置项和数据
	        var option = option = {
	    backgroundColor: '#2c343c',
	
	    title: {
	        text: '客户来源统计',
	        left: 'center',
	        top: 20,
	        textStyle: {
	            color: '#ccc'
	        }
	    },
	
	    tooltip: {
	        trigger: 'item',
	        formatter: '{a} <br/>{b} : {c} ({d}%)'
	    },
	
	    visualMap: {
	        show: false,
	        min: 80,
	        max: 600,
	        inRange: {
	            colorLightness: [0, 1]
	        }
	    },
	    series: [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius: '55%',
	            center: ['50%', '50%'],
	            data: [
	                {value: 335, name: '花样深圳'},
	                {value: 310, name: '深圳第一'},
	                {value: 274, name: '深圳公租房'},
	                {value: 235, name: '最深圳'},
	                {value: 400, name: '深圳吃喝玩乐达人'}
	            ].sort(function (a, b) { return a.value - b.value; }),
	            roseType: 'radius',
	            label: {
	                color: 'rgba(255, 255, 255, 0.3)'
	            },
	            labelLine: {
	                lineStyle: {
	                    color: 'rgba(255, 255, 255, 0.3)'
	                },
	                smooth: 0.2,
	                length: 10,
	                length2: 20
	            },
	            itemStyle: {
	                color: '#c23531',
	                shadowBlur: 200,
	                shadowColor: 'rgba(0, 0, 0, 0.5)'
	            },
	
	            animationType: 'scale',
	            animationEasing: 'elasticOut',
	            animationDelay: function (idx) {
	                return Math.random() * 200;
	            }
	        }
	    ]
	};
	
	        // 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);