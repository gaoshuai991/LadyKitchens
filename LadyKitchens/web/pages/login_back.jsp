<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/pages/back/include/import_file.jsp" %>
<html>
<head>
    <title>阿婆私房菜</title>
    <script src="js/cloud.js" type="text/javascript"></script>
    <script src="js/pages/login_back.js" type="text/javascript"></script>
</head>
<body style="background-color:#df7611; background-image:url(/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>
<div class="logintop">
    <span>欢迎登录阿婆私房菜管理平台</span>
    <ul>
        <li><a href="pages/front/MenuServletFront/index">回到前台</a></li>
        <li><a href="javascript:void(0)" id="about">关于</a></li>
    </ul>
</div>
<div class="loginbody">
    <span class="systemlogo"></span>
    <div class="loginbox">
        <form action="pages/LoginServlet/login" method="post" id="loginForm">
            <ul>
                <li><input name="admin.name" id="admin.name" type="text" class="loginuser"
                           placeholder="输入登录用户名"/></li>
                <li><input name="admin.pwd" id="admin.pwd" type="password" class="loginpwd"
                           placeholder="请输入登录密码"/></li>
                <li><input type="submit" class="loginbtn" value="登录"/></li>
            </ul>
        </form>
    </div>
</div>
<div class="loginbm"></div>
</body>
</html>
