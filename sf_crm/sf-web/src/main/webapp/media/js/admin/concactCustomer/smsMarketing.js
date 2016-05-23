
var isRefresh = 0;//用户是否重新选择
createToken('markActForm');
//表单重置
$('#markActForm')[0].reset();

//显示用户已经选择多少条记录
function submitsmsUser(){
    $('.userNum').html(userData[3]);
    return false;
}

//点击 “发送”  按钮，发送营销信息
$("#sendActBut").click(function(){
    var userCount = $('.userNum').html();
    if ( userCount <= 0){
        alert('请先选择用户;');
        return false;
    }
    var title = $("#markActForm input[name='title']").val();
    var target =$("#markActForm input[name='target']:checked").val();
    var content = $("#markActForm textarea[name='content']").val();
    var exeTimeType = $("#markActForm input[name='exeTimeType']:checked").val();
    var  executeTime = $("#markActForm input[name='executeTime']").val();
    if (title == ''){
        alert('营销主题不能为空');
        return false;
    }else if(target == undefined ){
        alert('营销目的不能为空');
        return false;
    }else if (content == ''){
        alert('营销内容不能为空');
        return false;
    }else if (exeTimeType == undefined){
        alert('执行时间方式不能为空');
        return false;
    }else if (exeTimeType == '1' && executeTime == ''){
        alert('执行时间不能为空');
        return false;
    }

    var sign = $("#markActForm input[name='smsSign']").val();
    var content = $("#markActForm textarea[name='content']").val();
    var smsContent = '【'+sign+'】'+content;
    if (getLength(smsContent) > 64 ){
        alert('输入的内容过长');
        return false;
    }

    if (isRefresh == 1){
        $("#markActForm input[name='userParams']").val(userList);
        $("#markActForm input[name='isSelectAll']").val(userData[2]);
        $("#markActForm input[name='isSuccessCustom']").val(isSuccessCustom[0]);
    }

    var userNum = $('.userNum').html();
    var smsCount = $('#remainCount').html();
    if (parseInt(userNum) > parseInt(smsCount)){
        alert('对不起，您的短信剩余条数不足，请及时充值');
        return false;
    }

    var data = $("#markActForm").serialize();
    $.ajax({
        type: "post",
        url:  baseUrl+"contactCustomer/sendActivity",
        data: data,
        dataType: "json",
        success: function(json){
            if (json.errorCode == 0){
                alert("活动发送成功！");
                window.location.reload();
            }else{
                alert("亲，对不起，此次活动发送失败！");
                window.location.reload();
            }
        }
    });
})

var sign = $("#markActForm input[name='smsSign']").val();
var leftAll = 62-getLength(sign);

$("#markActForm textarea[name='content']").focus(function(){
    var content = $(this).val();
    if (leftAll-getLength(content) < 0){
        var tex = '输入字数超过限制！';
    }else{
        var tex = '您还可以输入'+(leftAll-getLength(content))+'字';
    }
    $('#left-p').html(tex);
    $('#left-p').show();
})

$("#markActForm textarea[name='content']").blur(function(){
    $('#left-p').hide();
    var sign = $("#markActForm input[name='smsSign']").val();
    var content = $(this).val();
    var smsContent = '【'+sign+'】'+content;
    if (getLength(smsContent) > 64 ){
        alert('输入的内容过长');
        return;
    }
})

//校验输入字符数
function verifyResidueMsg() {
    var $words = $("#markActForm textarea[name='content']");
    //汉字的个数
    var msgChineseCharacterNum = ($words.val().replace(/\w/g,"")).length;
    //非汉字的个数
    var msgWordsNum = $words.val().length - msgChineseCharacterNum;
    var total = msgChineseCharacterNum + msgWordsNum;

    if(total <= leftAll){
        var texts = leftAll - total;
        $('#left-p').html('您还可以输入\<span style="color:blue;">'+texts+'\</span>字');
    } else{
        $('#left-p').html('输入字数超过限制！');
    }
}

//预览
function preview(){
    var sign = $("#markActForm input[name='smsSign']").val();
    var content = $("#markActForm textarea[name='content']").val();
    var smsContent = '【'+sign+'】'+content;
    if (getLength(smsContent) > 64 ){
        alert('输入的内容过长');
        return;
    }
    var text = $("textarea[name='content']").val();
    if (text == null || text == ''){
        $(".textContent").html('请在左边填写要短信内容,然后点击预览');
        alert('内容不能为空');
    }else{
        $(".textContent").html('【'+sign+'】'+text+'回复TD退订');
    }
}

$('#testBut').click(function(){
    $('#smsTestModal').modal('show');
    return false;
})

//短信测试
$('#smsTest').click(function(){

    var title = $("#markActForm input[name='title']").val();
    var testMobile = $("#smsTestModal input[name='testMobile']").val();
    var target =$("#markActForm input[name='target']:checked").val();
    var content = $("#markActForm textarea[name='content']").val();
    if (testMobile == ''){
        alert("测试手机号不能为空");
        return false;
    }
    if (!isPhone(testMobile)){
        alert('手机号格式错误');
        return false;
    }
    if (title == ''){
        alert('营销标题不能为空');
        return false;
    }
    if (target == ''){
        alert('营销目的不能为空');
        return  false;
    }
    if (content == ''){
        alert('营销内容不能为空');
        return false;
    }

    $.post(baseUrl+'contactCustomer/smsTest',{mobile:testMobile,target:target,title:title,content:content},function(data){
        if (data.errorCode == '0'){
            alert(data.errorMessage);
            $('#smsTestModal').modal('hide');
        }else{
            alert(data.errorMessage);
        }
    });
})

//页面切换
$("input[name='type']").click(function(){
    var selected = $(this).val();
    if (selected == 'email'){
        freshUrl(baseUrl+"contactCustomer/emailMarketing");
    }else if (selected == 'wx'){
        freshUrl(baseUrl+"contactCustomer/wxMarketing");
    }
});
//重新按钮
$('#selectAgain').click(function(){
    isRefresh = 1;
    selectUser();
})

//判断字符串长度，包括
function getLength(str){
    var realLength = 0;
    for (var i = 0; i < str.length; i++)
    {
        charCode = str.charCodeAt(i);
        if (charCode >= 0 && charCode <= 128)
            realLength += 1;
        else
            realLength += 1;
    }
    return realLength;
}

//临时存放已选择用户的数量,sms[0]每次刷新筛选table时的用户数,sms[1]用户手动选择数量,sms[2]是否全选，sms[3]最终选择的用户数
var userData = [0,0,0,0];
var userList = initialArry();

var isSuccessCustom = [1];

//单页选中
function allSelect(id,list){
    $('#'+id+' table .box-head').closest('table').find('tr > td:first-child input:checkbox')
        .each(function(){
            var userId = $(this).val();
            var info = $(this).parent().parent().siblings().eq(4).text();
            var val = userId+':'+info;
            if (!list.in_array(val)){
                $(this).prop('checked','checked');
            }
        }
    );
}
//初始化数组，用来保存用户手动选中的用户的userId
function initialArry(){
    //保存已选用户的信息数组
    var idList = new Array();
    Array.prototype.in_array =  function(e)
    {
        for(var i=0;i<this.length;i++)
        {
            if(this[i] == e)
                return true;
        }
        return false;
    }
    Array.prototype.deleteA = function(val){
        var pos = -1;
        if (idList.in_array(val)){
            for (var i=0;i<this.length;i++){
                if (this[i] == val){
                    pos = i;
                }
            }
        }
        if (pos > -1) {
            this.splice(pos, 1);
            return true;
        }
        return false;
    }
    Array.prototype.addElement = function(val){
        var info = val;
        if (!idList.in_array(info)){
            idList.push(info);
            return true;
        }
        return false;
    }
    return idList;
}

//非全选时定向选择用户，数据存放在临时数组里 arr:用户保存数据的临时数组，boxName:单选框name
function addData(arr,tableID,boxName,idList){
    //手动单个选择
    var i=0 ,j=0;
    var $checkBox = $('#'+tableID+'  :checkbox[name="'+boxName+'"]');
    $.each($checkBox,function(){
        var userId = $(this).attr('value');
        var info = $(this).parent().parent().siblings().eq(4).text();
        if (info == '无' || info == null){
            info = '';
        }
        var val = userId+':'+info;
        if (idList.in_array(val)){
            if (arr[2] == 1){
                $(this).prop('checked','');
            }else{
                $(this).prop('checked','checked');
            }
            i++;
        }
        j++;
        //$(this).unbind('click');
        $(this).on('click',function(){
            if($(this).prop('checked')){
                if (arr[2] == 1){
                    if (idList.in_array(val)){
                        idList.deleteA(val);
                        arr[3]++;
                    }
                }else{
                    if (!idList.in_array(val)){
                        idList.addElement(val);
                        arr[3]++;
                    }
                }
            }else {
                if (arr[2] == 1){
                    if (!idList.in_array(val)){
                        idList.addElement(val);
                        arr[3]--;
                    }
                }else{
                    if (idList.in_array(val)){
                        idList.deleteA(val);
                        arr[3]--;
                    }
                }
            }
            arr[1] = idList.length;
            $("."+tableID+"_Num").html(arr[3]);
        });
    });

    if (i == j && arr[2] != 1){
        $('#'+tableID+' .box-head').prop('checked','checked');
    }else if(i == j && arr[2] == 1){
        $('#'+tableID+' .box-head').prop('checked','');
    }

    //单页全选
    //$('#'+tableID+' .box-head').unbind('click');
    $('#'+tableID+' .box-head').on('click' , function(){
        var that = this;
        $(this).closest('table').find('tbody tr > td:first-child input:checkbox')
            .each(function(){
                this.checked = that.checked;
                var id = $(this).attr('value');
                var fo = $(this).parent().parent().siblings().eq(4).text();
                if (fo == '无' || fo == null){
                    fo = '';
                }
                var seval = id+':'+fo;

                if (this.checked){
                    if (arr[2] == 1){
                        if (idList.in_array(seval)){
                            idList.deleteA(seval);
                            arr[3]++;
                        }
                    }else{
                        if (!idList.in_array(seval)){
                            idList.addElement(seval);
                            arr[3]++;
                        }
                    }
                }else{
                    if (arr[2] == 1){
                        if (!idList.in_array(seval)){
                            idList.addElement(seval);
                            arr[3]--;
                        }
                    }else{
                        if (idList.in_array(seval)){
                            idList.deleteA(seval);
                            arr[3]--;
                        }
                    }
                }
            }
        );
        arr[1] = idList.length;
        $("."+tableID+"_Num").html(arr[3]);
    });
}

function selectUser(){
    $('#cancelAllBut').click();
    $('#successLi').addClass('active').siblings().removeClass('active');
    //tab切换
    $('#purchase_tab').click(function(){
        if ($('#status').val() == 'POTENTIAL_PURCHASE'){
            $('#cancelAllBut').click();
            tableModal.draw();
        }
        $('.buy-times').show();
        $('.blank-padding').hide();
        $('#status').val('SUCCESS_PURCHASE');
        isSuccessCustom[0] = 1;
        $('.wxLabel').show();
    });
    $('#potential_tab').click(function(){
        if ($('#status').val() == 'SUCCESS_PURCHASE'){
            $('#cancelAllBut').click();
            potentialTable.draw();
        }
        $('.buy-times').hide();
        $('.blank-padding').show();
        $('#status').val('POTENTIAL_PURCHASE');
        isSuccessCustom[0] = 0;
        $('.wxLabel').hide();
    });
    //条件查询
    $('#SearchBut').click(function(){
        if ($('#status').val() == 'SUCCESS_PURCHASE'){
            tableModal.draw();
        }else{
            potentialTable.draw();
        }
        userData[2] = 0;
        userList.length = 0;
        userData[3] = 0;
        $(".userListTable_Num").html('0');
        $(".potentialUserTable_Num").html('0');
        $('table .box-head').closest('table').find('tr > td:first-child input:checkbox')
            .each(function(){
                $(this).prop('checked','');
            }
        );
        return false;
    })
    //全选
    $("#selectAllBut").click(function(){
        userList.length = 0;
        userData[2] = 1;
        userData[3] = userData[0];
        if ($('#status').val() == 'SUCCESS_PURCHASE'){
            $(".userListTable_Num").html(userData[3]);
            allSelect('purchase_customer_table',userList);
        }else{
            $(".potentialUserTable_Num").html(userData[3]);
            allSelect('potential_customer_table',userList);
        }
        return false;
    });
    //取消
    $('#cancelAllBut').click(function(){
        userData[2] = 0;
        userList.length = 0;
        userData[3] = 0;
        $('#smsClientSelectedForm')[0].reset();
        $(".userListTable_Num").html('0');
        $(".potentialUserTable_Num").html('0');
        $('table .box-head').closest('table').find('tr > td:first-child input:checkbox')
            .each(function(){
                $(this).prop('checked','');
            }
        );
        //$('#SearchBut').click();
        return false;
    });
    //潜在客户列表
    var potentialTable = $('#potentialUserTable').DataTable({
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
        "bDestroy":true,
        "processing": true,
        "searching": false,
        "serverSide": true,
        "ajax": {
            "url":  baseUrl+"contactCustomer/concactUser",
            "data": function (d) {
                var keyword = $("#smsClientSelectedForm input[name='keyword']").val();
                var source = $("#smsClientSelectedForm input[name='source']:checked").val();
                var purchasePrice = $("#smsClientSelectedForm input[name='purchasePrice']:checked").val();
                var minPrice = $("#smsClientSelectedForm input[name='minPrice']").val();
                var maxPrice = $("#smsClientSelectedForm input[name='maxPrice']").val();
                var purchaseNum = $("#smsClientSelectedForm input[name='purchaseNum']:checked").val();

                d.keyword = keyword;
                d.source = source;
                d.purchasePrice = purchasePrice;
                d.minPrice = minPrice;
                d.maxPrice = maxPrice;
                d.purchaseNum = purchaseNum;
                d.hasMobile = "1";
                d.customPurchaseType="POTENTIAL_PURCHASE";
            }
        },
        "aaSorting": [
            [ 7, "desc" ]
        ],
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    return '<td class="center"><label><input name="potentialBox" type="checkbox" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
                },
                "targets": 0
            },{
                "render": function (data, type, row) {
                    if (data == null){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 1
            },{
                "render": function (data, type, row) {
                    if (data == null){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 2
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 3
            },{
                "render": function (data, type, row) {
                    if (data == 'WAIT_BUYER_PAY' ){
                        return '等待买家付款';
                    }else if (data == 'TRADE_CLOSED_BY_TAOBAO' || data == 'TRADE_CLOSED' || data =='TRADE_CANCELED'){
                        return '交易关闭';
                    }
                    return data;
                },
                "targets": 4
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data+'/'+row.city;
                    }
                },
                "targets": 6
            },{
                "render": function (data, type, row) {
                    if (data == null || data <= 0){
                        return '0天';
                    }else{
                        return getLocalTime(data);
                    }
                },
                "targets": 7
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 5
            },{
                "render": function (data, type, row) {
                    if (data == null || data <= 0){
                        return '￥0元';
                    }else{
                        return "￥ "+data+"元";
                    }
                },
                "targets": 8
            },{
                "render": function (data, type, row) {
                    if (data == null){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 9
            }
        ],
        "fnDrawCallback": function(data){
            $('#potentialUserTable .box-head').prop('checked','');
            userData[0] = data.json.recordsTotal;
            if (userData[2] == 1){
                allSelect('potential_customer_table',userList);
            }
            addData(userData ,'potentialUserTable','potentialBox',userList);
            if (data.json.userVO != undefined){
                $("#markActForm input[name='source']").val(data.json.userVO.source);$("#markActForm input[name='startContribution']").val(data.json.userVO.startContribution);
                $("#markActForm input[name='endContribution']").val(data.json.userVO.endContribution);$("#markActForm input[name='name']").val(data.json.userVO.name);
                $("#markActForm input[name='keyword']").val(data.json.userVO.keyword);$("#markActForm input[name='time']").val(data.json.userVO.time);
                $("#markActForm input[name='minPrice']").val(data.json.userVO.minPrice);$("#markActForm input[name='maxPrice']").val(data.json.userVO.maxPrice);
                $("#markActForm input[name='purchaseNum']").val(data.json.userVO.purchaseNum);$("#markActForm input[name='userParams']").val(data.json.userVO.userParams);
                $("#markActForm input[name='isSelectAll']").val(data.json.userVO.isSelectAll);$("#markActForm input[name='isSuccessCustom']").val(data.json.userVO.isSuccessCustom);
                $("#markActForm input[name='hasMobile']").val(data.json.userVO.hasMobile);
            }
        },
        "columns": [
            {"data":"receiverId","sortable": false},
            {"data":"tid","sortable": false},
            {"data": "receiverName","sortable": false},
            {"data": "buyerNick","sortable": false},
            {"data": "status","sortable": false},
            {"data": "mobile","sortable": false},
            {"data": "province","sortable": false},
            {"data": "created"},
            {"data": "price","sortable": false},
            {"data": "shopName","sortable": false}
        ]
    });

    var htx = '<span id="potentialUserTable_Se" class="col-sm-10">已选择<b style="padding: 0 4px;font-size: 16px;" class="potentialUserTable_Num">0</b>位客户</span>';
    $("#potentialUserTable_length").append(htx);


    //成功购买客户列表
    var tableModal = $('#userListTable').DataTable({
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
        "bDestroy":true,
        "processing": true,
        "searching": false,
        "serverSide": true,
        "bAutoWidth":true,
        "ajax": {
            "url":  baseUrl+"contactCustomer/concactUser",
            "data": function (d) {
                var keyword = $("#smsClientSelectedForm input[name='keyword']").val();
                var source = $("#smsClientSelectedForm input[name='source']:checked").val();
                var purchasePrice = $("#smsClientSelectedForm input[name='purchasePrice']:checked").val();
                var minPrice = $("#smsClientSelectedForm input[name='minPrice']").val();
                var maxPrice = $("#smsClientSelectedForm input[name='maxPrice']").val();
                var purchaseNum = $("#smsClientSelectedForm input[name='purchaseNum']:checked").val();

                d.keyword = keyword;
                d.source = source;
                d.purchasePrice = purchasePrice;
                d.minPrice = minPrice;
                d.maxPrice = maxPrice;
                d.purchaseNum = purchaseNum;
                d.hasMobile = "1";
                d.customPurchaseType="SUCCESS_PURCHASE";
                d.isSuccessCustom = "1";
            }
        },
        "columnDefs": [
            {
                "render": function (data, type, row) {
                    return '<td class="center"><label><input name="userBox" type="checkbox"class="ace" value="'+row.userId+'"/><span class="lbl"></span></label></td>';
                },
                "targets": 0
            },{
                "render": function (data, type, row) {
                    if (data == null){
                        return '';
                    }else{
                        return data;
                    }
                },
                "targets": 1
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 2
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 3
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 4
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data;
                    }
                },
                "targets": 5
            },{
                "render": function (data, type, row) {
                    if (data == null ){
                        return '无';
                    }else{
                        return data+'/'+row.city;
                    }
                },
                "targets": 6
            },{
                "render": function (data, type, row) {
                    if (data == null || data <= 0){
                        return '0天';
                    }else{
                        return data+'天';
                    }
                },
                "targets": 7
            },{
                "render": function (data, type, row) {
                    if (data == null || data <= 0){
                        return '￥0元';
                    }else{
                        return "￥ "+(data/100).toFixed(2)+"元";
                    }
                },
                "targets": 8
            },{
                "render": function (data, type, row) {
                    if (data == null || data <= 0){
                        return '0次';
                    }else{
                        return data+'次';
                    }
                },
                "targets": 9
            },{
                "render": function (data, type, row) {
                    if (data == null){
                        return '无';
                    }else{
                        return getLocalTime(data);
                    }
                },
                "targets": 10
            },{
                "render": function (data, type, row) {
                    return data.replace(/TB/g,"淘宝").replace(/TMALL/g,"天猫").replace(/JD/g,"京东").replace(/WX/g,"微信").replace(/YZ/g,"有赞");
                },
                "targets": 12
            },{
                "render": function (data, type, row) {
                    if (data == null){
                        return '无';
                    }else if (data == "TB"){
                        return '淘宝';
                    }else if (data == "TMALL"){
                        return '天猫';
                    }else if (data == 'JD'){
                        return '京东';
                    }else if (data == 'WX'){
                        return '微信';
                    }else if (data == 'YZ'){
                        return '有赞';
                    }
                },
                "targets": 11
            },{
                "render": function (data, type, row) {
                    if (data == null){
                        return '0';
                    }else{
                        return data;
                    }
                },
                "targets": 13
            }
        ],
        "fnDrawCallback": function(data){
            $('#userListTable .box-head').prop('checked','');
            userData[0] = data.json.recordsTotal;
            if (userData[2] == 1){
                allSelect('purchase_customer_table',userList);
            }
            addData(userData,'userListTable','userBox',userList);

            $("#markActForm input[name='source']").val(data.json.userVO.source);$("#markActForm input[name='startContribution']").val(data.json.userVO.startContribution);
            $("#markActForm input[name='endContribution']").val(data.json.userVO.endContribution);$("#markActForm input[name='name']").val(data.json.userVO.name);
            $("#markActForm input[name='keyword']").val(data.json.userVO.keyword);$("#markActForm input[name='time']").val(data.json.userVO.time);
            $("#markActForm input[name='minPrice']").val(data.json.userVO.minPrice);$("#markActForm input[name='maxPrice']").val(data.json.userVO.maxPrice);
            $("#markActForm input[name='purchaseNum']").val(data.json.userVO.purchaseNum);$("#markActForm input[name='userParams']").val(data.json.userVO.userParams);
            $("#markActForm input[name='isSelectAll']").val(data.json.userVO.isSelectAll);$("#markActForm input[name='isSuccessCustom']").val(data.json.userVO.isSuccessCustom);
            $("#markActForm input[name='hasMobile']").val(data.json.userVO.hasMobile);
            //alert(JSON.stringify(data.json.userVO))
        },
        "aaSorting": [
            [ 10, "desc" ]
        ],
        "columns": [
            {"data":"id","sortable": false},
            {"data": "name","sortable": false},
            {"data":"wxNickName","sortable": false},
            {"data": "tbBuyerNick","sortable": false},
            {"data": "jdPin","sortable": false},
            {"data": "mobile","sortable": false},
            {"data": "province","sortable": false},
            {"data": "purchaseAverageCycle"},
            {"data": "purchaseAverageAmount"},
            {"data": "totalPurchaseTimes"},
            {"data": "lastPurchaseDate"},
            {"data": "firstSource"},
            {"data": "source"},
            {"data": "contribution"}
        ]
    });

    var htm = '<span id="userListTable_Se" class="col-sm-10">已选择<b style="padding: 04px;font-size: 16px;" class="userListTable_Num">0</b>位客户</span>';
    $("#userListTable_length").append(htm);

    $('#smsClientSelectedModal').modal('show');
}

//判断固话或手机格式是否正确
function isPhone(mobile){
    var reg1 = /^0?1[3|4|5|8][0-9]\d{8}$/;
    if (reg1.test(mobile)) {
        return true;
    }
    return false;
}