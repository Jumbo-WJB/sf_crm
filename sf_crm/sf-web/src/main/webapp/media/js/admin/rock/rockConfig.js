var goodsCount = 1;
function addGoodsCofig() {

    if (goodsCount > 5) {
        alert("商品最大上限为5条。")
        return;
    }

    ++goodsCount;
    //$("#mvGruop").append('<p>123</p>')
    $("#goodsGroup").append('<div class="form-group"><label class="col-sm-4 control-label no-padding-right">选择积分商城的商品：</label><input hidden="hidden" class="goodsNumIndex" name="goodsId_' + goodsCount + '"/><div class="col-sm-6" style="padding-left: 25px;"><input type="text" readonly="readonly" name="goodsName_' + goodsCount + '" class="col-xs-2 col-sm-8"/><div class="col-sm-2" style="padding-left: 25px;"><span id="goods"></span><input class="goodsSel" width="200px" type="button" onclick="selPointGoods(goodsCount)" value="选择" name="select"/></div></div></div>');
    //$("#mvGruop").append('<div class="integralSignIn col-xs-16 col-sm-10" id="input_group_'+signCount+'" style="margin-top: 10px"><div class="input-group" style="margin-left: 200px;"><span class="ml20" style="margin-left: 15px">每连续签到</span><input  type="text" id="signInNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px;"/>天<span class="ml20" style="margin-left: 15px;">送积分</span><input  type="text" id="integralNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px"/>个<span class="ml20" style="margin-left: 15px;">领取限制</span><input id="getConfig_'+signCount+'" type="radio" class="ace" value="1" checked="checked"/><span class="lbl" style="margin-left: 15px;">每人仅限领取一次</span></div></div>');


}


$("#code").qrcode({
    render: "table", //table方式
    width: 200, //宽度
    height: 200, //高度
    text: baseUrl + "mobile/shake?sellerId=&shakeId=" //任意内容
});


function saveOrUpdateFrom() {

    if (!checkSubmit()){
        return;
    }

    var data = $('#rockConfigForm').serialize();
    //console.dir(data);
    //var buyIntegralArgs = "";
    //$.each($(".integralBuy"),function(i,value){
    //    buyIntegralArgs = buyIntegralArgs +',' +value.value;
    //});
//{'conertMoney':'"+conertMoney+"','groupIntegral':'"+groupIntegral+"','attentionIntegral':'"+groupIntegral+"','spreadIntegral':'"+spreadIntegral+"','buyIntegralArgs':'"+buyIntegralArgs+"'}

    $.ajax({
        type: "post", // 请求方式
        url: baseUrl + "rock/saveRockConfig", //url地址
        data: data, //数据
        dataType: "json",
        success: function (data) {
            if (data.errorCode == 0) {
                alert("添加成功");
                freshUrl(baseUrl+"/rock/rockDetail");
            } else {
                alert(data.errorMessage);
            }
        }, error: function () {
            alert("error");
        }
    });

}

/**
 * 选择积分商城商品
 */
function selPointGoods(i) {


    $('#pointGoodsSelectedModal').modal('show');

    $.each($(':checkbox[name="goodsId"]'), function (i, value) {
        $(this).click(function () {
            if ($(this).prop('checked')) {
                $(':checkbox[name="goodsId"]').removeAttr('checked');
                $(this).prop('checked', 'checked');
            }
        });
    });

    $("#goodsIndex").val(i);
}


/**
 * 选择带字红包池
 */
function selPool() {
    $('#hbPoolSelectedModal').modal('show');

    $.each($(':checkbox[name="cb"]'), function (i, value) {
        $(this).click(function () {
            if ($(this).prop('checked')) {
                $(':checkbox[name="cb"]').removeAttr('checked');
                $(this).prop('checked', 'checked');
            }
        });
    });

}

$('#rockConfigForm input[name="startConfig"]').click(function () {


    if ($('#rockConfigForm input[name="startConfig"]:checked').val() == 0) {
        $('#rockConfigForm input[name="startDate"]').attr("disabled", "disabled");
        $('#rockConfigForm input[name="endDate"]').attr("disabled", "disabled");
    } else {

        $('#rockConfigForm input[name="startDate"]').removeAttrs("disabled");
        $('#rockConfigForm input[name="endDate"]').removeAttrs("disabled");
    }
});

/**
 * 确定操作
 */
$("#poolSure").click(function (event) {
    var checks = $(".table td :input[type='checkbox']:checked");
    if (checks.length == 0) {
        alert("没有选中的红包池,请选择红包池！");
        return;
    }


    var value = $(':checkbox[name="cb"]:checked').val();

    var array = value.split(",");

    $('#rockConfigForm input[name="hbPoolName"]').val(array[1]);
    $('#rockConfigForm input[name="hbPoolId"]').val(array[0]);

    $('#rockConfigForm input[name="getHbNum"]').val(array[2]);


    $('#hbPoolSelectedModal').modal('hide');
});


/**
 * 确定操作
 */
$("#goodsSure").click(function (event) {
    var checks = $(".table td :input[type='checkbox']:checked");
    if (checks.length == 0) {
        alert("没有选中的礼物,请选择礼物！");
        return;
    }
    var value = $(':checkbox[name="goodsId"]:checked').val();
    var array = value.split(",");

    var goodsIndex = $("#goodsIndex").val();

    var getGiftNum = $('#rockConfigForm input[name="getGiftNum"]').val();

    var goodsNum = $(".goodsNumIndex").length;

    var num = parseInt(array[2]);

    if (goodsNum > 1) {
        var giftNum = parseInt(getGiftNum);
        num = num + giftNum;
    }


    $('#rockConfigForm input[name="getGiftNum"]').val(num);
    $('#rockConfigForm input[name="goodsId_' + goodsIndex + '"]').val(array[0]);

    $('#rockConfigForm input[name="goodsName_' + goodsIndex + '"]').val(array[1]);


    $('#pointGoodsSelectedModal').modal('hide');


});


function rockConfig() {
    //$("#giftConfig").hide();
    //$("#hbPoll").hide();
    //$("#pointConfig").hide();
    $("#rockDetail").hide();
    $("#show").hide();
    $("#save").hide();
    $("#back").hide();



}


$("#back").click(function () {
    $("#back").hide();
    $("#next").show();
    $("#rockGroup").show();
    $("#rockDetail").hide();
    $("#save").hide();
});

//js 获取当前日期时间 格式为 yyyy-mm-dd hh:MM:ss
Date.prototype.format = function (format) {
    var args = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds()
    };
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var i in args) {
        var n = args[i];
        if (new RegExp("(" + i + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));
    }
    return format;
};

$("#next").click(function () {
    var now = new Date().format("yyyy-MM-dd hh:mm:ss");

    if (!check().form()) {
        return;
    }



    $("#rockConfigForm input[name='rockName']").val($("#rockConfigForm input[name='rockTitle']").val());

    $("#rockGroup").hide();
    //$("#giftConfig").hide();
    //$("#pointConfig").hide();
    $("#rockDetail").show();
    //$("#hbPoll").show();
    //
    $("#next").hide();
    $("#show").show();
    $("#save").show();
    $("#back").show();
});

$(".configType").click(function () {


});
rockConfig()

function checkSubmit(){
    var isGetPointEnable = $('#rockConfigForm input[name="isShakePoint"]:checked').val();
    var isGetHBEnable = $('#rockConfigForm input[name="isShakeHb"]:checked').val();
    var isGetGoodsEnable = $('#rockConfigForm input[name="isShakeGift"]:checked').val();

    if (isGetPointEnable !=1 && isGetHBEnable !=1 && isGetGoodsEnable !=1){
        alert("至少配置1个摇一摇活动项目");
        return false;
    }

    if (isGetHBEnable ==1){
       var hbPoolName = $('#rockConfigForm input[name="hbPoolName"]').val();
       var hbPoolId =  $('#rockConfigForm input[name="hbPoolId"]').val();
       var getHbNum = $('#rockConfigForm input[name="getHbNum"]').val;

        if (hbPoolName =='' || hbPoolName==null ||hbPoolName==undefined
            || hbPoolId == '' || hbPoolId == null || hbPoolId ==undefined
        || getHbNum == null || getHbNum == '' || getHbNum == undefined){
            alert("红包为启用状态，配置不能为空！");
            return false;
        }
    }

    if (isGetPointEnable ==1){
        var pointIntervalMin = $('#rockConfigForm input[name="pointIntervalMin"]').val();
        var pointIntervalMax =  $('#rockConfigForm input[name="pointIntervalMax"]').val();
        var getPointNum = $('#rockConfigForm input[name="getPointNum"]').val;
        var isGetPointShare = $('#rockConfigForm input[name="isGetPointShare"]').val;
        if (pointIntervalMin == '' || pointIntervalMin == null || pointIntervalMin == undefined
            || pointIntervalMax == '' || pointIntervalMax == null || pointIntervalMax == undefined
            || getPointNum == '' || getPointNum == null || getPointNum == undefined
        ){
            alert("积分为启用状态，配置不能为空！");
            return false;
        }

        if (pointIntervalMin > pointIntervalMax) {
            alert("最小值不能大于最大值。");
            return false;
        }

        if (getPointNum <= 0) {
            alert("人数必须是大于0的整数。");
            return false;
        }
    }

    if (isGetGoodsEnable == 1){
       //var goodsUrl = $('#rockConfigForm input[name="goodsName_1"]').val();
        var goodsId =  $('#rockConfigForm input[name="goodsId_1"]').val();

        if (goodsId == '' || goodsId == null || goodsId == undefined
            || goodsId == '' || goodsId == null || goodsId == undefined
        ){
            alert("礼物为启用状态，配置不能为空！");
            return;
        }

    }
    return true;
}

function check() {

    jQuery.validator.addMethod("dateConfig", function (value, element) {

        var startDate = $('#rockConfigForm input[name="startDate"]').val();
        var endDate = $('#rockConfigForm input[name="endDate"]').val();


        if ($('#rockConfigForm input[name="startConfig"]:checked').val() == 1) {
            if (startDate == null || startDate == '' || startDate == undefined || endDate == null || endDate == '' || endDate == undefined) {
                return false;
            }

            var startTime = $("#rockConfigForm input[name='startDate']").val();
            var endTime = $("#rockConfigForm input[name='endDate']").val();

            if (startTime == ''){
                alert('起始时间不能为空');
                return false;
            }
            if (endTime == ''){
                alert('结束时间不能为空');
                return false;
            }
            if (startTime <= now){
                alert('起始时间必须大于当前时间');
                return false;
            }
            if (startTime >= endTime){
                alert('结束时间必须大于起始时间');
                return false;
            }
        }




        return true;
    }, "活动时间不能为空。");


    return $("#rockConfigForm").validate({

        rrorElement: 'span',
        errorClass: 'help-block',
        focusInvalid: false,
        rules: {
            rockTitle: {
                required: true,
                maxlength: 30

            },
            randomNum: {
                required: true,
                range: [1, 100]
            },
            rockNum: {
                required: true,
                digits: true
            }


        },
        messages: {
            rockTitle: {
                required: "摇一摇标题名称不能为空",
                maxlength: "名称长度不能大于30位"
            },
            randomNum: {
                required: "摇中机率不能为空",
                range: "机率为百分之1-100的数字"
            },
            rockNum: {
                required: "摇的次数限制不能为空",
                digits: "必须为整数"
            }
        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },

        success: function (label) {
            label.closest('.form-group').removeClass('has-error');
            label.remove();
        },

        errorPlacement: function (error, element) {
            element.parent('div').append(error);
        }

    });
}

$('#rockConfigForm input:checkbox[name="isShakePoint"]').click(function () {


    if ($('#rockConfigForm input[name="isShakePoint"]:checked').val()!=1){
        $('#from_group_point').find("*").each(function() {
            $(this).attr("disabled", "disabled");

        });
    }else{

        $('#from_group_point').find("*").each(function() {
            $(this).removeAttr("disabled");

        });
    }

});



$('#rockConfigForm input:checkbox[name="isShakeHb"]').click(function () {

    if ($('#rockConfigForm input[name="isShakeHb"]:checked').val()!=1){
        $('#rockConfigForm input[name="selHbPool"]').attr("disabled","disabled");
        $('#rockConfigForm input[name="isGetHBShare"]').attr("disabled","disabled");


        $('#rockConfigForm input[name="hbPoolName"]').val("");
        $('#rockConfigForm input[name="hbPoolId"]').val("");
        $('#rockConfigForm input[name="getHbNum"]').val("");




    }else{

        $('#rockConfigForm input[name="selHbPool"]').removeAttr("disabled");
        $('#rockConfigForm input[name="isGetHBShare"]').removeAttr("disabled");

    }


});


$('#rockConfigForm input:checkbox[name="isShakeGift"]').click(function () {

    if ($('#rockConfigForm input[name="isShakeGift"]:checked').val()!=1){
        $('#rockConfigForm input[name="selGoods"]').attr("disabled","disabled");
        $('#rockConfigForm input[name="isGetGiftShare"]').attr("disabled","disabled");
        $('#rockConfigForm input[name="addGoodsBtn"]').attr("disabled","disabled");
        $('.goodsSel').attr("disabled","disabled");




    }else{

        $('#rockConfigForm input[name="selGoods"]').removeAttr("disabled");
        $('#rockConfigForm input[name="isGetGiftShare"]').removeAttr("disabled");
        $('#rockConfigForm input[name="addGoodsBtn"]').removeAttr("disabled");
        $('.goodsSel').removeAttr("disabled");

    }


});



/**
 * 红包池分页
 * @type {*|jQuery}
 */
var oTable = $('#imgTable').dataTable({
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
            var name = $("#searchForm :input[name='name']").val();

            var startDate = $("#searchForm :input[name='startDate']").val();
            var endDate = $("#searchForm :input[name='endDate']").val();
            d.type = 'shake';//默认设置类型为好评返红包
            d.status = 'unBounded'//默认设置红包为未关联
            if (!isNullOrEmpty(name)) {
                d.name = name;
            }
            if (!isNullOrEmpty(startDate)) {
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
                return '<td class="center"><label><input type="checkbox" name="cb" class="ace" value="' + row.poolId + "," + row.name + "," + row.number + '"/><span class="lbl"></span></label></td>';
            },
            "targets": 0
        }, {
            "render": function (data, type, row) {
                if (data == null) {
                    return '';
                } else
                    return getLocalTime(data);
            },
            "targets": 2
        }, {
            "render": function (data, type, row) {
                if (data == "unBounded") {
                    return "未关联"
                } else if (data == "unReceived") {
                    return "待领取"

                } else if (data == "receiving") {
                    return "领取中"
                } else if (data == "done") {
                    return "结束"
                }
                return data;
            },
            "targets": 3
        }, {
            "render": function (data, type, row) {
                return (row.number - row.numberObtain);
            },
            "targets": 6
        }, {
            "render": function (data, type, row) {
                if (data == "gjc") {
                    return "关键词领取"
                } else if (data == "jfdh") {
                    return "积分兑换领取"

                } else if (data == "shake") {
                    return "摇一摇领取"
                } else if (data = "hpf") {
                    return "好评返领取"
                } else if (data = "gw") {
                    return "购物领取"
                } else if (data = "fxs") {
                    return "分享领取"
                } else {
                    return ""
                }
                return data;
            },
            "targets": 7
        }, {
            "render": function (data, type, row) {
                if (data == null) {
                    return '';
                } else
                    return getLocalTime(data);

            },
            "targets": 8
        }
    ],
    "sort": false,
    "columns": [
        {"data": "id"},
        {"data": "name"},
        {"data": "gmtCreated"},
        {"data": "states"},
        {"data": "number"},
        {"data": "numberObtain"},
        {"data": "null"},
        {"data": "type"},
        {"data": "endDate"}
    ]
});

//查询
$("#searchForm").submit(function () {
    $('#imgTable').DataTable().draw();
    return false; //阻止表单默认提交
});

/**
 * 商品列表dataTable
 * */
var goodsList = $('#goodsList').dataTable({
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
        "url": baseUrl + '/mall/goods/list',
        "data": function (d) {
            d.categoryName = '礼物';
            d.status = 'onsale';

        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {

                return '<td class="center"><label><input type="checkbox" name="goodsId" class="ace" value="' + data + "," + row.title + "," + row.quantity + '"/><span class="lbl"></span></label></td>';
            },
            "targets": 0
        }, {
            "render": function (data, type, row) {
                var name = row.title;
                var imgUrls = row.imgsUrl;
                var firstImg;
                if (!isNullOrEmpty(imgUrls)) {
                    firstImg = imgUrls.split(",")[0]
                }
                return '<td align="left"><a href="#"><img src="' + baseUrl + firstImg + '" width="60px" height="60px"/>' + name + '</a></td>';
            },
            "targets": 1
        }, {
            "render": function (data, type, row) {
                var price = data / 100;
                return "￥" + price.toFixed(2);
            },
            "targets": 2
        }, {
            "render": function (data, type, row) {

                return data;
            },
            "targets": 3
        }, {
            "render": function (data, type, row) {
                return data;
            },
            "targets": 4
        }, {
            "render": function (data, type, row) {
                return data;

            },
            "targets": 5
        }, {
            "render": function (data, type, row) {
                if (data == null) {
                    return '';
                } else
                    return getLocalTime(data);
            },
            "targets": 6
        }, {
            "render": function (data, type, row) {
                if (data == 'onsale') {
                    return '已上架';
                } else if (data == 'instock') {
                    return '已下架';
                }
                return '未知';
            },
            "targets": 7
        }
    ],
    "sort": false,
    "columns": [
        {"data": "goodsId"},
        {"data": null},
        {"data": "price"},
        {"data": "quantity"},
        {"data": "exchangeAmount"},
        {"data": "point"},
        {"data": "listTime"},
        {"data": "status"},
    ]
});