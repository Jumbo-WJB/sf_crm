
//创建表单token，防止表单重复提交
createToken('addForm');

//初始化
$.post(baseUrl + "dynamicResponse/getContentByType", {keywordType: "point_exchange_goods"}, function (data) {
    if (data.content == null || data.content == undefined){
        $("#inputEdit").val('积分商城首页图文');
    }
    if (data != null && !isNullOrEmpty(data.kewWordVO)) {
        var id = data.kewWordVO.id;
        $("#addForm input[name='title']").val(data.title);
        $("#addForm input[name='keyWord']").val(data.keyword);
        $("#addForm input[name='id']").val(id);
        $("#inputEdit").val(data.content);
    } else {
        $("#addForm input[name='id']").val('');
    }
}, "json");

//页面div布局切换
$("#addForm input[name='bizType']").click(function () {
    $("#addForm input[name='title']").val("");
    $("#addForm input[name='keyWord']").val("");
    $("#inputEdit").val("");
    var boxVal = $(this).val();
    if (boxVal == "point_exchange_goods" || boxVal == "express_query" || boxVal == "user_validate" || boxVal == "birthday") {
        $(".keywordContent").show();
        $(".successContent").show();
        $("#successInput").show();
        $(".introductory").hide();
        $("#selectPool").hide();
        $("#successEdit").hide();
        $("#signEdit").hide();
        $("#expressEdit").hide();
        $("#save").show();
        $("#delete").show();
        $.post(baseUrl + "dynamicResponse/getContentByType", {keywordType: boxVal}, function (data) {
            if (data.content == null || data.content == undefined){
                if (boxVal == "point_exchange_goods"){
                    $("#inputEdit").val('积分商城首页图文');
                }else if (boxVal == "express_query"){
                    $("#inputEdit").val('我的快递图文');
                }else if (boxVal == "user_validate"){
                    $("#inputEdit").val('我的认证图文');
                }else if (boxVal == "birthday"){
                    $("#inputEdit").val('我的生日图文');
                }
            }
            if (data != null && !isNullOrEmpty(data.kewWordVO)) {
                var id = data.kewWordVO.id;
                $("#addForm input[name='title']").val(data.title);
                $("#addForm input[name='keyWord']").val(data.keyword);
                $("#addForm input[name='id']").val(id);
                $("#inputEdit").val(data.content);
            } else {
                $("#addForm input[name='id']").val('');
            }
        }, "json");

    } else if (boxVal == "guide") {
        $(".keywordContent").hide();
        $(".successContent").hide();
        $("#successInput").hide();
        $(".introductory").show();
        $("#delete").hide();
        $("#save").hide();
        $.post(baseUrl + "dynamicResponse/getIntroduce", function (data) {
            if (data != null) {
                var content = data.introduceWord.replace(new RegExp(/(;)/g), '\n');
                $("#guid").html(content);
                $("#addForm input[name='title']").val(data.title);
                $("#addForm input[name='id']").val(data.kewWordVO.id);
            } else {
                alert("引导语内容为空");
            }
        }, "json");
    } else if (boxVal == "sign_in" || boxVal == "point_query") {
        $(".keywordContent").show();
        $(".successContent").show();
        $("#successInput").hide();
        $("#selectPool").hide();
        $("#signEdit").show();
        $(".introductory").hide();
        $("#save").show();
        $("#delete").show();
        $.post(baseUrl + "dynamicResponse/getContentByType", {keywordType: boxVal}, function (data) {
            if(boxVal == "sign_in"){
                $("#signWord ").val('签到成功，系统自动赠送您${signPointNum}个积分，您本月第${signAmountTimes}次签到，签到总排名第${signRank}，' +
                    '当前您累计获得的积分为${pointAmountTotal}，已经兑换${pointAmountExchange}，剩余积分${pointOverplus}。\r\n亲，' +
                    '前往${mallPointHref}兑换吧！');
                $("#exampleWord ").val('例：\r\n签到成功，系统自动赠送您10个积分，您本月第3次签到，签到总排名第10，' +
                    '当前您累计获得的积分为55，已经兑换13，剩余积分12。\r\n亲，' +
                    '前往 积分商城首页 兑换吧！');
            }else if (boxVal == "point_query"){
                $("#signWord ").val('当前您累计获得的积分为${pointAmountTotal}，已经兑换${pointAmountExchange}，剩余积分${pointOverplus}，' +
                    '所有粉丝排名第${pointRank}。\r\n亲，前往${mallPointHref}兑换吧！');
                $("#exampleWord ").val('例：\r\n当前您累计获得的积分为50，已经兑换20，剩余积分30，' +
                    '所有粉丝排名第6。\r\n亲，前往 积分商城首页 兑换吧！');
            }
            if (data != null &&!isNullOrEmpty(data.kewWordVO)) {
                $("#addForm input[name='title']").val(data.title);
                $("#addForm input[name='keyWord']").val(data.keyword);
                $("#addForm input[name='id']").val(data.kewWordVO.id);
            } else {
                $("#addForm input[name='id']").val('');
            }
        }, "json");
    } else if (boxVal == "shake") {
        $(".keywordContent").show();
        $(".successContent").show();
        $("#selectPool").show();
        $("#successInput").hide();
        $(".introductory").hide();
        $("#signEdit").hide();
        $("#save").show();
        $("#delete").show();
        $("#poolInput").attr("placeholder","选择要发送的摇一摇活动");
        $("#poolInput").attr("onclick","seeRank()");
        $.post(baseUrl + "dynamicResponse/getContentByType", {keywordType: boxVal}, function (data) {
            if (data != null && !isNullOrEmpty(data.kewWordVO)) {
                var id = data.kewWordVO.id;
                $("#addForm input[name='title']").val(data.title);
                $("#addForm input[name='keyWord']").val(data.keyword);
                $("#addForm input[name='id']").val(id);
                $("#addForm input[name='bizId']").val(data.kewWordVO.bizId);
                $("#poolInput").val(data.kewWordVO.bizName);
            } else {
                $("#addForm input[name='id']").val('');
                $("#poolInput").val('');
            }
        }, "json");
    } else {
        $(".keywordContent").show();
        $(".successContent").show();
        $("#selectPool").show();
        $("#successInput").hide();
        $(".introductory").hide();
        $("#signEdit").hide();
        $("#save").show();
        $("#delete").show();
        $("#poolInput").attr("placeholder","选择所要发送的红包活动");
        $("#poolInput").attr("onclick","selPool()");
        $.post(baseUrl + "dynamicResponse/getContentByType", {keywordType: boxVal}, function (data) {
            if (data != null && !isNullOrEmpty(data.kewWordVO)) {
                var id = data.kewWordVO.id;
                $("#addForm input[name='title']").val(data.title);
                $("#addForm input[name='keyWord']").val(data.keyword);
                $("#addForm input[name='id']").val(id);

                $("#addForm input[name='bizId']").val(data.kewWordVO.bizId);
                $("#poolInput").val(data.kewWordVO.bizName);
            } else {
                $("#addForm input[name='id']").val('');
                $("#poolInput").val('');
            }
        }, "json");

    }
});
//弹出悬浮层，展现红包池列表
function selPool() {
    $('#hbpoolModal').modal('show');
    TableModal.draw();
}

//弹出悬浮层，展现摇一摇列表
function seeRank() {
    $('#shakeListModal').modal('show');
    rankTable.draw();
}

$('.searchBut').click(function () {
    var type = $("#addForm input[name='bizType']:checked").val();
    if (type == 'shake'){
        rankTable.draw();
    }else{
        TableModal.draw();
    }
});

//单选
function checkOne() {
    $.each($(':checkbox[name="cbox"]'), function (i, value) {
        $(this).click(function () {
            if ($(this).prop('checked')) {
                $(':checkbox[name="cbox"]').removeAttr('checked');
                $(this).prop('checked', 'checked');
            }
        });
    });
}

//红包列表
var TableModal = $('#HBTable').DataTable({
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
        "url": baseUrl + '/hbPool/datas',
        "data": function (d) {

            var type;
            var name = $("#searchForm :input[name='name']").val();
            var bizType = $("#addForm input[name='bizType']:checked").val();
            if ("receive_common_hb" == bizType) {
                type = "common";
            } else if ("praise_receive_hb" == bizType) {
                type = "praise";
            } else if ("point_exchange_hb" == bizType) {
                type = "point_exchange";
            }
            $("#searchForm :input[name='type']").val(type);

            var startDate = $("#searchForm :input[name='startDate']").val();
            var endDate = $("#searchForm :input[name='endDate']").val();
            if (!isNullOrEmpty(name)) {
                d.name = name;
            }
            if (!isNullOrEmpty(type)) {
                d.type = type;
            }
            if (!isNullOrEmpty(startDate)){
                d.startDate = startDate;
            }
            if (!isNullOrEmpty(endDate)) {
                d.endDate = endDate;
            }
            //  console.dir(d);
        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                return '<th ><label><input type="checkbox" class="ace" name="cbox" value="' + row.poolId + '"/><span class="lbl"></span></label></th>';
            },
            "targets": 0
        },
        {
            "render": function (data, type, row) {
                if (data == null) {
                    return  '';
                } else
                    return getLocalTime(data);
            },
            "targets": 2
        },
        {
            "render": function (data, type, row) {

                var d = new Date();
                var endDate = row.endDate;
                var overNumber = row.number - row.numberObtain;

                if (row.numberObtain == 0 && d <= endDate) {
                    return "未领取";
                }
                if (row.numberObtain < row.number && row.numberObtain > 0 && d <= endDate) {
                    return "领取中";
                }
                if (overNumber == 0 || d > endDate) {
                    return "已结束";
                }

            },
            "targets": 3
        },
        {
            "render": function (data, type, row) {
                return (data / 100.00).toFixed(2);
            },
            "targets": 4
        },
        {
            "render": function (data, type, row) {
                return ((row.totalAmount - row.obtainAmount) / 100.00).toFixed(2);
            },
            "targets": 5
        },
        {
            "render": function (data, type, row) {
                return (row.number - row.numberObtain);
            },
            "targets": 8
        },
        {
            "render": function (data, type, row) {
                if (data == "common") {
                    return "普通红包"
                } else if (data == "point_exchange") {
                    return "积分兑换领取"
                } else if (data == "shake") {
                    return "摇一摇领取"
                } else if (data == "praise") {
                    return  "好评返领取"
                } else if (data == "shop") {
                    return   "购物领取"
                } else if (data == "share") {
                    return   "分享领取"
                } else if (data == "birthday") {
                    return   "生日领取"
                } else {
                    return  ""
                }
                return data;
            },
            "targets": 9
        }
    ],
    "fnDrawCallback": function (data) {
        var obj = data.json.hbPool;

        var sumObtainAmount = obj.sumObtainAmount;
        var sumNumber = obj.sumNumber;
        var sumTotalAmount = obj.sumTotalAmount;
        var sumNumberObtain = obj.sumNumberObtain;

        $('#sumTotalAmount').html((sumTotalAmount / 100.00).toFixed(2));
        $('#sumOverAmount').html(((sumTotalAmount - sumObtainAmount) / 100.00).toFixed(2));
        $('#sumNumber').html(sumNumber);
        $('#sumNumberObtain').html(sumNumberObtain);
        $('#sumOverNumber').html(sumNumber - sumNumberObtain);
        checkOne();
    },
    "columns": [
        {"data": "id", "sortable": false},
        {"data": "name", "sortable": false},
        {"data": "gmtCreated", "sortable": false},
        {"data": "states", "sortable": false},
        {"data": "totalAmount"},
        {"data": "null", "sortable": false},
        {"data": "number"},
        {"data": "numberObtain"},
        {"data": "null", "sortable": false},
        {"data": "type", "sortable": false}
    ]
});


var rankTable = $('#shakeTable').DataTable({
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
        "url": baseUrl + "rock/rockQueryConfig",
        "data": function (d) {
            var rockTitle = $("#searchForm input[name='rockTitle']").val();
            var status = $("#searchForm input[name='status']:checked").val();

            d.rockTitle = rockTitle;
            d.status = status;
        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                return '<th ><label><input type="checkbox" class="ace" name="cbox" value="' + row.rockId + '"/><span class="lbl"></span></label></th>';
            },
            "targets": 0
        },{
            "render": function (data, type, row) {
                var shakeType ="";
                if (row.isShakePoint == 1){
                    shakeType = shakeType+"积分,"
                }
                if (row.isShakeHb == 1){
                    shakeType = shakeType+"红包,"
                }
                if (row.isShakeGift == 1){
                    shakeType = shakeType+"礼物,"
                }

                return shakeType.substring(0,shakeType.length-1);
            },
            "targets": 2
        }, {
            "render": function (data, type, row) {
                if (data == null) {
                    return '';
                } else if (data == 'Y') {
                    return '进行中';
                } else {
                    return '已结束';
                }
            },
            "targets": 3
        }, {
            "render": function (data, type, row) {
                if (data == null) {
                    return '';
                } else {
                    return getLocalTime(data);
                }
            },
            "targets": 4
        }
    ],
    "aaSorting": [
        [ 4, "desc" ]
    ],
    "fnDrawCallback": function (data) {
        checkOne();
    },
    "columns": [
        {"data": "id", "sortable": false},
        {"data": "rockTitle", "sortable": false},
        {"data": "type", "sortable": false},
        {"data": "status", "sortable": false},
        {"data": "gmtCreated"}
    ]
})

$('.submitBut').click(function () {
    var id = '';
    var name = '';
    var i = 0;
    $(":checkbox[name='cbox']").each(function () {
        if ($(this).prop('checked')) {
            id = $(this).val();
            name = $(this).parent().parent().next().html();
            i++;
        }
    });
    if (id == '' || id == null) {
        alert("请选择一个活动");
        return false;
    }
    $("#addForm input[name='bizId']").val(id);
    $("#poolInput").val(name+'图文');
});

//保存回复设置
$('#save').click(function () {
    var title = $("#addForm input[name='title']").val();
    var bizType = $("#addForm input[name='bizType']:checked").val();
    var keyWord = $("#addForm input[name='keyWord']").val();
    var matchType = $("#addForm input[name='matchType']:checked").val();
    var bizId = $("#addForm input[name='bizId']").val();
    var bizName = $("#poolInput").val();
    var  id= $("#addForm input[name='id']").val();

    var successReplyContent;
    if (bizType == 'point_exchange_hb' || bizType == 'receive_common_hb' || bizType == 'praise_receive_hb' || bizType == 'shake') {
        successReplyContent = $("#poolInput").val();

    }else if (bizType == "point_exchange_goods" || bizType == "express_query" || bizType == "user_validate" || bizType == "birthday"){
        successReplyContent = $("#inputEdit").val();
        bizId = '';
    }else{
        successReplyContent = $("#signWord").val();
        bizId = '';
    }

    formData = {id:id,title: title, bizType: bizType, keyWord: keyWord, matchType: matchType, bizId: bizId,bizName:bizName,successReplyContent: successReplyContent};
    $.ajax({
        type: "post",
        url: baseUrl + "dynamicResponse/saveConfig",
        data: formData,
        dataType: "json",
        success: function (data) {
            if (data.errorCode == "-1") {
                alert('保存失败');
            } else {
                alert('保存成功');
            }
        }
    });
})

//删除回复设置
$('#delete').click(function(){
    var text = window.confirm("确定要删除吗？");
    if (text){
        var id = $("#addForm input[name='id']").val();
        if (id == ''){
            alert('无该条记录');
            return false;
        }
        $.post(baseUrl+"dynamicResponse/deleteConfig?id="+id,function(data){
            if (data.errorCode == '0'){
                $("#addForm input[name='title']").val('');
                $("#addForm input[name='id']").val('');
                $("#addForm input[name='keyWord']").val('');
                $("#addForm input[name='bizId']").val('');
                $("#poolInput").val('');
                alert('删除成功');
            }else{
                alert('删除失败');
            }
        });
    }else{
        return false;
    }
})


