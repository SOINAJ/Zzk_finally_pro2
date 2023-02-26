var $table = $('#table')
var $button = $('#button')
var $button1 = $('#button1')

$("#table").bootstrapTable({
    url: "../goods",
    method: "GET",
    cache: "false",
    columns: [
        {checkbox:"true",field: "state"},
        {title: "订单编号", field: "id"},
        {title: "菜品编号", field: "number_cai"},
        {title: "菜品名字", field: "food"},
        {title: "桌子编号", field: "number_zhuo"},
        {title: "做法", field: "way"}

    ],

    sidePagination: "server",

})

$(function () {
    $button.click(function () {
        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.id
        })
        $table.bootstrapTable('remove', {
            field: 'id',
            values: ids
        })
        deldata(ids)
    })

    $button1.click(function () {
        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.id
        })
        $table.bootstrapTable('remove', {
            field: 'id',
            values: ids
        })
        finsh(ids)
    })
})

function finsh(ids){

    $.ajax({
        url: "../goods/1",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            swal({
                title: "菜品状态更改",
                text: "你所选取菜品已上菜完成",
                type: "success",
                timeout: "3000"
            })
        },
        error: function (e) {
            console.log("error")
        }
    })
}

function deldata(ids){

    $.ajax({
        url: "../goods",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            console.log(dat)
            swal({
                title: "菜品状态更改",
                text: "你所选取菜品已被取消",
                type: "warning",
                timeout: "3000"
            })
        },
        error: function (e) {
            console.log("error")
        }
    })
}
