<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String addUrl = basePath + "pages/back/notice/NoticeServlet/insert" ;
%>
<html>
<head>
<base href="<%=basePath%>">
<title>阿婆私房菜后台管理系统</title>
<jsp:include page="/pages/back/include/import_file.jsp"/>
<script type="text/javascript" src="js/pages/back/notice/notice_add.js"></script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
    <li>发布公告</li>
    </ul>
</div>

	<div class="formbody">
		<div class="formtitle">
			<span>发布公告</span>
		</div>
		<form id="addForm" action="<%=addUrl%>" method="post">
			<ul class="forminfo">
				<li><label>公告标题：</label>
					<input name="notice.name" id="notice.name" type="text" class="dfinput" /></li>
				<li>
					<label>公告内容</label>
					<textarea class="form-control dfinput" style="height: 80px" rows="5" id="notice.content" name="notice.content"></textarea>
				</li>
				<li><label>&nbsp;</label>
					<input type="submit" style="width: 65px" class="btn" value="&nbsp;发布&nbsp;" /></li>
			</ul>
		</form>
	</div>
</body>
</html>
