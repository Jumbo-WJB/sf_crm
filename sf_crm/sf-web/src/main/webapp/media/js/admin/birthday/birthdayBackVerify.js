/*短信方面的校验参数*/
var $words = $(".words");
var $save = $("#save");
var ie = jQuery.support.htmlSerialize;
var msgChineseCharacterNum = 0;
var singChineseCharacterNum = 0;
var msgWordsNum = 0;
var singWordsNum = 0;
var maxNum = 140;
var texts = 0;
var signTexts = 0;
$words.val("");


//对短信签名做处理
var $msgSign = $("input[name='msgSign']");
//$msgSign.val("");

/**校验生日活动标题*/
function verifyBirthdayTitle() {
    var title = $("input[name='title']").val();
    if(title == "" || title == null) {
        $("#birthdayTitileDiv").show();
    } else {
        $("#birthdayTitileDiv").hide();
    }
}
/**校验生日活动积分*/
function verifyBirthdayPoints() {
    var careType = $('input[name="careType"]:checked').val();
    if(careType == "birthday_points") {
        var r = /^\+?[1-9][0-9]*$/;     //正整数
        if($("input[name='points']").val().trim()=="" || (!r.test($("input[name='points']").val().trim()))) {
            $("#birthdayPoints").show();
            $("#birthdayPoints font").html("赠送积分必填,并且是必须是整数");
            return false;
        } else {
            $("#birthdayPoints").hide();
        }

    }
}

/**
 * 校验短信字数是否超过
 * 70个汉字字符
 */
//顶部的提示文字
$words.focus(function(){
    //短信正文汉字的个数
    msgChineseCharacterNum = ($words.val().replace(/\w/g,"")).length;
    //短信正文非汉字的个数
    msgWordsNum = $words.val().length - msgChineseCharacterNum;
    //短信签名汉字的个数
    singChineseCharacterNum = ($msgSign.val().replace(/\w/g,"")).length;
    //短信签名非汉字的个数
    singWordsNum = $msgSign.val().length - singChineseCharacterNum;

    texts = Math.ceil((maxNum - (msgChineseCharacterNum*2 + msgWordsNum)) / 2);
    signTexts = Math.ceil((maxNum - (singChineseCharacterNum*2 + singWordsNum)) / 2);

    if($words.val()==""){
        $("p").html("<font style='color:blue'>您还可以输入的字数<span>"+(signTexts-2)+"</span></font>");
    }
});

$words.blur(function(){
    if($words.val() == ""){
        $("p").html("请在下面输入您的文字：");
    }
});

/**
 * 短信内容字数的校验
 */
function verifyResidueMsg() {

    //短信正文汉字的个数
    msgChineseCharacterNum = ($words.val().replace(/\w/g,"")).length;
    //短信正文非汉字的个数
    msgWordsNum = $words.val().length - msgChineseCharacterNum;
    //短信签名汉字的个数
    singChineseCharacterNum = ($msgSign.val().replace(/\w/g,"")).length;
    //短信签名非汉字的个数
    singWordsNum = $msgSign.val().length - singChineseCharacterNum;
    texts = Math.ceil((maxNum - (msgChineseCharacterNum*2 + msgWordsNum)) / 2);
    signTexts = Math.ceil((maxNum - (singChineseCharacterNum*2 + singWordsNum)) / 2);
    texts = texts - (70-signTexts+2);
    //var total = msgChineseCharacterNum*2 + msgWordsNum;

    if(texts>=0) {
        $save.removeAttr("disabled");
        $("p").html("您还可以输入的字数:<span>"+texts+"</span>").children().css({"color":"blue"});

    } else {
        $save.prop("disabled",true);
        $("p").html("您输入的字数超过了:<span>"+texts+"</span>").children("span").css({"color":"red"});
    }

    //if(msgChineseCharacterNum*2 + msgWordsNum <= maxNum){
    //    $save.removeAttr("disabled");
    //    texts = Math.ceil((maxNum - (msgChineseCharacterNum*2 + msgWordsNum)) / 2);
    //
    //    $("p").html("您还可以输入的字数:<span>"+texts+"</span>").children().css({"color":"blue"});
    //} else if(msgChineseCharacterNum*2 + msgWordsNum > maxNum){
    //    $save.prop("disabled",true);
    //    texts = Math.ceil(((msgChineseCharacterNum*2 + msgWordsNum)- maxNum)/2);
    //    $("p").html("您输入的字数超过了:<span>"+texts+"</span>").children("span").css({"color":"red"});
    //}
}

/**
 * 校验开始时间和结束时间
 * @returns {boolean}
 */
function verifyStartAndEnd() {
    /*时间方面的校验参数*/
    var startTime = $("input[name='startTime']").val();
    var hideStartTime = $("input[name='hideStartTime']").val();
    var hideDate = Date.parse((hideStartTime + " 00:00:00").replace(/-/g,"/"));
    var endTime = $("input[name='endTime']").val();
    var startdate = Date.parse((startTime + " 00:00:00").replace(/-/g,"/"));
    var enddate = Date.parse((endTime + " 00:00:00").replace(/-/g,"/"));
    $("#verifyDate").html("");
    if(startTime == null || startTime == "") {
        $("#verifyDate").html("请选择开始时间");
        return false;
    }
    if(startdate<hideDate) {
        $("#verifyDate").parent().css("margin-left","-12px");
        $("#verifyDate").html("开始时间不能小于系统生成的默认时间。");
        return false;
    }
    if(endTime == null || endTime == "") {
        $("#verifyDate").parent().css("margin-left","-83px");
        $("#verifyDate").html("请选择结束时间");
        return false;
    }
    if(startdate>enddate) {
        $("#verifyDate").parent().css("margin-left","-56px");
        $("#verifyDate").html("结束时间要大于开始时间");
        return false;
    }

}



