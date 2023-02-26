var myname
$(document).ready(function(){
    initName()
    console.log(myname)
    $("#myname").text(myname)
});

function initName(){
    // var myacc = getCookie("mysysAcc")
    myname = getCookie("mysyszhuo")
    // var mypwd = getCookie("mysysPwd")
    // var myrole = getCookie("mysysRole")
}