<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/pages/front/include/include_resources_head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>阿婆私房菜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="js/pages/front/checkout.js"></script>
</head>
<body>
<jsp:include page="/pages/front/include/include_title_head.jsp"/>
<div class="banner ban1">
    <div class="container">
        <div class="top-menu">
            <span class="menu"><img src="images/nav.png" alt=""/> </span>
            <ul>
                <li><a href="pages/front/MenuServletFront/index">home</a></li>
                <li><a href="pages/front/MenuServletFront/list">menus</a></li>
                <li><a href="pages/front/user/checkout.jsp" class="active">Check out</a></li>
                <li><a href="pages/front/about.jsp">about</a></li>
                <li><a href="pages/front/contact.jsp">contact</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="cart-items">
    <div class="container">
        <div style="height: 100px">
            <span style="font-size: 35px;display: inline;">我的购物车(<span
                    id="cartLength">${fn:length(cartList)}</span>)</span>
            <div style="float: right;position: relative;">
                <div id="total" style="display:inline-block;font-size: 30px;margin-top: 10px"></div>
                <div style="display:inline-block;margin-left: 20px">
                    <a href="pages/front/CheckOutServlet/checkOut" class="btn btn-lg btn-danger"><i
                            class="icon icon-edit"></i>&nbsp;结账</a>
                </div>
            </div>
        </div>
        <div id="msgDiv">
            <c:if test="${fn:length(cartList) == 0}">
                <p>暂无记录！</p>
            </c:if>
        </div>
        <c:forEach var="menu" items="${cartList}" varStatus="index">
            <div class="cart-header" id="cart-header${index.count}">
                <div class="close2" id="close${index.count}-${menu.id}"></div>
                <div class="cart-sec simpleCart_shelfItem">
                    <div class="cart-item cyc">
                        <img src="upload/menu/${menu.imgpath}" id="menuimg-${menu.id}" class="img-responsive"
                             style="width: 230px;height: 230px" alt="">
                    </div>
                    <div class="cart-item-info">
                        <h3>${menu.name}</h3><br>
                        <ul class="qty">
                            <li><p>原&nbsp;&nbsp;材&nbsp;&nbsp;料：</p></li>
                            <li><p>${menu.burden}</p></li>
                        </ul>
                        <ul class="qty">
                            <li><p>介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绍：</p></li>
                            <li><p>${menu.brief}</p></li>
                        </ul>
                        <br/>
                        <ul class="qty">
                            <li><p>购买数量：</p></li>
                            <li>
                                <a id="subCount${index.count}-${menu.id}" href="javascript:void(0)"><i
                                        class="glyphicon glyphicon-minus" style="font-size: 20px"></i></a>
                            </li>
                            <li>
                                <p id="count${index.count}">${menu.count}</p>
                            </li>
                            <li>
                                <a id="addCount${index.count}-${menu.id}" href="javascript:void(0)"><i
                                        class="glyphicon glyphicon-plus" style="font-size: 20px"></i></a>
                            </li>
                        </ul>
                        <div class="delivery">
                            <p>价格 : ￥<span id="price${index.count}">${menu.count * menu.price}</span></p>
                            <span>Delivered in 1-1:30 hours</span>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
<jsp:include page="/pages/front/user/include_showMenuDetails_modal.jsp"/>
</body>
</html>
