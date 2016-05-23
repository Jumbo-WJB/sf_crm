/*function acceptPrize(userId, goodsId,presentType) {
    var sellerId = $("input[name='sellerId']").val();
    //freshUrl(baseUrl+"mobile/activity/list/toedit?userId="+userId);
    if(presentType == 'HB') {
        window.location.href = "mobile/hongbao/receive?hbPoolId="+poolId+"&ruleType=HB_POOL&userId="+userId+"";
    }
    if(presentType=='GIFTS') {
        window.location.href = "mall/goods/detail?sellerId=1&userId="+userId+"&gid="+goodsId+"";
    }
    if(presentType=='POINTS' || presentType=='DISCOUNT') {
        $.ajax({
            type : "post",
            url : baseUrl+"/mobile/receive/prize",
            data : {sellerId:sellerId,userId:userId,birthdayActivityId:birthdayActivityId,presentType:presentType},
            dataType : "json",
            success : function(data){
                if (data.errorCode == "-1"){
                    alert(data.info);
                    window.location.reload();
                }else{
                    alert(data.info);
                    window.location.reload();
                }
            }
        });
    }
}*/

//领红包
function acceptPrizeHb(poolId,userId,sellerId) {

    window.location.href = "hongbao/receiveOrUserBound?hbPoolId="+poolId+"&ruleType=HB_POOL&userId="+userId+"&sellerId="+sellerId+"&businessType=birthday";
}
//领礼物
function acceptPrizeGifts(sellerId,userId, goodsId, birthdayActivityId) {
    window.location.href = "mall/goods/detail?sellerId="+sellerId+"&userId="+userId+"&gid="+goodsId+"&obtainId="+birthdayActivityId+"";
}
//领积分或者折扣
function acceptPrizepd(sellerId, userId, birthdayActivityId,presentType) {
    $.ajax({
        type : "post",
        url : baseUrl+"/mobile/receive/prize",
        data : {sellerId:sellerId,userId:userId,birthdayActivityId:birthdayActivityId,presentType:presentType},
        dataType : "json",
        success : function(data){
            if (data.errorCode == "-1"){ alert(data.info);
                //window.location.reload();
            }else{
                alert(data.info);
                //window.location.reload();
                $("#apoints").removeAttr("href");
                $("#apoints").hide();
                $("#apoints").after("已领取");
            }
        }
    });
}
