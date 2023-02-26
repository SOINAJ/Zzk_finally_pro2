var $table = $('#table')
var $button = $('#button')
var number_zhuo = getCookie("mysyszhuo")

$("#table").bootstrapTable({
    url: "../goods/1/"+number_zhuo,
    method: "GET",
    cache: "false",
    columns: [
        {title: "订单编号", field: "id"},
        {title: "菜品编号", field: "number_cai"},
        {title: "菜品名字", field: "food"},
        {title: "桌子编号", field: "number_zhuo"},
        {title: "做法", field: "way"}

    ],

    sidePagination: "client",

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
})

function deldata(ids){

    $.ajax({
        url: "../goods",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            console.log(dat)
        },
        error: function (e) {
            console.log("error")
        }
    })
}
