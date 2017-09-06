window.onload = function () {
    bind(ele("selAll"), "click", function () {
        handleSelectAll("orderid", this.checked);
    });
};
var jsUrl = "";
$(document).ready(function () {
    $(".click").click(function () {
        var eleId = this.id;
        $(".tip").fadeIn(200, function () {
            if (eleId == "delBtn") {	// 删除处理
                var nid = "";	// 保存所有的删除的ID编号
                var nidEle = document.all("orderid");
                if (nidEle.length != undefined) {
                    for (var x = 0; x < nidEle.length; x++) {
                        if (nidEle[x].checked) {
                            nid += nidEle[x].value + "|";
                        }
                    }
                } else {
                    if (nidEle.checked) {
                        nid = nidEle.value + "|";
                    }
                }
                if (nid != "") {
                    jsUrl = "/pages/back/order/OrderServlet/delete?ids=" + nid;
                    document.getElementById("pMsg").innerHTML = "是否要删除这些订单信息？";
                } else {	// 没有选择任何的数据
                    jsUrl = "";
                    document.getElementById("pMsg").innerHTML = "未选择任何订单信息！";
                }
            }
        });
    });

    $("button[id*=showDetailsBtn-]").each(function () {
        var id = this.id.split("-") [1];
        $(this).on("click", function () {
            $.post(getContextPath()+"/pages/back/order/OrderServlet/show", {"id": id}, function (data) {
                $("#orderDetailsModal").modal("toggle");
                console.log(data);
                if (data != undefined) {	// 现在有数据返回
                    $("#modalOrderid").text(data.id);
                    $("#modalUsername").text(data.username);
                    var detailsList = data.orderDetailsList;
                    var tab = $("#detailsTable");
                    $("#detailsTable").find("tr:gt(0)").empty();
                    for (var x in detailsList) {
                        var tr = "<tr><td>" + detailsList[x].menuname + "</td><td>" + detailsList[x].count + "</td><td>" + detailsList[x].price + "</td></tr>";
                        tab.append(tr);
                    }
                    // $("#modalOrderTimes").text(new Date(data.times.time).format("yyyy-MM-dd hh:mm:ss"));
                    $("#modalOrderTotal").text("￥ " + data.total);
                } else {
                    alert("订单详情加载失败！");
                }
            }, "json");
        });
    });

    $(".tiptop a").click(function () {
        $(".tip").fadeOut(200);
    });

    $(".sure").click(function () {
        $(".tip").fadeOut(100, function () {
            if (jsUrl != "") {
                window.location = getContextPath()+jsUrl;
            }
        });
    });

    $(".cancel").click(function () {
        $(".tip").fadeOut(100);
    });
    $('.tablelist tbody tr:odd').addClass('odd');
});