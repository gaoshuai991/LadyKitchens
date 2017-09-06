<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
    <title>阿婆私房菜</title>
</head>
<body>
<script type="text/javascript">
    window.alert("${msg}");
    if ("${url}".indexOf("login") >= 0)
        window.parent.location = "<%=basePath%>${url}";
    else
        window.location = "<%=basePath%>${url}";
</script>
</body>
</html>
