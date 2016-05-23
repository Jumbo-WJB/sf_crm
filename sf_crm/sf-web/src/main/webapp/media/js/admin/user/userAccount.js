var oTable = $('#hbAccountTable').dataTable({
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
        "url":  baseUrl+'/userAccount/datas',
        "data": function (d) {
            var wxNickName = $("#searchForm :input[name='wxNickName']").val();
            var startDate = $("#searchForm :input[name='startDate']").val();
            var endDate = $("#searchForm :input[name='endDate']").val();
            if (!isNullOrEmpty(wxNickName)) {
                d.wxNickName = wxNickName;
            }
            if (!isNullOrEmpty(startDate)) {
                d.startDate = startDate;
            }
            if (!isNullOrEmpty(endDate)) {
                d.endDate = endDate;
            }
        }
    },
    "columnDefs": [
        {
            "render": function (data, type, row) {
                return '<td class="center"><label><input type="checkbox" class="ace" value="'+data+'"/><span class="lbl"></span></label></td>';
            },
            "targets": 0
        }, {
            "render": function (data, type, row) {
                if(data == "1"){
                    return "男"
                } else if(data=="2"){
                    return "女"
                }else
                    return "";
            },
            "targets":3
        },{
            "render": function (data, type, row) {
                if(!isNullOrEmpty(data)){
                    return (data/100.00).toFixed(2);
                }else{
                    return 0;
                }
            } ,
            "targets":4
        },{
            "render": function (data, type, row) {
                if(!isNullOrEmpty(data)){
                    return (data/100.00).toFixed(2);
                }else{
                    return 0;
                }
            } ,
            "targets":5
        },{
            "render": function (data, type, row) {
                if(!isNullOrEmpty(data)){
                    return (data/100.00).toFixed(2);
                }else{
                    return 0;
                }
            } ,
            "targets":7
        },{
            "render": function (data, type, row) {
                if(data == "0"){
                    return "否"
                } else{
                    return "是"

                }
            },
            "targets":9
        },{
            "render": function (data, type, row) {
                if(data == "0"){
                    return "否"
                } else{
                    return "是"

                }
            },
            "targets":10
        },{
            "render": function (data, type, row) {
                if(data==null){
                    return  '';
                }else
                    return getLocalTime(data);
            },
            "targets":11
        }
//                    {"visible": false, "targets": [3]}
    ],
    "columns": [
        {"data": "id","sortable": false},
        {"data": "wxNickName","sortable": false},
        {"data": "name","sortable": false},
        {"data": "sex","sortable": false},
        {"data": "hbobtainAmount"},
        {"data": "hongbaoAmount"},
        {"data": "hbcashNumber"},
        {"data": "hbcashAmount"},
        {"data": "hbtotalNumber"},
        {"data": "isOldUser","sortable": false},
        {"data": "isVerify","sortable": false},
        {"data": "hbcashDate","sortable": false}
    ]
});

$("#searchForm").submit(function () {
    $('#hbAccountTable').DataTable().draw()
    return false; //阻止表单默认提交
});
