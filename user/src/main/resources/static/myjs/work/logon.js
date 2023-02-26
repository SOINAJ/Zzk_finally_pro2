$(".myacc").blur(function (){
    var place = $(".myacc").val()
    if (isEmpty(place)){
        $("#msg_acc").html("账号不能为空")
        var classname = $(".msg_acc1").attr("class")
        classname += " animated rubberBand"
        $(".msg_acc1").attr("class",classname)
        $(".msg_acc1").css("display","block")
        // $(".myip").css("display","none")
        $(".myname").css("display","none")
    }else {
        var number = place.length
        if (number < 3 || number >8){
            $("#msg_acc").html("账号的长度应该要大于3位,小于8位")
            var classname = $(".msg_acc1").attr("class")
            classname += " animated rubberBand"
            $(".msg_acc1").attr("class",classname)
            $(".msg_acc1").css("display","block")
            // $(".myip").css("display","none")
            $(".myname").css("display","none")
        }else {
            $(".myname").css("display","block")
            $(".myip").attr("type","submit")
        }
    }
})

$(".mypasswd").blur(function (){
    var textate = $(".mypasswd").val()
    if (isEmpty(textate)){
        $("#msg_passwd").html("密码不能为空")
        var classname = $(".msg_passwd1").attr("class")
        classname += " animated rubberBand"
        $(".msg_passwd1").attr("class",classname)
        $(".msg_passwd1").css("display","block")
        // $(".myip").css("display","none")
        $(".myname").css("display","none")
    }else {
        var number = textate.length
        if (number < 3 || number >8){
            $("#msg_passwd").html("密码的长度应该要大于3位,小于8位")
            var classname = $(".msg_passwd1").attr("class")
            classname += " animated rubberBand"
            $(".msg_passwd1").attr("class",classname)
            $(".msg_passwd1").css("display","block")
            // $(".myip").css("display","none")
            $(".myname").css("display","none")
        }else {
            $(".myname").css("display","block")
            $(".myip").attr("type","submit")
        }
    }
})

$(".myacc").focus(function (){
    $("#msg_acc").text("")
    $(".msg_acc1").attr("class","msg_acc1")
    // $(".myip").css("display","block")
})

$(".mypasswd").focus(function (){
    $("#msg_passwd").text("")
    $(".msg_passwd1").attr("class","msg_passwd1")
    // $(".myip").css("display","block")
})