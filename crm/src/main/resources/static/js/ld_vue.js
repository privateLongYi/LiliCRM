      // 基于准备好的dom，初始化echarts实例
	        var myChart = echarts.init(document.getElementById('like'));
	
	        // 指定图表的配置项和数据
	        var option = option = {
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
    },
    legend: {
        orient: 'vertical',
        left: 10,
        data: ['完成金额', '未完成金额']
    },
    series: [
        {
            name: '目标',
            type: 'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            },
            labelLine: {
                show: false
            },
            data: [
                {value: 335, name: '完成金额'},
                {value: 1548, name: '未完成金额'}
            ]
        }
    ]
};




	
	        // 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);