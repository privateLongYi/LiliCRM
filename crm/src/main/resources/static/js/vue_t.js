      // 基于准备好的dom，初始化echarts实例
	        var myChart = echarts.init(document.getElementById('like'));
	
	        // 指定图表的配置项和数据
	        var option = {
    tooltip: {
        formatter: '{a} <br/>{b} : {c}%'
    },
    toolbox: {
        feature: {
            restore: {},
            saveAsImage: {}
        }
    },
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            detail: {formatter: '{value}%'},
            data: [{value: 60, name: '完成率'}]
        }
    ]
};



	
	        // 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);