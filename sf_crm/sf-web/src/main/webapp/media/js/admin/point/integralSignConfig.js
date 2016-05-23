
integraSignRuleDetail();
/**
 * 获取表单详细信息
 */
function integraSignRuleDetail(){
    $.post( baseUrl+"/integral/querySignIntegral", '', function(data){
        if(!isNullOrEmpty(data.signInPointConfigVO)){
            loadData(data.signInPointConfigVO);
        }
    }, "json")
}


/**
 * 加载数据
 * @param topSelector
 * @param obj
 */
function loadData(obj){

    if (obj.signInVOList!=null){

        signCount = obj.signInVOList.length;

        $.each(obj.signInVOList,function(index,value){

            if(index>0){

                loadSignIntegralInput(index)
            }
            var r = index+1;

            $('#signInNum_'+r).val(value.signInTimes);
            $('#integralNum_'+r).val(value.point);
            $('#getConfig_'+r).val(value.getTimes);
        });

    }
    //signCount = 1;


}

function loadSignIntegralInput(index){
    var i = index +1;
    //$("#mvGruop").append('<div class="integralSignIn col-xs-16 col-sm-10" id="input_group_'+i+'" style="margin-top: 10px"><div class="input-group" style="margin-left: 200px;"><span class="ml20" style="margin-left: 15px">每连续签到</span><input  type="text" id="signInNum_'+i+'" style="margin-left: 10px;margin-right: 10px;"/>天<span class="ml20" style="margin-left: 15px;">送积分</span><input  type="text" id="integralNum_'+i+'" style="margin-left: 10px;margin-right: 10px"/>个<span class="ml20" style="margin-left: 15px;">领取限制</span><input id="getConfig_'+i+'" type="radio" class="ace" value="1" checked="checked"/><span class="lbl" style="margin-left: 15px;">每人仅限领取一次</span></div></div>');

    $("#mvGruop").append('<div class="col-xs-16 col-sm-12" id="input_group_'+i+'" style="margin-top: 10px"><div class="col-sm-3"></div><div class="integralSignIn input-group"><span class="delIcon"></span>&nbsp;每连续签到&nbsp;&nbsp;<input  type="text" class="signInNum" id="signInNum_'+i+'" />&nbsp;&nbsp;天&nbsp;&nbsp送积分&nbsp;&nbsp;&nbsp;<input  type="text" class="integralNum" id="integralNum_'+i+'"/>&nbsp;&nbsp;个&nbsp;&nbsp;&nbsp;领取限制&nbsp;&nbsp;<input name="config_'+i+'" class="getConfig" type="radio" class="ace"  id="getConfig_'+i+'" value="1" checked="checked"/><span class="lbl"> 每人仅限领取一次</span></div> </div>');

    //$("#mvGruop").append('<div class="col-xs-16 col-sm-12" id="input_group_'+i+'" style="margin-top: 10px"><div class="col-sm-3"></div><div class="integralSignIn input-group"><span class="delIcon"></span>每连续签到&nbsp;&nbsp;<input type="text" id="signInNum_'+i+'"/>&nbsp;&nbsp;天&nbsp;&nbsp;送积分&nbsp;&nbsp;<input  type="text" id="integralNum_'+i+'"/>&nbsp;&nbsp;个&nbsp;&nbsp;领取限制&nbsp;&nbsp;<input name="config_'+i+'" type="radio" class="ace" id="getConfig_'+i+'" value="1" checked="checked"/> <span class="lbl">每人仅限领取一次</span> </div> </div>');
    $('.delIcon').on("click",function(){
        $(this).parent().parent().remove();
    });
}

var signCount = 1;
function addSignInCofig(){

    var num = $(".integralSignIn").length;

    if (num>=5){
        alert("不能添加了,已达到最大上限。");
        return;
    }

    signCount++;


    //$("#mvGruop").append('<p>123</p>')
    $("#mvGruop").append('<div class="col-xs-16 col-sm-12" id="input_group_'+signCount+'" style="margin-top: 10px"><div class="col-sm-3"></div><div class="integralSignIn input-group"><span class="delIcon"></span>&nbsp;每连续签到&nbsp;&nbsp;<input type="text" class="signInNum" id="signInNum_'+signCount+'"/>&nbsp;&nbsp;天&nbsp;&nbsp;&nbsp;送积分&nbsp;&nbsp;<input  type="text" class="integralNum" id="integralNum_'+signCount+'"/>&nbsp;&nbsp;个&nbsp;&nbsp;&nbsp;领取限制&nbsp;&nbsp;<input name="config_'+signCount+'" class="getConfig" type="radio" class="ace" id="getConfig_'+signCount+'" value="1" checked="checked"/><span class="lbl">每人仅限领取一次</span> </div> </div>');
    //$("#mvGruop").append('<div class="integralSignIn col-xs-16 col-sm-10" id="input_group_'+signCount+'" style="margin-top: 10px"><div class="input-group" style="margin-left: 200px;"><span class="ml20" style="margin-left: 15px">每连续签到</span><input  type="text" id="signInNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px;"/>天<span class="ml20" style="margin-left: 15px;">送积分</span><input  type="text" id="integralNum_'+signCount+'" style="margin-left: 10px;margin-right: 10px"/>个<span class="ml20" style="margin-left: 15px;">领取限制</span><input id="getConfig_'+signCount+'" type="radio" class="ace" value="1" checked="checked"/><span class="lbl" style="margin-left: 15px;">每人仅限领取一次</span></div></div>');


    $('.delIcon').on("click",function(){


        $(this).parent().parent().remove();
    });
}


function saveOrUpdateFrom(){
    //var data = $('#signInConifgForm').serialize();

    var ids = [];

    var errCode = 0;

    $(".integralSignIn").each(function(index){

        var signInNum = $(this).find(".signInNum").val();

        var point = $(this).find(".integralNum").val();
        var getNum = $(this).find(".getConfig").val();


        if ((signInNum == null || signInNum =='') || (point == null || point == '') || (getNum == null || getNum =='')){
            alert("信息不能为空。");
            errCode = -1;
            return;
        }

        if(index>0){
            var prevSignInNum = $(".signInNum").eq(index-1).val();

            if (signInNum <= prevSignInNum){
                errCode = -1;
                alert("连续签到天数必须大于前一项。");
                return;
            }
        }


        if (signInNum !=null && point!=null && getNum!=null){
            var person = {"signInTimes":signInNum,"point":point,"getTimes":getNum};

            ids.push(person);

        }

    });


    if (errCode != -1){
        $.ajax({
            type : "post",
            url : baseUrl+"/signIntegralConfig/save",
            //data : {signInConfig:ids.toString()},
            data : JSON.stringify(ids),
            async:false,
            dataType : "json",
            contentType:"application/json",
            success : function(data){
                if (data.errorCode == '0'){
                    alert("保存成功！");
                }else{
                    alert("保存失败！");
                    return false;
                }
            }
        });
    }

}

var oTable = $('#signPointQueryTable').dataTable({

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
        "url": baseUrl + '/integral/signIntegralDetailList',
        "data": function (d) {

        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {

                if (data == '1'){
                    return '男';
                }
                if (data == '2'){
                    return '女';
                }

                return data;
            },
            "targets": 1
        },
        {
            "render": function (data, type, row) {

                if (data !=null && data !=''){
                    return data.substring(0,data.length-2);
                }
                return data;
            },
            "targets": 4
        },
        {
            "render": function (data, type, row) {

                return data;

            },
            "targets": 5
        }, {
            "render": function (data, type, row) {
                if (data == '1'){
                    return '是';
                }
                return data;
            },
            "targets": 6
        }, {
            "render": function (data, type, row) {
                if (data == '-1'){
                    return '0';
                }
                return data;
            },
            "targets": 9
        },
//                    {"visible": false, "targets": [3]}
    ],
    "sort": false,
    "columns": [
        {"data": "wxNickName"},
        {"data": "sex"},
        {"data": "amount"},
        {"data": "signInTimes"},
        {"data": "lastSignInDate"},
        {"data": "pointAmountTotal"},
        {"data": "isOldUser"},
        {"data": "mobile"},
        {"data": "name"},
        {"data": "totalPurchaseTimes"},

    ]
});





