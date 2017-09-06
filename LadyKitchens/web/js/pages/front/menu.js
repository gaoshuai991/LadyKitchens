$(function () {
    $("#updatePwdBtn").on("click", function () {
        $("#updatePwdModal").modal("toggle");
    });
    modalBuy();
    $("a[id*='addCart-']").each(function () {
        var menuid = this.id.split("-")[1];
        $(this).on("click", function () {
            if (getUser() == "") {
                alert("您还未登录，请先登录！");
                window.location = getContextPath()+"/pages/front/login.jsp";
                return;
            }
            $.post(getContextPath()+"/pages/front/MenuServletFront/addCart", {"menuid": menuid}, function (data) {
                if (data.trim() == "true") {
                    updateCartRecord(menuid, 1);
                    changeRecord(menuid, 1);
                    operateAlert(true, "已将该菜品添加至购物车。", "");
                    $("#emptyMsg").html("<span style='color: orangered'>待结账</span>");
                    updateTotal();
                    $.post(getContextPath()+"/pages/front/CheckOutServlet/calcLength", {}, function (data) {
                        $("#cartLengthHead").html(data);
                    });
                }
                else
                    operateAlert(false, "", "菜品余量不足！");
            }, "text");

        });
    });
});