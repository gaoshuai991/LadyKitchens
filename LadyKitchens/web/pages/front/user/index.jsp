<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/pages/front/include/include_resources_head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>阿婆私房菜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="阿婆 私房菜"/>
    <script>
        function getUser() {
            return "${user}";
        }
    </script>
    <script src="js/pages/front/user/index.js"></script>
</head>
<body>
<!-- head.jsp -->
<jsp:include page="/pages/front/include/include_title_head.jsp"/>
<div class="banner">
    <div class="container">
        <div class="top-menu">
            <ul>
                <li><a href="pages/front/MenuServletFront/index" class="active">home</a></li>
                <li><a href="pages/front/MenuServletFront/list">menus</a></li>
                <li><a href="pages/front/user/checkout.jsp">Check out</a></li>
                <li><a href="pages/front/about.jsp">about</a></li>
                <li><a href="pages/front/contact.jsp">contact</a></li>
            </ul>
        </div>
        <section class="slider">
            <div class="flexslider">
                <ul class="slides">
                    <c:forEach var="notice" items="${allNewNotice}">
                        <li>
                            <div class="slider-info">
                                <h2 style="font-size: 2.7em">${notice.name}</h2>
                                <p>${notice.content}</p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </section>
    </div>
</div>
<!--end-banner-->

<div class="content">
    <!--hot-offer-->
    <div class="today-offer">
        <div class="today-head">
            <h3>阿婆精选</h3>
            <p>我们为您挑选了最近一周最热门的菜品，尝尝看吧~</p>
        </div>
        <div class="today-grids">
            <c:forEach var="menu" items="${allHotMenus}">
                <div class="col-md-3 today-grid test1">
                    <img src="upload/menu/${menu.imgpath}" id="menuimg-${menu.id}" class="img-responsive"
                         style="width: 340px;height: 300px"
                         alt="/">
                    <div class="textbox" style="height: 80px">
                        <h4>${menu.name}</h4>
                        <p style="font-weight: bold">${menu.brief}</p>
                    </div>
                </div>
            </c:forEach>
            <div class="clearfix"></div>
        </div>
    </div>
    <!--end-hot-offer-->
    <div class="order-grids" style="margin-top: 150px">
        <div class="container">
            <div class="order-head">
                <h3>热门菜品</h3>
                <p>阿婆私房菜，揽尽天下美食</p>
            </div>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="false">
                <c:forEach var="type" items="${allType}" varStatus="index">
                    <div style="border: 1px solid gainsboro;margin-bottom: 50px">
                        <div class="menu-offer"
                             style="text-align: left;padding-top:30px;padding-bottom: 20px;padding-left: 20px">
                            <div class="container">
                                <span class="text-info" style="font-size: 2em">${type.name}</span>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <c:forEach var="menu" items="${allHotTypedMenus}" varStatus="status">
                                    <c:if test="${menu.typeid == type.id}">
                                        <div class="col-md-3 order-grid">
                                            <img id="menuimg-${menu.id}" src="upload/menu/${menu.imgpath}"
                                                 class="img-responsive" alt="/" style="width: 250px;height: 170px"><br>
                                            <p style="font-size: 1.2em;color: rgb(120,120,120)">${menu.name}&nbsp;&nbsp;&nbsp;￥${menu.price}</p>
                                        </div>
                                    </c:if>
                                </c:forEach>
                                <div class="clerafix"></div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
<!-- 查看菜品详情的的Modal -->
<jsp:include page="/pages/front/user/include_showMenuDetails_modal.jsp"/>
</body>
</html>