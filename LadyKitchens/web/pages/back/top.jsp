<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String logoutUrl = basePath + "pages/LoginServlet/logout";
    String updatePwdUrl = basePath + "pages/back/admin/updatePwd.jsp";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>CRM管理系统</title>
    <jsp:include page="/pages/back/include/import_file.jsp"/>
    <script type="text/javascript" src="js/pages/back/top.js"></script>
</head>
<body style="background:url(<%=basePath%>images/topbg.gif) repeat-x;">
<div class="topleft">
    <a href="pages/back/index.jsp" target="_parent"></a> <a href="pages/back/DefaultServletBack/show"
                                                             target="rightFrame"><img src="images/loginlogo.png"
                                                                                      border="0"></a>
</div>

<ul class="nav">
    <li><a href="pages/back/user/UserServlet/list" target="rightFrame"><img src="images/icon13.png" border="0"
                     title="工作台"/>
        <h2>客户列表</h2></a></li>
    <li><a href="pages/back/notice/notice_add.jsp" target="rightFrame"> <img
            src="images/icon09.png" title="发布公告"/>
        <h2>发布公告</h2></a></li>
</ul>

<div class="topright">
    <ul>
        <li style="font-size:13px; color:#FFD6AF;">当前管理员：${admin.name}</li>
        <li><a href="<%=updatePwdUrl%>" target="rightFrame">修改密码</a></li>
        <li><a href="<%=logoutUrl%>" target="_parent">注销</a></li>
    </ul>
</div>
</body>
</html>
