/**
 * 页面加载时执行的方法，为了获取防止重复提交的token
 */
createToken("birthdayForm");

var manualTarget = "";
var poolId = "";
var goodsId = "";
var poolName="";
var poolTotalNum="";
//商品数量
var goodsNum;
var surplus="";
var hbTotalCash="";
/**选择红包池后锁定的时间*/
var submitStartDate="";
var submitEndDate="";
var showStr="";
var dtNow=new Date();
var dtNew=new Date(dtNow.getTime()+7*24*60*60*1000);
var endtimeStr = "" + dtNew.getFullYear() + "-";
endtimeStr += (dtNew.getMonth()+1) + "-";
endtimeStr += (dtNew.getDate());

/**
 * 关怀类别:生日红包
 */
$("#birthHb").bind("click", function(event) {
    $("#hiddenDiv1").show();
    $("#hiddenDiv2").hide();
    $("#hiddenDiv3").hide();
    $("#hiddenDiv4").hide();
    $("#hiddenDiv5").hide();
    //$("#starttime").prop("disabled", true);
    //$("#endtime").val("");
    //$("#endtime").prop("disabled", true);
    //清空其他数据，防止数据混乱
    goodsId = "";
    $("#birthdayForm input[name='points']").val("");
    $("#birthdayForm input[name='discount']").val("");
    $("#birthdayForm input[name='secretPassword']").val("");
    //清空"领取限制" 下面的显示框
    $("textarea[name='showarea']").val("");
    $(".showarea").hide();
});
/**
 * 关怀类别：生日礼物
 */
$("#birthGifts").bind("click", function(event) {
    $("#hiddenDiv1").hide();
    $("#hiddenDiv2").show();
    $("#hiddenDiv3").hide();
    $("#hiddenDiv4").hide();
    $("#hiddenDiv5").hide();
    //把选择红包后的时间给清除掉
    submitStartDate="";
    submitEndDate="";
    //$("#starttime").removeAttr("disabled");
    //$("#endtime").removeAttr("disabled");
    $("#starttime").val($("input[name='hideStartTime']").val());
    //$("#endtime").val("");
    //清空其他数据，防止数据混乱
    poolId = "";
    $("#birthdayForm input[name='points']").val("");
    $("#birthdayForm input[name='discount']").val("");
    $("#birthdayForm input[name='secretPassword']").val("");
    //清空"领取限制" 下面的显示框
    $("textarea[name='showarea']").val("");
    $(".Divshowarea").hide();
});
/**
 * 关怀类别： 生日积分
 */
$("#birthPoints").bind("click", function(event) {
    $("#hiddenDiv1").hide();
    $("#hiddenDiv2").hide();
    $("#hiddenDiv3").show();
    $("#hiddenDiv4").hide();
    $("#hiddenDiv5").hide();
    //把选择红包后的时间给清除掉
    submitStartDate="";
    submitEndDate="";
    //$("#starttime").removeAttr("disabled");
    //$("#endtime").removeAttr("disabled");
    $("#starttime").val($("input[name='hideStartTime']").val());
    //$("#endtime").val("");
    //清空其他数据，防止数据混乱
    goodsId = "";
    poolId = "";
    $("#birthdayForm input[name='discount']").val("");
    $("#birthdayForm input[name='secretPassword']").val("");
});
/**
 * 关怀类别： 生日折扣
 */
$("#birthDiscount").bind("click", function(event) {
    $("#hiddenDiv1").hide();
    $("#hiddenDiv2").hide();
    $("#hiddenDiv3").hide();
    $("#hiddenDiv4").show();
    $("#hiddenDiv5").show();
    //$("#starttime").removeAttr("disabled");
    //$("#endtime").removeAttr("disabled");
    $("#starttime").val($("input[name='hideStartTime']").val());
    //$("#endtime").val("");
    //把选择红包后的时间给清除掉
    submitStartDate="";
    submitEndDate="";
    //清空其他数据，防止数据混乱
    poolId = "";
    goodsId = "";
    $("#birthdayForm input[name='points']").val("");
    $("#birthdayForm input[name='secretPassword']").val("");
});
/**
 * 赠送对象 手动选择 样式的调整
 */
$("#manual").bind("click",function(event){
    $("#findCus").show();
});
/**
 * 赠送对象 自动选择 样式的调整
 */
$("#auto").bind("click",function(event){
    manualTarget = "";
    //$("#endtime").prop("value",endtimeStr);
    $("#findCus").hide();
});
/**
 * 是否短信提醒
 */
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
 * 选择强关系级别
 *
 */
$("#searchForm input[name='relationship']").each(function(){
    var level = "";
    $(this).click(function(){
        var startTime = $("input[name='startTime']").val();
        var endTime = $("input[name='endTime']").val();
        level = $(this).val();
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
                    d.startTime = startTime;
                    d.endTime = endTime;
                    d.level=level;
                }
            },
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return '<td class="center"><label><input name="manualcbox" type="checkbox" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                    },
                    "targets": 0
                },{
                    "render": function (data, type, row) {
                        if(data="TMLL"){
                            return "天猫";
                        }
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

/**
 * 选择红包池
 */
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
                //var searchStartDate = $("#searchForm :input[name='startDate']").val();
                //var searchEndDate = $("#searchForm :input[name='endDate']").val();

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
                    return '<td class="center"><label><input name="cbox" type="radio" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
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
        if($(this).prop('checked')){
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

    if(poolId == '' || poolId == null) {
        alert("红包池未选择");
        return false;
    }

    //if(sttDate < defaultDate) {
    //    poolId = '';
    //    alert("以选择红包池的开始时间不能小于默认值");
    //    return false;
    //}
    $("textarea[name='showarea']").val(showStr);
    $(".showarea").show();
    $("input[name='surplus']").val(surplus);
    //$("#starttime").val(submitStartDate);
    //$("#endtime").val(submitEndDate);
});

/**
 *  赠送对象， 手动选择
 */
function selectSendTarget() {
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
            }
        },
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    return '<td class="center"><label><input name="manualcbox" type="checkbox" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                },
                "targets": 0
            },{
                "render": function (data, type, row) {
                    if(data="TMLL"){
                        return "天猫";
                    }
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
                    return "";
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
}
$('#manualsubmit').click(function(){
    manualTarget = "";
    $("tbody :checkbox[name='manualcbox']").each(function(){
        if($(this).prop("checked")){
            manualTarget += $(this).val()+",";

        }
    });

    if (manualTarget == ''|| manualTarget == null){
        alert("赠送对象至少选择一个");
        return false;
    }
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
                    return '<td class="center"><label><input name="giftscbox" type="radio" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
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
    $('#searchGiftsBut').click(function(){

        TableModal.draw();
    });


}
$('#giftssubmit').click(function(){

    var i = 0;
    //$(":checkbox[name='giftscbox']").each(function(){
    //    if ($(this).prop('checked')){
    //        goodsId = $(this).val();
    //        //商品名称
    //        var goodsName = $(this).parent().parent().siblings().eq(0).html();
    //        //商品数量
    //        var goodsNum = $(this).parent().parent().siblings().eq(1).html();
    //        showStr = "商品名称:" + goodsName + "     商品数量:" + goodsNum;
    //        $("textarea[name='showarea']").val(showStr);
    //        i++;
    //    }
    //});
    $("input[name='giftscbox']").each(function(){
        if($(this).prop('checked')) {
            goodsId = $(this).val();
            //商品名称
            var goodsName = $(this).parent().parent().siblings().eq(0).html();
            //商品数量
            goodsNum = $(this).parent().parent().siblings().eq(1).html();
            showStr = "商品名称:" + goodsName + "\r\n商品数量:" + goodsNum;
            $("textarea[name='showarea']").val(showStr);
            $(".Divshowarea").show();
        }
    });

    if (goodsId == ''|| goodsId == null){
        alert("未选择生日礼物");
        return false;
    }
});
//保存回复设置
$('#save').click(function(){
    //生日活动标题
    var title = $("input[name='title']").val();
    var target = $("input[name='sendTarget']:checked").val();
    //先判断开始时间和结束时间
    var startTime = $("input[name='startTime']").val();
    var hideStartTime = $("input[name='hideStartTime']").val();
    var hideDate = Date.parse((hideStartTime + " 00:00:00").replace(/-/g,"/"));
    var endTime = $("input[name='endTime']").val();
    var startdate = Date.parse((startTime + " 00:00:00").replace(/-/g,"/"));
    var enddate = Date.parse((endTime + " 00:00:00").replace(/-/g,"/"));
    var careType = $('input[name="careType"]:checked').val();
    var remindShortMessage = $("#birthdayForm input[name='remindShortMessage']:checked").val();
    var shortMessageContent = $("#birthdayForm textarea[name='shortMessageContent']").val();

    if(title == "" || title == null) {
        alert("生日活动标题不能为空");
        return false;
    }
    if(target=='manual') {
        if(manualTarget=="") {
            alert("请选择客户");
            return false;
        }
    }

    if(careType=='birthday_red_packet') {
        if(poolId=="") {
            alert("请选择红包池");
            return false;
        }
    }
    if(careType=='birthday_gifts') {
        if(goodsId=="") {
            alert("请选择生日礼物");
            return false;
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
        if (shortMessageContent.trim() == "") {
            alert("短信内容不能为空");
            return false;
        }
    }
    if(startTime == null || startTime == "") {
        alert("请选择开始时间");
        return false;
    }


    if(startdate<hideDate) {
        alert("开始时间不能小于默认值");
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

    //var data = $('#birthdayForm').serlize();
    var editBaId = $("input[name='birthdayActivityId']").val();
    var title = $("#birthdayForm input[name='title']").val();
    var careType = $("#birthdayForm input[name='careType']:checked").val();
    //有两种类型7天内过生日，30天内过生日，还有一种是手动选择的
    var sendTarget = $("#birthdayForm input[name='sendTarget']:checked").val();
    var getLimit = $("#birthdayForm input[name='getLimit']:checked").val();
    //var poolId = $("#birthdayForm input[name='poolId']").val(); //红包池ID
    //var goodsId = $("#birthdayForm input[name='goodsId']").val(); //积分商场商品id
    var points = $("#birthdayForm input[name='points']").val();
    var discount = $("#birthdayForm input[name='discount']").val();
    var secretPassword = $("#birthdayForm input[name='secretPassword']").val();
    var token = $("#birthdayForm input[name='token']").val();
    //var startTime = $("#birthdayForm input[name='startTime']").val();
    //var endTime = $("#birthdayForm input[name='endTime']").val();


    formData = {title:title,careType:careType,manualTarget:manualTarget,getLimit:getLimit,poolId:poolId,goodsId:goodsId,
        points:points,discount:discount,secretPassword:secretPassword,remindShortMessage:remindShortMessage,
        shortMessageContent:shortMessageContent,endTime:endTime,surplus:surplus,goodsNum:goodsNum,
        startTime:startTime,sendTarget:sendTarget,birthdayActivityId:editBaId,token:token};
    //if(true) {
    //    alert("manualTarget:" + manualTarget);
        //alert("poolId:" + poolId);
        //alert("goodsId:" + goodsId);
        //alert("points:" + points);
        //alert("discount:" + discount);
        //alert("secretPassword:" + secretPassword);
        //return false;
    //}

    $.ajax({
        type : "post",
        url : baseUrl+"/birthday/save/info",
        data : formData,
        dataType : "json",
        success : function(data){
            if (data.errorCode == "-1"){
                alert(data.info);
                //window.location.reload();
                createToken("birthdayForm");
            }else{
                alert('保存成功');
                window.location.reload();
            }
        }
    });
});

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