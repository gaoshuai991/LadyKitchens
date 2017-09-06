<%--
  Created by IntelliJ IDEA.
  User: Gss
  Date: 2017/8/30
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<html>
  <head>
    <title>阿婆私房菜</title>
  </head>
  <body>
  <script type="text/javascript">
    window.onload = function(){
        window.location = "<%=basePath%>pages/front/MenuServletFront/index";
    }
  </script>
  </body>
</html>
