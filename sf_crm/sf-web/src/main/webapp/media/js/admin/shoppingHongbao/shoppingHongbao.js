/**
 * 价格, 保留2位小数
 * */
//var REG_PRICE = /^(\d*.\d{1,2}|\d+)$/;
var REG_PRICE = /^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;
/**
 * 库存数量 正整数
 * */
var REG_QUANTITY = /^([1-9]\d*)$/;
/**
 * 积分数量, 0 或者正整数
 * */
var REG_POINT = /^([1-9]\d*|[0]{1,1})$/;

/**
 * 验证价格
 * @param objId 当前input元素的Id
 * @param showId 显示提示信息的html元素id
 * */
function checkPriceById(objId,showId){
    var price = document.getElementById(objId).value;
    var show = null;
    if(!isNullOrEmpty(showId)){
        show = document.getElementById(showId);
    }
    if(price.match(REG_PRICE)){
        if(!isNullOrEmpty(show)) {
            show.innerHTML = '';
        }
    }else{
        if(!isNullOrEmpty(show)) {
            show.innerHTML = '请输入价格,最多保留两位小数';
        }
        return false;
    }
    return true;
}

/**
 * 选择红包池
 */
function selectHBPool() {
    //弹出悬浮层，展现红包池列表
    var poolId = $('#hbPoolId').val();
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

            }
        },
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    if(poolId == data){
                        return '<td class="center"><label><input name="cbox" type="radio" class="ace" value="'+data+'" checked/><span class="lbl"></span></label></td>';
                    }
                    return '<td class="center"><label><input name="cbox" type="radio" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                },
                "targets": 0
            }, {
                "render": function (data, type, row) {
                    if(data==null){
                        return  '';
                    }else
                        return new Date(data).format('yyyy-MM-dd hh:mm:ss');
                },
                "targets":2
            },{
                "render": function (data, type, row) {
                    if(data==null){
                        return  '';
                    }else
                        return new Date(data).format('yyyy-MM-dd hh:mm:ss');
                },
                "targets":3
            },{
                "render": function (data, type, row) {
                    if(data==null){
                        return  '';
                    }else
                        return new Date(data).format('yyyy-MM-dd hh:mm:ss');
                },
                "targets":4
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
                "targets":5
            },{
                "render": function (data, type, row) {
                    return (row.number-row.numberObtain);
                },
                "targets":8
            },{
                "render" : function(data, type, row) {
                    return (data/100);
                },
                "targets":9
            }

        ],
        "sort":false,
        "columns": [
            {"data": "poolId"},
            {"data": "name"},
            {"data": "startDate"},
            {"data": "endDate"},
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

    $("input[name='cbox']").each(function(){
        if($(this).prop('checked')) {
            var poolId = $(this).val();
            var startDate = $(this).parent().parent().siblings().eq(1).html();
            var endDate = $(this).parent().parent().siblings().eq(2).html();
            var validAmount = $(this).parent().parent().siblings().eq(7).html();
            var totalMoney = $(this).parent().parent().siblings().eq(8).html();
            $('#goodsQuantity').val(validAmount);
            $('#hbcashAmount').val(totalMoney);
            $('#beginDate').val(startDate);
            $('#endDate').val(endDate);
            $('#hbPoolId').val(poolId);
        }
    })
})

/**
 *    创建或者编辑红包活动
 *    @param type 0-create, 1-update
 * */
function submitForm(id,type){
    var imgId = [];

    //活动名称
    var activityName = $('#activityName').val();
    if(isNullOrEmpty(activityName)){
        $('#activity_name_err_msg').html('活动名称不能为空');
        return;
    }
    //商品名
    var goodsName = $('#goodsName').val();
    if(isNullOrEmpty(goodsName)){
        $('#goods_name_err_msg').html('商品名称不能为空');
        return ;
    }
    //商品链接
    var goodsLink = $('#goodsLink').val();
    if(isNullOrEmpty(goodsLink)){
        $('#goods_link_err_msg').html('商品链接不能为空');
        return ;
    }
    //商品店铺价格
    if(!checkPriceById('goodsPrice','price_err_msg')){
        return;
    }
    var goodsPrice = $('#goodsPrice').val();

    //商品来源
    var goodsSource = $('input[name="goodsSource"]:checked').val();

    //店铺名称
    var shopName = $('#shopName').val();
    if(isNullOrEmpty(shopName)){
        $('#shop_name_err_msg').html('店铺名称不能为空');
        return ;
    }

    //限制商品数量
    var goodsQuantity = $('#goodsQuantity').val();

    //红包总金额
    var hbcashAmount = $('#hbcashAmount').val();

    //使用范围
    var applyRange = $('input[name="applyRange"]:checked').val();

    //红包释放时间
    var releaseTime = $('input[name="releaseTime"]:checked').val();

    //选择红包池
    var hbPoolId = $('#hbPoolId').val();
    if(isNullOrEmpty(hbPoolId)){
        $('#poolid_err_msg').html('请选择红包池');
        return ;
    }

    //活动开始时间
    var beginDate = $('#beginDate').val();

    //活动结束时间
    var endDate = $('#endDate').val();

    //活动说明
    var activityDesc = editor.getContent();
    //图片
    var fileNames = '';
    $.each($('input[type="file"]'), function(index,obj){
        var fn = $('input[type="file"]').eq(index).attr("name");
        fileNames += fn;
        if(index < $('input[type="file"]').length -1){
            fileNames += '|';
        }
        imgId.push($('input[type="file"]').eq(index).attr("id"));
    });

    //编辑情况下:
    var activityId = $('#activityId').val();
    var activityGoodsId = $('#activityGoodsId').val();

    var token = $('#token').val();
    var data = {"activityId":activityId,"activityGoodsId":activityGoodsId,"activityName":activityName,"goodsName":goodsName,"goodsLink":goodsLink,"goodsPrice":goodsPrice,"goodsSource":goodsSource,"shopName":shopName, "hbPoolId":hbPoolId,"goodsQuantity":goodsQuantity, "hbcashAmount":hbcashAmount,"applyRange":applyRange,"releaseTime":releaseTime,"beginDate":beginDate,"endDate":endDate,"activityDesc":escape(activityDesc),"fileNames":fileNames};
    var  postData = JSON.stringify(data).replace(/\"/g,"'");
    $.ajaxFileUpload({
        url : baseUrl + 'shophb/addOrUpdateAct?token=' + token,
        secureuri:false,
        fileElementId: imgId,  //这里不在是以前的id了，要写成数组的形式哦！
        dataType: 'json',
        data: {goodsData:postData},
        success: function(reponseData){
            if(reponseData.errorCode == 0){
                alert(reponseData.errorMessage);
                if(type == 0){
                    freshUrl(baseUrl + "shophb/shophbAct");
                }else if(type == 1){
                    freshUrl(baseUrl + "shophb/shophbActList");
                }
            }else{
                alert(reponseData.errorMessage);
            }
        },
        error: function(reponseData){
            alert("保存失败!");
        }
    });
}

/**
 *  预览商品
 * */
function preView(){
    var link = $('#goodsLink').val();
    if(isNullOrEmpty(link)){
        alert('请输入商品链接');
        return;
    }
//    location.href = link;
    window.open(link);          //在新窗口打开
}


