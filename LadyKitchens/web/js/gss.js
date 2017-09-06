var record = {};

function updateCartRecord(id, change) {
    $.post(getContextPath()+"/pages/front/CheckOutServlet/changeCartRecord", {"menuid": id, "change": change}, function (data) {
        return data.trim() == "true";
    });
}

function changeRecord(id, change) {
    if (change == 0)
        record["" + id] = undefined;
    else if (record["" + id] == undefined) {
        record["" + id] = 1;
    } else {
        record["" + id] = record["" + id] + change;
    }
}

function loadRecord() {
    var cartRecord = getCartRecord();
    for (var k in cartRecord) {
        record[k] = cartRecord[k];
    }
}

function modalBuy() {
    $("img[id*=menuimg-]").each(function () {
        var menuid = this.id.split("-")[1];
        $(this).css("cursor", "pointer");
        $(this).on("click", function () {
            $.post(getContextPath()+"/pages/front/MenuServletFront/show", {"menuid": menuid}, function (data) {
                $("#smid").val(data.id);
                $("#smimg").attr("src", getContextPath()+"/upload/menu/" + data.imgpath);
                $("#smname").html(data.name);
                $("#smtype").html(data.typename);
                $("#smburden").html(data.burden);
                $("#smbrief").html(data.brief);
                if (record["" + data.id] != undefined)
                    $("#smsum").html(data.sum - record["" + data.id]);
                else
                    $("#smsum").html(data.sum);
                $("#smprice").html("￥" + data.price);
                $("#menuShowModal").modal("toggle");
            }, "json");
        });
    });
    $("#smbtn").on("click", function () {
        if (getUser() == "") {
            alert("您还未登录，请先登录！");
            window.location = getContextPath()+"/pages/front/login.jsp";
            return;
        }
        if ($("#smsum").html() == "0") {
            operateAlert(false, "", "菜品余量不足！");
            return;
        }
        $.post(getContextPath()+"/pages/front/MenuServletFront/addCart", {"menuid": $("#smid").val()}, function (data) {
            if (data.trim() == "true") {
                $("#smsum").html(parseInt($("#smsum").html()) - 1);
                updateCartRecord($("#smid").val(), 1);
                changeRecord($("#smid").val(), 1);
                operateAlert(true, "已将该菜品添加至购物车。", "");
                $("#emptyMsg").html("<span style='color: orangered'>待结账</span>");
                updateTotal();
                $.post(getContextPath()+"/pages/front/CheckOutServlet/calcLength", {}, function (data) {
                    $("#cartLengthHead").html(data);
                });
            }
            else
                operateAlert(false, "", "添加购物车失败，请与管理员联系。");
        }, "text");
    });
}

/**
 * 警告框操作信息，ID必须为“alertDiv”
 * @param flag 操作成功或失败的标记
 * @param suctext 操作成功时的显示文本内容
 * @param faltext 操作失败时的显示文本内容
 */
function operateAlert(flag, suctext, faltext) {
    if (flag) {
        $("#alertDiv").attr("class", "alert alert-success");
        $("#alertText").text(suctext);
    } else {
        $("#alertDiv").attr("class", "alert alert-danger");
        $("#alertText").text(faltext);
    }
    $("#alertDiv").fadeIn(1000, function () {
        $("#alertDiv").fadeOut(3000);
    });
}

function updateTotal() {
    $.post(getContextPath()+"/pages/front/CheckOutServlet/calcTotal", {}, function (data) {
        $("#total").html("合计：<span style='color: orangered'>" + data + "</span>")
        $("#totalHead").html(data);
    }, "text");
}