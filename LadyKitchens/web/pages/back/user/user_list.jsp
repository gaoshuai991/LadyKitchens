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
    <title>阿婆私房菜后台管理系统</title>
    <jsp:include page="/pages/back/include/import_file.jsp"/>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link rel="stylesheet" href="css/font-awesome.css"/>
    <script type="text/javascript" src="js/pages/back/user/user_list.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
        <li>客户列表</li>
    </ul>
</div>
<div class="rightinfo">
    <div class="formtitle">
        <span>客户信息列表</span>
    </div>
    <jsp:include page="/pages/back/include/split_page_plugin_search.jsp"/>
    <table class="tablelist">
        <thead>
        <tr>
            <%--<th width="2%"><input id="selAll" name="selAll" type="checkbox"/></th>--%>
            <th width="2%">ID</th>
            <th width="6%">用户名</th>
            <th width="5%">真实姓名</th>
            <th width="3%">性别</th>
            <th width="3%">年龄</th>
            <th width="8%">身份证号</th>
            <th width="7%">电话</th>
            <th width="12%">地址</th>
            <th width="8%">邮箱</th>
            <th width="6%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.realname}</td>
                <td>${user.sex}</td>
                <td>${user.age}</td>
                <td>${user.card}</td>
                <td>${user.phone}</td>
                <td>${user.address}</td>
                <td>${user.email}</td>
                <td>
                    <button id="up-${user.id}-${user.name}-${user.realname}"
                            style="background: url('<%=basePath%>images/btnbg.png')"
                            class="btn-xs btn-primary"><i
                            class="icon icon-edit"></i>&nbsp;修改密码&nbsp;&nbsp;
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="/pages/back/include/split_page_plugin_bar.jsp"/>

    <div class="tip">
        <div class="tiptop">
            <span>重置客户密码</span><a></a>
        </div>

        <div class="tipinfo">
            <span><img src="images/ticon.png"/></span>
            <div class="tipright">
                <label style="color:gray;width:70px;line-height:15px; display:block; float:left;">用户名：</label>
                <label id="upname"></label><br>
                <label style="color:gray;width:70px;line-height:15px; display:block; float:left;">真实姓名：</label>
                <label id="uprealname"></label><br>
                <input class="dfinput" style="width: 180px;" type="text" id="newpwd" name="newpwd"
                       placeholder="请输入新密码...">
            </div>
        </div>

        <div class="tipbtn" style="margin: 0">
            <input id="butSure" type="button" class="sure" value="确定"/>
            <input id="butCancel" type="button" class="cancel" value="取消"/>
        </div>
    </div>
</div>
</body>
</html>
