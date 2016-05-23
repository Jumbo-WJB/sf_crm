$('#searchForm')[0].reset();
$('#SearchBut').click(function(){
    tableModal.draw();
})

//营销活动查询
var tableModal = $('#validateDetailTable').DataTable({
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
        "url":  baseUrl+"userValidate/showValidate",
        "data": function (d) {
            var name = $("#searchForm input[name='wxNickName']").val();
            var mobile = $("#searchForm input[name='mobile']").val();
            var time = $("#searchForm select[name='time'] option:selected").val();

            d.wxNickName = name;
            d.mobile = mobile;
            d.time = time;
        }
    },
    "columnDefs": [{
            "render": function (data, type, row) {
                if (data == "1"){
                    return "成功";
                }else{
                    return "失败";
                }
            },
            "targets": 2
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return '';
                }else{
                    return getLocalTime(data);
                }
            },
            "targets": 3
        },{
            "render": function (data, type, row) {
                if (data == null){
                    return "无";
                }else{
                    return "有";
                }
            },
            "targets": 4
        },{
        "render": function (data, type, row) {
            if (data == null){
                return "无";
            }else{
                return data;
            }
        },
        "targets": 5
        },{
        "render": function (data, type, row) {
            if (data == null || data <= 0){
                return "0次";
            }else{
                return data+"次";
            }
        },
        "targets": 6
        },{
            "render": function (data, type, row) {
                if (row.userId == null){
                    return '无';
                }else{
                    return '<label><a href="javascript:view('+row.userId+')">查看</a></label>';
                }
            },
            "targets": 7
        }
    ],
    "sort":false,
    "columns": [
        {"data": "wxNickName"},
        {"data": "mobile"},
        {"data": "result"},
        {"data": "validateDate"},
        {"data": "userPortraitId"},
        {"data": "name"},
        {"data": "totalPurchaseTimes"},
        {"data": "null"}
    ]
});


function view(val){
    $.ajax({
        type : "post",
        url : baseUrl+"knowCustomer/withPortrait",
        data : {userId:val},
        dataType : "json",
        success : function(data){
            if (data.count == 1){
                //freshUrl(baseUrl+"knowCustomer/userPortrait?userId="+val);
                $('#userportraitModal iframe').attr('src',baseUrl+'knowCustomer/userPortrait?userId='+val);
                $('#userportraitModal').modal('show');
            }else{
                alert("该用户画像不存在");
                return false;
            }
        }
    });
}