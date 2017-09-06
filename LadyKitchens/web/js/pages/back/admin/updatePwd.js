$(function(){
    $("#submitBtn").on("click", function () {
        var oldPwd = $("#oldpwd").val();
        $.post(getContextPath()+"/pages/back/admin/AdminServlet/checkOldPwd", {"oldPwd": oldPwd}, function (data) {
            if (data.trim() != "true") {
                alert("原密码不正确！")
                return;
            }
            if ($("#newpwd").val() != $("#confnewpwd").val()) {
                alert("两次密码输入不一致！");
                return;
            }
            $.post(getContextPath()+"/pages/back/admin/AdminServlet/updatePwd", {"admin.pwd": $("#newpwd").val()}, function (data) {
                if (data.trim() == "true") {
                    alert("密码修改成功，请重新登录！");
                } else {
                    alert("密码修改失败");
                }
                window.parent.location = getContextPath()+"/pages/login_back.jsp";
            }, "text");
        }, "text");
    })
});