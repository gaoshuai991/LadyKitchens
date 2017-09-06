<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>CRM管理系统</title>
    <jsp:include page="/pages/back/include/import_file.jsp"/>
</head>
<body>
<div class="footer"><i>版权所有 Gss </i></div>
</body>
</html>
