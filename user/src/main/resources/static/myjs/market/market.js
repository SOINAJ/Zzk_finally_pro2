$(document).ready(function () {
    get_market_number()
    getpart()
    button3_onclick()
});


var number = 0
var now_num = 1


function button3_onclick() {
    getGoods_user(now_num)
}


function get_market_number() {
    $.ajax({
        url: "../food_market",
        type: "GET",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (dat) {

            var length = parseInt(dat.data)
            if (length % 7 == 0) {
                number = length / 7
            } else {
                number = parseInt( length / 7 ) + 1
            }
            console.log("number"+number)
        },
        error: function (e) {
            console.log("error")
        }
    })
}


function getGoods_user(num) {
    $.ajax({
        url: "../food_market/" + num,
        type: "GET",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (dat) {
            var data_length = dat.data.length
            var text1 = ""
            for (var i = 0; i < data_length; i++) {
                var classname = "myid" + dat.data[i].id
                var idname = "myselect" + dat.data[i].id
                var tablename = "mytable" + dat.data[i].id
                var td1 = "mytd" + dat.data[i].id
                text1 +=
                    '<div onclick="choosethis(this)" class="panel panel-warning" id=' + classname + '>' +
                    '<div class="panel-heading">' +
                    '<label>' +
                    '<span><h3 class="panel-title"><i class="glyphicon glyphicon-cloud"></i> 餐厅菜品 </h3></span>' +
                    '</label>' +
                    '</div>' +
                    '<label>' +
                    '<div class="panel-body"><span> ' + dat.data[i].food + ' </span></div>' +
                    '</label>' +
                    '<table class="table">' +
                    '<tr><th>菜品编号</th><td>' + dat.data[i].id + '</td> </tr>' +
                    '<tr><th>菜品剩量</th><td id=' + td1 + '>' + dat.data[i].stack + '</td></tr>' +
                    '<label style="margin-left: 10px;"  id=' + tablename + ' onmouseenter="selectthis(this)" onmouseleave="selectthis2(this)">' +
                    '<span>菜品做法:</span>' +
                    '<select id=' + idname + ' name="select2" class="select2">' +
                    '<option value="1">煎</option>' +
                    '<option value="2">炒</option>' +
                    '<option value="3">炸</option>' +
                    '<option value="4">焗</option>' +
                    '</select>' +
                    '</label>' +
                    '<tr><th>菜品单价</th><td>' + dat.data[i].money + '</td></tr>' +
                    '</table>' +
                    '</div>'
            }
            $("#mymarket").append(text1)
        },
        error: function (e) {
            console.log("error")
        }
    })
    // console.log(now_num)
}


