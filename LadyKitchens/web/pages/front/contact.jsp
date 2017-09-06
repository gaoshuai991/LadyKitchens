<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/pages/front/include/include_resources_head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>阿婆私房菜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
                <li><a href="pages/front/user/checkout.jsp">Check out</a></li>
                <li><a href="pages/front/about.jsp">about</a></li>
                <li><a href="pages/front/contact.jsp" class="active">contact</a></li>
            </ul>
        </div>
    </div>
</div>
<!--end-banner-->
<div class="content">
    <div class="contact">
        <div class="container">
            <h3>contact us</h3>
            <div class="google-map">
                <iframe src="http://map.baidu.com/?newmap=1&shareurl=1&l=18&tn=B_NORMAL_MAP&hb=B_SATELLITE_STREET&c=12991694,4198869&s=s%26da_src%3DsearchBox.button%26wd%3D%E5%9B%BD%E5%AE%B6%E9%AB%98%E6%96%B0%E5%8C%BA%E5%A4%A7%E5%AD%A6%E5%9B%AD%26c%3D286%26src%3D0%26wd2%3D%E6%B5%8E%E5%AE%81%E5%B8%82%E4%BB%BB%E5%9F%8E%E5%8C%BA%26sug%3D1%26l%3D12%26from%3Dwebmap%26biz_forward%3D%7B%22scaler%22%3A1%2C%22styles%22%3A%22pl%22%7D%26sug_forward%3D2a89ba9901a6762b97031902"></iframe>
            </div>
            <div class="contact-grids">
                <div class="col-md-6 contact-left">
						<span>济宁国家高新区大学园位于山东省济宁市国家高新区海川路 16 号，具体位置位于孔子国际学校以北，
                            山推研发中心以南，广安家园以东，辰欣药业对过。大学园是高新区完善产学研基地功能、培养储备人才的重要工程，
                            主要是通过联合办学、共建人才实训基地和公共研发平台，坚持产学研相结合、学历教育与技能实训相结合，
                            超前谋划人力资源布局，以专业化、技能型人才加速 推动产业链升级、价值链攀升。</span>
                    <address>
                        <p>The Hewlett Packard Enterprise Inc.</p>
                        <p>济宁慧与基地,</p>
                        <p>国家高新区大学园.</p>
                        <p>电话: +86 132 208 79735</p>
                        <p>E-mail: <a href="javascript:void(0)">jackiegss@163.com</a></p>
                    </address>
                </div>
                <div class="col-md-6 contact-right">
                    <form>
                        <h5>姓名</h5>
                        <input type="text">
                        <h5>邮箱</h5>
                        <input type="text">
                        <h5>请填写信息</h5>
                        <textarea></textarea>
                        <input type="submit" value="发送">
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/front/user/include_updatePwd_modal.jsp"/>
<script>
    $(function () {
        $("#updatePwdBtn").on("click", function () {
            $("#updatePwdModal").modal("toggle");
        });
    })
</script>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
</body>
</html>
