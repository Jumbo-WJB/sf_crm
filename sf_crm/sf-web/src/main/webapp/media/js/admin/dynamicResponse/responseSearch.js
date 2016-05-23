$('#searchForm')[0].reset();
$('#searchBut').click(function(){
    tableModal.draw();
})

var tableModal = $('#responseSearchTable').DataTable({
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
        "url":  baseUrl+"dynamicResponse/responseList",
        "data": function (d) {
            var bizType = $("#searchForm input[name='bizType'] option:selected").val();
            var title = $("#searchForm input[name='title']").val();
            d.bizType = bizType;
            d.title = title;
        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                if (data == null){
                    return '';
                }
                switch (data){
                    case "point_exchange_hb":
                    data = "积分兑换红包";
                    break;
                    case "point_exchange_goods":
                        data = "积分兑换商品";
                        break;
                    case "express_query":
                        data = "快递查询";
                        break;
                    case "receive_common_hb":
                        data = "普通红包领取";
                        break;
                    case "praise_receive_hb":
                        data = "好评返红包";
                        break;
                    case "share_receive_hb":
                        data = "分享送红包";
                        break;
                    case "sign_in":
                        data = "签到";
                        break;
                    case "user_validate":
                        data = "用户验证";
                        break;
                    case "point_query":
                        data = "积分查询";
                        break;
                    case "guide":
                        data = "引导语";
                        break;
                    default :
                        break;
                }
                return data;
            },
            "targets": 1
        },{
            "render": function (data, type, row) {
                if (data == '0'){
                    return '模糊匹配';
                }else{
                    return '精确匹配';
                }
            },
            "targets": 3
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '';
                }
                return getLocalTime(data);
            },
            "targets": 5
        },{
            "render": function (data, type, row) {

                var str = '<label><p><a href="javascript:view('+row.id+');">查看</a>';
                if(row.bizType!='guide'){
                    str = str + '|<a  href=\"javascript:edit('+row.id+');\">编辑</a>'

                        +'|<a href=\"javascript:delet('+row.id+')\">删除</a></p></label>';
                }

                return str;

            },
            "targets": 7
        }
    ],
    "sort":false,
    "columns": [
        {"data": "title"},
        {"data": "bizType"},
        {"data": "keyWord"},
        {"data": "matchType"},
        {"data": "successReplyContent"},
        {"data": "gmtModified"},
        {"data": "failReplyContent"},
        {"data": null}
    ]
});

//查看
function view(id){
    $.post(baseUrl+"dynamicResponse/viewConfig?id="+id,function(data){
        if (data != null){
            $("#editForm input[name='id']").val(data.config.id);
            $("#editForm input[name='title']").val(data.config.title);
            $("#editForm input[name='bizType']").val(data.config.bizType);
            $("#editForm input[name='keyWord']").val(data.config.keyWord);
            $("#editForm textarea[name='successReplyContent']").val(data.config.successReplyContent);
            $('#editForm input[name="matchType"]').each(function(){
                if ($(this).val() == data.config.matchType){
                    $(this).prop('checked','checked');
                }
            })
        }
    });
    $("#editModal").modal("show");
}

//编辑
function edit(id){
    view(id);
    $('#editDiv').show();
}

//删除
function delet(id){
    $.post(baseUrl+"dynamicResponse/deleteConfig?id="+id,function(data){
        if (data.errorCode == '0'){
            alert('删除成功');
        }else{
            alert('删除失败');
        }
    });
}

$('#saveMarketing').click(function(){
    var data = $('#editForm').serialize();

    $.post(baseUrl+'dynamicResponse/saveConfig',data,function(data){
        if (data.errorCode = '0'){
            alert('编辑成功');
        }else{
            alert('编辑失败');
        }
    });
});