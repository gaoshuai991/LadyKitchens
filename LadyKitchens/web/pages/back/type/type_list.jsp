<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateUrl = basePath + "pages/back/menu/MenuServlet/updatePre";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>阿婆私房菜后台管理系统</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <jsp:include page="/pages/back/include/import_file.jsp"/>
    <%--<link rel="stylesheet" href="/css/buttons.css"/>--%>
    <link rel="stylesheet" href="css/font-awesome.css"/>
    <script type="text/javascript" src="js/pages/back/type/type.js"></script>
</head>
<body style="height: 505px">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
        <li>菜品类型列表</li>
    </ul>
</div>

<div class="rightinfo">
    <div class="formtitle">
        <span>菜品类型列表</span>
    </div>
    <div class="tools">
        <input class="form-control toolbar" style="display: inline;width: 250px;margin-right: 10px" type="text"
               id="newtypename"
               placeholder="输入菜品类型名称进行添加...">
        <ul class="toolbar">
            <li class="click" id="addBtn"><span><img src="images/t01.png"/></span>添加</li>
            <li class="click" id="delBtn"><span><img src="images/t03.png"/></span>删除</li>
        </ul>

    </div>

    <table class="tablelist" style="width: 60%">
        <thead>
        <tr>
            <th width="5%"><input id="selAll" name="selAll" type="checkbox"/></th>
            <th width="10%">编号</th>
            <th>名称</th>
            <th width="16%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allType}" var="type" varStatus="status">
            <%--<form action="<%=updateUrl%>" method="post">--%>
            <tr>
                <td><input id="typeid" name="typeid" type="checkbox" value="${type.id}"/></td>
                <td>${type.id}</td>
                <td><input type="text" id="typename-${type.id}" value="${type.name}"></td>
                <td style="padding: 8px 0 0 10px">
                    <ul class="toolbar">
                        <li class="click" id="updateBtn-${type.id}">
                            <i class='icon icon-edit'></i>&nbsp;修改&nbsp;
                        </li>
                    </ul>
                </td>
            </tr>
            <%--</form>--%>
        </c:forEach>
        </tbody>
    </table>

    <div class="tip">
        <div class="tiptop">
            <span>提示信息</span><a></a>
        </div>

        <div class="tipinfo">
            <span><img src="images/ticon.png"/></span>
            <div class="tipright">
                <p id="pMsg">是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input id="butSure" type="button" class="sure" value="确定"/>&nbsp;
            <input id="butCancel" type="button" class="cancel" value="取消"/>
        </div>
    </div>
</div>
</body>
</html>
