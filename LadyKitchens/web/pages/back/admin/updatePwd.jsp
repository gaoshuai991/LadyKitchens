<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String addUrl = basePath + "pages/back/menu/MenuServlet/insert";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>阿婆私房菜后台管理系统</title>
    <jsp:include page="/pages/back/include/import_file.jsp"/>
    <script type="text/javascript" src="js/pages/back/admin/updatePwd.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
        <li>修改密码</li>
    </ul>
</div>

<div class="formbody">
    <div class="formtitle">
        <span>修改密码</span>
    </div>

    <ul class="forminfo">
        <li><label>原密码：</label>
            <input id="oldpwd" type="password" placeholder="请输入原始密码" class="dfinput" /></li>
        <li><label>新密码：</label>
            <input id="newpwd" type="password" placeholder="请输入新密码" class="dfinput" /></li>
        <li><label>确认密码：</label>
            <input id="confnewpwd" type="password" placeholder="请确认新密码" class="dfinput" /></li>

        <li><label>&nbsp;</label>
            <input type="button" id="submitBtn" class="btn" style="width: 50px" value="&nbsp;提&nbsp;交&nbsp;" /></li>
    </ul>
</div>
</body>
</html>
