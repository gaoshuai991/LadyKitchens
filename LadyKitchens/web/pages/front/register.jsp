<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/pages/front/include/include_resources_head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>阿婆私房菜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="js/pages/front/register.js"></script>
</head>
<body>
<jsp:include page="/pages/front/include/include_title_head.jsp"/>
<div class="banner ban1">
    <div class="container">
        <div class="top-menu">
            <span class="menu"><img src="images/nav.png" alt=""/> </span>
            <ul>
                <li><a href="pages/front/MenuServletFront/index">home</a></li>
                <li><a href="pages/front/MenuServletFront/list">menus</a></li>
                <li><a href="pages/front/user/checkout.jsp">Check out</a></li>
                <li><a href="pages/front/about.jsp">about</a></li>
                <li><a href="pages/front/contact.jsp">contact</a></li>
            </ul>
        </div>
    </div>
</div>
<!--end-banner-->
<div class="content">
    <!-- registration -->
    <div class="main-1">
        <div class="container">
            <div class="register">
                <form id="regForm" action="pages/front/UserServlet/register" method="post">
                    <div class="register-top-grid">
                        <h3>个人信息</h3>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>真实姓名<label>*</label></span>
                            <input type="text" id="user.realname" name="user.realname">
                        </div>
                        <div id="user.realnameMsg" class="wow fadeInRight"></div>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>手机号<label>*</label></span>
                            <input type="text" id="user.phone" name="user.phone">
                        </div>
                        <div id="user.phoneMsg" class="wow fadeInRight"></div>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>地址<label>*</label></span>
                            <input type="text" id="user.address" name="user.address">
                        </div>
                        <div id="user.addressMsg" class="wow fadeInRight"></div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="register-bottom-grid">
                        <h3>登录信息</h3>
                        <div class="wow fadeInLeft" data-wow-delay="0.4s">
                            <span>用户名<label>*</label></span>
                            <input type="text" id="user.name" name="user.name">
                        </div>
                        <div id="user.nameMsg" class="wow fadeInRight"></div>
                        <div class="wow fadeInLeft" data-wow-delay="0.4s">
                            <span>密码<label>*</label></span>
                            <input type="password" id="user.pwd" name="user.pwd">
                        </div>
                        <div id="user.pwdMsg" class="wow fadeInRight"></div>
                        <div class="wow fadeInRight" data-wow-delay="0.4s">
                            <span>确认密码<label>*</label></span>
                            <input type="password" id="cpwd" name="cpwd">
                        </div>
                        <div id="cpwdMsg" class="wow fadeInRight"></div>
                    </div>
                    <div class="clearfix"></div>
                    <div>
                        <input class="button button-3d button-primary button-rounded" type="submit" value="submit">
                        <div class="clearfix"></div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
</body>
</html>
