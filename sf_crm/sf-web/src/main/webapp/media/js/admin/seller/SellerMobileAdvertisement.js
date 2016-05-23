/**
 * 查看详细信息方法
 * @type {*|jQuery}
 */
detail();

/**
 * 获取表单详细信息
 */
function  detail(){
    $.post( baseUrl+"/sellerMobileMenu/detail",{functionType:'advertisement'},  function(data){
        if(!isNullOrEmpty(data.sellerMobileMenus)){
            $.each(data.sellerMobileMenus,function(i,value){
                var  isSelect=value.isSelect;
                var  name=value.name;
                var functionType=value.functionType;
                var isShowOther=value.isShowOther;
                $(":input[type='hidden'][name='"+name+"']").val(value.id);
                if("0"==isSelect){
                    return true;
                }

                    var  link=value.link;
                    $("."+name).val(link)
                    var  url=value.url;
                if(!isNullOrEmpty(url)){
                    $("#menuForm  img[name='"+ name+"']").css("display","block");
                    $("#menuForm  img[name='"+ name+"']").attr("src",baseUrl+url);
                }
            })

        }
    }, "json")
}

/**
 * 保存或更新方法
 */
$("#saveOrUpdate").click(function (event) {
    event.preventDefault()
    var saveDataAry=[];
    var arrId = []
    //遍历广告内容
    $.each($(':input[type="file"]'),function(i,value){
        var name=$(':input[type="file"]').eq(i).attr('name');
        var  type='indexpage';
        if(i>=3){
            type='point';
        }
        var url='';
        if(!isNullOrEmpty($("#menuForm  img[name='"+ name+"']").attr("src"))){
            url=$("#menuForm  img[name='"+ name+"']").attr("src");
            var index=   url.indexOf("/upload");
            url=  url.substring(index,index.length);
        }
        var data={'id':$(":input[type='hidden'][name='"+name+"']").val(),'type':type,'functionType':'advertisement','name':name,'url':url,'link':$(':input[name="link"]').eq(i).val(),'priority':i,'isShowOther':$(':input[name="isShowOther"]:checked').val(),'isSelect':'1'};
        saveDataAry.push(data);
        arrId.push($(':input[type="file"]').eq(i).attr('id'));
    });

    var  saveStr=JSON.stringify(saveDataAry).replace(/\"/g,"'");
    $.ajaxFileUpload({
        url:  baseUrl+"/sellerMobileMenu/saveOrUpdate", //地址
        secureuri:false,
        fileElementId: arrId,  //这里不在是以前的id了，要写成数组的形式哦！
        dataType: 'json',
        data: {
            SellerMobileMenus:saveStr
        },
        success: function (data){
            alert("保存成功!");
            freshUrl(baseUrl+"/sellerMobileAdvertisement/get");
        },
        error: function(data){
            alert("保存失败!");
        }
    });

});