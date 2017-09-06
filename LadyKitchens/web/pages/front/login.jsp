<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/pages/front/include/include_resources_head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>阿婆私房菜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="js/pages/front/login.js"></script>
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
    <div class="main-1">
        <div class="container">
            <div class="login-page">
                <div class="account_grid">
                    <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
                        <h3>新用户</h3>
                        <p>如果您尚未拥有账户，可以通过点击下方按钮成为我们阿婆私房菜的一员。<br>尽享我们为您提供的优质服务！</p>
                        <br>
                        <a class="acount-btn" href="pages/front/register.jsp">创建新账户</a>
                    </div>
                    <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
                        <h3>已注册用户</h3>
                        <p>如果您已经拥有我们的账户，请在下方进行登录。</p>
                        <form id="loginForm" action="pages/front/UserServlet/login" method="post">
                            <div>
                                <span>用户名<label>*</label></span>
                                <input type="text" id="user.name" name="user.name">
                            </div>
                            <div>
                                <span>密码<label>*</label></span>
                                <input type="password" id="user.pwd" name="user.pwd">
                            </div>
                            <input type="submit" value="登录">
                            <a class="forgot" href="#">&nbsp;&nbsp;&nbsp;&nbsp;忘记密码?</a>
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
</div>
</body>
</html>
