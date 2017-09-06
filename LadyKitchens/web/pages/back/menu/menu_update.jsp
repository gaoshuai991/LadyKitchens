<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateUrl = basePath + "pages/back/menu/MenuServlet/update";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>阿婆私房菜后台管理系统</title>
    <jsp:include page="/pages/back/include/import_file.jsp"/>
    <script type="text/javascript" src="js/pages/back/menu/menu_update.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
        <li>编辑菜品信息</li>
    </ul>
</div>

<div class="formbody">
    <div class="formtitle">
        <span>编辑菜品</span>
    </div>
    <div style="border: 1px solid #7a869d;padding: 5px;margin-left: 110px;margin-bottom: 12px;width: 210px"><img
            src="/upload/menu/${menu.imgpath}" style="width:210px;"></div>
    <form id="updateForm" action="<%=updateUrl%>" method="post" enctype="multipart/form-data">
        <ul class="forminfo">
            <%--<li><label>用户名</label>--%>
            <%--<label>${menu.name}</label>--%>
            <%--<i></i></li>--%>
            <li><label>菜品名称：</label>
                <input name="menu.name" id="menu.name" type="text" class="dfinput" value="${menu.name}"/></li>
            <li><label>菜品类别：</label>
                <select id="menu.typeid" name="menu.typeid" class="dfinput">
                    <c:forEach items="${allType}" var="type">
                        <option value="${type.id}" ${menu.typeid==type.id?"selected" : ""}>${type.name}</option>
                    </c:forEach>
                </select></li>
            <li><label>数量：</label>
                <input name="menu.sum" id="menu.sum" type="text" class="dfinput" value="${menu.sum}"/></li>

            <li><label>单价：</label>
                <input name="menu.price" id="menu.price" type="text" class="dfinput" value="${menu.price}"/></li>
            <li><label>原材料：</label>
                <input name="menu.burden" id="menu.burden" type="text" class="dfinput" value="${menu.burden}"/></li>
            <li><label>简介：</label>
                <input name="menu.brief" id="menu.brief" type="text" class="dfinput" value="${menu.brief}"/></li>

            <li><label>照片</label>
                <input name="photo" id="photo" type="file"/>
            </li>

            <li><label>&nbsp;</label>
                <input type="hidden" name="menu.imgpath" id="menu.imgpath" value="${menu.imgpath}">
                <input type="hidden" name="menu.id" id="menu.id" value="${menu.id}">
                <input type="submit" class="btn" value="&nbsp;修改&nbsp;"/></li>
        </ul>
    </form>
</div>
</body>
</html>
