$('#searchForm')[0].reset();
$("#searchForm input[name='type']").click(function(){
    tableModal.draw();
})

//营销活动查询
var tableModal = $('#marketListTable').DataTable({
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
        "url":  baseUrl+"contactCustomer/marketingList",
        "data": function (d) {
            var type = $("#searchForm input[name='type']:checked").val();
            d.type = type;
        }
    },
    "columnDefs": [{
            "render": function (data, type, row) {
                if (data == "sale"){
                    return "销售";
                }else if (data == "increase_fans"){
                    return "增粉";
                }else if (data == "spread"){
                    return "传播";
                }else if(data == "test"){
                    return "测试";
                }else if (data == "other"){
                    return "其他";
                }
            },
            "targets": 1
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '';
                }else{
                    return data+"人";
                }

            },
            "targets":2
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '0%';
                }
                return data+'%';
            },
            "targets": 3
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '无';
                }
                return data+'%';
            },
            "targets": 4
        },{
            "render": function (data, type, row) {
                if(data != null){
                    return getLocalTime(data);
                }
            },
            "targets":5
        },{
        "render": function (data, type, row) {
            if (data == 'send_success'){
                return '成功';
            }else if (data == 'send_failed'){
                return '失败';
            }else if (data == 'to_send'){
                return '待发送';
            }else if (data == 'send_open'){
                return '已打开';
            }else if (data == 'send_unopen'){
                return '未打开';
            }else if (data == 'send_fatigue'){
                return '疲劳';
            }else if (data == 'send_td'){
                return '疲劳';
            }
        },
        "targets":6
        },{
            "render": function (data, type, row) {
                if(data==null){
                }else
                    return getLocalTime(data);
            },
            "targets":7
        },{
            "render": function (data, type, row) {
                if (row.target == 'test'){
                    return '<label><p><a href="javascript:edit('+row.activityId+');">查看</a>' +
                        '|<a onclick="deleteA('+row.activityId+','+row.executeTime+');" href="javascript:void(0)">删除</a></p></label>';
                }else{
                    return '<label><p><a href="javascript:edit('+row.activityId+');">查看</a>' +
                        '|<a onclick="deleteA('+row.activityId+','+row.executeTime+');" href="javascript:void(0)">删除</a>|<a href="javascript:view('+row.activityId+');">明细</a></p></label>';
                }
            },
            "targets": 8
        }
    ],
    "sort":false,
    "columns": [
        {"data": "title"},
        {"data": "target"},
        {"data": "wxPersonCount"},
        {"data": "successRate"},
        {"data": "openRate"},
        {"data": "executeTime"},
        {"data": "status"},
        {"data": "gmtCreated"},
        {"data": null}
    ]
});

//营销活动编辑
function edit(e){
    var type = $("#searchForm input[name='type']:checked").val();
    if (type == 'sms'){
        $('#textContent').show();
        $('#emailContent').hide();
    }else if (type == 'email'){
        $('#textContent').hide();
        $('#emailContent').show();
    }
    $.ajax({
        type : "post",
        url : baseUrl+"contactCustomer/edit",
        data : {activityId:e},
        dataType : "json",
        success : function(data){
            if (data.errorCode !=-1){
                $('#editForm input[name="activityId"]').attr('value',data.marketResult.activityId);
                $('#editForm input[name="title"]').val(data.marketResult.title).css("color","#333");
                $('#editForm input[name="executeTime"]').val(data.marketResult.executeTime).css("color","#333");
                if (type == 'sms'){
                    $('#textContent').val(data.marketResult.content).css("color","#333");
                }else if (type == 'email'){
                    ue.setContent(data.marketResult.content);
                }
                $('#editForm input[name="target"]').each(function(){
                    if ($(this).val() == data.marketResult.target){
                        $(this).prop('checked','checked');
                    }else{
                        $(this).attr("disabled","disabled");
                    }
                })
                $('#marketingEditModal').modal('show');
            }else{
                alert(data.errorMessage);
            }
        }
    });
}
//保存营销编辑
$('#saveMarketing').click(function(){
    var type = $("#searchForm input[name='type']:checked").val();
    var content;
    if (type == 'sms'){
        content =  $('#textContent').val();
    }else if (type == 'email'){
        content = ue.getContent();
    }
    var datas = $("#editForm").serialize();
    datas = datas +"&content="+content;
    $.ajax({
        async: false,
        type : "post",
        url : baseUrl+"contactCustomer/save",
        data : datas,
        dataType : "json",
        success : function(data){
            if (data.errorCode == 0){
                alert("编辑成功！");
                tableModal.draw();
            }else{
                alert("编辑失败！");
            }
        }
    });
    $('#marketingEditModal').modal('hide');
})

//暂停或开启
function stopA(val){
    $.post(baseUrl+"contactCustomer/stateSwitch",{activityId:val},function(data){
        if (data.errorCode == "0"){
            alert("操作成功");
            tableModal.draw();
        }else{
            alert("操作失败");
        }
    });
}

function view(val){
    var type = $("#searchForm input[name='type']:checked").val();
    freshUrl(baseUrl+'contactCustomer/marketDetail?activityId='+val+'&type='+type);
}

//删除
function deleteA(val,time){
    var now = new Date().getTime();
    var confirm = '';
    if (time > now){
        confirm = '该营销活动还未发送，确定要删除吗？';
    }else{
        confirm = '确定要删除吗？';
    }

    if (window.confirm(confirm)){
        $.post(baseUrl+"contactCustomer/deleteActivity",{activityId:val},function(data){
            if (data.errorCode == "0"){
                alert("操作成功");
                tableModal.draw();
            }else{
                alert("操作失败");
            }
        });
    }
}

