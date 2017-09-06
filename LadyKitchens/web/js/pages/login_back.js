$(function () {
    $("#about").on("click", function () {
        alert("阿婆私房菜后台管理系统 v1.0\nAuthor: Gss");
    });
    $('.loginbox').css({
        'position': 'absolute',
        'left': ($(window).width() - 692) / 2
    });
    $(window).resize(function () {
        $('.loginbox').css({
            'position': 'absolute',
            'left': ($(window).width() - 692) / 2
        });
    });
    $("#loginForm").validate({
        debug: true, // 取消表单的提交操作
        submitHandler: function (form) {
            form.submit(); // 提交表单
        },
        errorPlacement: function (error, element) {
            // $("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
        },
        highlight: function (element, errorClass) {
            $(element).fadeOut(1, function () {
                $(element).fadeIn(1, function () {
                    // $("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
                    $("#" + $(element).attr("id").replace(".", "\\.")).css("border", "1px solid red");
                });

            })
        },
        unhighlight: function (element, errorClass) {
            $(element).fadeOut(1, function () {
                $(element).fadeIn(1, function () {
                    // $("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
                    $("#" + $(element).attr("id").replace(".", "\\.")).css("border", "");
                });
            })
        },
        errorClass: "text-danger",
        rules: {
            "admin.name": {
                required: true
            },
            "admin.pwd": {
                required: true
            }
        }
    });
});
