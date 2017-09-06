<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/pages/front/include/include_resources_head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>阿婆私房菜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="js/pages/front/user/update.js"></script>
    <script src="jquery/Message_zh_CN.js"></script>
</head>
<body>
<jsp:include page="/pages/front/include/include_title_head.jsp"/>
<div class="banner ban1">
    <div class="container">
        <div class="top-menu">
            <span class="menu"><img src="images/nav.png" alt=""/> </span>
            <ul>
                <li><a href="pages/front/MenuServletFront/index">home</a></li>
                <li><a href="pages/front/about.jsp">about</a></li>
                <li><a href="pages/front/MenuServletFront/list">menus</a></li>
                <li><a href="pages/front/user/checkout.jsp">Check out</a></li>
                <li><a href="pages/front/contact.jsp">contact</a></li>
            </ul>
        </div>
    </div>
</div>
<!--end-banner-->
<div class="content">
    <div class="main-1">
        <div class="container">
            <div class="login-page">
                <div class="account_grid">
                    <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
                        <h3>修改个人信息</h3>
                        <p>请在下方修改您的信息</p>
                        <form id="updateForm" action="" method="post">
                            <div>
                                <span>用户名<label>*</label></span>
                                <input type="text" id="user.name" name="user.name" value="${user.name}" disabled>
                            </div>
                            <div>
                                <span>真实姓名<label>*</label></span>
                                <input type="text" id="user.realname" name="user.realname" value="${user.realname}">
                            </div>
                            <div>
                                <span>性别<label>*</label></span>
                                <input type="text" id="user.sex" name="user.sex" value="${user.sex}">
                            </div>
                            <div>
                                <span>年龄<label>*</label></span>
                                <input type="text" id="user.age" name="user.age" value="${user.age}">
                            </div>
                            <div>
                                <span>身份证号<label>*</label></span>
                                <input type="text" id="user.card" name="user.card" value="${user.card}">
                            </div>
                            <div>
                                <span>电话<label>*</label></span>
                                <input type="text" id="user.phone" name="user.phone" value="${user.phone}">
                            </div>
                            <div>
                                <span>邮箱<label>*</label></span>
                                <input type="text" id="user.email" name="user.email" value="${user.email}">
                            </div>
                            <div>
                                <span>地址<label>*</label></span>
                                <input type="text" id="user.address" name="user.address" value="${user.address}">
                            </div>
                            <input type="hidden" name="user.id" value="${user.id}">
                            <input type="submit" value="修改">
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
</body>
</html>
