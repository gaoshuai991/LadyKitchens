<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String addUrl = basePath + "pages/back/menu/MenuServlet/insert" ;
%>
<html>
<head>
<base href="<%=basePath%>">
<title>阿婆私房菜后台管理系统</title>
<jsp:include page="/pages/back/include/import_file.jsp"/>
<script type="text/javascript" src="js/pages/back/menu/menu_add.js"></script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
    <li>添加菜品</li>
    </ul>
</div>

	<div class="formbody">
		<div class="formtitle">
			<span>添加菜品</span>
		</div>
		<form id="addForm" action="<%=addUrl%>" method="post" enctype="multipart/form-data">
			<ul class="forminfo">
				<li><label>菜品名称：</label>
					<input name="menu.name" id="menu.name" type="text" class="dfinput" /></li>
				<li><label>菜品分类：</label>
					<select id="menu.typeid" name="menu.typeid" class="dfinput">
						<c:forEach items="${allType}" var="type">
							<option value="${type.id}">${type.name}</option>
						</c:forEach>
					</select>
				</li>
				<li><label>数量：</label>
					<input name="menu.sum" id="menu.sum" type="text" class="dfinput" /></li>
				<li><label>单价：</label>
					<input name="menu.price" id="menu.price" type="text" class="dfinput" /></li>
				<li><label>原材料：</label>
					<input name="menu.burden" id="menu.burden" type="text" class="dfinput" /></li>
				<li><label>简介：</label>
					<input name="menu.brief" id="menu.brief" type="text" class="dfinput" /></li>
				<li><label>照片</label>
					<input name="photo" id="photo" type="file"  />
				</li>
				<li><label>&nbsp;</label>
					<input type="submit" style="width: 65px" class="btn" value="&nbsp;添加&nbsp;" /></li>
			</ul>
		</form>
	</div>
</body>
</html>
