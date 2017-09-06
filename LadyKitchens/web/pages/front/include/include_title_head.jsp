<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String logoutUrl = basePath + "pages/front/UserServlet/logout";
%>
<base href="<%=basePath%>">
<script>
    <!-- FlexSlider -->
    $(window).load(function () {
        $('.flexslider').flexslider({
            animation: "slide",
            start: function (slider) {
                $('body').removeClass('loading');
            }
        });
    });
    <!-- FlexSlider -->
    function getCartRecord() {
        return ${cartRecordJson};
    }
    function getUser() {
        return "${user}";
    }
    function getContextPath(){
        return "${pageContext.request.contextPath}";
    }
    $(function () {
        updateTotal();
        loadRecord();
    })
</script>
<div class="alert alert-success" id="alertDiv"
     style="display: none;position: fixed;margin: 0 40%;width: 280px;z-index: 99999">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <span id="alertText"></span>
</div>
<div class="header">
    <div class="container">
        <div class="top-header">
            <div class="phone">
                <ul>
                    <li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></li>
                    <li><p>132 2087 9735</p></li>
                </ul>
            </div>
            <div class="logo">
                <h1><a href="pages/front/MenuServletFront/index">Lady Kitchens</a></h1>
            </div>
            <div class="header-right">
                <c:choose>
                    <c:when test="${user==null}">
                        <a class="btn btn-sm btn-primary" href="pages/front/login.jsp">用户登录</a>
                        <a class="btn btn-sm btn-primary" href="pages/login_back.jsp" target="_blank">admin登录</a>
                    </c:when>
                    <c:when test="${user!=null}">
							<span class="button-dropdown button-dropdown-primary" data-buttons="dropdown">
                                <a href="#" class="button button button-primary"> 欢迎：${user.realname} <i
                                        class="icon icon-caret-down"></i></a>
                                <ul class="button-dropdown-list is-below">
                                    <li><a href="javascript:void(0)" id="updatePwdBtn">修改密码</a></li>
                                    <li><a href="pages/front/UserServlet/updatePre">修改个人信息</a></li>
                                    <li class="button-dropdown-divider"><a href="<%=logoutUrl%>">注销</a></li>
                                </ul>
                            </span>
                    </c:when>
                </c:choose>
                <div class="cart box_1">

                    <a href="pages/front/user/checkout.jsp">
                        <h3>$&nbsp;<span id="totalHead">0.00</span>&nbsp;(<span
                                id="cartLengthHead"> ${fn:length(cartList)}</span>
                            items)<img src="images/bag.png" alt=""></h3>
                    </a>
                    <br>
                    <p><span id="emptyMsg" style="font-size: 11px">
                        <c:if test="${fn:length(cartList) == 0}">
                            购物车为空
                        </c:if>
                        <c:if test="${fn:length(cartList) != 0}">
                            <span style='color: orangered'>待结账</span>
                        </c:if>
                    </span></p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
