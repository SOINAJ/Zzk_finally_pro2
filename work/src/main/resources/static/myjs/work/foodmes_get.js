var $table = $('#table')
var $button = $('#button')

$("#table").bootstrapTable({
    url: "../allFmes",
    method: "GET",
    cache: "false",
    columns: [
        {checkbox:"true",field: "state"},
        {title: "菜品编号", field: "id"},
        {title: "菜品名字", field: "food"},
        {title: "菜品库存", field: "stack"}
    ],

    sidePagination: "server",
    onClickRow: function (row, field) {
        // console.log(row)
        // console.log(field)
        var data = field[0]
        console.log(data.dataset.index)
        // if (isEmpty(row.stack)) {
        //     showOnclick(row, data.dataset.index)
        // }
        showOnclick(row, data.dataset.index)
    }
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
        url: "../allFmes",
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



function updatainline(data, indexnum) {
    console.log(data)
    var rows = {
        index: indexnum,
        field: "stack",
        value: data.stack
    }
    $("#table").bootstrapTable("updateCell", rows)
}

function showOnclick(data, indexnum) {
    var name = data.id

    var index = layer.open({
        title: "菜品库存更新",
        type: 1,
        area: ['350px', '220px'],
        shadeClose: true,
        content:
            '<h4 style="text-align: center">当前选择菜品编号是: <a style="text-align: center;text-decoration: none;cursor: pointer">' + name + '</a> 的菜品</h4><p></p>' +
            '<h5 style="text-align: center">更新该库存' +
            '<input type="text" class="mystack" style="border: black 1px solid"/>' +
            '</h5>',

        btn: ['是', '否'],
        scrollbar: false,
        yes: function () {
            var stack = $(".mystack").val()
            $.ajax({
                url: "../allFmes",
                type: "POST",
                datatype: "json",
                contentType: "application/json",
                data: {
                    "id": name,
                    "stack":stack
                },
                success: function (dat) {
                    if (dat.data == '1') {
                        swal({
                            title: "菜品库存",
                            text: "你已对该菜品库存进行更新",
                            type: "success",
                            timeout: "3000"
                        })
                        data.stack = stack
                        updatainline(data, indexnum)
                    } else {
                        swal({
                            title: "菜品库存",
                            text: "你对该菜品库存更新失败",
                            type: "warning",
                            timeout: "3000"
                        })
                    }
                },
                error: function (e) {
                    console.log("error")
                }
            })
            layer.close(index)
        }

        ,
    })
}
