function updatePriceAndCount(index, type) {
    if (type == 1) {
        $("#price" + index).html(Math.round(parseInt($("#price" + index).html()) * (1 + 1 / parseInt($("#count" + index).html())) * 100) / 100);
        $("#count" + index).html(parseInt($("#count" + index).html()) + 1);
    } else {
        $("#price" + index).html(Math.round(parseInt($("#price" + index).html()) * (1 - 1 / parseInt($("#count" + index).html())) * 100) / 100);
        $("#count" + index).html(parseInt($("#count" + index).html()) - 1);
    }
}

$(function () {
    $("#updatePwdBtn").on("click", function () {
        $("#updatePwdModal").modal("toggle");
    });
    updateTotal();
    $(".close2").each(function () {
        var id = this.id;
        var index = this.id.split("-")[0].charAt(this.id.split("-")[0].length - 1);
        var menuid = this.id.split("-")[1];
        $(this).on('click', function () {
            $.post(getContextPath()+"/pages/front/CheckOutServlet/removeCart", {"menuid": menuid}, function (data) {
                if (data.trim() == "true") {
                    updateCartRecord(menuid, 0);
                    changeRecord(menuid,0);
                    $("#cartLength").html(parseInt($("#cartLength").html()) - 1);
                    $("#cartLengthHead").html($("#cartLength").html());
                    if ($("#cartLength").html() == 0) {
                        $("#msgDiv").html("<p>暂无记录！</p>");
                        $("#emptyMsg").html("购物车为空");
                    }
                    updateTotal();
                    $('#cart-header' + index).fadeOut('slow', function (c) {
                        $('.cart-header' + index).remove();
                    });
                } else {
                    operateAlert(false, "", "出现错误，请与管理员联系！")
                }
            }, "text");
        });
    });
    $("a[id*=subCount]").each(function () {
        var index = this.id.split("-")[0].charAt(this.id.split("-")[0].length - 1);
        var menuid = this.id.split("-")[1];
        $(this).on('click', function () {
            if ($("#count" + index).html() > 1) {
                $.post(getContextPath()+"/pages/front/CheckOutServlet/subCart", {"menuid": menuid}, function (data) {
                    if (data.trim() == "true") {
                        updateCartRecord(menuid, -1);
                        changeRecord(menuid,-1);
                        updatePriceAndCount(index, 0);
                        updateTotal();
                    } else {
                        operateAlert(false, "", "出现错误，请与管理员联系！")
                    }
                }, "text");
            }
        });
    });
    $("a[id*=addCount]").each(function () {
        var index = this.id.split("-")[0].charAt(this.id.split("-")[0].length - 1);
        var menuid = this.id.split("-")[1];
        $(this).on('click', function () {
            $.post(getContextPath()+"/pages/front/CheckOutServlet/addCart", {"menuid": menuid}, function (data) {
                if (data.trim() == "true") {
                    updateCartRecord(menuid,1);
                    changeRecord(menuid,1);
                    updatePriceAndCount(index, 1);
                    updateTotal();
                } else {
                    operateAlert(false, "", "菜品余量不足！");
                }
            }, "text");
        });
    });
});