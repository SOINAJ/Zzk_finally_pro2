var $table = $('#table')
var $button = $('#button')
var $button1 = $('#button1')

$("#table").bootstrapTable({
    url: "../tables",
    method: "GET",
    cache: "false",
    columns: [
        {checkbox:"true",field: "state"},
        {title: "序号编号", field: "id"},
        {title: "桌子状态", field: "state"},
        {title: "桌子号", field: "passwd"},
        {title: "桌子类型", field: "name"}
    ],

    sidePagination: "server"

})

$(function () {
    $button.click(function () {

        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.passwd
        })
        $table.bootstrapTable('updateCell', {
            index: ids,
            field: 'state',
            values: 1
        })
        update_table(ids)
    })

    $button1.click(function () {

        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.passwd
        })
        $table.bootstrapTable('updateCell', {
            index: ids,
            field: 'state',
            values: 0
        })
        update_table1(ids)
    })
})

function update_table(ids){
    console.log(ids)
    var acc = getCookie("mysysAcc")
    $.ajax({
        url: "../tables/"+acc,
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            if (dat.code == 20021) {
                swal({
                    title: "换桌",
                    text: "已换新桌子,请刷新页面",
                    type: "success",
                    timeout: "3000"
                })
            } else {
                swal({
                    title: "换桌",
                    text: "已换桌失败,请刷新页面",
                    type: "warning",
                    timeout: "3000"
                })
            }
        },
        error: function (e) {
            console.log("error")
        }
    })
}

function update_table1(ids){
    console.log(ids)
    $.ajax({
        url: "../tables/1",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(ids),
        success: function (dat) {
            if (dat.code == 20021) {
                swal({
                    title: "一键复位",
                    text: "所选桌子已复位,请刷新页面",
                    type: "success",
                    timeout: "3000"
                })
            } else {
                swal({
                    title: "一键复位",
                    text: "所选桌子复位失败,请刷新页面",
                    type: "warning",
                    timeout: "3000"
                })
            }
        },
        error: function (e) {
            console.log("error")
        }
    })
}