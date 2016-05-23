$('#searchForm')[0].reset();
//1.全选，所有box选中，此时只记一个标志，sms[2]=1,如果撤销几个，记录去除的id，后台处理，判断一把
//2.非全选，sms[2]=0,记录选中的id，如果此时全选了，sms[2]=0,清空记录去除的id
//3.取消，sms[2]=0,清空原有数据，所有box不选中，查询条件重置查询一把
//两个tab，共用一个临时数组用来处理，提交时判断当前状态，发送哪一个,两个查询合并

//临时存放已选择用户的数量,userData[0]每次刷新筛选table时的用户数,userData[1]用户手动选择数量,userData[2]是否全选，userData[3]最终选择的用户,
var userData = [0,0,0,0,0];
//初始化数组，userList用来保存形如[userId:mobile]数据，emailList用来保存形如[userId:email]数据
var userList = new zArray();
var emailList = new zArray();

//默认为成功购买用户列表
var isSuccessCustom = [1];
var modalData = [0];
//tab切换
$('#purchase_tab').click(function(){
    if ($('#status').val() == 'POTENTIAL_PURCHASE'){
        $('#cancelAllBut').click();
        tableModal.draw();
    }
    $('#status').val('SUCCESS_PURCHASE');
    $('.goEmail').show();
    $('.hasEmail').show();
    isSuccessCustom[0] = 1;
    $('.wxOption').show();
});
$('#potential_tab').click(function(){
    if ($('#status').val() == 'SUCCESS_PURCHASE'){
        $('#cancelAllBut').click();
        potentialTable.draw();
    }
    $('#status').val('POTENTIAL_PURCHASE');
    $('.goEmail').hide();
    $('.hasEmail').hide();
    isSuccessCustom[0] = 0;
    $('.wxOption').hide();
});
//条件查询
$('#SearchBut').click(function(){
    if ($('#status').val() == 'SUCCESS_PURCHASE'){
        tableModal.draw();
    }else{
        potentialTable.draw();
    }
    userList.clear();
    emailList.clear();
    userData[2] = 0;
    userData[3] = 0;
    $(".userListTable_Num").html('0');
    $(".potentialUserTable_Num").html('0');
    $('table .box-head').closest('table').find('tr > td:first-child input:checkbox')
        .each(function(){
            $(this).prop('checked','');
        }
    );
})

//全选
$("#selectAllBut").click(function(){
    var source = $("#searchForm input[name='source']").val();
    var start = $("#searchForm input[name='startContribution']").val();
    var end  = $("#searchForm input[name='endContribution']").val();
    userList.clear();
    emailList.clear();
    userData[2] = 1;
    userData[3] = userData[0];
    userData[4] = userData[0];
    if ($('#status').val() == 'SUCCESS_PURCHASE'){
        if (source != ''|| start != '' || end != ''){
            userData[3] = modalData[0];
            userData[4] = modalData[0];
        }
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
    $("#searchForm input[name='source']").val('');
    $("#searchForm input[name='startContribution']").val('');
    $("#searchForm input[name='endContribution']").val('');
    $("#searchForm")[0].reset();
    userList.clear();
    emailList.clear();
    userData[2] = 0;
    userData[3] = 0;
    $(".userListTable_Num").html('0');
    $(".potentialUserTable_Num").html('0');
    $('table .box-head').closest('table').find('tr > td:first-child input:checkbox')
        .each(function(){
            $(this).prop('checked','');
        }
    );
    return false;
});

//封装数组操作，增删查
function zArray(){
    var zArr = new Array();
    this.in_array =  function(val){
        for(var i=0;i<zArr.length;i++)
        {
            if(zArr[i] == val)
                return true;
        }
        return false;
    }
    this.deleteA = function(val){
        var pos = -1;
        if (this.in_array(val)){
            for (var i=0;i<zArr.length;i++){
                if (zArr[i] == val){
                    pos = i;
                }
            }
        }
        if (pos > -1) {
            zArr.splice(pos, 1);
            return true;
        }
        return false;
    }
    this.addElement = function(val){
        if (!this.in_array(val)){
            zArr.push(val);
            return true;
        }
        return false;
    }
    this.clear = function(){
        if (zArr.length > 0){
            zArr.length = 0;
            return true;
        }
    }
    this.getElement = function(){
        return zArr;
    }
    this.length = function(){
        return zArr.length;
    }
}

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

//非全选时定向选择用户，数据存放在临时数组里 arr:用户保存数据的临时数组，boxName:单选框name
function addData(arr,tableID,boxName,idList,eList){
    //手动单个选择
    var i=0 ,j=0;
    var $checkBox = $('#'+tableID+'  :checkbox[name="'+boxName+'"]');
    $.each($checkBox,function(){
        var userId = $(this).attr('value');
        var info = $(this).parent().parent().siblings().eq(4).text();
        var val;
        if (info != '无' || info != null || info != ''){
            val = userId+':'+info;
        }

        if (eList != null){
            var email = $(this).parent().parent().siblings().eq(5).text();
            var efo;
            if (email != '无' || email != null || email != ''){
                efo = userId+':'+email;
            }
        }
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
                        if (eList != null && email != '无' && email != ''){
                            eList.deleteA(efo);
                            arr[4]++;
                        }
                        arr[3]++;
                    }
                }else{
                    if (!idList.in_array(val)){
                        idList.addElement(val);
                        if (eList != null && email != '无' && email != ''){
                            eList.addElement(efo);
                            arr[4]++;
                        }
                        arr[3]++;
                    }
                }
            }else {
                if (arr[2] == 1){
                    if (!idList.in_array(val)){
                        idList.addElement(val);
                        if (eList != null && email != '无' && email != ''){
                            eList.addElement(efo);
                            arr[4]--;
                        }
                        arr[3]--;
                    }
                }else{
                    if (idList.in_array(val)){
                        idList.deleteA(val);
                        if (eList != null && email != '无' && email != ''){
                            eList.deleteA(efo);
                            arr[4]--;
                        }
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
                var seval;
                if (fo != '无' || fo != null || fo != ''){
                    seval = id+':'+fo;
                }

                if (eList != null){
                    var mail = $(this).parent().parent().siblings().eq(5).text();
                    var einfo;
                    if (mail != '无' || mail != null || mail != ''){
                        einfo = id+':'+mail;
                    }

                }

                if (this.checked){
                    if (arr[2] == 1){
                        if (idList.in_array(seval)){
                            idList.deleteA(seval);
                            if (eList != null && mail != '无' && mail != ''){
                                eList.deleteA(einfo);
                                arr[4]++;
                            }
                            arr[3]++;
                        }
                    }else{
                        if (!idList.in_array(seval)){
                            idList.addElement(seval);
                            if (eList != null && mail != '无' && mail != ''){
                                eList.addElement(einfo);
                                arr[4]++;
                            }
                            arr[3]++;
                        }
                    }
                }else{
                    if (arr[2] == 1){
                        if (!idList.in_array(seval)){
                            idList.addElement(seval);
                            if (eList != null && mail != '无' && mail != ''){
                                eList.addElement(einfo);
                                arr[4]--;
                            }
                            arr[3]--;
                        }
                    }else{
                        if (idList.in_array(seval)){
                            idList.deleteA(seval);
                            if (eList != null && mail != '无' && mail != ''){
                                eList.deleteA(einfo);
                                arr[4]--;
                            }
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
        "url":  baseUrl+"knowCustomer/customerList",
        "data": function (d) {
            var name = $("#searchForm input[name='name']").val();
            var source = $("#searchForm select[name='tempSource'] option:selected").val();
            var keyword = $("#searchForm input[name='keyword']").val();
            var time = $("#searchForm select[name='time'] option:selected").val();
            d.name = name;
            d.source = source;
            d.keyword = keyword;
            d.time = time;
            d.customPurchaseType="POTENTIAL_PURCHASE";

            var type = '';
            $("#searchForm input[name='type']").each(function(){
                if(this.checked){
                    type = $(this).val();
                }
            })
            if (type == 'mobile'){
                d.hasMobile = '1';
            }
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
    "ajax": {
        "url":  baseUrl+"knowCustomer/customerList",
        "data": function (d) {
            var name = $("#searchForm input[name='name']").val();
            var tempsource = $("#searchForm select[name='tempSource'] option:selected").val();
            var keyword = $("#searchForm input[name='keyword']").val();
            var time = $("#searchForm select[name='time'] option:selected").val();

            var source = $("#searchForm input[name='source']").val();
            var startContribution = $("#searchForm input[name='startContribution']").val();
            var endContribution = $("#searchForm input[name='endContribution']").val();
            var type = '';
            d.name = name;
            d.keyword = keyword;
            d.time = time;
            d.startContribution = startContribution;
            d.endContribution = endContribution;
            d.customPurchaseType="SUCCESS_PURCHASE";
            d.isSuccessCustom = "1";

            $("#searchForm input[name='type']").each(function(){
                    if(this.checked){
                        if (type != ''){
                            type = type+','+$(this).val();
                        }else{
                            type = $(this).val();
                        }

                    }
            })
            if (type == 'mobile'){
                d.hasMobile = '1';
            }else if (type == 'email'){
                d.hasEmail = '1';
            }else if (type == 'mobile,email'){
                d.hasMobile = '1';
                d.hasEmail = '1';
            }

            if (tempsource != null && tempsource != ''){
                d.source = tempsource;
            }else if(source != null && source != ''){
                d.source = source;
            }
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
                    return '<label><a href="javascript:void(0);" onclick="goPortriat('+row.userId+')">'+data+'</a></label>';
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
                if (data == null || data == ''){
                    return '无';
                }else{
                    return data;
                }
            },
            "targets": 5
        },{
            "render": function (data, type, row) {
                if (data == null || data == ''){
                    return '无';
                }else{
                    return data;
                }
            },
            "targets": 6
        },{
            "render": function (data, type, row) {
                if (data == null ){
                    return '无';
                }else{
                    return data+'/'+row.city;
                }
            },
            "targets": 7
        },{
            "render": function (data, type, row) {
                if (data == null || data <= 0){
                    return '0天';
                }else{
                    return data+'天';
                }
            },
            "targets": 8
        },{
            "render": function (data, type, row) {
                if (data == null || data <= 0){
                    return '￥0元';
                }else{
                    return "￥ "+(data/100).toFixed(2)+"元";
                }
            },
            "targets": 9
        },{
            "render": function (data, type, row) {
                if (data == null || data <= 0){
                    return '0次';
                }else{
                    return data+'次';
                }
            },
            "targets": 10
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '无';
                }else{
                    return getLocalTime(data);
                }
            },
            "targets": 11
        },{
            "render": function (data, type, row) {
                return data.replace(/TB/g,"淘宝").replace(/TMALL/g,"天猫").replace(/JD/g,"京东").replace(/WX/g,"微信").replace(/YZ/g,"有赞");
            },
            "targets": 13
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
                    return  '有赞';
                }
            },
            "targets": 12
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '0';
                }else{
                    return data;
                }
            },
            "targets": 14
        }
    ],
    "fnDrawCallback": function(data){
        $('#userListTable .box-head').prop('checked','');
        userData[0] = data.json.recordsTotal;
        modalData[0]= data.json.recordsTotal;
        if (userData[2] == 1){
            allSelect('purchase_customer_table',userList);
        }
        addData(userData,'userListTable','userBox',userList,emailList);
    },
    "aaSorting": [
        [ 11, "desc" ]
    ],
    "columns": [
        {"data":"id","sortable": false},
        {"data": "name","sortable": false},
        {"data":"wxNickName","sortable": false},
        {"data": "tbBuyerNick","sortable": false},
        {"data": "jdPin","sortable": false},
        {"data": "mobile","sortable": false},
        {"data": "email","sortable": false},
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

//转到用户画像页面
function goPortriat(val){
    $.ajax({
        type : "post",
        url : baseUrl+"knowCustomer/withPortrait",
        data : {userId:val},
        dataType : "json",
        success : function(data){
            if (data.count == 1){
                $('#userportraitModal iframe').attr('src',baseUrl+'knowCustomer/userPortrait?userId='+val);
                $('#userportraitModal').modal('show');
            }else{
                alert("该用户画像不存在");
                return false;
            }
        }
    });
}

//创建短信营销活动
$('#goSmsMarketing').click(function(){
    var data = $('#searchForm').serialize();
    var firstSource = null;
    var source = $("#searchForm input[name='source']").val();
    var tempSource = $("#searchForm select[name='tempSource'] option:selected").val();
    if (source != ''){
        source = source;
    }else{
        source = tempSource;
    }

    data = data+"&source="+source+"&userParams="+userList.getElement()
        +"&isSelectAll="+userData[2]+"&allSelectCount="+userData[3]+"&isSuccessCustom="+isSuccessCustom[0];
    freshUrl(baseUrl+"contactCustomer/smsMarketing?data="+data);
});

//创建邮件营销活动
$('#goEmailMarketing').click(function(){
    var data = $('#searchForm').serialize();
    var source = null;
    var source = $("#searchForm input[name='source']").val();
    var tempSource = $("#searchForm select[name='tempSource'] option:selected").val();
    if (source != ''){
        source = source;
    }else{
        source = tempSource;
    }

    data = data+"&source="+source+"&userParams="+emailList.getElement()
        +"&isSelectAll="+userData[2]+"&allSelectCount="+userData[4]+"&isSuccessCustom="+isSuccessCustom[0];

    freshUrl(baseUrl+"contactCustomer/emailMarketing?data="+data);
});

$("#searchForm input[name='type']").each(function(){
    $(this).click(function(){
        if ($('#status').val() == 'SUCCESS_PURCHASE'){
            tableModal.draw();
        }else{
            potentialTable.draw();
        }
    })
})