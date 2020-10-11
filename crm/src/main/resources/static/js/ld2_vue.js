


      // 基于准备好的dom，初始化echarts实例
	        var myChart = echarts.init(document.getElementById('like2'));
	
	        // 指定图表的配置项和数据
	        var option = {
    title: {
        text: ''
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['成交','收款']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['8/31', '9/7', '9/14', '9/21', '9/28']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name: '成交',
            type: 'line',
            stack: '总量',
            data: [1500, 2500, 6000, 7500, 9500]
        },
		{
		    name: '收款',
		    type: 'line',
		    stack: '总量',
		    data: [1000, 2000, 5000, 6500, 7500]
		}
    ]
};




	
	        // 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);