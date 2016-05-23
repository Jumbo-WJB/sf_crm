createToken('addForm');
//表单重置
$('#addForm')[0].reset();

//保存商家配置信息
$('#save').click(function(){
    if (checkForm() > 0){
        return false;
    }

    var sellerName = $("#addForm input[name='sellerName']").val();
    var mobile = $("#addForm input[name='mobile']").val();var phone = $("#addForm input[name='phone']").val();
    var email = $("#addForm input[name='email']").val();var address = $("#addForm input[name='address']").val();
    var wxNo = $("#addForm input[name='wxNo']").val();var wxAppId = $("#addForm input[name='wxAppId']").val();
    var wxAppSecret = $("#addForm input[name='wxAppSecret']").val();var wxMchid = $("#addForm input[name='wxMchid']").val();
    var wxAppKey = $("#addForm input[name='wxAppKey']").val();
    var smsSerial = $("#addForm input[name='smsSerial']").val();var smsNotifySign = $("#addForm input[name='smsNotifySign']").val();
    var smsSaleSign = $("#addForm input[name='smsSaleSign']").val();var emailSign = $("#addForm input[name='emailSign']").val();
    var emailFromName = $("#addForm input[name='emailFromName']").val();
    var token = $("#addForm input[name='token']").val();

    var data = {sellerName:sellerName,mobile:mobile,phone:phone,email:email,
        address:address,wxNo:wxNo,wxAppId:wxAppId,wxAppSecret:wxAppSecret,wxMchid:wxMchid,wxAppKey:wxAppKey,smsSerial:smsSerial,
        smsNotifySign:smsNotifySign,smsSaleSign:smsSaleSign,emailSign:emailSign,emailFromName:emailFromName};
    var jsonStr = JSON.stringify(data).replace(/\"/g,"'");

    $.ajaxFileUpload({
        type : 'post',
        url : baseUrl+"sellerConfig/saveSellerConfig?token="+token,
        secureuri:false,
        fileElementId: ['wxSecrteUrl','wxImgUrl','wxQrcode'],
        data : {sellerConifg:jsonStr},
        dataType : "json",
        success : function(data){
            if (data.errorCode == 0){
                alert(data.errorMessage);
                window.location.reload();
            }else{
                alert(data.errorMessage);
            }
        },
        error : function(){
            alert("系统异常，请稍后重试！");
        }
    })
})

function checkForm(){
    var errFlag = 0;
    var $sellerName = $("input[name='sellerName']");var $mobile = $("input[name='mobile']");
    var $wxNo = $("input[name='wxNo']");var $wxAppId = $("input[name='wxAppId']");
    var $wxAppSecret = $("input[name='wxAppSecret']");var $wxMchid = $("input[name='wxMchid']");
    var $wxAppKey = $("input[name='wxAppKey']");
    var $phone = $("input[name='phone']");var $email = $("input[name='email']");

    if (!checkData($sellerName,'商家名不能为空')){
        errFlag++;
    }
    if (!checkData($wxNo,'微信号不能为空')){
        errFlag++;
    }
    if (!checkData($wxAppId,'微信appid不能为空')){
        errFlag++;
    }
    if (!checkData($wxAppSecret,'微信appsecret不能为空')){
        errFlag++;
    }
    if (!checkData($wxMchid,'微信商户号不能为空')){
        errFlag++;
    }
    if (!checkData($wxAppKey,'微信商户key不能为空')){
        errFlag++;
    }

    if (hasSecrte != 1 && $('.wxSecrteUrl').html() == ''){
        $('.wxSecrteUrl').parent().find('.required').html("证书不能为空");
        errFlag++;
    }

    if (hasWxImg != 1 && $('.wxImgUrl').html() == ''){
        $('.wxImgUrl').parent().find('.required').html("公众号头像不能为空");
        errFlag++;
    }

    if (hasQrcode != 1 && $('.wxQrcode').html() == ''){
        $('.wxQrcode').parent().find('.required').html("微信二维码不能为空");
        errFlag++;
    }

    if ($mobile.val() != ''){
        if (!isMobile($mobile.val())){
            $mobile.parent().find('.required').html("手机号格式错误");
            errFlag++;
        }
    }

    if ($phone.val() != ''){
        if (!isPhone($phone.val())){
            $phone.parent().find('.required').html("座机号格式错误");
            errFlag++;
        }
    }

    if ($email.val() != ''){
        if (!isEmail($email.val())){
            $email.parent().find('.required').html("邮箱格式错误");
            errFlag++;
        }
    }

    return errFlag;
}

function checkData(element,errText){
    if (element.val() == ''){
        element.parent().find('.required').html(errText);
        return false;
    }
    return true;
}

//判断固话或手机格式是否正确
function isMobile(mobile){
    var reg1 = /^0?1[3|4|5|8][0-9]\d{8}$/;
    if (reg1.test(mobile)) {
        return true;
    }
    return false;
}

//验证固话格式
function isPhone(mobile){
    var reg2 = /^0\d{2,3}-?\d{7,8}$/;
    if (reg2.test(mobile)) {
        return true;
    }
    return false;
}

//验证邮箱格式
function isEmail(email){
    var reg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    if (reg.test(email)){
        return true;
    }
    return false;
}