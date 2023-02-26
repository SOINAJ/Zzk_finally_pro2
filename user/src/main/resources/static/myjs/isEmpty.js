function isEmpty(str){
    if(str==null||$.trim(str)==""||str=="null"||str.length===0){
        return true;
    }
    return false;
}

function returnEmpty(str){
    if(str==null||str.trim()==""||str=="null"){
        return "";
    }
    return str;
}

function getCookie(cookie_name) {

    var allcookies = document.cookie;
    //索引长度，开始索引的位置
    var cookie_pos = allcookies.indexOf(cookie_name);


    // 如果找到了索引，就代表cookie存在,否则不存在
    if (cookie_pos != -1) {
        // 把cookie_pos放在值的开始，只要给值加1即可
        //计算取cookie值得开始索引，加的1为“=”
        cookie_pos = cookie_pos + cookie_name.length + 1;
        //计算取cookie值得结束索引
        var cookie_end = allcookies.indexOf(";", cookie_pos);


        if (cookie_end == -1) {
            cookie_end = allcookies.length;


        }
        //得到想要的cookie的值
        var value = unescape(allcookies.substring(cookie_pos, cookie_end));
    }
    return value;
}

function setCookie(cname,cvalue,exdays){
    var d= new Date()
    d.setTime(d.getTime() + (exdays*24*60*60*1000))
    var expires = "expires=" + d.toUTCString()
    document.cookie=cname + "=" + cvalue + "; " + expires
}

function Aclick(){
    var mysyszhuo = getCookie("mysyszhuo")
    $.ajax({
        url: "../logoutSystem",
        type: "POST",
        datatype: "json",
        contentType: "application/json;charset=UTF-8",
        data: {
            "mysyszhuo":mysyszhuo
        },
        success: function (dat) {
            document.location.href="../login.html"
        },
        error: function (e) {
            console.log("error")
        }
    })
}