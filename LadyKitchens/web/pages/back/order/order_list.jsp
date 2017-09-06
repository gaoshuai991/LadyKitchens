<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <%--<link rel="stylesheet" href="/css/buttons.css"/>--%>
    <link rel="stylesheet" href="css/font-awesome.css"/>
    <script type="text/javascript" src="js/pages/back/order/order_list.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="pages/back/index.jsp" target="_top">首页</a></li>
        <li>订单列表</li>
    </ul>
</div>

<div class="rightinfo">
    <div class="formtitle">
        <span>订单列表</span>
    </div>
    <div class="tools">

        <ul class="toolbar">
            <%--<li class="click" id="addBtn"><span><img src="/images/t01.png"/></span>添加</li>--%>
            <li class="click" id="delBtn"><span><img src="images/t03.png"/></span>删除</li>
        </ul>

    </div>

    <jsp:include page="/pages/back/include/split_page_plugin_search.jsp"/>
    <table class="tablelist">
        <thead>
        <tr>
            <th width="2%"><input id="selAll" name="selAll" type="checkbox"/></th>
            <th width="6%">订单ID</th>
            <th width="8%">用户名</th>
            <th width="4%">总价</th>
            <th width="10%">下单时间</th>
            <th width="6%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allOrderInfo}" var="orderInfo">
            <tr>
                <td><input id="orderid" name="orderid" type="checkbox" value="${orderInfo.id}"/></td>
                <td>${orderInfo.id}</td>
                <td>${orderInfo.username}</td>
                <td>￥&nbsp;${orderInfo.total}</td>
                <td><fmt:formatDate value="${orderInfo.times}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <button id="showDetailsBtn-${orderInfo.id}" style="background: url('<%=basePath%>images/btnbg.png')"
                            class="btn-xs btn-primary"><i
                            class="icon icon-edit"></i>&nbsp;查看详情&nbsp;
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <jsp:include page="/pages/back/include/split_page_plugin_bar.jsp"/>

    <div class="modal fade" id="orderDetailsModal"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
        <div class="modal-dialog" style="width: 1000px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title">
                        <span class="glyphicon glyphicon-folder-open"></span>
                        <strong>订单详情</strong></h3>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-2 text-right"><strong>订单ID：</strong></div>
                        <div id="modalOrderid" class="col-md-10">21051321</div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2 text-right"><strong>下单用户：</strong></div>
                        <div id="modalUsername" class="col-md-10">老李</div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2 text-right"><strong>订单内容：</strong></div>
                        <div class="col-md-10">
                            <table id="detailsTable" class="table table-hover" style="width: 50%">
                                <tr>
                                    <th>菜品名称</th>
                                    <th>数量</th>
                                    <th>价格</th>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2 text-right"><strong>下单时间：</strong></div>
                        <div id="modalOrderTimes" class="col-md-10">2017-09-01 11:30:45</div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2 text-right" style="font-size: 20px;font-weight: bold">总价：</div>
                        <div id="modalOrderTotal" style="font-size: 20px;font-weight: bold;" class="col-md-10">￥&nbsp;52.60</div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
                </div>
            </div>
        </div>
    </div>




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
