//定义根目录
var baseUrl = getRootPath();
//获取请求根目录
function getRootPath()
{
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
}

//获取时间函数
function getLocalTime(nS) {
    return new Date(parseInt(nS)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
}

//判断时间是否为空参数
function isNullOrEmpty(strVal) {
    return strVal == '' || strVal == null || strVal == undefined || strVal == "undefined"
}

//积分排行
function pointRank(sellerId, userId){
    $.ajax({
        type : "POST",
        url : baseUrl + 'mobile/mall/pr/ajax/list?t='+ new Date().getTime(),
        data: {'sellerId':sellerId,'userId':userId},
        dataType : "json",
        success : function(d){
            if(d.errorCode == 0){
                var html = '';
                    html += '<div class="wap rank-page" style="background: #F7F7F7;margin-top: -11px">';
                    html += '<ul class="user-list" style="background:#F7F7F7;">';
                    var obj = d.myRank;
                    if(!isNullOrEmpty(obj)){
                        var wximgurl = obj.wxImgUrl;
                        var username = obj.name;
                        var wxNickName = obj.wxNickName;
                        var payPointTotal = obj.pointExchangeTotal;
                        var zanNum = obj.zanTotal;
                        var beUserId = obj.userId;    //被点赞人userId
                        var rank = obj.rank;
                        var maxExchangePoint = d.maxExchangePoint;
                        var percent = 0;
                        if(maxExchangePoint != 0){
                            percent = payPointTotal * 100 / maxExchangePoint;
                        }
                          html += '<li style="background-color: #FFCB31;"  >';
                          html += '<span class="rank-num" >' + rank + '</span>';
                          html += '<a href="javascript:;" style="color:black" class="zan-btn active" data-buid="' + beUserId + '">' + zanNum + '</a>';
                          if(!isNullOrEmpty(wximgurl)){
                              html += '<span class="user-photo"><img src="'+ wximgurl + '" style="border-radius: 50%; width: 50px; height: 50px"/></span>';
                          }else{
                              html += '<span class="user-photo"><img src="' + baseUrl + 'media/images/photo.jpg"></span>';
                          }
                          html += '<div class="progress-text"><span class="sr-only" style="color:black">' + wxNickName + '</span><span class="num" style="color:black">累计:' + payPointTotal + '积分</span></div>';
                          html += '<div class="progress"><div class="progress-bar" style="width:' + percent + '%;"></div></div>';
                          html += '</li>';
                    }
                $.each(d.allRank, function(index, obj){
                    var wximgurl = obj.wxImgUrl;
                    var username = obj.name;
                    var wxNickName = obj.wxNickName;
                    var payPointTotal = obj.pointExchangeTotal;
                    var zanNum = obj.zanTotal;
                    var beUserId = obj.userId;    //被点赞人userId
                    var rank = obj.rank;
                    var maxExchangePoint = d.maxExchangePoint;
                    var percent = 0;
                    if(maxExchangePoint != 0){
                        percent = payPointTotal * 100 / maxExchangePoint;
                    }
                    html += '<li>';
                    html += '<span class="rank-num" >' + rank + '</span>';
                    html += '<a href="javascript:;" class="zan-btn" data-buid="' + beUserId + '">' + zanNum + '</a>';
                    if(!isNullOrEmpty(wximgurl)){
                        html += '<span class="user-photo"><img src="'+ wximgurl + '" style="border-radius: 50%; width: 50px; height: 50px"/></span>';
                    }else{
                        html += '<span class="user-photo"><img src="' + baseUrl + 'media/images/photo.jpg"></span>';
                    }
                    if(isNullOrEmpty(wxNickName)){
                        wxNickName = '';
                    }
                    html += '<div class="progress-text"><span class="sr-only">' + wxNickName + '</span><span class="num">累计:' + payPointTotal + '积分</span></div>';
                    html += '<div class="progress"><div class="progress-bar" style="width:' + percent + '%;"></div></div>';
                    html += '</li>';
//                    html += '<div class="itemLi">';
//                    html += '<img style="border-radius: 50%" src="' + wximgurl + '">';
//                    html += '<div class="info"><div class="name">' + wxNickName + '</div>累计兑换:' + payPointTotal + '积分</div>';
//                    html += '<div class="pull-right"><br><span class="u-fontAtv"><a href="javascript:void(0)" onclick="dz('+ beUserId + ',' + userId + ',' + zanNum + ',this)">' + zanNum + '赞</a></span></div>';
//                    html += '</div>';
                })

                html += '</ul></div>';

                $('#my_point_content').html(html);

                Zepto(function($){
                    $('.zan-btn').bind('click', function(event) {
                        var target = $(this);
                        var buid = target.data('buid');
                        if(buid == '$!userId'){
                            alert('不能对自己点赞');
                            return ;
                        }
                        if(!target.hasClass('active')){
//                            var buid = target.data('buid');
                            $.post(baseUrl + 'mobile/dianzan',{sellerId:sellerId,buid :buid,uid:userId,interactionEntry:'point_exchange_rank'} , function(data) {
                                if(data.errorCode == 0){
                                    target.text(parseInt(target.text())+1);
                                    target.addClass('active')
                                    var countNode = target.siblings('.progress-text').find('.num');
                                }else{
                                    alert(data.errorMessage);
                                }
                            },'json');
                        }
                    });
                })

            }else{
                alert(d.errorMessage);
            }
        }
    });
}

//兑换明细
function pointExchangeDetail(sellerId, userId){
    $.ajax({
        type : "POST",
        url : baseUrl + '/mobile/mall/pr/ajax/point/exchange?t='+ new Date().getTime(),
        data: {'sellerId':sellerId,'userId':userId},
        dataType : "json",
        success : function(d){
            if(d.errorCode == 0){
                var html = '';
                $.each(d.data, function(index, obj){

                    //商品或者红包的名字
                    var exchangeName = obj.title;
                    //消耗积分
                    var payPoint = obj.point;
                    //状态
                    var sta = obj.status;
                    //兑换类型
                    var exchangeType = obj.exchangeMethod;
                    //
                    var imgUrls = obj.imgsUrl;
                    //商品或者红包图片
                    var imgUrl = '';
                    if(exchangeType == 'hongbao'){
                        imgUrl = baseUrl + 'media/mobile/assets/images/public/hb-pic.jpg';
                    }else if(exchangeType == 'goods'){
                        if(!isNullOrEmpty(imgUrls)){
                            imgUrl = baseUrl + imgUrls;
                        }
                    }
                    var staContext = '';
                    if(sta == 'success'){
                        staContext = '成功';
                    }else if(sta == 'fail'){
                        staContext = '失败';
                    }else if(sta == 'expire'){
                        staContext = '已过期';
                    }else if(sta == 'over'){
                        staContext = '已兑换完';
                    }else if(sta == 'wait_exchange'){
//                        staContext = '<a href="' + baseUrl + 'mobile/hongbao/receive?hbPoolId='+ obj.poolId + '&userId=' + obj.userId + '&sellerId=' + obj.sellerId + '&businessType=point_exchange' + '&ruleType=HB_POOL' + '&amount=' + obj.hbMoney + '">待兑换</a>';
//                        staContext = '<a href="' + baseUrl + 'mobile/hongbao/dismantle?hbObtainId='+ obj.hongbaoObtainId + '&userId=' + obj.userId + '&sellerId=' + obj.sellerId + '&businessType=point_exchange' + '">待兑换</a>';
                        staContext = '<a href="' + baseUrl + 'mobile/hongbao/receiveOrUserBound?hbPoolId='+ obj.poolId + '&userId=' + obj.userId + '&sellerId=' + obj.sellerId + '&businessType=point_exchange&actionValue='+obj.point +'&hbObtainId='+ obj.hongbaoObtainId +'" style="color:#FF7E01">待兑换</a>';
                    }

                    html += '<div class="itemLi">';
                    html += '<img src="' + imgUrl + '">';
                    html += '<div class="info"><div class="name">' + exchangeName + '</div>消耗积分:' + payPoint + '</div>';
                    html += '<div class="pull-right">' + staContext + '</div>';
                    html += '</div>';
                })
                $('#my_point_content').html(html);
            }else{ alert(d.errorMessage);
            }
        }
    });
}

//积分获取明细
function pointObtainDetail(sellerId, userId){
    $.ajax({
        type : "POST",
        url : baseUrl + 'mobile/mall/pr/ajax/point/obtain?t='+ new Date().getTime(),
        data: {'sellerId':sellerId,'userId':userId},
        dataType : "json",
        success : function(d){
            if(d.errorCode == 0){
                var html = '';
                $.each(d.data, function(index, obj){

                    var obtainTime = obj.obtainDate;
                    var amount = obj.amount;
                    var type = obj.obtainMethod;
                    var sta = obj.status;

                    var obType = '';
                    if('sign_in' == type){
                        obType = '签到';
                    }else if('give' == type){
                        obType = '赠送';
                    }else if('share' == type){
                        obType = '分享';
                    }else if('shake' == type){
                        obType = '摇一摇';
                    }else if('birthday' == type){
                        obType = '生日';
                    }else if('subscribe' == type){
                        obType = '关注';
                    }else if('shopping' == type){
                        obType = '购物';
                    }

                    var staStr = '';
                    if('y' == sta){
                        staStr = '成功';
                    }else if('n' == sta){
                        staStr = '失败';
                    }
                    html += '<div class="itemLi">';
                    html += '' + obtainTime + '';
//                    html += '<div class="info" style="margin:0"><div class="name">' + obType + '</div>获取积分:' + amount + '积分</div>';
                    html += '<div class="info" style="margin:0"><div class="name">' + obType + '&nbsp;&nbsp;&nbsp;获取积分:' + amount + '积分</div></div>';
                    html += '<div class="pull-right">' + staStr + '</div>';
                    html += '</div>';
                })
                $('#my_point_content').html(html);
            }else{
                alert(d.errorMessage);
            }
        }
    });
}

//属性Map, key为属性名, value为属性值, 数组
var propMap = {};
//sku Map, key为skuId, value为数组, 0位置是sku的属性值,多个属性值之间用 _ 连接, 1号位置放库存量, 2号位置放价格
var skuMap = {};
//最终选择的skuId
var skuId = '';
//第一个属性可用属性值集合
var one_prop_value = [];
//第二个属性可用属性集合
var two_prop_value = [];
//第三个属性可用属性集合, 最多支持三个属性
var three_prop_value = [];
//商品总库存量
var goodsStockTotal = 0;
//选中的某SKU的库存量
var skuStockTotal = 0;
function createGoodsSkuInfo(sellerId, goodsId, giftSource){
    $.ajax({
        type : "POST",
        url : baseUrl + 'mobile/mall/sku/detail?t='+ new Date().getTime(),
        data: {'sellerId':sellerId,'gid':goodsId},
        dataType : "json",
        success : function(d){
            if(d.errorCode == 0){
                propMap = d.skuPropData;
                goodsStockTotal = d.mallGoods.quantity;
//                console.dir(propMap);
                $.each(d.skuData, function(index, sku){
                    var parr = [];
                    var oneContext = '';
                    var propNameValue = sku.propsName;
                    //去掉结尾的 ;
                    var index = propNameValue.lastIndexOf(';');
                    if (index == propNameValue.length-1) {
                        propNameValue = propNameValue.substring(0, propNameValue.length-1);
                    }

//                    console.dir(propNameValue);
                    $.each(propNameValue.split(';'), function(num,pvn){
                        var pv = pvn.split(":");
                        oneContext += pv[3];
                        if(num < propNameValue.split(';').length - 1){
                            oneContext += '_';
                        }
                    });
                    parr[0] = oneContext;
                    parr[1] = sku.quantity;
                    parr[2] = sku.price;
                    skuMap[sku.skuId] = parr;
                });
                console.dir(skuMap);
//                console.dir(Object.keys(propMap).length);
                var html = ''
                var pNum = Object.keys(propMap).length;
                if(pNum > 0){     //有SKU
                    html += '<div class="form-grounp title">';
                    html += '<div class="label-info">商品参数</div>';
                    html += '</div>';
                    var i = 1;
                    $.each(propMap, function(key, values){
                        if(i == 1){
                            one_prop_value = values;
                        }else if(i == 2){
                            two_prop_value = values;
                        }else if(i == 3){
                            three_prop_value = values;
                        }
                        html += '<div class="form-grounp">';
                        html += '<label class="label">' + key + '</label>';
                        html += '<div class="label-info">';
                        html += '<ul id="p_' + i + '">';
//                        html += '<ul>';
                        i++;
//                        console.dir(propMap[key]);
                        $.each(values, function(num, value){
//                            html += '<li><a href="javascript:">' + value + '</a></li>';
                            html += '<li><input type="button" value="' + value + '"/></li>';
                        });
                        html += '</ul></div></div>';
                    });

                    html += '<div class="form-grounp noBorder">';
                    html += '<label class="label mg-top5">数量</label>';
                    html += '<div class="label-info">';
                    if(isNullOrEmpty(giftSource)){
                        html += '<div class="num-plug" style="float: left">';
                        html += '<a href="javascript:" class="del">－</a>';
                        html += '<input type="text" class="inputtext" value="1" id="buy_amount">';
                        html += '<a href="javascript:" class="add">＋</a>';
                        html += '</div>';
                    }else{
                        html += '<div class="num-plug" style="float: left; width: 30px">';
                        html += '<input type="text" class="inputtext" value="1" id="buy_amount" readonly>';
                        html += '</div>';
                    }
                    html += '<div style="float: left; margin: 12px 0 0 5px; font-size: 12px; color: #ff6701">';
                    html += '库存:<span id="sku_amount">' + goodsStockTotal + '</span>';
                    html += '</div>';
                    html += '</div></div>';
                }else{                                                      //无SKU
                    html += '<div class="form-grounp title">';
                    html += '<div class="label-info">商品参数</div>';
                    html += '</div>';
                    html += '<div class="form-grounp noBorder">';
                    html += '<label class="label mg-top5">数量</label>';
                    html += '<div class="label-info">';
                    if(isNullOrEmpty(giftSource)){
                        html += '<div class="num-plug" style="float: left;">';
                        html += '<a href="javascript:" class="del">－</a>';
                        html += '<input type="text" class="inputtext" value="1" id="buy_amount">';
                        html += '<a href="javascript:" class="add">＋</a>';
                        html += '</div>';
                    }else{
                        html += '<div class="num-plug" style="float: left;width:30px">';
                        html += '<input type="text" class="inputtext" value="1" id="buy_amount" readonly>';
                        html += '</div>';
                    }
                    html += '<div style="float: left; margin: 12px 0 0 5px; font-size: 12px; color: #ff6701">';
                    html += '库存:<span id="sku_amount">' + goodsStockTotal + '</span>';
                    html += '</div>';
                    html += '</div></div>';
                }
                $('#goodsSpec').html(html);
                $('.form-grounp .label-info ul li input').click(function(){
                    var classValue = $(this).parent().prop('class');
                    if(classValue == 'checked'){
                        $(this).parent().removeClass('checked');
                    }else {
                        $(this).parent().parent().find('.checked').removeClass('checked');
                        $(this).parent().addClass('checked');
                    }
                    var liid = $(this).parent().parent().prop('id');
                    var p_index = liid.split('_')[1];       //点击了第几个属性
                    var p_value = $(this).prop('value');   //选中的属性值
                    if(!isSeletedSku()){                    //没有匹配到Sku
                        skuId = '';
                        $("#sku_amount").html("" + goodsStockTotal);
                        skuStockTotal = 0;
                        handlerNoMarch(p_index,p_value);
                    }
                });
                //数量减法
                $('.noBorder .label-info .num-plug a.del').click(function(){
                    var num = $('.noBorder .label-info .num-plug input.inputtext').val();
                    if(num > 1){
                        $('.noBorder .label-info .num-plug input.inputtext').val(num-1);
                    }
                });
                //数量加法
                $('.noBorder .label-info .num-plug a.add').click(function(){
                    var num = $('.noBorder .label-info .num-plug input.inputtext').val();
                    if(skuStockTotal != 0){
                        if(num < skuStockTotal){
                            num = Number(num) + 1;
                            $('.noBorder .label-info .num-plug input.inputtext').val(num);
                        }
                    }else if(goodsStockTotal != 0){
                        if(num < goodsStockTotal){
                            num = Number(num) + 1;
                            $('.noBorder .label-info .num-plug input.inputtext').val(num);
                        }
                    }
                });
                //只有一个属性,并且属性值也只有一个的情况下默认选中
                if(pNum == 1 && Object.keys(skuMap).length == 1){
                    $('.form-grounp .label-info ul li input:first').parent().addClass('checked');
                    $.each(skuMap, function(key, value){
                        skuId = key;
                    });
                }
            }else{
                alert(d.errorMessage);
            }
        }
    });
}
/**
 * 查找选择的属性值组合, 多个值之间用 _ 连接
 * */
function findSelectedPropValue(){
    var value = '';
    var as = $('.form-grounp .label-info ul li[class="checked"] input');
//    console.dir(as);
    $.each(as, function (index, aobj) {
//        console.dir(aobj);
        value += aobj.value;
        if(index < as.length -1){
            value += '_';
        }
    });
    return value;
}

/**
 *  判断是否匹配到一个sku
 * */
function isSeletedSku(){
    //查找所有选中的 li 里面的 <a> 的值
    var seletedProps = findSelectedPropValue();
//    console.dir(seletedProps);
    var flag = false;
    $.each(skuMap, function(key, value){
        if(value[0] == seletedProps){            //已经确定了一个sku
            skuId = key;
//            console.dir(value[0]);
            skuStockTotal = value[1];
            $("#sku_amount").html("" + value[1]);
            $("#sku_price").html(Number(value[2]/100).toFixed(2));
            flag = true;
            return flag;                    //在 $.each 里面直接返回 true 有问题
        }else{
//            $("#sku_amount").html("无");
        }
    });
    return flag;
}

/**
 * 取属性个数, 目前最多支持三个属性
 * */
function getPropNum(){
    return Object.keys(propMap).length;
}

/**
 * 没匹配到的处理
 * 目标: 把与当前选定属性值匹配的其它属性值可用, 不匹配的变成不可用.
 *       1. 首先找出与当前选定属性值匹配的属性, 比如总共三个属性, 选定了第二个属性的一个属性值, 这时候要把与之相匹配的第一个与第三个属性的属性值找出来.
 *       2. 如果有的话, 这时候还要保留选定好的第一个或者第三个的属性值, 因为已经选定好的属性还要保留选定的状态.
 *       3. 分别遍历各个属性的属性值, 每个属性值作相对应的处理.
 *
 * @param index 选的第几个属性
 * @param value 选的属性值
 * */
function handlerNoMarch(index, value){
//    console.dir(index + " : " + value);
    var selectedProp = findSelectedPropValue();
    if(isNullOrEmpty(selectedProp)){            //没有选中任何属性值, 还原到最开始状态
        toOriginal();
        return ;
    }
    var match_one_p = [];           //与某个属性值匹配的第一个属性的属性值集合
    var match_two_p = [];           //
    var match_three_p = [];         //与某个属性匹配的第三个属性的属性值集合
    var one_prop_select = '';       //第一个属性选择值
    var two_prop_select = '';       //第二个属性选择值
    var three_prop_select = '';     //第三个属性选择值
    var selectedProps = selectedProp.split('_');
    for(var j=0;j<selectedProps.length;j++){
        var temp = selectedProps[j];
//        console.dir(temp);
//        console.dir(one_prop_value);
//        console.dir(two_prop_value);
//        console.dir(three_prop_value);
        if(one_prop_value.join(',').indexOf(temp) >= 0){
            one_prop_select = temp;
        }else if(two_prop_value.join(',').indexOf(temp) >= 0){
            two_prop_select = temp;
        }else if(three_prop_value.join(',').indexOf(temp) >= 0){
            three_prop_select = temp;
        }
    }
    var z = 1;
    $.each(skuMap, function(key, pvalue){
        var propValua = pvalue[0];
        var arr = propValua.split('_');
//        console.dir(index + ':'+ value + ':' +z + ":" + arr[0] + ":" + arr[index-1]);
        if(!isNullOrEmpty(arr[0]) && arr[index-1] == value){
            match_one_p.push(arr[0]);
        }
        if(!isNullOrEmpty(arr[1]) && arr[index-1] == value){
            match_two_p.push(arr[1]);
        }
        if(!isNullOrEmpty(arr[2]) && arr[index-1] == value){
            match_three_p.push(arr[2]);
        }
        z++;
    });
//    console.dir(one_prop_select);
//    console.dir(two_prop_select);
//    console.dir(three_prop_select);
//    console.dir(match_one_p.join(','));
//    console.dir(match_two_p.join(','));
//    console.dir(match_three_p.join(','));
    var pnum = Object.keys(propMap).length;
    for(var k=0; k<pnum; k++){
        if(k == index-1){
            continue;
        }
//        console.dir(k+1);
        if(k+1 == 1) {      //第一个属性的处理
//            console.dir($('#p_' + (k + 1) + ' li input'));
//                    console.dir(match_one_p.join(','));
            $.each($('#p_' + (k + 1) + ' li input'), function (y, obj) {
//                    console.dir(pvalue);
                var pvalue = obj.value;
                if(match_one_p.join(',').indexOf(pvalue) >= 0){    //说明要置为可选的状态
                    if(pvalue == one_prop_select) {
                        obj.parentNode.className = 'checked';
                    }
                    obj.className = '';
                    obj.disabled = false;
                }else{
                    obj.parentNode.className = '';
                    obj.className = 'invalid';
                    obj.disabled = true;
                }
//                console.dir(obj.parentNode.className);

            });
        }
        if(k+1 == 2) {
            $.each($('#p_' + (k + 1) + ' li input'), function (y, obj) {
                var pvalue = obj.value;
                if(match_two_p.join(',').indexOf(pvalue) >= 0){    //说明要置为可选的状态
                    if(pvalue == two_prop_select) {
                        obj.parentNode.className = 'checked';
                    }
                    obj.className = '';
                    obj.disabled = false;
                }else{
                    obj.parentNode.className = '';
                    obj.className = 'invalid';
                    obj.disabled = true;
                }
//                console.dir(obj.parentNode.className);
            });
        }
        if(k+1 == 3) {      //第三个属性的处理
            $.each($('#p_' + (k + 1) + ' li input'), function (y, obj) {
                var pvalue = obj.value;
                if(match_three_p.join(',').indexOf(pvalue) >= 0){    //说明要置为可选的状态
                    if(pvalue == three_prop_select) {
                        obj.parentNode.className = 'checked';
                    }
                    obj.className = '';
                    obj.disabled = false;
                }else{
                    obj.parentNode.className = '';
                    obj.className = 'invalid';
                    obj.disabled = true;
                }
            });
        }
    }
}

function toOriginal(){
    var pnum = Object.keys(propMap).length;
    for(var k=0; k<pnum; k++){
        $.each($('#p_' + (k + 1) + ' li input'), function (y, obj) {
            obj.parentNode.className = '';
            obj.className = '';
            obj.disabled = false;
        });
    }
}

/**
 * 确定兑换商品
 * */
function exchange(sellerId,userId,goodsId,obtainId,giftSource){
    if(Object.keys(propMap).length > 0 && isNullOrEmpty(skuId)){
        alert('请选择商品规格');
        return ;
    }
    var amount = $("#buy_amount").val();
    if(isNullOrEmpty(amount)){
        alert('请填写购买数量');
        return ;
    }
    var reg = new RegExp(/^[1-9][0-9]*$/);
    if(reg.test(amount)){
        amount = Number(amount);
        if(skuStockTotal != 0){
            if(amount > skuStockTotal){
                alert('购买数量大于库存数量, 请修改');
                return ;
            }
        }else if(goodsStockTotal != 0){
            if(amount > goodsStockTotal){
                alert('购买数量大于库存数量, 请修改');
                return ;
            }
        }
    }else{
        alert('请正确填写购买数量');
        return ;
    }
    window.location.href = baseUrl + '/mobile/mall/exchange?sellerId=' + sellerId + '&goodsId=' + goodsId + '&skuId=' + skuId + '&amount=' + amount + '&userId=' + userId + '&obtainId=' + obtainId + '&giftSource=' + giftSource;
}

/**
 * 兑换商品的下一步
 * */
function exchangeNext(sellerId,userId,goodsId,skuId,obtainId,giftSource,isVirval) {
    if('n' == isVirval) {
        var rid = $("#receiver_id").val();
        if (isNullOrEmpty(rid)) {
            alert("请选择收件人");
            return;
        }
    }else{
        rid = '';
    }

    var num = $('#buy_amount_hidden').val();
    if(num > stockTotal){
        alert("当前数量大于该商品库存数量");
        return;
    }
    var token = $('#token').val();
    console.dir(token);
    window.location.href = baseUrl + 'mobile/mall/exchangeNext?sellerId=' + sellerId + '&goodsId=' + goodsId + '&skuId=' + skuId + '&amount=' + num + '&userId=' + userId + '&receiverId=' + rid + '&obtainId=' + obtainId + '&giftSource=' + giftSource + '&token=' + token;
}

/**
 * 添加收件人信息
 * */
function addRece(sellerId, userId){
    var name = $('#myForm .form-grounp .label-info input[name="userName"]').val();
    var mobile = $('#myForm .form-grounp .label-info input[name="mobile"]').val();
    var province = $('#province').val();
    var city = $('#city').val();
    var district = $('#district').val();
    var road = $('#myForm .form-grounp .label-info input[name="road"]').val();
    var zip = $('#myForm .form-grounp .label-info input[name="zip"]').val();
//    console.dir(province + ":" + city + ":" + district);
    if(isNullOrEmpty(name)){
        alert('请填写收件人姓名');
        return ;
    }
    if(isNullOrEmpty(mobile)){
        alert('请填写收件人手机号')
        return false;
    }
    if(isNullOrEmpty(province)){
        alert('请填写收件人所在省份')
        return false;
    }
    if(isNullOrEmpty(city)){
        alert('请填写收件人所在市')
        return false;
    }
    if(isNullOrEmpty(district)){
        alert('请填写收件人所在区县')
        return false;
    }
    if(isNullOrEmpty(road)){
        alert('请填写收件人所在街道门牌信息')
        return false;
    }
        $.ajax({
        type : "POST",
        url : baseUrl + 'mobile/mall/addAddress?t='+ new Date().getTime(),
        data: {'sellerId':sellerId,'userId':userId,'name':name,'mobile':mobile,'province':province,'city':city,'district':district,'address':road,'zip':zip},
        dataType : "json",
        success : function(d){
            if(d.errorCode == 0){
                console.dir(d);
                //更改收件人信息
                $('#receiver_info').show();
                $('#name').html(name);
                $('#phone').html(mobile);
                $('#address').html(province + city + district + road);
                $('#receiver_id').val(d.data)
                //添加更新收件人列表

//                var html = '<div class="itemLi">';
//                    html += '<a href="javascript:">';
//                    html += '<div class="info"style="margin: 0">';
//                    html += '<div class="name" style="line-height: 25px"><span id="rec_name_' + d.data + '">' + name + '</span><span id="rec_mobile_' + d.data + '" style="margin: 0 10px">' + mobile + '</span></div>';
//                    html += '<input type="radio" class="u-inputradio" name="r" value="' + d.data + '">';
//                    html += '<label for="label1" id="rec_address_' + d.data + '">' + (province + city + district + road) + '</label>';
//                    html += '<br/></div></a></div>';
//                var $divObj = $(html);
//                console.dir($divObj);
//                $.each($('#rece_list .itemLi'),function(i,obj){
//                    if(i == $('#rece_list .itemLi').length -1){
//                        $('#rece_list').insertBefore($divObj,obj);
//                    }
//                });

                //清空数据
                $('#myForm .form-grounp .label-info input[name="userName"]').val('');
                $('#myForm .form-grounp .label-info input[name="mobile"]').val('');
//                $('#myForm .form-grounp .label-info input[name="province"]').val('');
//                $('#myForm .form-grounp .label-info input[name="city"]').val('');
//                $('#myForm .form-grounp .label-info input[name="district"]').val('');
                $('#myForm .form-grounp .label-info input[name="road"]').val('');
                $('#myForm .form-grounp .label-info input[name="zip"]').val('');

                $('#main_div').show();
                $('#change_rece').hide();
                $('#add_receiver').hide();
            }else{
                alert(d.errorMessage);
            }
        }
    });
}

/**
 * 异步填充收件人信息
 * */
function toChangeReceiver(sellerId, userId){

    $.ajax({
        type : "POST",
        url : baseUrl + 'mobile/mall/getReceivers?t='+ new Date().getTime(),
        data: {'sellerId':sellerId,'userId':userId},
        dataType : "json",
        success : function(d){
            if(d.errorCode == 0){
                var html = '';
                $.each(d.data, function(i, obj){
                    var temp = '';
                    if(obj.isDefault == 'y'){
                        temp = 'checked';
                    }
                        html += '<div class="itemLi">';
                        html += '<a href="javascript:">';
                        html += '<div class="info"style="margin: 0">';
                        html += '<div class="name" style="line-height: 25px"><span id="rec_name_' + obj.receiverId + '">' + obj.name + '</span><span id="rec_mobile_' + obj.receiverId + '" style="margin: 0 10px">' + obj.mobile + '</span></div>';
                        html += '<input type="radio" class="u-inputradio" name="r" ' + temp + ' value="' + obj.receiverId + '">';
                        html += '<label for="label1" id="rec_address_' + obj.receiverId + '">' + obj.province + obj.city + obj.district + obj.address + '</label><br/></div></a></div>';

                });

                html += '<div class="itemLi">';
                html += '<div class="info" style="margin: 0">';
                html += '<a href="javascript:toAddRece()" class="add_rece">添加收件人</a>';
                html += '<br/></div></div>';
//                console.dir(html);
                $('#rece_list').html(html);

                $('#main_div').hide();
                $('#change_rece').show();
                $('#add_receiver').hide();
                var originalId = $('#receiver_id').prop('value');
                if(!isNullOrEmpty(originalId)) {
                    $.each($('#rece_list .itemLi .info input[type="radio"]'), function (i, obj) {
                        var val = obj.value;
//                        console.dir(originalId + "     " + val);
                        if (originalId == val) {
                            obj.checked = 'checked';
                        }
                    });
                }

                //点击更换收件人
                $('#rece_list .itemLi a').click(function(){
//                    console.dir($(this));
                    $(this).find('input[type="radio"]').prop("checked","checked");
                    var originalId = $('#receiver_id').prop('value');
                    var newId = $(this).find('input[type="radio"]').prop('value');
                    if(originalId != undefined && originalId != newId){
//                        console.dir(originalId);
//                        console.dir(newId);
//                        console.dir($('#name').html());
//                        console.dir($('#rec_name_' + newId).html());
                        $('#receiver_info').show();
                        $('#name').html($('#rec_name_' + newId).html());
                        $('#phone').html($('#rec_mobile_' + newId).html());
                        $('#address').html($('#rec_address_' + newId).html());
                        $('#receiver_id').val(newId)
                    }
                    $('#main_div').show();
                    $('#change_rece').hide();
                });


            }else{
                alert(d.errorMessage);
            }
        }
    });

}

//点击添加收件人按钮
function toAddRece(){
    $('#main_div').hide();
    $('#change_rece').hide();
    $('#add_receiver').show();
}

//获取当前url中的参数，如http://suniusoft.com?sellerId=1,getArgs().sellerId即取到sellerId
function getArgs(){
    var args = new Object( ); //声明一个空对象
    var query = window.location.search.substring(1); // 取查询字符串，如从 http://www.snowpeak.org/testjs.htm?a1=v1&a2=&a3=v3#anchor 中截出 a1=v1&a2=&a3=v3。
    var pairs = query.split("&"); // 以 & 符分开成数组
    for(var i = 0; i < pairs.length; i++) {
        var pos = pairs[i].indexOf('='); // 查找 "name=value" 对
        if (pos == -1) continue; // 若不成对，则跳出循环继续下一对
        var argname = pairs[i].substring(0,pos); // 取参数名
        var value = pairs[i].substring(pos+1); // 取参数值
        value = decodeURIComponent(value); // 若需要，则解码
        args[argname] = value; // 存成对象的一个属性
    }
    return args; // 返回此对象
}
