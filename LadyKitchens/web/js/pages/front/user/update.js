$(function() {
    $("#updatePwdBtn").on("click", function () {
        $("#updatePwdModal").modal("toggle");
    });
    $("#updateForm").validate({
        debug : true, // 取消表单的提交操作
        submitHandler : function(form) {
            form.submit(); // 提交表单
        },
        highlight : function(element, errorClass) {
            $(element).fadeOut(1,function() {
                $(element).fadeIn(1, function() {
                    $("#" + $(element).attr("id").replace(".","\\.")).css("border","1px solid red");
                });

            })
        },
        unhighlight : function(element, errorClass) {
            $(element).fadeOut(1,function() {
                $(element).fadeIn(1,function() {
                    $("#" + $(element).attr("id").replace(".","\\.")).css("border","");
                });
            })
        },
        errorClass : "text-danger",
        rules : {
            "user.realname" : {
                required : true
            },
            "user.sex" : {
                required : true
            },
            "user.age" : {
                required : true,
                digits:true
            },
            "user.card" : {
                required : true
            },
            "user.phone" : {
                required : true
            },
            "user.email" : {
                required : true
            },
            "user.address" : {
                required : true
            }
        }
    });
});