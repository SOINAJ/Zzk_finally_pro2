// $(document).scroll(function () {
//     var scrollh = $(window).height();
//     var scrollTop = Math.max(document.documentElement.scrollTop || document.body.scrollTop);
//     console.log(now_num +"!"+ number)
//     if (parseInt(now_num) < parseInt(number)) {
//         if ((scrollTop + $(window).height()) >= scrollh) {
//             $("#jiazai").show();
//             var interval = setTimeout(function () {
//                 $("#jiazai").hide();
//             }, 1000);
//             var inter = setTimeout(function () {
//                 // $("#container div").first().clone().appendTo($("#container"));
//                 // now_num ++
//                 if (now_num < number) {
//                     now_num++
//                     getGoods_user(parseInt(now_num))
//                 }
//
//             }, 1000);
//         }
//     }
// });

$(window).scroll(function () {
    var scrollh = $(document).height();
    var scrollTop = Math.max(document.documentElement.scrollTop || document.body.scrollTop);
    console.log(scrollh +"!"+ scrollTop)
    if (parseInt(now_num) < parseInt(number)) {
        if ((scrollTop + $(window).height()) >= scrollh) {
            $("#jiazai").show();
            var interval = setTimeout(function () {
                $("#jiazai").hide();
            }, 1000);
            var inter = setTimeout(function () {
                // $("#container div").first().clone().appendTo($("#container"));
                // now_num ++
                if (now_num < number) {
                    now_num++
                    getGoods_user(parseInt(now_num))
                }

            }, 1000);
        }
    }
});

function getpart(){
    $.ajax({
        url:"../checkUsers",
        type:"POST",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            var part = dat.data.part
            var data = part.substring(0,1)
            console.log(data)
            $("#myp").attr("class",data)
        },
        error:function (e){
            console.log("error")
        }
    })
}

function put_goods_market(idName,data){
    var myzhuo = getCookie("mysyszhuo")
    $.ajax({
        url: "../goods",
        type: "PUT",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data: {
            "idName": idName,
            "selete":data,
            "number":myzhuo
        },
        success: function (dat) {
            var number = $("#mytd"+idName).html()
            var num = parseInt(number) - 1
            $("#mytd"+idName).html(num)
        },
        error: function (e) {
            console.log("error")
        }
    })
}

function selectthis(data){
    var classname = data.id
    var idName = classname.substring(7)
    var this_data = "myid" + idName
    document.getElementById(this_data).removeAttribute("onclick")
}

function selectthis2(data){
    var classname = $(data).prop("id")
    var idName = classname.substring(7)
    var this_data = "myid" + idName
    var obj = document.getElementById(this_data)
    var my = document.createAttribute("onclick")
    my.nodeValue = "choosethis(this)"
    obj.attributes.setNamedItem(my)
    // $(this_data).removeAttrs("onclick","choosethis(this)")
}

function choosethis(data) {
    // var part = $("#myp").attr("class")
    var classname = $(data).prop("id")
    var idName = classname.substring(4)

    var seletedata = $("#myselect"+classname.substring(4)).val()
    console.log(seletedata)
        swal({
            title: "您确定要点这个菜吗",
            text: "",
            type: "info",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false
        }, function () {
            swal("已下单！", "您已下单这个菜品,请稍等。", "success");
            put_goods_market(idName,seletedata)
            // $(data).remove()
        })
    // var myidName = idName.substring()
    // console.log(idName)
    // if (part == "B") {

    // }
    // else {
    //     swal({
    //         title: "不可接受",
    //         text: "你不可接受该订单",
    //         type: "warning",
    //         showCancelButton: true,
    //     })
    // }

}