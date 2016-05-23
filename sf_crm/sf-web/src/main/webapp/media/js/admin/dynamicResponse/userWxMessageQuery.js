
var oTable = $('#userWXMessageQueryTable').dataTable({

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
        "url": baseUrl + '/dynamicResponse/sceneReplySearch',
        "data": function (d) {
            var wxNickName = $("#userWXMessageQueryForm :input[name='wxNickName']").val();

            var mobile = $("#userWXMessageQueryForm :input[name='mobile']").val();

            var bizType = $("#userWXMessageQueryForm :input[name='bizType']").val();

            var toSend = $("#userWXMessageQueryForm :input[name='toSend']").val();



            if (!isNullOrEmpty(mobile)) {
                d.mobile = mobile;
            }

            if (!isNullOrEmpty(wxNickName)) {
                d.wxNickName = wxNickName;
            }

            if (!isNullOrEmpty(bizType)) {
                d.bizType = bizType;
            }

            if (!isNullOrEmpty(toSend)) {
                d.toSend = toSend;
            }




        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                var datetime = new Date();
                var dateTime2 = new Date();
                datetime.setTime(row.createTime);
                if (dateTime2.getDate() - 2 <datetime.getDate()){
                    return '<td class="center"><label><input name="openId" type="checkbox" class="ace" value="'+data+'&'+row.msgId+'"/><span class="lbl"></span></label></td>';
                }

                return '<td class="center"><label><input disabled="disabled" name="openId" type="checkbox" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';


            },
            "targets": 0
        },
        {
            "render": function (data, type, row) {

                var msgType = "";
                if ('text' == data) {
                    msgType = "文本";
                }
                return msgType;
            },
            "targets": 4
        },
        {
            "render": function (data, type, row) {

                var fromSource = "";
                if ("TB"==data){
                    fromSource = "淘宝";
                }
                if ("JD"==data){
                    fromSource = "京东";
                }
                if ("WX"==data){
                    fromSource = "微信";
                }

                return fromSource;
            },
            "targets": 6
        }, {
            "render": function (data, type, row) {

                var bizType = "";
                if (data == 'artificial'){
                    bizType = '人工';
                }
                if (data == 'intelligence'){
                    bizType = '智能';
                }
                    //    bizType = '积分兑换红包';
                    //}
                //if (data == 'point_exchange_hb'){
                //    bizType = '积分兑换红包';
                //}
                //if (data == 'express_query'){
                //    bizType = '快递查询';
                //}
                //if (data == 'receive_common_hb'){
                //    bizType = '普通红包领取';
                //}
                //if (data == 'praise_receive_hb'){
                //    bizType = '好评返红包';
                //}
                //if (data == 'share_receive_hb'){
                //    bizType = '分享送红包';
                //}
                //if (data == 'sign_in'){
                //    bizType = '签到';
                //}
                //if (data == 'user_validate'){
                //    bizType ='用户验证';
                //}
                //if (data == 'point_query'){
                //    bizType = '积分查询';
                //}
                return bizType;
            },
            "targets": 7
        }, {
            "render": function (data, type, row) {

                var datetime = new Date();
                datetime.setTime(data);
                var year = datetime.getFullYear();
                var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
                var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
                var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
                var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
                var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
                return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;



            },
            "targets": 8
        },
        {
            "render": function (data, type, row) {

                var datetime = new Date();
                datetime.setTime(data);
                var year = datetime.getFullYear();
                var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
                var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
                var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
                var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
                var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
                return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
            },
            "targets": 9
        },
//                    {"visible": false, "targets": [3]}
    ],
    "sort": false,
    "columns": [
        {"data": "wxOpenid"},
        {"data": "wxNickName"},
        {"data": "mobile"},
        {"data": "content"},
        {"data": "msgType"},
        {"data": "times"},
        {"data": "firstSource"},
        {"data": "replyType"},
        {"data": "createTime"},
        {"data": "replyCreateTime"},
        {"data": "replyContent"},
    ]
});



$("#userWXMessageQueryForm").submit(function () {
    $('#userWXMessageQueryTable').DataTable().draw()
    return false; //阻止表单默认提交
});


$("#replyButton").click(function (event){
    event.preventDefault()
    if (confirm("确定要发送吗")) {
        var checks = $(".table td :input[type='checkbox']:checked");

        if (checks.length == 0) {
            alert("没有选中的,请选择要发送的记录！");
            return;
        }
        var ids = [];
        $.each(checks, function (index, check) {

            ids.push($(check).val());
        });

        var content = $("#pointReplyForm :input[name='content']").val();

        $.ajax({
            type : "post",
            url : baseUrl+"integral/sendMessageToUser",
            data : {openId:ids.toString(),content:content},
            dataType : "json",
            success : function(data){
                if (data.errorCode == '0'){
                    alert("发送成功！");
                    $('#userWXMessageQueryTable').DataTable().draw();
                }else{
                    alert("发送失败！");
                    return false;
                }
            }
        });
    }
});

$(".ace").click(function(){

    selectAll();
})

function selectAll(){
    var a = $(".ace");
    if($(".ace").prop("checked")){

        for(var i = 0;i<a.length;i++){
            if(a[i].type == "checkbox") a[i].checked = true;
        }
    }
    else {

        for (var i = 0; i < a.length; i++) {
            if (a[i].type == "checkbox") a[i].checked = false;
        }
    }
}







