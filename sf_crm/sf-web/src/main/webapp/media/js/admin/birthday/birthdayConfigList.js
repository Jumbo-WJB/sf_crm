
//全局变量
var manualTarget = "";
var poolId = 0;
var goodsId = 0;
var sellerId = $("input[name='hdSellerId']").val();
var flag = "";
/**列表当前行的下一行中的开始时间和结束时间*/
var nextLineStartTime = "";
var nextLineEndTime = "";
/**上一行的开始时间和结束时间*/
var prevLineStartTime = "";
var prevLineEndTime = "";
/**选择红包池后锁定的时间*/
var submitStartDate="";
var submitEndDate="";
/**红包数量*/
var surplus="";
//点击手动选择的时候出现button按钮
$("#manual").bind("click",function(event){
    $("#target").prop("class","col-sm-6");
    //$("#target").css("margin-left","-26px");
    $("#findCus").show();
});
//点击"所有粉丝" button按钮消失
$("#auto").bind("click",function(event){
    manualTarget = "";
    //$("#endtime").prop("value",endtimeStr);
    $("#target").prop("class","col-sm-3");
    $("#target").css("margin-left","-8px");
    $("#findCus").hide();
});
//点击关怀类别
$("#birthHb").bind("click", function(event) {
    $("#hiddenDiv1").show();
    $("#hiddenDiv2").hide();
    $("#hiddenDiv3").hide();
    $("#hiddenDiv4").hide();
    //$("#starttime").prop("disabled", true);
    //$("#endtime").val("");
    //$("#endtime").prop("disabled", true);
    /**
     * 清空其他数据，防止数据混乱
     * @type {string}
     */
    goodsId=0;
    $("#birthdayForm input[name='points']").val(0);
    $("#birthdayForm input[name='discount']").val("");
    $("#birthdayForm input[name='secretPassword']").val("");
});
$("#birthGifts").bind("click", function(event) {
    $("#hiddenDiv1").hide();
    $("#hiddenDiv2").show();
    $("#hiddenDiv3").hide();
    $("#hiddenDiv4").hide();
    //$("#starttime").removeAttr("disabled");
    //$("#endtime").removeAttr("disabled");
    /**
     * 清空其他数据，防止数据混乱
     * @type {string}
     */
    poolId = 0;
    $("#birthdayForm input[name='points']").val(0);
    $("#birthdayForm input[name='discount']").val("");
    $("#birthdayForm input[name='secretPassword']").val("");
});
$("#birthPoints").bind("click", function(event) {
    $("#hiddenDiv1").hide();
    $("#hiddenDiv2").hide();
    $("#hiddenDiv3").show();
    $("#hiddenDiv4").hide();
    //$("#starttime").removeAttr("disabled");
    //$("#endtime").removeAttr("disabled");
    /**
     * 清空其他数据，防止数据混乱
     * @type {string}
     */
    goodsId = 0;
    poolId = 0;
    $("#birthdayForm input[name='discount']").val("");
    $("#birthdayForm input[name='secretPassword']").val("");
});
$("#birthDiscount").bind("click", function(event) {
    $("#hiddenDiv1").hide();
    $("#hiddenDiv2").hide();
    $("#hiddenDiv3").hide();
    $("#hiddenDiv4").show();
    //$("#starttime").removeAttr("disabled");
    //$("#endtime").removeAttr("disabled");
    /**
     * 清空其他数据，防止数据混乱
     * @type {string}
     */
    poolId = 0;
    goodsId = 0;
    $("#birthdayForm input[name='points']").val(0);
    $("#birthdayForm input[name='secretPassword']").val("");
});
$("input[name='remindShortMessage']").bind("click", function() {

    var rsmVal = $("input[name='remindShortMessage']:checked").val();

    if(rsmVal=="1") {
        $("textarea[name='shortMessageContent']").removeAttr("disabled");
    }
    if(rsmVal=="0") {
        $("textarea[name='shortMessageContent']").prop("disabled",true);
    }
});

/**
 * 编辑页面点击"取消"或右上角的'x'
 * 清空所有的全局变量。
 *
 */
function abolish() {
    manualTarget = "";
    poolId = 0;
    goodsId = 0;
    flag = ""
    nextLineStartTime = "";
    nextLineEndTime = "";
    prevLineStartTime = "";
    prevLineEndTime = "";
    submitStartDate="";
    submitEndDate="";

}

/**
 * 选择强关系级别
 *
 */
$("#searchForm input[name='relationship']").each(function(){
    var level = "";
    $(this).click(function(){
        var birthdayActivityId = $("input[name='birthdayActivityId']").val();
        var startTime = $("input[name='startTime']").val();
        var endTime = $("input[name='endTime']").val();
        level = $(this).val();
        //alert(level);
        var TableModal = $('#birthdayTable').DataTable({
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
            "bDestroy":true,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "ajax": {
                "url":  baseUrl+'/birthday/manual/operation',
                "data": function (d) {
                    if(submitStartDate != null && submitStartDate !="") {
                        startTime = submitStartDate;
                    }
                    if(submitEndDate != null && submitEndDate !="") {
                        endTime = submitEndDate;
                    }
                    d.startTime = startTime;
                    d.endTime = endTime;
                    d.level=level;
                }
            },
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        if(row.birthdayActivityId==birthdayActivityId) {
                            return '<td class="center"><label><input name="manualcbox" type="checkbox" class="ace" value="'+data+'" checked="checked"/><span class="lbl"></span></label></td>';
                        } else {
                            return '<td class="center"><label><input name="manualcbox" type="checkbox" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                        }
                    },
                    "targets": 0
                },{
                    "render": function (data, type, row) {
                        if(data=='TB') {
                            return "淘宝";
                        }
                        if(data=='JD') {
                            return "京东";
                        }
                        if(data=='YZ') {
                            return "有赞";
                        }
                        if(data=='WX') {
                            return "微信";
                        }
                    },
                    "targets": 4
                },{
                    "render": function (data, type, row) {
                        if(data==null || data==""){
                            return "";
                        } else {
                            return getYMDTime(data);
                        }
                    },
                    "targets": 6
                }
            ],
            "sort":false,
            "columns": [
                {"data": "userId"},
                {"data": "wxNickName"},
                {"data": "tbBuyerNick"},
                {"data": "jdPin"},
                {"data": "firstSource"},
                {"data": "mobile"},
                {"data": "birthday"}
            ]
        });
        $('#birthdayModal').modal('show');
        $('#searchBut').click(function(){
            TableModal.draw();
        });


    });

});
/*选择红包池*/
function selectHBPool() {
    var editPoolId = $("input[name='poolId']").val();
    /**选择红包池，时候填写的开始时间和结束时间*/
    var startTime = $("input[name='startTime']").val();
    var endTime = $("input[name='endTime']").val();
    var startdate=Date.parse((startTime + " 00:00:00").replace(/-/g,"/"));
    var enddate=Date.parse((endTime + " 00:00:00").replace(/-/g,"/"));
    var careType = $('input[name="careType"]:checked').val();
    var hideStartTime = $("input[name='hideStartTime']").val();
    var hideDate = Date.parse((hideStartTime + " 00:00:00").replace(/-/g,"/"));

    if(careType=='birthday_red_packet') {
        if(startTime == null || startTime == "") {
            alert("请先选择开始时间");
            return false;
        }
        if(endTime == null || endTime == "") {
            alert("请先选择结束时间");
            return false;
        }
        if(startdate>enddate) {
            alert("结束时间要大于开始时间");
            return false;
        }
        if(startdate<hideDate) {
            alert("开始时间不能小于默认值");
            return false;
        }
    }
    //弹出悬浮层，展现红包池列表
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
        "bDestroy":true,
        "processing": true,
        "searching": false,
        "serverSide": true,
        "ajax": {
            //"url":  baseUrl+'/hbPool/datas',
            "url": baseUrl+'birthday/hbPool/datas',
            "data": function (d) {
                var name = $("#searchForm :input[name='name']").val();
                var type = $("#searchForm :input[name='type']").val();

                /**搜索的开始时间和结束时间*/
                //var startDate = $("#searchForm :input[name='startDate']").val();
                //var endDate = $("#searchForm :input[name='endDate']").val();
                if (!isNullOrEmpty(name)) {
                    d.name = name;
                }
                if (!isNullOrEmpty(type)) {
                    d.type = type;
                }
                if (!isNullOrEmpty(startTime)) {
                    d.searchStartDate = startTime;
                }
                if (!isNullOrEmpty(endTime)) {
                    d.searchEndDate = endTime;
                }
            }
        },
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    if(data==editPoolId) {
                        return '<td class="center"><label><input name="cbox" type="radio" class="ace" value="'+data+'" checked="checked"/><span class="lbl"></span></label></td>';
                    } else {
                        return '<td class="center"><label><input name="cbox" type="radio" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                    }
                },
                "targets": 0
            }, {
                "render": function (data, type, row) {
                    if(data==null){
                        return  '';
                    }else
                        return getLocalTime(data);
                },
                "targets":2
            }, {
                "render": function (data, type, row) {

                    if(data == "unBounded"){
                        return "未关联";
                    } else if (data == "unReceived"){
                        return "待领取";

                    }else if (data == "receiving"){
                        return "领取中";
                    } else if (data == "done"){
                        return "结束";
                    }
                    return data;
                },
                "targets":3
            },{
                "render": function (data, type, row) {
                    return (row.number-row.numberObtain);
                },
                "targets":6
            },{
                "render" : function(data, type, row) {
                    return (data/100);
                },
                "targets":7
            }
        ],
        "sort":false,
        "columns": [
            {"data": "poolId"},
            {"data": "name"},
            {"data": "gmtCreated"},
            {"data": "states"},
            {"data": "number"},
            {"data": "numberObtain"},
            {"data": "null"},
            {"data": "totalAmount"}
        ]
    });
    $('#hbpoolModal').modal('show');
    $('#searchBut').click(function(){
        TableModal.draw();
    });

}
$('#hbsubmitBut').click(function(){
    var defaultTime = $("input[name='startTime']").val();
    var defaultDate = Date.parse((defaultTime + " 00:00:00").replace(/-/g,"/"));
    var sttDate;

    $("input[name='cbox']").each(function(){
        if ($(this).prop('checked')){
            poolId = $(this).val();
            //红包列表中的开始时间和结束时间
            submitStartDate = $(this).parent().parent().siblings().eq(6).html();
            submitEndDate = $(this).parent().parent().siblings().eq(7).html();

            sttDate =  Date.parse((submitStartDate + " 00:00:00").replace(/-/g,"/"));

            //红包池名称
            poolName = $(this).parent().parent().siblings().eq(0).html();
            //红包池总数量
            poolTotalNum = $(this).parent().parent().siblings().eq(3).html();
            //红包剩余数量
            surplus = $(this).parent().parent().siblings().eq(5).html();
            //红包总金额
            hbTotalCash = $(this).parent().parent().siblings().eq(6).html();

            showStr = "红包名称:" + poolName + "\r\n红包总数量:" + poolTotalNum + "\r\n红包剩余数量:" + surplus +"\r\n总金额:" + hbTotalCash;
        }
    });
    if (poolId == 0){
        alert("未选择红包池");
        return false;
    }
    $("textarea[name='showarea']").val(showStr);
    $("input[name='surplus']").val(surplus);
    //$("#starttime").val(submitStartDate);
    //$("#endtime").val(submitEndDate);
    //$("#addForm input[name='bizId']").val(val);
});
//选择生日礼物
function selectBirthdayGifts() {
    var editGoodsId = $("input[name='goodsId']").val();

    var TableModal = $('#giftsTable').DataTable({
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
        "bDestroy":true,
        "processing": true,
        "searching": false,
        "serverSide": true,
        "ajax": {
            "url":  baseUrl+'/birthday/select/gifts',
            "data": function (d) {

                var title = $("#searchForm input[name='title']").val();
                var startDate = $("#searchForm :input[name='startDate']").val();
                var endDate = $("#searchForm :input[name='endDate']").val();
                if (!isNullOrEmpty(title)) {
                    d.title = title;
                }
                if (!isNullOrEmpty(startDate)) {
                    d.startDate = startDate;
                }
                if (!isNullOrEmpty(endDate)) {
                    d.endDate = endDate;
                }

            }
        },
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    if(data==editGoodsId) {
                        return '<td class="center"><label><input name="giftscbox" type="radio" class="ace" value="'+data+'" checked="checked"/><span class="lbl"></span></label></td>';

                    } else {
                        return '<td class="center"><label><input name="giftscbox" type="radio" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                    }

                },
                "targets": 0
            }
        ],
        "sort":false,
        "columns": [
            {"data": "goodsId"},
            {"data": "title"},
            {"data": "quantity"},
            {"data": "price"},
            {"data": "point"}
        ]
    });
    $('#giftsModal').modal('show');
    $('#giftsSearchBut').click(function(){
        TableModal.draw();
    });
}
$('#giftssubmit').click(function(){

    $("input[name='giftscbox']").each(function(){
        if($(this).prop('checked')) {
            goodsId = $(this).val();
            //商品名称
            var goodsName = $(this).parent().parent().siblings().eq(0).html();
            //商品数量
            var goodsNum = $(this).parent().parent().siblings().eq(1).html();
            showStr = "商品名称:" + goodsName + "     商品数量:" + goodsNum;
            $("textarea[name='showarea']").val(showStr);
        }

    });
    if (goodsId == 0){
        alert("未选择生日礼物");
        return false;
    }
    //$("#addForm input[name='bizId']").val(val);
});
//赠送对象， 手动选择
function selectSendTarget() {
    var birthdayActivityId = $("input[name='birthdayActivityId']").val();
    var startTime = $("input[name='startTime']").val();
    var endTime = $("input[name='endTime']").val();
    var startdate=Date.parse((startTime + " 00:00:00").replace(/-/g,"/"));
    var enddate=Date.parse((endTime + " 00:00:00").replace(/-/g,"/"));
    var careType = $('input[name="careType"]:checked').val();
    var hideStartTime = $("input[name='hideStartTime']").val();
    var hideDate = Date.parse((hideStartTime + " 00:00:00").replace(/-/g,"/"));


    if(!(careType=='birthday_red_packet')) {
        if(startTime == null || startTime == "") {
            alert("请先选择开始时间");
            return false;
        }
        if(endTime == null || endTime == "") {
            alert("请先选择结束时间");
            return false;
        }
        if(startdate>enddate) {
            alert("结束时间要大于开始时间");
            return false;
        }
        if(startdate<hideDate) {
            alert("开始时间不能小于默认值");
            return false;
        }
    } else {
        //如果是红包类型的,先让他选择红包池
        if(poolId=="" || poolId==null) {
            alert("请先选择红包池");
            return false;
        }

    }

    var TableModal = $('#birthdayTable').DataTable({
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
        "bDestroy":true,
        "processing": true,
        "searching": false,
        "serverSide": true,
        "ajax": {
            "url":  baseUrl+'/birthday/manual/operation',
            "data": function (d) {
                //if(submitStartDate != null && submitStartDate !="") {
                //    startTime = submitStartDate;
                //}
                //if(submitEndDate != null && submitEndDate !="") {
                //    endTime = submitEndDate;
                //}

                d.startTime = startTime;
                d.endTime = endTime;
                d.birthdayActivityId = birthdayActivityId;
            }
        },
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    if(row.birthdayActivityId==birthdayActivityId) {
                        return '<td class="center"><label><input name="manualcbox" type="checkbox" class="ace" value="'+data+'" checked="checked"/><span class="lbl"></span></label></td>';
                    } else {
                        return '<td class="center"><label><input name="manualcbox" type="checkbox" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                    }
                },
                "targets": 0
            },{
                "render": function (data, type, row) {
                    if(data=='TB') {
                        return "淘宝";
                    }
                    if(data=='JD') {
                        return "京东";
                    }
                    if(data=='YZ') {
                        return "有赞";
                    }
                    if(data=='WX') {
                        return "微信";
                    }
                },
                "targets": 4
            },{
                "render" : function(data, type, row) {
                    if(data==null || data==""){
                        return "";
                    } else {
                        return getYMDTime(data);
                    }
                },
                "targets": 6
            }
        ],
        "sort":false,
        "columns": [
            {"data": "userId"},
            {"data": "wxNickName"},
            {"data": "tbBuyerNick"},
            {"data": "jdPin"},
            {"data": "firstSource"},
            {"data": "mobile"},
            {"data": "birthday"}
        ]
    });
    $('#birthdayModal').modal('show');
    $('#searchBut').click(function(){
        TableModal.draw();
    });
}
$('#manualsubmit').click(function(){
    manualTarget= "";
    $("tbody :checkbox[name='manualcbox']").each(function(){
        if($(this).prop("checked")){
            manualTarget += $(this).val()+",";
        }
    });

    if (manualTarget == ''|| manualTarget == null){
        alert("赠送对象至少选择一个");
        return false;
    }
    //$("#addForm input[name='bizId']").val(manualTarget);
});
//页面加载生日列表
var oTable = $('#birthdayactivity').dataTable({
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
        "url":  baseUrl+'birthday/activity/list/info',
        "data": function (d) {
            var title = $("input[name='birthdayActivityTitle']").val();
            var status = $("select[name='birthdayActivityStatus']").val();
            var birthdayActivitystartDate = $("input[name='birthdayActivitystartDate']").val();
            var birthdayActivityendDate = $("input[name='birthdayActivityendDate']").val();
            if (!isNullOrEmpty(title)) {
                d.title = title;
            }
            if(!isNullOrEmpty(status)) {
                d.status = status;
            }
            if(!isNullOrEmpty(birthdayActivitystartDate)) {
                d.startDate = birthdayActivitystartDate;
            }
            if(!isNullOrEmpty(birthdayActivityendDate)) {
                d.endDate = birthdayActivityendDate;
            }
        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                if(data==null){
                    return  '';
                }else {
                    return getLocalTime(data);
                }
            },
            "targets":1
        },{
            "render": function (data, type, row) {
                if(data=="unstart"){
                    return '活动未开始';
                }else if(data=="start"){
                    return '活动进行中';
                }else if(data=="stop") {
                    return '活动暂停';
                } else if(data=="over") {
                    return '活动结束';
                } else {
                    return '';
                }
            },
            "targets":2
        },{
            "render": function (data, type, row) {
                if(data != null) {
                    if(data=="birthday_red_packet"){
                        return  '生日红包';
                    }
                    if(data=="birthday_gifts") {
                        return '生日礼物';
                    }
                    if(data=="birthday_points") {
                        return '生日积分';
                    }
                    if(data=="birthday_discount"){
                        return '生日折扣';
                    }
                } else {
                    return '';
                }

            },
            "targets":3
        },{
            "render": function (data, type, row) {
                if(data==null){
                    return  '';
                }else {
                    //return getLocalTime(data);
                    return getYMDTime(data);
                }
            },
            "targets":4
        }, {
            "render": function (data, type, row) {
                if(data==null){
                    return  '';
                }else {
                    //return getLocalTime(data);
                    return getYMDTime(data);
                }
            },
            "targets":5
        },{
            "render": function (data, type, row) {
                var zting=1;
                var kqi=0;
                var markToken = "birthdayForm";
                if(data != null) {
                    if(row.status=='unstart') {
                        return "<a href='javascript:edit("+data+");' id='edit"+data+"'>编辑</a>&nbsp;|&nbsp;" +
                            "未开始&nbsp;|&nbsp;" +
                            "<a href='javascript:detail("+data+");'>明细</a>";
                    }else if(row.status=='start') {
                        //return "<a href='' id='edit"+data+"' onclick='edit("+data+")'>编辑</a>&nbsp;|&nbsp;" +
                        //    "<a href='#' style='color:red' onclick='modifyStatus("+data+","+zting+");'>暂停</a>&nbsp;|&nbsp;" +
                        //    "<a href='#' onclick='detail("+data+")'>明细</a>";

                        return "<a href='javascript:edit("+data+");' id='edit"+data+"' onclick='createToken("+markToken+");'>编辑</a>&nbsp;|&nbsp;&nbsp;" +
                            "<a href='javascript:modifyStatus("+data+","+zting+");' id='modify"+data+"' style='color:red'>暂停</a>&nbsp;&nbsp;|&nbsp;&nbsp;" +
                            "<a href='javascript:detail("+data+");'>明细</a>";

                    } else if(row.status=='stop') {
                        return "<a href='javascript:edit("+data+");' id='edit"+data+"' onclick='createToken("+markToken+");'>编辑</a>&nbsp;|&nbsp;&nbsp;" +
                            "<a href='javascript:modifyStatus("+data+","+kqi+");' id='modify"+data+"' style='color:green'>开启</a>&nbsp;&nbsp;|&nbsp;&nbsp;" +
                            "<a href='javascript:detail("+data+");'>明细</a>";

                    } else {
                        return "<a href='javascript:edit("+data+");' id='edit"+data+"' onclick='createToken("+markToken+");'>编辑</a>&nbsp;|&nbsp;&nbsp;" +
                            "结束&nbsp;&nbsp;|&nbsp;&nbsp;" +
                            "<a href='javascript:detail("+data+");'>明细</a>";
                    }

                }

            },
            "targets":6
        }
    ],
    "sort": false,
    "columns": [

        {"data": "title"},
        {"data": "gmtCreated"},
        {"data": "status"},
        {"data": "careType"},
        {"data": "startTime"},
        {"data": "endTime"},
        {"data": "birthdayActivityId"}

    ]
});

//生日列表点击搜索
$("#birthdayConfigListsearchForm").submit(function () {
    var birthdayActivitystartDate = $("input[name='birthdayActivitystartDate']").val();
    var birthdayActivityendDate = $("input[name='birthdayActivityendDate']").val();
    var birthdayActivitystartDateParse = Date.parse((birthdayActivitystartDate + " 00:00:00").replace(/-/g,"/"));
    var birthdayActivityendDateParse = Date.parse((birthdayActivityendDate + " 00:00:00").replace(/-/g,"/"));

    if(birthdayActivitystartDateParse > birthdayActivityendDateParse) {
        alert("开始时间不能小于结束时间");
        return false;
    }
    $('#birthdayactivity').DataTable().draw()
    return false; //阻止表单默认提交
});
function modifyStatus(dataInfo, zting) {
    var statusInfo = "";
    var idMark = "#modify"+dataInfo;
    if(zting == 1) {
        statusInfo="stop";
    }
    if(zting == 0) {
        statusInfo="start";
    }

    $.ajax({
        type: 'POST',
        cache:false,
        url: baseUrl+'birthday/activity/change/status',
        dataType: 'json',
        data:  {
                birthdayId:dataInfo,
                status:statusInfo
               },
        success: function(data) {
            if(data.errorCode==0) {//修改成功
                alert(data.info);
                if(data.resultStatus == "开启") {
                    $(idMark).html(data.resultStatus);
                    $(idMark).attr("style", "color:green");
                    $(idMark).attr("href","javascript:modifyStatus("+dataInfo+",0)");

                    $(idMark).parent().siblings().eq(2).html("暂停");
                }
                if(data.resultStatus == "暂停") {
                    $(idMark).html(data.resultStatus);
                    $(idMark).attr("style", "color:red");
                    $(idMark).attr("href","javascript:modifyStatus("+dataInfo+",1)");

                    $(idMark).parent().siblings().eq(2).html("进行中");

                }
                //window.location.reload();
            } else {
                alert(data.info);
                //window.location.reload();
            }
        }

    });
}
function edit(dataInfo) {
    //获取防止重复提交的token
    createToken("birthdayForm");
    //点击当前行的"编辑"按钮， 获取下一行的开始时间和结束时间
    var editId = "#edit" + dataInfo;

    nextLineStartTime = $(editId).parent().parent().next().find('td').eq(4).html();
    nextLineEndTime = $(editId).parent().parent().next().find('td').eq(5).html();
    prevLineStartTime = $(editId).parent().parent().prev().find('td').eq(4).html();
    prevLineEndTime = $(editId).parent().parent().prev().find('td').eq(5).html();

    //freshUrl(baseUrl+"birthday/activity/list/toedit?birthdayActivityId="+dataInfo);
    $.post( baseUrl+"birthday/activity/list/toedit",
        {birthdayActivityId:dataInfo},
        function(data){
            loadData('#editModal', data);
            $('#editModal').modal('show');
        },
        "json"
    )
}
/**
 * 加载数据
 * @param topSelector
 * @param obj
 */
function loadData(topSelector, obj){

    //console.dir(obj);
    //设置隐藏的birthdayActivityId
    $("input[name='birthdayActivityId']").val(obj.configInfo.birthdayActivityId);
    //设置生日活动标题
    $('#birthdayForm input[name="title"]').val(obj.configInfo.title);

    //生日关怀类别
    if(obj.configInfo.careType=='birthday_red_packet') {
        $("#birthHb").prop("checked","checked");
        $("#hiddenDiv1").show();
        $("#hiddenDiv2").hide();
        $("#hiddenDiv3").hide();
        $("#hiddenDiv4").hide();
    }
    if(obj.configInfo.careType=='birthday_gifts') {
        $("#birthGifts").prop("checked","checked");
        $("#hiddenDiv1").hide();
        $("#hiddenDiv2").show();
        $("#hiddenDiv3").hide();
        $("#hiddenDiv4").hide();

    }
    if(obj.configInfo.careType=='birthday_points') {
        $("#birthPoints").prop("checked","checked");
        $("#hiddenDiv1").hide();
        $("#hiddenDiv2").hide();
        $("#hiddenDiv3").show();
        $("#hiddenDiv4").hide();

    }
    if(obj.configInfo.careType=='birthday_discount') {
        $("#birthDiscount").prop("checked","checked");
        $("#hiddenDiv1").hide();
        $("#hiddenDiv2").hide();
        $("#hiddenDiv3").hide();
        $("#hiddenDiv4").show();

    }

    flag = obj.configInfo.sendTarget;
    //设置赠送对象
    if(obj.configInfo.sendTarget=='auto') {

        $("#auto").prop("checked","checked");
    }
    if(obj.configInfo.sendTarget=='manual') {
        $("#manual").prop("checked","checked");
        $("#target").prop("class","col-sm-6");
        $("#findCus").show();
    }
    //给短信签名赋值
    $("input[name='msgSign']").val(obj.signName);
    //给input type=hidden name=poolId这个标签赋值
    $("input[name='poolId']").val(obj.configInfo.poolId);
    //给input type=hidden name=goodsId这个标签赋值
    $("input[name='goodsId']").val(obj.configInfo.goodsId);
    //填充积分
    $("input[name='points']").val(obj.configInfo.points);
    //填充折扣
    $("input[name='discount']").val(obj.configInfo.discount);
    //填充暗号
    $("input[name='secretPassword']").val(obj.configInfo.secretPassword);
    //是否短信提醒
    if(obj.configInfo.remindShortMessage==0) {
        $("#r0").prop("checked","checked");
        $("textarea[name='shortMessageContent']").prop("disabled",true);
    }
    if(obj.configInfo.remindShortMessage==1) {
        $("#r1").prop("checked","checked");
        $("textarea[name='shortMessageContent']").removeAttr("disabled");
    }
    //填充短信内容
    $("textarea[name='shortMessageContent']").val(obj.configInfo.shortMessageContent);
    //填充开始结束时间
    $("#starttime").val(obj.startTimeInfo);
    $("#endtime").val(obj.endTimeInfo);
    $("input[name='birthdayActivityId']").val(obj.configInfo.birthdayActivityId);


}
//保存
$('#save').click(function(){

    var editBaId = $("input[name='birthdayActivityId']").val();
    var title = $("#birthdayForm input[name='title']").val();
    var careType = $("#birthdayForm input[name='careType']:checked").val();
    var sendTarget = $("#birthdayForm input[name='sendTarget']:checked").val();
    var getLimit = $("#birthdayForm input[name='getLimit']:checked").val();
    //var poolId = $("#birthdayForm input[name='poolId']").val(); //红包池ID
    //goodsId = $("input[name='giftscbox']:checked").val();
    var points = $("#birthdayForm input[name='points']").val();
    var discount = $("#birthdayForm input[name='discount']").val();
    var secretPassword = $("#birthdayForm input[name='secretPassword']").val();
    var remindShortMessage = $("#birthdayForm input[name='remindShortMessage']:checked").val();
    var shortMessageContent = $("#birthdayForm textarea[name='shortMessageContent']").val();
    /**开始时间*/
    var startTime = $("#birthdayForm input[name='startTime']").val();
    /**结束时间*/
    var endTime = $("#birthdayForm input[name='endTime']").val();
    var startdate = Date.parse((startTime + " 00:00:00").replace(/-/g,"/"));
    var enddate = Date.parse((endTime + " 00:00:00").replace(/-/g,"/"));
    /**把下一行的开始时间和结束时间进行转化,用于比较时间的大小*/
    var nextLineStartDate = Date.parse((nextLineStartTime + " 00:00:00").replace(/-/g,"/"));
    var nextLineEndDate = Date.parse((nextLineEndTime + " 00:00:00").replace(/-/g,"/"));
    /**把下一行的开始时间和结束时间进行转化,用于比较时间的大小*/
    var prevLineStartDate = Date.parse((prevLineStartTime + " 00:00:00").replace(/-/g,"/"));
    var prevLineEndDate = Date.parse((prevLineEndTime + " 00:00:00").replace(/-/g,"/"));
    var token = $("#birthdayForm input[name='token']").val();
    //对页面的数据进行校验
    if(title=="" || title==null) {
        alert("生日活动标题不能为空");
        return false;
    }

    if(flag == "auto" && sendTarget == "manual" && manualTarget == "") {
        alert("请选择客户");
        return false;
    }

    if(careType=='birthday_red_packet') {
        if(poolId == 0) {
            alert("请选择红包池");
            return false;
        }
    }

    if(careType=='birthday_gifts') {
        if(goodsId==0) {
            alert("生日礼物还未选择");
            return false;
            //goodsId=$("input[name='goodsId']").val();
        }
    }
    if(careType=='birthday_points') {
        var r = /^\+?[1-9][0-9]*$/;  //正整数
        if($("input[name='points']").val().trim()=="") {
            alert("请输入赠送积分");
            return false;
        }

        if(!r.test($("input[name='points']").val().trim())) {
            alert("积分必须是整数");
            return false;
        }
    }
    if(careType=='birthday_discount') {
        if($("input[name='discount']").val().trim()=="") {
            alert("请输入折扣");
            return false;
        } else {
            var dis = $("input[name='discount']").val().trim();
            if(isNaN(dis)) {
                alert("折扣只能是数字");
                return false;
            } else {
                //var r= /^[+-]?[1-9]?[0-9]*\.[0-9]*$/;
                var r = /^\+?[1-9][0-9]*$/;  //正整数
                var r2 = /^[+-]?[1-9]?[0-9]*\.\d?$/;//小数点后一位的
                if(!(r.test(dis) || r2.test(dis))) {//正整数或者是小数点后一位的
                    alert("折扣是1-10之间的整数或者一位小数");
                    return false;
                }
            }

            //alert(dis);
            //dis = dis.replace(/[^\d.]/g,"");

        }

        if($("input[name='secretPassword']").val().trim()=="") {
            alert("请输入暗号");
            return false;
        }
    }

    if(remindShortMessage==1) {
        if(shortMessageContent=="" || shortMessageContent==null) {
            alert("短信提醒内容不能为空");
            return false;
        }
    }
    if(startTime == null || startTime == "") {
        alert("请先选择开始时间");
        return false;
    }
    if(endTime == null || endTime == "") {
        alert("请选择结束时间");
        return false;
    }
    if(startdate>enddate) {
        alert("结束时间要大于开始时间");
        return false;
    }
    /**
     * 业务上一个用户只能参加一个活动，
     * 所以活动之间的时间段不能够于重叠。
     * 为了防止编辑后时间上有重叠，判断一下，
     * 当前行的开始时间要大于下一行的结束时间
     * 当前行的结束时间要小于上一行的开始时间
     */
    if(startdate <= nextLineEndDate) {
        alert("开始时间要大于 " + nextLineEndTime);
        return false;
    }
    if(enddate >= prevLineStartDate) {
        alert("结束时间要小于" + prevLineStartTime);
        return false;
    }
    if(false) {
        alert("birthdayActivityId:" + editBaId);
        alert("title:" + title);
        alert("careType:" + careType);
        alert("manualTarget:" + manualTarget);
        alert("sendTarget:" + sendTarget);
        alert("poolId:" + poolId);
        alert("goodsId:" + goodsId);
        alert("points:" + points);
        alert("discount:" + discount);
        alert("secretPassword:" + secretPassword);
        alert("remindShortMessage:" + remindShortMessage);
        alert("shortMessageContent:" + shortMessageContent);
        alert("startTime:" + startTime);
        alert("endTime:" + endTime);
        alert("surplus:" + surplus);
        alert("token:" + token);
        return false;
    }
    formData = {title:title,careType:careType,manualTarget:manualTarget,getLimit:getLimit,poolId:poolId,goodsId:goodsId,
        points:points,discount:discount,secretPassword:secretPassword,remindShortMessage:remindShortMessage,
        shortMessageContent:shortMessageContent,endTime:endTime,surplus:surplus,
        startTime:startTime,sendTarget:sendTarget,birthdayActivityId:editBaId,token:token};

        $.ajax({
            type : "post",
            //url : baseUrl+"/birthday/activity/list/edit",
            url : baseUrl + "birthday/edit/birthday/config/update",
            data : formData,
            dataType : "json",
            success : function(data){
                if (data.errorCode == "-1"){
                    alert(data.info);
                    window.location.reload();
                }else{
                    alert(data.info);
                    window.location.reload();
                    //freshUrl(baseUrl+"birthday/activity/tolist");
                }
            }
        });
});
/*详情*/
function detail(dataInfo) {
    var TableModal = $('#detailsTable').dataTable({
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
        "bDestroy":true,
        "processing": true,
        "searching": false,
        "serverSide": true,
        "ajax": {
            "url":  baseUrl+'birthday/activity/details/list',
            "data": function (d) {
                d.birthdayId=dataInfo;
            }
        },
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    if(data!=null){
                        if(data=="birthday_red_packet"){
                            return  '生日红包';
                        }else if(data=="birthday_gifts") {
                            return '生日礼物';
                        } else if(data=="birthday_points") {
                            return '生日积分';
                        } else if(data=="birthday_discount"){
                            return '生日折扣';
                        }
                    }else {
                        return  '';
                    }

                },
                "targets":1
            }, {
                "render": function (data, type, row) {
                    if(data==null){
                        return  '';
                    }else {
                        return getLocalTime(data);
                    }

                },
                "targets":2
            }, {
                "render": function (data, type, row) {
                    if(data==null){
                        return  '';
                    }else {
                        return getLocalTime(data);
                    }
                },
                "targets":3
            }
        ],
        "sort":false,
        "columns": [
            {"data": "wxNickName"},
            {"data": "presentType"},
            {"data": "birthday"},
            {"data": "receiveDate"},
            {"data": "presentName"}
        ]
    });
    $('#detailsModal').modal('show');
    $('#searchBut').click(function(){
        TableModal.draw();
    });
    $("#addForm input[name='bizId']").val(val);

}
//全选
//单页全选
$('table th input:checkbox').on('click' , function(){
    var that = this;
    $(this).closest('table').find('tr > td:first-child input:checkbox')
        .each(function(){
            this.checked = that.checked;
            var userId = $(this).val();
            if (this.checked){
                if (!idList.in_array(userId)){
                    idList.addElement(userId);
                }
            }else{
                if (idList.in_array(userId)){
                    idList.deleteA(userId);
                }
            }
            $(this).closest('tr').toggleClass('selected');
        }
    );
    userData[1] = idList.length;
    $(".userListTable_Num").html(userData[1]);
});

//保存已选用户的信息数组
var idList = new Array();
Array.prototype.in_array =  function(e)
{
    for(var i=0;i<this.length;i++)
    {
        if(this[i] == e)
            return true;
    }
    return false;
}
Array.prototype.deleteA = function(val){
    var pos = -1;
    if (idList.in_array(val)){
        for (var i=0;i<this.length;i++){
            if (this[i] == val){
                pos = i;
            }
        }
    }
    if (pos > -1) {
        this.splice(pos, 1);
        return true;
    }
    return false;
}
Array.prototype.addElement = function(val){
    var info = val;
    if (!idList.in_array(info)){
        idList.push(info);
        return true;
    }
    return false;
}
//清除idlist数据
function clearList(){
    idList.length = 0;
}

//非全选时定向选择用户，数据存放在临时数组里 arr:用户保存数据的临时数组，boxName:单选框name
function addInfo(arr,tableID,boxName){
    //手动单个选择
    var $checkBox = $('#'+tableID+'  :checkbox[name="'+boxName+'"]');
    $.each($checkBox,function(i){
        var userId = $(this).attr('value');
        if (idList.in_array(userId)){
            $(this).prop('checked','checked');
        }
        $(this).on('click',function(){
            //取得id
            var userId = $checkBox.eq(i).attr('value');
            if($(this).prop('checked')){
                $checkBox.eq(i).removeAttr('checked');
                $(this).prop('checked','checked');
                idList.addElement(userId);
            }else {
                idList.deleteA(userId);
            }
            arr[1] = idList.length;
            $("."+tableID+"_Num").html(arr[1]);
        });
    });
}