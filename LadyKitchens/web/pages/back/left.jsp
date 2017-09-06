<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="js/pages/back/left.js"></script>
</head>
<body style="background:#fff3e1;">
<dl class="leftmenu">
    <dd>
        <div class="title">
            <span><img src="images/${gup.img}"/></span>菜品管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="pages/back/menu/MenuServlet/list" target="rightFrame">菜品列表</a><i></i></li>
            <li><cite></cite><a href="pages/back/menu/MenuServlet/insertPre" target="rightFrame">菜品添加</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="/images/${gup.img}"/></span>菜品类型管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="pages/back/type/TypeServlet/list" target="rightFrame">菜品类型列表</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="/images/${gup.img}"/></span>订单管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="pages/back/order/OrderServlet/list" target="rightFrame">订单列表</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="/images/${gup.img}"/></span>客户管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="pages/back/user/UserServlet/list" target="rightFrame">客户列表</a><i></i></li>
            <%--<li><cite></cite><a href="#" target="rightFrame">客户修改</a><i></i></li>--%>
        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="/images/${gup.img}"/></span>公告管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="pages/back/notice/NoticeServlet/list" target="rightFrame">公告列表</a><i></i></li>
            <li><cite></cite><a href="pages/back/notice/notice_add.jsp" target="rightFrame">发布公告</a><i></i></li>
        </ul>
    </dd>
</dl>

</body>
</html>
