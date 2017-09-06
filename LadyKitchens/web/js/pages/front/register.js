$(function() {
    $("#regForm").validate({
        debug : true, // 取消表单的提交操作
        submitHandler : function(form) {
            form.submit(); // 提交表单
        },
        // errorPlacement : function(error, element) {
            // $("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
        // },
        highlight : function(element, errorClass) {
            $(element).fadeOut(1,function() {
                $(element).fadeIn(1, function() {
                    // $("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
                    $("#" + $(element).attr("id").replace(".","\\.")).css("border","1px solid red");
                });

            })
        },
        unhighlight : function(element, errorClass) {
            $(element).fadeOut(1,function() {
                $(element).fadeIn(1,function() {
                    // $("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
                    $("#" + $(element).attr("id").replace(".","\\.")).css("border","");
                });
            })
        },
        errorClass : "text-danger",
        messages:{
            "cpwd" : {
                equalTo:"两次密码输入不一致！"
            }
        },
        rules : {
            "user.realname" : {
                required : true
            },
            "user.phone" : {
                required : true
            } ,
            "user.address" : {
                required : true
            } ,
            "user.name" : {
                required : true
            } ,
            "user.pwd" : {
                required : true
            } ,
            "cpwd" : {
                required : true,
                equalTo:"#user\\.pwd"
            } ,
            /*"code" : {
                required : true ,
                remote : {
                    url : "checkRandAndCode.action", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "html", // 接受数据格式
                    data : { // 要传递的数据
                        code : function() {
                            return $("#code").val();
                        }
                    },
                    dataFilter : function(data, type) {
                        if (data.trim() == "true") {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }*/
        }
    });
})