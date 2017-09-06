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
                <li><a href="pages/front/about.jsp" class="active">about</a></li>
                <li><a href="pages/front/contact.jsp">contact</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="content">
    <div class="aboutus">
        <div class="container">
            <h3>about us</h3>
            <div class="about-grids">
                <div class="col-md-7 about-grid">
                    <img src="images/p10.jpg" class="img-responsive" alt="/">
                    <h4>最好的服务、最好的菜品、最好的环境！</h4>
                    <p>肯德基（KentuckyFried Chicken，肯塔基州炸鸡），简称KFC，是美国跨国连锁餐厅之一，
                        也是世界第二大速食及最大炸鸡连锁企业，由哈兰·山德士于1930年在肯塔基州路易斯维尔创建，
                        主要出售炸鸡、汉堡、薯条、盖饭、蛋挞、汽水等高热量快餐食品。</p>
                    <P>肯德基隶属于百胜餐饮集团，并与百事可乐结成了战略联盟，固定销售百事公司提供的碳酸饮料。
                        2017年6月，《2017年BrandZ最具价值全球品牌100强》公布，肯德基排名第81位。</P>
                </div>
                <div class="col-md-5 about-grid1">
                    <h3>Our history</h3>
                    <div class="history">
                        <div class="hist-year">
                            <h5>1937:</h5>
                        </div>
                        <div class="hist-text">
                            <P>
                                狄克·麦当劳与兄弟迈克·麦当劳在洛杉矶东部开了一家汽车餐厅。由于他们制作的汉堡包味美价廉，深受顾客欢迎。虽然每个汉堡包只卖15美分，但年营业额仍超过了25万美元。这是相当可观的数目。</P>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="history">
                        <div class="hist-year">
                            <h5>1953:</h5>
                        </div>
                        <div class="hist-text">
                            <P>第一位加盟者福斯以1000美元的价格购买到麦当劳特许经营权，在凤凰城开了一家麦当劳快餐店。他得到的帮助除了新建筑的设计、一周货款和快捷服务的基本说明，其它什么都没有。</P>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="history">
                        <div class="hist-year">
                            <h5>1960:</h5>
                        </div>
                        <div class="hist-text">
                            <P>行政总裁雷.克洛克正式将“Dick and Mac McDonald”餐厅更名为“McDonald's” 。并以270万美元收购麦当劳兄弟的餐厅。</P>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="history">
                        <div class="hist-year">
                            <h5>1977:</h5>
                        </div>
                        <div class="hist-text">
                            <P>麦当劳正式在全国餐厅中增加多款套餐 1980 麦当劳成立25周年，麦当劳在香港开设第1000家国际餐厅，国际营业额首次突破10亿美元。</P>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="history">
                        <div class="hist-year">
                            <h5>2017:</h5>
                        </div>
                        <div class="hist-text">
                            <P>《2017年BrandZ全球最具价值品牌百强榜》公布，麦当劳以977.23亿美元的品牌价值在百强榜排名第10。</P>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="ourteam">
        <div class="container">
            <h3>our cooks</h3>
            <div class="team-grids">
                <div class="col-md-3 team-grid">
                    <img src="images/t1.jpg" class="img-responsive" alt=""/>
                    <h4>Bradley Grosh</h4>
                    <p>Were dolor in hendrerit in vulputate velit esse molestie con sequat,</p>
                </div>
                <div class="col-md-3 team-grid">
                    <img src="images/t2.jpg" class="img-responsive" alt=""/>
                    <h4>david austin</h4>
                    <p>Were dolor in hendrerit in vulputate velit esse molestie con sequat,</p>
                </div>
                <div class="col-md-3 team-grid">
                    <img src="images/t3.jpg" class="img-responsive" alt=""/>
                    <h4>Patrick Pool</h4>
                    <p>Were dolor in hendrerit in vulputate velit esse molestie con sequat,</p>
                </div>
                <div class="col-md-3 team-grid">
                    <img src="images/t4.jpg" class="img-responsive" alt=""/>
                    <h4>Dayle Peters</h4>
                    <p>Were dolor in hendrerit in vulputate velit esse molestie con sequat,</p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <script>
        $(function () {
            $("#updatePwdBtn").on("click", function () {
                $("#updatePwdModal").modal("toggle");
            });
        })
    </script>
</div>
<jsp:include page="/pages/front/include/include_title_foot.jsp"/>
</body>
</html>
