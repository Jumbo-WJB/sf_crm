
//表单重置
$('#addForm')[0].reset();

$('#addShop').click(function(){
    $('#addForm input[name="shopId"]').val('');
    $('#addForm')[0].reset();
    $('#shopModal').modal('show');
    $(".general").hide();
    $(".self").show();
    $(".plugin").show();
    $('.notBrowser').show();
    $(".polySpireDIV").show();
    $('#addForm input[name="shopType"]').each(function(){
        $(this).removeAttr('disabled');
    });
    $("#addForm input[name='shopAppId']").removeAttr('readonly');
    $("#addForm input[name='shopAppSecret']").removeAttr('readonly');
    createToken('addForm');
})

$("#addForm input[name='shopType']").click(function(){
    var type = $(this).val();
    var accessType = $("#addForm input[name='accessType']:checked").val();

    $('.notBrowser').show();
    $(".browserDIV").hide();
    if (type == 'TB' || type == 'TMALL'){
        $(".general").hide();
        $(".self").show();
        $(".plugin").show();
        $(".polySpireDIV").show();
    }else if (type == 'JD'){
        $(".general").show();
        $(".self").show();
        $(".plugin").hide();
        $(".polySpireDIV").hide();
        $("#addForm input[name='polySpireUrl']").val('');
    }else {
        $(".general").hide();
        $(".self").show();
        $(".plugin").hide();
        $(".polySpireDIV").hide();
        $("#addForm input[name='polySpireUrl']").val('');
    }

    if (type == 'JD' && accessType == 'general'){
        $("#addForm input[name='shopAppId']").val(jdAppKey).attr('readonly','readonly');
        $("#addForm input[name='shopAppSecret']").val(jdAppSecret).attr('readonly','readonly');
    }else{
        $("#addForm input[name='shopAppId']").val('').removeAttr('readonly');
        $("#addForm input[name='shopAppSecret']").val('').removeAttr('readonly');
    }
})

$("#addForm input[name='accessType']").click(function(){
    var type = $(this).val();
    var sellerType = $("#addForm input[name='shopType']:checked").val();

    if (type == 'plugin'){
        $('.notBrowser').hide();
        $(".browserDIV").show();
    }else{
        $('.notBrowser').show();
        $(".browserDIV").hide();
        if (sellerType == 'TB' || sellerType == 'TMALL'){
            $(".polySpireDIV").show();
        }else{
            $(".polySpireDIV").hide();
        }
    }

    if (sellerType == 'JD' && type == 'general'){
        $("#addForm input[name='shopAppId']").val(jdAppKey).attr('readonly','readonly');
        $("#addForm input[name='shopAppSecret']").val(jdAppSecret).attr('readonly','readonly');
    }else{
        $("#addForm input[name='shopAppId']").val('').removeAttr('readonly');
        $("#addForm input[name='shopAppSecret']").val('').removeAttr('readonly');
    }
})

function edit(id){
    $.ajax({
        type : "post",
        url : baseUrl+"sellerConfig/findConfig",
        data : {id:id},
        dataType : "json",
        success : function(data){
            if (data.errorCode == 0){
                $("#addForm input[name='shopId']").val(data.shopConfig.shopId);
                $("#addForm input[name='shopName']").val(data.shopConfig.shopName);
                $('#addForm input[name="shopType"]').each(function(){
                    if ($(this).val() == data.shopConfig.shopType){
                        $(this).prop('checked','checked');
                        $(this).removeAttr('disabled');
                    }else{
                        $(this).attr('disabled','disabled');
                    }
                })
                if (data.shopConfig.shopType == 'TB' || data.shopConfig.shopType == 'TMALL'){
                    $(".general").hide();
                    $(".self").show();
                    $(".plugin").show();
                    $(".polySpireDIV").show();
                }else if (data.shopConfig.shopType == 'JD'){
                    $(".general").show();
                    $(".self").show();
                    $(".plugin").hide();
                    $(".polySpireDIV").hide();
                }else {
                    $(".general").hide();
                    $(".self").show();
                    $(".plugin").hide();
                    $(".polySpireDIV").hide();
                }
                $('#addForm input[name="accessType"]').each(function(){
                    if ($(this).val() == data.shopConfig.accessType){
                        $(this).prop('checked','checked');
                    }

                })
                if (data.shopConfig.accessType == 'plugin'){
                    $('.notBrowser').hide();
                    $(".browserDIV").show();
                }else{
                    $('.notBrowser').show();
                    $(".browserDIV").hide();
                    if (data.shopConfig.shopType == 'TB' || data.shopConfig.shopType == 'TMALL'){
                        $(".general").hide();
                        $(".self").show();
                        $(".plugin").show();
                        $(".polySpireDIV").show();
                    }else if (data.shopConfig.shopType == 'JD'){
                        $(".general").show();
                        $(".self").show();
                        $(".plugin").hide();
                        $(".polySpireDIV").hide();
                    }else {
                        $(".general").hide();
                        $(".self").show();
                        $(".plugin").hide();
                        $(".polySpireDIV").hide();
                    }
                }
                $("#addForm input[name='shopAppId']").val(data.shopConfig.shopAppId);
                $("#addForm input[name='shopAppSecret']").val(data.shopConfig.shopAppSecret);
                $("#addForm input[name='polySpireUrl']").val(data.shopConfig.polySpireUrl);
            }
        }
    })

    createToken('addForm');
    $('#shopModal').modal('show');
}

//保存店铺信息设置
$('#save').click(function(){
    if (check() > 0) {
        return false;
    }

    var accessType = $('#addForm input[name="accessType"]:checked').val();
    if (accessType == null || accessType == '' || accessType == undefined){
        alert('接入方式不能为空');
        return false;
    }

    var sellerType = $("#addForm input[name='shopType']:checked").val();
    if (sellerType == 'TB' || sellerType == 'TMALL'){
        if (accessType == 'self_development'){
            if (!checkPolyUrl()){
                return false;
            }
        }
    }

    var data = $('#addForm').serialize();
    $.ajax({
        type : "post",
        url : baseUrl+"sellerConfig/saveShopConfig",
        data : data,
        dataType : "json",
        success : function(data){
            if (data.errorCode == 0){
                alert(data.errorMessage);
                $('#shopModal').modal('hide');
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

function deleteA(id){
    var text = window.confirm("亲，删除以后用户的数据同步就会停止，确定要删除吗？");
    if (text){
        $.post(baseUrl+"sellerConfig/deleteConfig",{shopId:id},function(data){
            if (data.errorCode == 0){
                alert("删除成功");
                window.location.reload();
            }else{
                alert("删除失败");
            }
        },"json")
    }else{
        return false;
    }
}

//提交前验证表单
function check() {
    var flag = 0;
    var $shopName = $("#addForm input[name='shopName']");
    var $shopAppId = $("#addForm input[name='shopAppId']");
    var $shopAppSecret = $("#addForm input[name='shopAppSecret']");

    var accessType = $('#addForm input[name="accessType"]:checked').val();

    if ($shopName.val() == ''){
        $('.noName').remove();
        $shopName.parent().append('<span class="noName">店铺名不能为空</span>');
        $('.noName').css({'color':'#d16e6c','font-size':'15px'});
        flag++ ;
    }

    if (accessType != 'plugin'){
        if ($shopAppId.val() == ''){
            $('.noAppId').remove();
            $shopAppId.parent().append('<span class="noAppId">shopAppId不能为空</span>');
            $('.noAppId').css({'color':'#d16e6c','font-size':'15px'});
            flag++ ;
        }
        if ($shopAppSecret.val() == ''){
            $('.noSecretId').remove();
            $shopAppSecret.parent().append('<span class="noSecretId">shopAppSecret不能为空</span>');
            $('.noSecretId').css({'color':'#d16e6c','font-size':'15px'});
            flag++ ;
        }
    }

    return flag;
}


$('#urlVerify').click(function(){
    if (checkPolyUrl()){
        alert('测试成功，该聚石塔url有效');
    }
})

//聚石塔url正确性验证
function checkPolyUrl(){
    var flag;
    var polyUrl = $("#addForm input[name='polySpireUrl']").val();
    if (polyUrl ==  null || polyUrl == ''){
        alert('请填写聚石塔url');
        flag = false;
        return flag;
    }

    $.ajax({
        type : "post",
        url : baseUrl+'sellerConfig/urlVerify',
        data : {url:polyUrl},
        dataType : "json",
        async: false,
        success : function(data){
            if (data.errorCode == 0){
                flag = true;
            }else{
                alert(data.errorMessage);
                flag = false;
            }
        }
    })

    return flag;
}
