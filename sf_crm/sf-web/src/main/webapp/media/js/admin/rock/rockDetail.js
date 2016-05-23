$("#back").click(function () {
    $("#back").hide();
    $("#next").show();
    $("#rockGroup").show();
    $("#rockDetail").hide();
    $("#save").hide();
});

$("#next").click(function () {

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

    $("#back").show();


    if ($("#isShowView").val() != 1) {
        $("#save").show();
    }
});

$('#rockConfigForm input[name="startConfig"]').click(function () {

    if ($('#rockConfigForm input[name="startConfig"]:checked').val() == 0) {
        $('#rockConfigForm input[name="startDate"]').attr("disabled", "disabled");
        $('#rockConfigForm input[name="endDate"]').attr("disabled", "disabled");
    } else {

        $('#rockConfigForm input[name="startDate"]').removeAttrs("disabled");
        $('#rockConfigForm input[name="endDate"]').removeAttrs("disabled");
    }
});

function saveOrUpdateFrom() {

    if (!checkSubmit()) {
        return;
    }


    var data = $('#rockConfigForm').serialize();
    var isShakeHb = $('#rockConfigForm input[name="isShakeHb"]').val();
    var isShakePoint = $('#rockConfigForm input[name="isShakePoint"]').val();
    var isShakeGift = $('#rockConfigForm input[name="isShakeGift"]').val();


    console.dir(data);

    var isShakeStr = '';
    if (isShakeHb == '0') {

        isShakeStr = isShakeStr + "&isShakeHb=" + isShakeHb;

    }
    if (isShakePoint == '0') {
        isShakeStr = isShakeStr + "&isShakePoint=" + isShakePoint;
    }
    if (isShakeGift == '0') {
        isShakeStr = isShakeStr + "&isShakeGift=" + isShakeGift;
    }


    $.ajax({
        type: "post", // 请求方式
        url: baseUrl + "rock/saveRockConfig", //url地址
        data: data + isShakeStr, //数据
        dataType: "json",
        success: function (data) {
            if (data.errorCode == 0) {
                alert("保存成功");

                //$('#pointGoodsSelectedModal').modal('hide');

                $('#editModal').modal('hide');
                tableModal.draw();
                //freshUrl(baseUrl + "/rock/rockDetail");
            } else {
                alert(data.errorMessage);
            }
        }, error: function () {
            alert("error");
        }
    });
}

function checkSubmit() {
    var isGetPointEnable = $('#rockConfigForm input[name="isShakePoint"]:checked').val();
    var isGetHBEnable = $('#rockConfigForm input[name="isShakeHb"]:checked').val();
    var isGetGoodsEnable = $('#rockConfigForm input[name="isShakeGift"]:checked').val();

    if (isGetPointEnable != 1 && isGetHBEnable != 1 && isGetGoodsEnable != 1) {
        alert("至少配置1个摇一摇活动项目");
        return false;
    }

    if (isGetHBEnable == 1) {
        var hbPoolName = $('#rockConfigForm input[name="hbPoolName"]').val();
        var hbPoolId = $('#rockConfigForm input[name="hbPoolId"]').val();
        var getHbNum = $('#rockConfigForm input[name="getHbNum"]').val;

        if (hbPoolName == '' || hbPoolName == null || hbPoolName == undefined
            || hbPoolId == '' || hbPoolId == null || hbPoolId == undefined
            || getHbNum == null || getHbNum == '' || getHbNum == undefined) {
            alert("红包为启用状态，配置不能为空！");
            return false;
        }
    }

    if (isGetPointEnable == 1) {
        var pointIntervalMin = $('#rockConfigForm input[name="pointIntervalMin"]').val();
        var pointIntervalMax = $('#rockConfigForm input[name="pointIntervalMax"]').val();
        var getPointNum = $('#rockConfigForm input[name="getPointNum"]').val;
        var isGetPointShare = $('#rockConfigForm input[name="isGetPointShare"]').val;
        if (pointIntervalMin == '' || pointIntervalMin == null || pointIntervalMin == undefined
            || pointIntervalMax == '' || pointIntervalMax == null || pointIntervalMax == undefined
            || getPointNum == '' || getPointNum == null || getPointNum == undefined
        ) {
            alert("积分为启用状态，配置不能为空！");
            return false;
        }

        if (pointIntervalMin > pointIntervalMax) {
            alert("最小值不能大于最大值。");
            return false;
        }

        if (getPointNum <= 0) {
            alert("人数必须大于0的整数。");
            return false;
        }

    }

    if (isGetGoodsEnable == 1) {
        //var goodsUrl = $('#rockConfigForm input[name="goodsName_1"]').val();
        var goodsId = $('#rockConfigForm input[name="goodsName_1"]').val();

        if (goodsId == '' || goodsId == null || goodsId == undefined
            || goodsId == '' || goodsId == null || goodsId == undefined
        ) {
            alert("礼物为启用状态，配置不能为空！");
            return false;
        }

    }
    return true;
}


$('#rockConfigForm input:checkbox[name="isShakePoint"]').click(function () {

    if ($('#rockConfigForm input[name="isShakePoint"]:checked').prop("checked")) {

        $('#rockConfigForm input[name="isShakePoint"]').val("1");
    } else {

        $('#rockConfigForm input[name="isShakePoint"]').val("0");
    }

    isShakePoint();

});

$('#rockConfigForm input:checkbox[name="isShakeHb"]').click(function () {

    if ($('#rockConfigForm input[name="isShakeHb"]:checked').prop("checked")) {

        $('#rockConfigForm input[name="isShakeHb"]').val("1");
    } else {

        $('#rockConfigForm input[name="isShakeHb"]').val("0");


    }

    isShakeHb();

});

$('#rockConfigForm input:checkbox[name="isShakeGift"]').click(function () {

    if ($('#rockConfigForm input[name="isShakeGift"]:checked').prop("checked")) {

        $('#rockConfigForm input[name="isShakeGift"]').val("1");
    } else {
        $('#rockConfigForm input[name="isShakeGift"]').val("0");
    }

    isShakeGift();

});

function isShakePoint() {
    if ($("#isShowView").val() == 1) {
        $('#from_group_point').find("*").each(function () {
            $(this).attr("disabled", "disabled");
            //$(this).val("");
        });
    } else {
        if ($('#rockConfigForm input[name="isShakePoint"]:checked').val() != 1) {
            $('#from_group_point').find("*").each(function () {
                $(this).attr("disabled", "disabled");
            });
        } else {
            $('#rockConfigForm input[name="isShakePoint"]').val("1");
            $('#from_group_point').find("*").each(function () {
                $(this).removeAttr("disabled");
            });
        }
    }
}

function isShakeHb() {

    if ($("#isShowView").val() == 1) {

        $('#rockConfigForm input[name="selHbPool"]').attr("disabled", "disabled");
        $('#rockConfigForm input[name="isGetHbShare"]').attr("disabled", "disabled");
    } else {
        if ($('#rockConfigForm input[name="isShakeHb"]:checked').val() != 1) {
            $('#rockConfigForm input[name="selHbPool"]').attr("disabled", "disabled");
            $('#rockConfigForm input[name="isGetHbShare"]').attr("disabled", "disabled");
            //$('#rockConfigForm input[name="isShakeHb"]').val("1");
            //$('#rockConfigForm input[name="hbPoolName"]').val("");
            //$('#rockConfigForm input[name="hbPoolId"]').val("");
            //$('#rockConfigForm input[name="getHbNum"]').val("");

        } else {

            //$('#rockConfigForm input[name="isShakeHb"]').val("0");
            $('#rockConfigForm input[name="selHbPool"]').removeAttr("disabled");
            $('#rockConfigForm input[name="isGetHbShare"]').removeAttr("disabled");

        }

    }
}

function isShakeGift() {

    if ($("#isShowView").val() == 1) {

        $('#rockConfigForm input[name="selGoods"]').attr("disabled", "disabled");
        $('#rockConfigForm input[name="isGetGiftShare"]').attr("disabled", "disabled");

    } else {

        if ($('#rockConfigForm input[name="isShakeGift"]:checked').val() != 1) {

            $('#rockConfigForm input[name="isGetGiftShare"]').attr("disabled", "disabled");
            $('#rockConfigForm input[name="addGoodsBtn"]').attr("disabled", "disabled");
            $('.goodsSel').attr("disabled", "disabled");


            //$('#rockConfigForm input[name="hbPoolName"]').val("");

        } else {

            $('#rockConfigForm input[name="selGoods"]').removeAttr("disabled");
            $('#rockConfigForm input[name="isGetGiftShare"]').removeAttr("disabled");
            $('.goodsSel').removeAttr("disabled");
            $('#rockConfigForm input[name="addGoodsBtn"]').removeAttr("disabled");

        }
    }
}

/**
 * 选择积分商城商品
 */
function selPointGoods(i) {


    if (isGoodsInit) {

        goodsList();
        isGoodsInit = false;
    } else {
        goodsList.draw();
    }

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


    if (isHbsInit) {

        hbPoolList();
        isHbsInit = false;
    } else {
        oTable.draw();
    }

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

function check() {

    jQuery.validator.addMethod("dateConfig", function (value, element) {

        var startDate = $('#rockConfigForm input[name="startDate"]').val();
        var endDate = $('#rockConfigForm input[name="endDate"]').val();


        if ($('#rockConfigForm input[name="startConfig"]:checked').val() == 1) {
            if (startDate == null || startDate == '' || startDate == undefined || endDate == null || endDate == '' || endDate == undefined) {
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
            },
            startDate: {
                dateConfig: true
            },
            endDate: {
                dateConfig: true
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

var isHbsInit = true;
var oTable;
function hbPoolList() {
    isHbsInit = true;
    /**
     * 红包池分页
     * @type {*|jQuery}
     */
    oTable = $('#imgTable').DataTable({
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
                d.states = 'unBounded'//默认设置红包为未关联
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
}

var isGoodsInit = true;
var goodsList;
function goodsList() {
    isGoodsInit = true;
    /**
     * 商品列表dataTable
     * */
    goodsList = $('#goodsList').DataTable({
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
            {"data": "status"}
        ]
    });
}


$('#searchForm')[0].reset();
$('#SearchBut').click(function () {
    tableModal.draw();
});

//摇一摇配置查询
var tableModal = $('#rockDetailTable').DataTable({
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
                var shakeType = "";
                if (row.isShakePoint == 1) {
                    shakeType = shakeType + "积分,"
                }
                if (row.isShakeHb == 1) {
                    shakeType = shakeType + "红包,"
                }
                if (row.isShakeGift == 1) {
                    shakeType = shakeType + "礼物,"
                }

                return shakeType.substring(0, shakeType.length - 1);
            },
            "targets": 0
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
            "targets": 2
        },

        //{
        //    "render": function (data, type, row) {
        //        return '<div style="padding:10px;" name="' + row.sellerId + '" class="barCode" id="' + row.rockId + '"></div>';
        //    },
        //    "targets": 3
        //},
        {
            "render": function (data, type, row) {
                if (data == null) {
                    return '';
                } else {
                    return getLocalTime(data);
                }
            },
            "targets": 3
        }, {
            "render": function (data, type, row) {
                return '<label><a href="javascript:showDetail(' + row.id + ');">查看</a>|<a href="javascript:edit(' + row.id + ');">修改</a>|<a href="#" onclick="del(' + row.id + ')">删除</a>|<a href="javascript:showRockObtainDetail(' + row.rockId + ')">领取明细</a> </label>';
            },
            "targets": 4
        }
    ],
    "sort": false,
    //"fnDrawCallback": function (data) {
    //    //$.each($('.barCode'), function () {
    //    //    var idName = $(this).attr("id");
    //    //    var sellerId = $(this).attr("name");
    //    //    $("#" + idName + "").qrcode({
    //    //        render: "table", //table方式
    //    //        width: 150, //宽度
    //    //        height: 150, //高度
    //    //        text: baseUrl + "mobile/doShake?sellerId=" + sellerId + "&rockId=" + idName //任意内容
    //    //    });
    //    //});
    //},
    "columns": [
        {"data": "type"},
        {"data": "rockTitle"},
        {"data": "status"},
        {"data": "gmtCreated"},
        {"data": null}
    ]
});

//查看
function view(id) {

    $.post(baseUrl + "rock/viewDetail?id=" + id, function (data) {

        if (data != null) {

            $("#rockConfigForm input[name='id']").val(data.rockConfigVO.id);
            $("#rockConfigForm input[name='rockTitle']").val(data.rockConfigVO.rockTitle);
            $("#rockConfigForm input[name='wxNumber']").val(data.rockConfigVO.wxNumber);
            $("#rockConfigForm input[name='isVerify']").val(data.rockConfigVO.isVerify);

            $("#rockConfigForm input[name='randomNum']").val(data.rockConfigVO.randomNum);
            $("#rockConfigForm input[name='getNum']").val(data.rockConfigVO.getNum);
            $("#rockConfigForm input[name='rockNum']").val(data.rockConfigVO.rockNum);
            $("#rockConfigForm input[name='type']").val(data.rockConfigVO.type);
            $("#rockConfigForm input[name='startDate']").val(data.rockConfigVO.startDate);
            $("#rockConfigForm input[name='endDate']").val(data.rockConfigVO.endDate);
            $("#rockConfigForm input[name='pointIntervalMin']").val(data.rockConfigVO.pointIntervalMin);
            $("#rockConfigForm input[name='pointIntervalMax']").val(data.rockConfigVO.pointIntervalMax);

            $("#rockConfigForm input[name='getPointNum']").val(data.rockConfigVO.getPointNum);
            //$("#rockConfigForm input[name='isGetPointShare']").val(data.rockConfigVO.isGetPointShare);
            $("#rockConfigForm input[name='hbPoolId']").val(data.rockConfigVO.hbPoolId);

            $("#rockConfigForm input[name='hbPoolName']").val(data.rockConfigVO.hbPoolName);

            $("#rockConfigForm input[name='getHbNum']").val(data.rockConfigVO.getHbNum);
            $("#rockConfigForm input[name='isGetHbShare']").val(data.rockConfigVO.isGetHbShare);


            $("#rockConfigForm input[name='getGiftNum']").val(data.rockConfigVO.getGiftNum);

            if (data.rockConfigVO.isShakePoint == 1) {


                $("#rockConfigForm input[name='isShakePoint']").prop("checked", "chekced");
            }

            if (data.rockConfigVO.isShakeGift == 1) {
                $("#rockConfigForm input[name='isShakeGift']").prop("checked", "chekced");
            }

            if (data.rockConfigVO.isShakeHb == 1) {

                $("#rockConfigForm input[name='isShakeHb']").prop("checked", "chekced");
            }

            var giftRobj = $("#rockConfigForm input[name='isGetGiftShare']");

            for (i = 0; i < giftRobj.length; i++) {

                if (giftRobj[i].value == data.rockConfigVO.isGetGiftShare) {

                    giftRobj[i].checked = true;
                    break;
                }
            }

            var startConfigRobj = $("#rockConfigForm input[name='startConfig']");

            for (i = 0; i < startConfigRobj.length; i++) {

                if (startConfigRobj[i].value == data.rockConfigVO.startConfig) {

                    startConfigRobj[i].checked = true;
                    break;
                }
            }

            var pointRobj = $("#rockConfigForm input[name='isGetPointShare']");

            for (i = 0; i < pointRobj.length; i++) {

                if (pointRobj[i].value == data.rockConfigVO.isGetPointShare) {

                    pointRobj[i].checked = true;
                    break;
                }
            }

            var hbRobj = $("#rockConfigForm input[name='isGetHbShare']");

            for (i = 0; i < hbRobj.length; i++) {

                if (hbRobj[i].value == data.rockConfigVO.isGetHbShare) {
                    hbRobj[i].checked = true;
                    break;
                }
            }

            var goodsId = data.rockConfigVO.goodsId;
            var goodsName = data.rockConfigVO.goodsName;

            var goodsIdArray = new Array();
            var goodsNameArray = new Array();
            goodsIdArray = goodsId.split("&");
            goodsNameArray = goodsName.split("&");

            $("#goodsGroup").find("*").remove();

            if (goodsIdArray.length > 1) {

                for (var i = 0; i < goodsIdArray.length - 1; i++) {


                    var index = i + 1;

                    //if (i > 0) {
                    $("#goodsGroup").append('<div class="form-group"><label class="col-sm-4 control-label no-padding-right">选择积分商城的商品：</label><input hidden="hidden" class="goodsNumIndex" name="goodsId_' + index + '"/><div class="col-sm-6" style="padding-left: 25px;"><input type="text" readonly="readonly" name="goodsName_' + index + '" class="col-xs-2 col-sm-8"/><div class="col-sm-2" style="padding-left: 25px;"><span id="goods"></span><input width="200px" type="button" onclick="selPointGoods(' + index + ')" value="选择" name="select"/></div></div></div>');
                    //}

                    $("#rockConfigForm input[name='goodsId_" + index + "']").val(goodsIdArray[i]);
                    $("#rockConfigForm input[name='goodsName_" + index + "']").val(goodsNameArray[i]);
                }
            } else {

                $("#goodsGroup").append('<div class="form-group"><label class="col-sm-4 control-label no-padding-right">选择积分商城的商品：</label><input hidden="hidden" class="goodsNumIndex" name="goodsId_1"/><div class="col-sm-6" style="padding-left: 25px;"><input type="text" readonly="readonly" name="goodsName_1" class="col-xs-2 col-sm-8"/><div class="col-sm-2" style="padding-left: 25px;"><span id="goods"></span><input class="goodsSel" width="200px" type="button" onclick="selPointGoods(1)" value="选择" disabled="disabled" name="select"/></div></div></div>');
            }

            isShakeGift();
            isShakePoint();
            isShakeHb();

        }
    });

    $('#editDiv').hide();
    $("#editModal").modal("show");
}

var goodsCount = 1;
function addGoodsCofig() {

    if (goodsCount >= 5) {
        alert("商品最大上限为5条。")
        return;
    }

    ++goodsCount;
    //$("#mvGruop").append('<p>123</p>')
    $("#goodsGroup").append('<div class="form-group"><label class="col-sm-4 control-label no-padding-right">选择积分商城的商品：</label><input hidden="hidden" class="goodsNumIndex" name="goodsId_' + goodsCount + '"/><div class="col-sm-6" style="padding-left: 25px;"><input type="text" readonly="readonly" name="goodsName_' + goodsCount + '" class="col-xs-2 col-sm-8"/><div class="col-sm-2" style="padding-left: 25px;"><span id="goods"></span><input width="200px" type="button" onclick="selPointGoods(' + goodsCount + ')" value="选择" name="select"/></div></div></div>');
    //$("#mvGruop").append('<div class="integralSignIn col-xs-16 col-sm-10" id="input_group_'+signCount+'" style="margin-top: 10px"><div class="input-group" style="margin-left: 200px;"><span class="ml20" style="margin-left: 15px">每连续签到</span><input  type="text" id="signInNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px;"/>天<span class="ml20" style="margin-left: 15px;">送积分</span><input  type="text" id="integralNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px"/>个<span class="ml20" style="margin-left: 15px;">领取限制</span><input id="getConfig_'+signCount+'" type="radio" class="ace" value="1" checked="checked"/><span class="lbl" style="margin-left: 15px;">每人仅限领取一次</span></div></div>');

}

//编辑
function edit(id) {

    $("#rockGroup").show();

    //$("#goodsGroup").remove();

    $(".form-horizontal").find("*").each(function () {
        $(this).attr("disabled", false);
    });

    $("#isShowView").val("0");

    view(id);

    $("#rockConfigForm input[name='rockName']").attr("disabled", "disabled");

    $("#rockConfigForm input[name='hbPoolName']").attr("readOnly", "readOnly");

    $("#rockConfigForm input[name='getHbNum']").attr("readOnly", "readOnly");

    $("#rockConfigForm input[name='getGiftNum']").attr("readOnly", "readOnly");

    $("#next").show();
    $("#back").hide();
    $("#rockDetail").hide();
    $("#show").hide();
    $("#save").hide();

    $('#editDiv').show();
}

function showDetail(id) {


    $("#rockGroup").show();

    view(id);

    $("#next").show();
    $("#back").hide();
    $("#rockDetail").hide();
    $("#show").hide();
    $("#save").hide();


    $("#isShowView").val("1");


    $("#rockConfigForm").find("*").each(function () {
        $(this).attr("disabled", "disabled");
    });


}


function del(id) {


    if (confirm("确认删除吗")) {


        $.ajax({
            type: "post", // 请求方式
            url: baseUrl + "/rock/delete", //url地址
            data: {ids: id}, //数据
            dataType: "json",
            success: function (response, ifo) {
                alert("删除成功");
                $('#rockDetailTable').DataTable().draw();
            }, error: function () {
                alert("error");
            }
        })
    }

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


//查询
var receiveDetailModal;
var isInit = true;
function doTable() {
    isInit = true;
    receiveDetailModal = $('#receiveDetailTable').DataTable({
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
            "url": baseUrl + "rock/rockQueryDetail",
            "data": function (d) {
                var rockId = $("#rockObtainRockId").val();
                d.rockId = rockId;


            }
        },
        "columnDefs": [{
            "render": function (data, type, row) {

                if (data == "received") {
                    return "已领取";
                } else {
                    return "未领取";
                }
            },
            "targets": 3
        }, {
            "render": function (data, type, row) {

                if (row.userPortraitId == null) {
                    return "无";
                } else {
                    return "有";
                }
            },
            "targets": 5
        }, {
            "render": function (data, type, row) {
                if (data == null) {
                    return "无";
                } else {
                    return getLocalTime(data);
                }
            },
            "targets": 6
        }, {
            "render": function (data, type, row) {

                if (data == null) {
                    return "";
                } else {
                    return '<label><a href="javascript:void(0);" onclick="goPortriat(' + row.userId + ')">查看</a></label>';
                }
            },
            "targets": 7
        }
        ],
        "sort": false,
        "columns": [
            {"data": "wxNickName"},
            {"data": "rockTitle"},
            {"data": "rockResult"},
            {"data": "shakeStatus"},
            {"data": "mobile"},
            {"data": "userPortraitId"},
            {"data": "obtainDate"},
            {"data": null}
        ]
    });
}

//转到用户画像页面
function goPortriat(val) {
    $.ajax({
        type: "post",
        url: baseUrl + "knowCustomer/withPortrait",
        data: {userId: val},
        dataType: "json",
        success: function (data) {
            if (data.count == 1) {
                $('#userportraitModal iframe').attr('src', baseUrl + 'knowCustomer/userPortrait?userId=' + val);
                $('#userportraitModal').modal('show');
            } else {
                alert("该用户画像不存在");
                return false;
            }
        }
    });
}


function showRockObtainDetail(i) {

    $("#rockObtainRockId").val(i);

    if (isInit) {

        doTable();
        isInit = false;
    } else {
        receiveDetailModal.draw();
    }

    $("#receiveDetailModal").modal('show');

    return false; //阻止表单默认提交
}