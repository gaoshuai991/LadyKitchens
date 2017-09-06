var userid = "";
$(document).ready(function() {
    $("button[id*='up-']").each(function() {
        $(this).on("click",function () {
            var result = this.id.split("-");
            userid = result[1];
            var name = result[2];
            var realname = result[3];
            $("#upname").html(name);
            $("#uprealname").html(realname);
            $(".tip").fadeIn(200);
        });
    });

    $(".tiptop a").click(function() {
        $(".tip").fadeOut(200);
    });

    $(".sure").click(function() {
        $(".tip").fadeOut(100,function() {
            var newpwd = $("#newpwd").val();
            $.post(getContextPath()+"/pages/back/user/UserServlet/updatePwd",{'user.id':userid,'user.pwd':newpwd},function(data){
                if(data.trim()=="true"){
                    alert("客户密码修改成功！");
                }else{
                    alert("客户密码修改成功！");
                }
            },"text");
            // window.location = "pages/back/user/UserServlet/updatePwd?user.id="+userid+"&user.pwd="+newpwd;
        });
    });

    $(".cancel").click(function() {
        $(".tip").fadeOut(100);
    });
    $('.tablelist tbody tr:odd').addClass('odd');
});