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
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <%--<link rel="stylesheet" href="/css/buttons.css"/>--%>
    <link rel="stylesheet" href="css/font-awesome.css"/>
    <script type="text/javascript" src="js/pages/back/menu/menu_list.js"></script>
    <jsp:include page="/pages/back/include/import_file.jsp"/>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
        <li>菜品列表</li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click" id="addBtn"><span><img src="images/t01.png"/></span>添加</li>
            <li class="click" id="delBtn"><span><img src="images/t03.png"/></span>删除</li>
        </ul>

    </div>

    <jsp:include page="/pages/back/include/split_page_plugin_search.jsp"/>
    <table class="tablelist">
        <thead>
        <tr>
            <th width="2%"><input id="selAll" name="selAll" type="checkbox"/></th>
            <th width="6%">图片</th>
            <th width="8%">名称</th>
            <th width="6%">类型</th>
            <th width="4%">余量</th>
            <th width="4%">价格</th>
            <th width="10%">原材料</th>
            <th width="15%">简介</th>
            <th width="6%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allMenu}" var="menu">
            <tr>
                <td><input id="menuid" name="menuid" type="checkbox" value="${menu.id}"/></td>
                <td style="text-align: center;padding: 3px 0px"><img src="upload/menu/${menu.imgpath}" width="100px"
                                                                     alt="${menu.name}">
                </td>
                <td>${menu.name}</td>
                <c:set var="typeid" value="${menu.typeid}"/>
                <td>${typeMap[typeid+0]}</td>
                <td>${menu.sum}</td>
                <td>${menu.price}</td>
                <td>${menu.burden}</td>
                <td>${menu.brief}</td>
                <td><a href="<%=updateUrl%>?menu.id=${menu.id}" style="background: url('<%=basePath%>images/btnbg.png')"
                       class="btn-xs btn-primary"><i
                        class="icon icon-edit"></i>&nbsp;编辑&nbsp;&nbsp;&nbsp;</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <jsp:include page="/pages/back/include/split_page_plugin_bar.jsp"/>


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
