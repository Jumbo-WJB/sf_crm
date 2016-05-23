//初始化，默认为7天
initData(7);
$('#loadingModal').modal('show');
setTimeout(function(){$('#loadingModal').modal('hide');},700);
//视图切换
$('#searchForm input[name="days"]').click(function(){
    var selected = $(this).val();
    if (selected == "7"){
        $('.7_days_info').show();
        $('.15_days_info').hide();
        $('.30_days_info').hide();
        initData(7);
    }else if (selected == "15"){
        $('.7_days_info').hide();
        $('.15_days_info').show();
        $('.30_days_info').hide();
        initData(15);
    }else if (selected == "30"){
        $('.7_days_info').hide();
        $('.15_days_info').hide();
        $('.30_days_info').show();
        initData(30);
    }
});

//初始化表格数据
function initData(days){
    //获取文本区域数据
    $.ajax({
        type : "post",
        url : baseUrl+"interaction/integralCount",
        data : {days:days},
        dataType : "json",
        success : function(data){
            if (data.errorCode == '0'){
                $('#totalPresentPoint').html(data.modal.totalPresentPoint);
                $('#exchangedPoint').html(data.modal.exchangedPoint);
                $('#totalExchangeHBAmount').html(data.modal.totalExchangeHBAmount);
                $('#nonExchangePoint').html(data.modal.nonExchangePoint);
                $('#totalReceiveHBNum').html(data.modal.totalReceiveHBNum);
                $('#totalReceiveHBAmount').html(data.modal.totalReceiveHBAmount);
                $('#maxReceiveHBAmount').html(data.modal.maxReceiveHBAmount);
                $('#receiveHBFansNum').html(data.modal.receiveHBFansNum);
            }else{
                alert(data.errorMessage);
            }
        },error : function(){
            alert("请求异常，请重试！");
        }
    })

    //获取图表区域数据
    $.ajax({
        type : "post",
        url : baseUrl+"interaction/integralCharts",
        data : {lastDays:days},
        dataType : "json",
        success : function(data){
            if (data.errorCode == '0'){
                if (days == 7){
                    get7daysCharts(data.modal);
                }else if (days == 15){
                    get15daysCharts(data.modal);
                }else if (days == 30){
                    get30daysCharts(data.modal);
                }
            }else{
                alert(data.errorMessage);
            }
        },error : function(){
            alert("请求异常，请重试！");
        }
    })
}
/**
 * 最近7天积分兑换情况
 */
function get7daysCharts(chartsData){
    $('#7-interactionChart').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '最近7天积分兑换图'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                chartsData[0].day,
                chartsData[1].day,
                chartsData[2].day,
                chartsData[3].day,
                chartsData[4].day,
                chartsData[5].day,
                chartsData[6].day
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '数量'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
                +
                '<td style="padding:0"><b>{point.y:f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [
            {
                name: '兑换积分数',
                data: [
                    chartsData[0].totalExchangePoint,
                    chartsData[1].totalExchangePoint,
                    chartsData[2].totalExchangePoint,
                    chartsData[3].totalExchangePoint,
                    chartsData[4].totalExchangePoint,
                    chartsData[5].totalExchangePoint,
                    chartsData[6].totalExchangePoint
                ]

            },
            {
                name: '兑换人数',
                data: [
                    chartsData[0].totalExchangeCount,
                    chartsData[1].totalExchangeCount,
                    chartsData[2].totalExchangeCount,
                    chartsData[3].totalExchangeCount,
                    chartsData[4].totalExchangeCount,
                    chartsData[5].totalExchangeCount,
                    chartsData[6].totalExchangeCount
                ]
            }
        ]
    });
}

/**
 * 最近15天积分兑换情况
 */
function get15daysCharts(chartsData){
    $('#15-interactionChart').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '最近15天积分兑换图'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                chartsData[0].day,
                chartsData[1].day,
                chartsData[2].day,
                chartsData[3].day,
                chartsData[4].day,
                chartsData[5].day,
                chartsData[6].day,
                chartsData[7].day,
                chartsData[8].day,
                chartsData[9].day,
                chartsData[10].day,
                chartsData[11].day,
                chartsData[12].day,
                chartsData[13].day,
                chartsData[14].day
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '数量'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
                +
                '<td style="padding:0"><b>{point.y:f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [
            {
                name: '兑换积分数',
                data: [
                    chartsData[0].totalExchangePoint,
                    chartsData[1].totalExchangePoint,
                    chartsData[2].totalExchangePoint,
                    chartsData[3].totalExchangePoint,
                    chartsData[4].totalExchangePoint,
                    chartsData[5].totalExchangePoint,
                    chartsData[6].totalExchangePoint,
                    chartsData[7].totalExchangePoint,
                    chartsData[8].totalExchangePoint,
                    chartsData[9].totalExchangePoint,
                    chartsData[10].totalExchangePoint,
                    chartsData[11].totalExchangePoint,
                    chartsData[12].totalExchangePoint,
                    chartsData[13].totalExchangePoint,
                    chartsData[14].totalExchangePoint
                ]
            },
            {
                name: '兑换人数',
                data:
                    [
                        chartsData[1].totalExchangeCount,
                        chartsData[2].totalExchangeCount,
                        chartsData[3].totalExchangeCount,
                        chartsData[4].totalExchangeCount,
                        chartsData[5].totalExchangeCount,
                        chartsData[6].totalExchangeCount,
                        chartsData[7].totalExchangeCount,
                        chartsData[8].totalExchangeCount,
                        chartsData[9].totalExchangeCount,
                        chartsData[10].totalExchangeCount,
                        chartsData[11].totalExchangeCount,
                        chartsData[12].totalExchangeCount,
                        chartsData[13].totalExchangeCount,
                        chartsData[14].totalExchangeCount
                    ]
            }
        ]
    });
}

/**
 * 最近30天积分兑换情况
 */
function get30daysCharts(chartsData){
    $('#30-interactionChart').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '最近30天积分兑换图'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                chartsData[0].day,
                chartsData[1].day,
                chartsData[2].day,
                chartsData[3].day,
                chartsData[4].day,
                chartsData[5].day,
                chartsData[6].day,
                chartsData[7].day,
                chartsData[8].day,
                chartsData[9].day,
                chartsData[10].day,
                chartsData[11].day,
                chartsData[12].day,
                chartsData[13].day,
                chartsData[14].day,
                chartsData[15].day,
                chartsData[16].day,
                chartsData[17].day,
                chartsData[18].day,
                chartsData[19].day,
                chartsData[20].day,
                chartsData[21].day,
                chartsData[22].day,
                chartsData[23].day,
                chartsData[24].day,
                chartsData[25].day,
                chartsData[26].day,
                chartsData[27].day,
                chartsData[28].day,
                chartsData[29].day
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '数量'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
                +
                '<td style="padding:0"><b>{point.y:f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [
            {
                name: '兑换积分数',
                data: [
                    chartsData[0].totalExchangePoint,
                    chartsData[1].totalExchangePoint,
                    chartsData[2].totalExchangePoint,
                    chartsData[3].totalExchangePoint,
                    chartsData[4].totalExchangePoint,
                    chartsData[5].totalExchangePoint,
                    chartsData[6].totalExchangePoint,
                    chartsData[7].totalExchangePoint,
                    chartsData[8].totalExchangePoint,
                    chartsData[9].totalExchangePoint,
                    chartsData[10].totalExchangePoint,
                    chartsData[11].totalExchangePoint,
                    chartsData[12].totalExchangePoint,
                    chartsData[13].totalExchangePoint,
                    chartsData[14].totalExchangePoint,
                    chartsData[15].totalExchangePoint,
                    chartsData[16].totalExchangePoint,
                    chartsData[17].totalExchangePoint,
                    chartsData[18].totalExchangePoint,
                    chartsData[19].totalExchangePoint,
                    chartsData[20].totalExchangePoint,
                    chartsData[21].totalExchangePoint,
                    chartsData[22].totalExchangePoint,
                    chartsData[23].totalExchangePoint,
                    chartsData[24].totalExchangePoint,
                    chartsData[25].totalExchangePoint,
                    chartsData[26].totalExchangePoint,
                    chartsData[27].totalExchangePoint,
                    chartsData[28].totalExchangePoint,
                    chartsData[29].totalExchangePoint
                ]

            },
            {
                name: '兑换人数',
                data: [
                    chartsData[0].totalExchangeCount,
                    chartsData[1].totalExchangeCount,
                    chartsData[2].totalExchangeCount,
                    chartsData[3].totalExchangeCount,
                    chartsData[4].totalExchangeCount,
                    chartsData[5].totalExchangeCount,
                    chartsData[6].totalExchangeCount,
                    chartsData[7].totalExchangeCount,
                    chartsData[8].totalExchangeCount,
                    chartsData[9].totalExchangeCount,
                    chartsData[10].totalExchangeCount,
                    chartsData[11].totalExchangeCount,
                    chartsData[12].totalExchangeCount,
                    chartsData[13].totalExchangeCount,
                    chartsData[14].totalExchangeCount,
                    chartsData[15].totalExchangeCount,
                    chartsData[16].totalExchangeCount,
                    chartsData[17].totalExchangeCount,
                    chartsData[18].totalExchangeCount,
                    chartsData[19].totalExchangeCount,
                    chartsData[20].totalExchangeCount,
                    chartsData[21].totalExchangeCount,
                    chartsData[22].totalExchangeCount,
                    chartsData[23].totalExchangeCount,
                    chartsData[24].totalExchangeCount,
                    chartsData[25].totalExchangeCount,
                    chartsData[26].totalExchangeCount,
                    chartsData[27].totalExchangeCount,
                    chartsData[28].totalExchangeCount,
                    chartsData[29].totalExchangeCount
                ]

            }
        ]
    });
}





