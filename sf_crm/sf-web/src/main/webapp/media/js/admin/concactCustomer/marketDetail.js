
//短信营销明细
var smstableModal = $('#smsDetailTable').DataTable({
    "language": {
        "paginate": {
            "first": "首页",
            "last": "末页",
            "next": "下一页",
            "previous": "上一页"
        },
        "lengthMenu": "每页 _MENU_ 条记录",
        "zeroRecords": "没有数据",
        "info": "共 _TOTAL_ 记录， 当前第 _PAGE_ 页",
        "infoFiltered": ""
    },
    "pagingType": "full_numbers",
    "processing": true,
    "searching": false,
    "serverSide": true,
    "ajax": {
        "url":  baseUrl+"contactCustomer/searchActivity",
        "data": function (d) {
            var activityId = $("#searchForm input[name='activityId']").val();
            var type = $("#searchForm input[name='type']:checked").val();
            var activityTitle = $("#searchForm input[name='activityTitle']").val();
            var startTime = $("#searchForm input[name='startTime']").val();
            var endTime = $("#searchForm input[name='endTime']").val();
            var isSuccess = $("#searchForm option:selected").val();

            d.activityId = activityId;
            d.type = type;
            d.activityTitle = activityTitle;
            d.startTime = startTime;
            d.endTime = endTime;
            d.isSuccess = isSuccess;
        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                if (data == null){
                    return '无';
                }else {
                    return data;
                }
            },
            "targets": 3
        },{
            "render": function (data, type, row) {
                if (data == 'send_success'){
                    return '成功';
                }else if (data == 'send_failed'){
                    return '失败';
                }else if (data == 'to_send'){
                    return '待发送';
                }else if (data == 'send_open'){
                    return '已打开';
                }else if (data == 'send_unopen'){
                    return '未打开';
                }else if (data == 'send_fatigue'){
                    return '疲劳';
                }else if (data == 'send_td'){
                    return '疲劳';
                }
            },
            "targets": 4
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '0次';
                }else {
                    return data+'次';
                }
            },
            "targets": 5
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '0次';
                }else {
                    return data+'次';
                }
            },
            "targets": 5
        },{
            "render": function (data, type, row) {
                return data.replace(/TB/g,"淘宝").replace(/TMALL/g,"天猫").replace(/JD/g,"京东").replace(/WX/g,"微信").replace(/YZ/g,"有赞");
            },
            "targets": 6
        }
    ],
    "sort":false,
    "columns": [
        {"data": "activityTitle"},
        {"data": "name"},
        {"data": "mobile"},
        {"data": "wxNickName"},
        {"data": "isSuccess"},
        {"data": "smsAcceptNumber"},
        {"data": "firstSource"},
        {"data": "contribution"}
    ]
});

//邮件营销明细
var emailtableModal = $('#emailDetailTable').DataTable({
    "language": {
        "paginate": {
            "first": "首页",
            "last": "末页",
            "next": "下一页",
            "previous": "上一页"
        },
        "lengthMenu": "每页 _MENU_ 条记录",
        "zeroRecords": "没有数据",
        "info": "共 _TOTAL_ 记录， 当前第 _PAGE_ 页",
        "infoFiltered": ""
    },
    "pagingType": "full_numbers",
    "processing": true,
    "searching": false,
    "serverSide": true,
    "ajax": {
        "url":  baseUrl+"contactCustomer/searchActivity",
        "data": function (d) {
            var activityId = $("#searchForm input[name='activityId']").val();
            var type = $("#searchForm input[name='type']:checked").val();
            var activityTitle = $("#searchForm input[name='activityTitle']").val();
            var startTime = $("#searchForm input[name='startTime']").val();
            var endTime = $("#searchForm input[name='endTime']").val();
            var isSuccess = $("#searchForm option:selected").val();

            d.activityId = activityId;
            d.type = type;
            d.activityTitle = activityTitle;
            d.startTime = startTime;
            d.endTime = endTime;
            d.isSuccess = isSuccess;
        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                if (data == null){
                    return '无';
                }else {
                    return data;
                }
            },
            "targets": 2
        },{
            "render": function (data, type, row) {
                if (data == "1"){
                    return '是';
                }else {
                    return '否';
                }
            },
            "targets": 3
        },{
            "render": function (data, type, row) {
                if (data == 'send_success'){
                    return '成功';
                }else if (data == 'send_failed'){
                    return '失败';
                }else if (data == 'to_send'){
                    return '待发送';
                }else if (data == 'send_open'){
                    return '已打开';
                }else if (data == 'send_unopen'){
                    return '未打开';
                }else if (data == 'send_fatigue'){
                    return '疲劳';
                }else if (data == 'send_td'){
                    return '疲劳';
                }
            },
            "targets": 4
        },{
            "render": function (data, type, row) {
                if (data == 'send_open'){
                    return '是';
                }else if (data == 'send_unopen'){
                    return '否';
                }
            },
            "targets": 5
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '0次';
                }else {
                    return data+'次';
                }
            },
            "targets": 6
        },{
            "render": function (data, type, row) {
                return data.replace(/TB/g,"淘宝").replace(/TMALL/g,"天猫").replace(/JD/g,"京东").replace(/WX/g,"微信").replace(/YZ/g,"有赞");
            },
            "targets": 7
        }
    ],
    "sort":false,
    "columns": [
        {"data": "activityTitle"},
        {"data": "name"},
        {"data": "email"},
        {"data": "wxNickName"},
        {"data": "isSuccess"},
        {"data": "isOpen"},
        {"data": "smsAcceptNumber"},
        {"data": "firstSource"},
        {"data": "contribution"}
    ]
});

var type = $('#selectType').val();
if (type == "sms"){
    smstableModal.draw();
    $(".smsMarketTable").show();
    $(".emailMarketTable").hide();
}else if (type == "email"){
    emailtableModal.draw();
    $(".smsMarketTable").hide();
    $(".emailMarketTable").show();
}
$("#searchForm input[name='type']").each(function(){
    var selectedVal = $(this).val();
    if (selectedVal == type){
        $(this).prop('checked','checked');
    }
})

//搜索按钮
$("#SearchBut").click(function(){
    var type = $("#searchForm input[name='type']:checked").val();
    if (type == null){
        alert("请选择活动类型！");
    }
    if (type == "sms"){
        smstableModal.draw();
    }else if (type == "email"){
        emailtableModal.draw();
    }
})
//div切换
$("#searchForm input[name='type']").click(function(){
    var selectedVal = $(this).val();
    if (selectedVal == "sms"){
        smstableModal.draw();
        $(".smsMarketTable").show();
        $(".emailMarketTable").hide();
    }else if (selectedVal == "email"){
        emailtableModal.draw();
        $(".smsMarketTable").hide();
        $(".emailMarketTable").show();
    }
})
//重置按钮
$("#resetBut").click(function(){
    $('#searchForm input[name="activityId"]').attr('value','');
    $('#searchForm')[0].reset();
})
