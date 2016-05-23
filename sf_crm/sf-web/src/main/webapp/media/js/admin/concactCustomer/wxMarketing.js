
createToken('markActForm');
//表单重置
$('#markActForm')[0].reset();

//页面切换
$("input[name='type']").click(function(){
    var selected = $(this).val();
    if (selected == 'sms'){
        freshUrl(baseUrl+"contactCustomer/smsMarketing");
    }else if (selected == 'email'){
        freshUrl(baseUrl+"contactCustomer/emailMarketing");
    }
});

$('#sendActBut').click(function(){
    var type = $("input[name='type']:checked").val();
    var title = $("input[name='title']").val();
    var target = $("input[name='target']:checked").val();
    var wxSendType = $("input[name='wxSendType']:checked").val();
    var url = $("input[name='url']").val();
    var wxImgUrl = $(".wxImgUrl").html();
    var content = $("textarea[name='content']").val();
    var token = $("input[name='token']").val();

    if (type == undefined){
        alert('请选择营销方式');
        return false;
    }
    if (title == ''){
        alert('请填写营销主题');
        return false;
    }
    if (target == undefined){
        alert('请选择营销目的');
        return false;
    }
    if (wxSendType == undefined){
        alert('请选择发送方式');
        return false;
    }
    if (url == ''){
        alert('请填写活动链接');
        return false;
    }
    if (wxImgUrl == ''){
        alert('请上传活动图片');
        return false;
    }
    if (content == ''){
        alert('请填写营销内容');
        return false;
    }

    if (wxSendType == 'mass'){
        if (monthWxMassTimes > 3){
            alert("对不起，您一个月只能群发四次！");
            return false;
        }
    }

    var data = {type:type,title:title,target:target,wxSendType:wxSendType,url:url,content:content};
    var data = JSON.stringify(data).replace(/\"/g,"'");

    $.ajaxFileUpload({
        type : 'post',
        url : baseUrl+"contactCustomer/sendWxMarket?token="+token,
        secureuri:false,
        fileElementId: ['wxImgUrl'],
        data : {marketVO:data},
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