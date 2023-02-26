$(document).ready(function(){
    // var user = window.parent.document.getElementById("mypart")
    // var part = ($(user).html()).substring(0,2)

    var number_zhuo = getCookie("mysyszhuo")
    $("#user").val(number_zhuo)
    $(".select2").change(function(){
        Myoption()
    })

})

function form_post(){
    if (!isEmpty($("#work").val())){
        console.log("not null")
        $.ajax({
            url:"../complains",
            type:"post",
            contentType:"application/json",
            datatype:"json",
            data:$(".form-report").serialize(),
            success:function(data){
                runback(data.code)
                console.log(data)
            },
            error:function (data){
                console.log(data)
            }
        })
    }else {
        runback("20040")
    }

}

function runback(oh){
    if (oh == "20041" || oh == 20041) {
        swal({
            title: "投诉成功",
            text: "我们将于3个工作日内处理,并且进行改进",
            type: "success",
            confirmButtonColor: "#009900",
            closeOnConfirm: false
        })
    }
    else {
        swal({
            title: "投诉消息上传失败",
            text: "消息上传可能有问题,上传失败,请检查内容",
            type: "warning",
            confirmButtonColor: "#DD6B55",
            closeOnConfirm: false
        })
    }
}



function Myoption(){
    var number = $(".select2").val()
    console.log(number)
    if(number == "4"){
        $(".otherlabel").css("display","block")
    }else{
        $(".otherlabel").css("display","none")
    }
}
