$(document).ready(function(){
   userReady()
});
var this_state
function userReady(){
    $.ajax({
        url:"../checkUsers",
        type:"POST",
        datatype:"json",
        contentType:"application/json:charset=UTF-8",
        success:function (dat){
            $("#myname").html(dat.data.username)
            $("#mypart").html(dat.data.part)
            $("#mypart").css("display","none")
            this_state = dat.data.talk
            check_have_return(dat.data.part)
            get_notice()
        },
        error:function (e){
            console.log("error")
        }
    })
}

function haveState(data){
    switch (this_state){
        case "0":
            // $("#U_new_goods").attr("href","../404.html")
            // $("#U_new_goods1").attr("href","../404.html")
            $(data).attr("href","../404.html")
            $(".mytitle").val("打开失败")
            $(".mycontent").val("您的账号需要上传信息,待管理员审核后正常使用该功能")
            $("#mybtn1").trigger("onclick")
            break
    }
}