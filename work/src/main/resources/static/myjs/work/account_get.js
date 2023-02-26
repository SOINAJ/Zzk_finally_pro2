var $table = $('#table')
var $button = $('#button')

$("#table").bootstrapTable({
    url: "../login/g",
    method: "GET",
    cache: "false",
    columns: [
        {checkbox:"true",field: "state"},
        {title: "账号编号", field: "id"},
        {title: "人员账号", field: "account"},
        {title: "账号密码", field: "passwd"},
        {title: "人员姓名", field: "name"}
    ],

    sidePagination: "server"

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
    console.log(ids)
    $.ajax({
        url: "../login/d",
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