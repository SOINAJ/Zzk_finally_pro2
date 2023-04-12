
function endfun(){
    /*swal({
        title: "结账发送",
        text: "请稍后,服务人员正在过来帮您结账",
        type: "success",
        timeout: "3000"
    })*/
    var tess = "你需要结账: ";
    $.ajax({
        url:"../goods/3/"+$("#myname").html() ,
        type:"get",
        contentType:"application/json",
        datatype:"json",
        success:function(data){
            console.log(data)
            if(data.code == 20011){

                tess += data.data + " 元,需要打包盒吗"
                swal({
                    title: "结账发送",
                    text: "请稍后,服务人员正在过来帮您结账",
                    type: "info",
                    showCancelButton: true,
                    confirmButtonColor: "#faebcc",
                    confirmButtonText: "确定结账",
                    closeOnConfirm: false
                }, function () {
                    // swal("已确定结账！", "工作人员正在过来给你打包。", "success");

                    swal({
                        title: "已确定结账",
                        text: tess,
                        type: "info",
                        showCancelButton: true,
                        confirmButtonColor: "#2a94de",
                        confirmButtonText: "确定结账",
                        closeOnConfirm: false
                    }, function () {
                        swal("已确定结账！", "工作人员正在过来给你打包。", "success");
                        // $(data).remove()
                    })
                    // $(data).remove()
                })
            }

        },
        error:function (data){
            console.log(data)
        }
    })
    // console.log(tess+" !! ")



}

function give_me_money(){

}