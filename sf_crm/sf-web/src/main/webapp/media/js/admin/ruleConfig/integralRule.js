//
//var i=1+3;
////添加不规则记录
//function addText(){
//
//    if (i>10){
//        alert("到达到最大上限。");
//        return;
//    }
//    if (i%2!=0){
//        var g = parseInt(i/2)+1;
//        $("#mdiv").append('<div class="mdivR"><div class="form-group" id="interalGroup_'+g+'"><label class="col-sm-4 control-label no-padding-right" style="font-family: Helvetica;">第'+i+'次购物每100元购物金额赠送：</label><div class="col-sm-2" style="padding-left: 25px;"><label><input class="integralBuy col-xs-10 col-sm-5" type="text" name="integralBuy_'+i+'" placeholder="输入积分"></label></div></div></div>');
//    }else{
//        var j = i/2;
//        $("#interalGroup_"+j).append('<div class="mdivR"><label class="col-sm-2 control-label no-padding-right" style="font-family:Helvetica;width:245px;margin-left: -52px">第'+i+'次购物每100元购物金额赠送：</label><div class="col-sm-4" style="padding-left: 25px;"><label><input class="integralBuy col-xs-10 col-sm-5" type="text" name="integralBuy_'+i+'" placeholder="输入积分"></label></div>');
//    }
//    i++;
//}



//function loadIntegralGroup(index){
//   i = index+1;
//   addText();
//}

//var signCount = 3;
//function addSignInCofig(){
//    $("#mvGruop").append('<div class="col-xs-16 col-sm-10" id="input_group_'+signCount+'" style="margin-top: 10px"><div class="input-group" style="margin-left: 200px;"><span class="ml20" style="margin-left: 15px">每连续签到</span><input  type="text" name="signInNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px;"/>天<span class="ml20" style="margin-left: 15px;">送积分</span><input  type="text" name="integralNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px"/>个<span class="ml20" style="margin-left: 15px;">领取限制</span><input name="getConfig_'+signCount+'" type="radio" class="ace" value="" checked="checked"/><span class="lbl" style="margin-left: 15px;">每人仅限领取一次</span></div></div>');
//    signCount++;
//}


function integralRuleSave(){
    var data = $('#integralConfigForm').serialize();
    $.ajax({
        type: "post", // 请求方式
        url:  baseUrl+"/integralConfig/save", //url地址
        data: data, //数据
        dataType: "json",
        success: function (data) {
            if(data.errorCode == 0){
                alert("添加成功");

            }else{
                alert(data.errorMessage);
            }
        }, error: function () {
            alert("error");
        }
    });

}




function saveOrUpdateFrom(){
    var data = $('#integralConfigForm').serialize();

    //var buyIntegralArgs = "";
    //$.each($(".integralBuy"),function(i,value){
    //    buyIntegralArgs = buyIntegralArgs +',' +value.value;
    //});
//{'conertMoney':'"+conertMoney+"','groupIntegral':'"+groupIntegral+"','attentionIntegral':'"+groupIntegral+"','spreadIntegral':'"+spreadIntegral+"','buyIntegralArgs':'"+buyIntegralArgs+"'}
    $.ajax({
        type: "post", // 请求方式
        url:  baseUrl+"/integralConfig/save", //url地址
        data: data, //数据
        dataType: "json",
        success: function (data) {
            if(data.errorCode == 0){
                alert("计算成功。");

            }else{
                alert(data.errorMessage);
            }
        }, error: function () {
            alert("error");
        }
    });

}

integralRuleDetail();


/**
 * 获取表单详细信息
 */
function  integralRuleDetail(){
    $.post( baseUrl+"/integral/integralConfig", '', function(data){
        if(!isNullOrEmpty(data.integralConfigVO)){
            loadData(data.integralConfigVO);
        }
    }, "json")
}


$('#integralConfigDiv input[name="configName"]').click(function(){

    var type = $(this).val();
    if (type == 'SYS'){
        $('#integralConfigDiv input[name="conertMoney"]').prop("readonly","readonly");
        $('#integralConfigDiv input[name="attentionIntegral"]').prop("readonly","readonly");

    }else{

        $('#integralConfigDiv input[name="conertMoney"]').removeAttrs("readonly");
        $('#integralConfigDiv input[name="attentionIntegral"]').removeAttrs("readonly");
    }



    $.post( baseUrl+"/integral/integralConfig", {configName:type}, function(data){
        if(!isNullOrEmpty(data.integralConfigVO)){
            loadData(data.integralConfigVO);
        }
    }, "json")
});

/**
 * 加载数据
 * @param topSelector
 * @param obj
 */
function loadData(obj){

    if (obj.configName=="SYS"){

        $("#integralConfigDiv input:radio[name='configName'][value='SYS']").prop("checked","checked");

        $("#conertMoney").attr("disabled","disabled");
        $("#attentionIntegral").attr("disabled","disabled");
    }else{
        $("#integralConfigDiv input:radio[name='configName'][value='CUSTOM']").prop("checked","checked");
        $("#conertMoney").attr("disabled","");
        $("#attentionIntegral").attr("disabled","");
    }


    $('#integralConfigDiv input[name="conertMoney"]').val(obj.conertMoney);
    //$('#integralConfigDiv input[name="groupIntegral"]').val(obj.groupIntegral);
    $('#integralConfigDiv input[name="attentionIntegral"]').val(obj.attentionIntegral);
    //$('#integralConfigDiv input[name="spreadIntegral"]').val(obj.spreadIntegral);
    //$('#integralConfigDiv input[name="attentionIntegral"]').val(obj.attentionIntegral);

    //$('#integralConfigDiv input[name="integralBuy_1"]').val("");
    //$('#integralConfigDiv input[name="integralBuy_2"]').val("");
    //$('#integralConfigDiv input[name="integralBuy_3"]').val("");

    //$(".mdivR").remove();
    //
    //// 初始化动态框下标
    //i=4;
    //
    //var r =1;
    //$.each(obj.buyIntegralList,function(index,value){
    //
    //
    //    if (index>2){
    //        loadIntegralGroup(index);
    //    }
    //    r = index+1;
    //    $('#integralConfigDiv input[name="integralBuy_'+r+'"]').val(value);
    //
    //});

}


//表单验证
var MyValidator = function() {

    var handleSubmit = function() {
        $('.form-horizontal').validate({
            errorElement : 'span',
            errorClass : 'help-block',
            focusInvalid : false,
            rules : {
                attentionIntegral : {
                    digits:true,
                    required:true,
                    min:1
                },
                conertMoney : {
                    digits:true,
                    required:true
                }


            },
            messages : {
                attentionIntegral : {
                    digits:"必须是整数",
                    required:"必填字段"
                },
                conertMoney : {
                    digits:"必须是整数",
                    required:"必填字段"
                }

            },
            highlight : function(element) {
                $(element).closest('.form-group').addClass('has-error');
            },

            success : function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement : function(error, element) {
                element.parent('div').append(error);
            },

            submitHandler : function(form) {
               saveOrUpdateFrom();//增加或更新表单
            }
        });



        $('.form-horizontal input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.form-horizontal').validate().form()) {
                    $('.form-horizontal').submit();
                }
                return false;
            }
        });
    }


    return {
        init : function() {
            handleSubmit();
        }
    };
}();

MyValidator.init();





