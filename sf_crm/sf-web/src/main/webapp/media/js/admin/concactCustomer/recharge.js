$('#searchForm')[0].reset();
$("#searchForm input[name='type']").click(function(){
    tableModal.draw();
})
//营销活动查询
var tableModal = $('#rechargeTable').DataTable({
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
        "url":  baseUrl+"contactCustomer/rechargeList",
        "data": function (d) {
            var packageType = $("#searchForm input[name='chargeType']:checked").val();
            d.packageType = packageType;
        }
    },
    "columnDefs": [{
        "render": function (data, type, row) {
            return '<label><input name="name" type="radio" class="ace" value="'+data+'"/><span class="lbl"></span></label>';
        },
        "targets": 0
    },{
        "render": function (data, type, row) {
            if (data == null){
                return '0条';
            }else{
                return data+'条';
            }
        },
        "targets": 1
    },{
        "render": function (data, type, row) {
            if(data==null){
                return  '';
            }else
                return '￥ '+(data/100).toFixed(2)+' 元';
        },
        "targets": 2
    },{
        "render": function (data, type, row) {
            if (data == null){
                return '0条';
            }else{
                return data+'条';
            }
        },
        "targets": 3
    }
    ],
    "sort":false,
    "columns": [
        {"data": "packageId"},
        {"data": "packageCount"},
        {"data": "packageFee"},
        {"data": "packageFree"}
    ]
});

$("#searchForm input[name=chargeType]").click(function(){
    var type = $(this).val();
    if (type == 'sms'){
        $('.smsP').show();
        $('.emailP').hide();
    }else if (type == 'email'){
        $('.smsP').hide();
        $('.emailP').show();
    }
    tableModal.draw();
});

$('#concact-service').click(function(){
    $('#serviceModal').modal('show');
})
