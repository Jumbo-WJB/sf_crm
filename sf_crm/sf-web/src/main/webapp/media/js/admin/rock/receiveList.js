$('#searchForm')[0].reset();
$('#SearchBut').click(function(){
    tableModal.draw();
})

//营销活动查询
var tableModal = $('#receiveDetailTable').DataTable({
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
        "url":  baseUrl+"rock/rockQueryDetail",
        "data": function (d) {
            var rockTitle = $("#searchForm input[name='rockTitle']").val();
            var mobile = $("#searchForm input[name='mobile']").val();
            var nDay = $("#searchForm select[name='nDay'] option:selected").val();

            d.rockTitle = rockTitle;
            d.mobile = mobile;
            d.nDay = nDay;
        }
    },
    "columnDefs": [{
        "render": function (data, type, row) {
            if (data == "received"){
                return "已领取";
            }else{
                return "未领取";
            }
        },
        "targets": 3
    },{
        "render": function (data, type, row) {
            if (row.userPortraitId == null){
                return "无";
            }else{
                return "有";
            }
        },
        "targets": 5
    },{
        "render": function (data, type, row) {
            if (data == null){
                return "无";
            }else{
                return getLocalTime(data);
            }
        },
        "targets": 6
    },{
        "render": function (data, type, row) {
            if (data == null){
                return "";
            }else{
                return '<label><a href="javascript:void(0);" onclick="goPortriat('+row.userId+')">查看</a></label>';
            }
        },
        "targets": 7
    }
    ],
    "sort":false,
    "columns": [
        {"data": "wxNickName"},
        {"data": "rockTitle"},
        {"data": "rockResult"},
        {"data": "shakeStatus"},
        {"data": "mobile"},
        {"data": "userPortraitId"},
        {"data": "obtainDate"},
        {"data": null}
    ]
});

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
