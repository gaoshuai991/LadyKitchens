<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/pages/front/include/include_resources_head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>阿婆私房菜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script>
    </script>
    <script src="js/pages/front/menu.js"></script>

</head>
<body>
<!-- head.jsp -->
<jsp:include page="/pages/front/include/include_title_head.jsp"/>
<div class="banner ban1">
    <div class="container">
        <div class="top-menu">
            <span class="menu"><img src="images/nav.png" alt=""/> </span>
            <ul>
                <li><a href="pages/front/MenuServletFront/index">home</a></li>
                <li><a href="pages/front/MenuServletFront/list" class="active">menus</a></li>
                <li><a href="pages/front/user/checkout.jsp">Check out</a></li>
                <li><a href="pages/front/about.jsp">about</a></li>
                <li><a href="pages/front/contact.jsp">contact</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="content">
    <div class="events-section">
        <div class="container">
            <h3>menus</h3>
            <div class="events-grids">
                <div class="events1">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="false">
                        <c:forEach var="type" items="${allType}" varStatus="index">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading${index.count}">
                                    <h4 class="panel-title">
                                        <a role="button" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${index.count}"
                                           aria-expanded="${index.count == 1 ? 'true' : 'false'}"
                                           aria-controls="collapse${index.count}">
                                                ${type.name}
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapse${index.count}"
                                     class="panel-collapse collapse ${index.count == 1 ? 'in' : ''}" role="tabpanel"
                                     aria-labelledby="heading${index.count}">
                                    <div class="panel-body">
                                        <c:forEach var="menu" items="${allMenu}">
                                            <c:if test="${menu.typeid==type.id}">
                                                <div class="col-md-4 event-grid" style="margin-bottom: 30px">
                                                        <img id="menuimg-${menu.id}" src="upload/menu/${menu.imgpath}"
                                                             style="width:350px;height: 265px;cursor:pointer;"
                                                             class="img-responsive zoom-img" alt="">
                                                    <h5>${menu.burden}</h5>
                                                    <h4>${menu.name}</h4>
                                                    <div style="height: 52px">
                                                        <p>${menu.brief}</p>
                                                    </div>
                                                    <div class="cur">
                                                        <div class="cur-left">
                                                            <div class="item_add"><span class="item_price"><a
                                                                    href="javascript:void(0)"
                                                                    id="addCart-${menu.id}"><span
                                                                    class="glyphicon glyphicon-shopping-cart"
                                                                    aria-hidden="true"></span></a></span>
                                                            </div>
                                                        </div>
                                                        <div class="cur-right">
                                                            <div class="item_add"><span
                                                                    class="item_price"><h6><span>only</span>￥${menu.price}</h6></span>
                                                            </div>
                                                        </div>
                                                        <div class="clearfix"></div>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
<jsp:include page="/pages/front/user/include_showMenuDetails_modal.jsp"/>
</body>
</html>
