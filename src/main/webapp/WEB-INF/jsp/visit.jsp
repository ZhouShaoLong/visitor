<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="../../static/img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="../../static/img/apple_icons_57x57.png">
    <link rel="apple-touch-icon" sizes="72x72" href="../../static/img/apple_icons_72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="../../static/img/apple_icons_114x114.png">
    <title>游客服务系统</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../static/css/theme.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../static/css/revslider.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../static/css/custom.css" type="text/css" media="all" />
    <script src="//cdn.tinymce.com/4/tinymce.min.js">
    </script>
    <script>
        tinymce.init({
            selector: 'textarea'
        });
    </script>
</head>
<body>
<div class="main_header type1">
    <div class="tagline">
        <div class="container">
            <div class="fright">
                <div class="tagline_items">
                    <div class="log_in_out"><a href="/admin/toAdminLogin.do"><i class="glyphicon-log-in"></i> 管理员登录</a></div>
                    <div class="log_in_out"><a href="/user/toLogin.do"><i class="icon-sign-in"></i> 用户登录</a></div>

                    <div class="cart_btn">
                        <i class="icon-user"></i>个人信息
                        <c:if test="${sessionScope.user!=null}">
                            <div class="cart_submenu">
                                <div class="cart_wrap">
                                    <ul class="product_posts">
                                        <li>
                                            <img src="../../static/img/user_icon999.png" alt="" />
                                            <h3>${user.getName()}</h3>
                                            <div class="price">${user.getEmail()}</div>
                                        </li>
                                    </ul>
                                    <a href="/user/detail.do" class=" shortcode_button btn_small btn_type5 mr15">用户详情</a>
                                    <a href="/user/logout.do" class=" shortcode_button btn_small btn_type1 mr0">注销</a>
                                </div>
                            </div></c:if>
                    </div>
                </div>

            </div>
            <div class="fleft">
                <div class="phone"><i class="icon-phone"></i> +1 800 245 39 25</div>
                <div class="email"><a href="mailto:#"><i class="icon-envelope"></i> info@yourdomain.com</a></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="header_parent_wrap">
        <header>
            <div class="container">
                <a class="top_menu_toggler" href="javascript:void(0)"></a>
                <div class="logo_sect">
                    <a href="/index.do" class="logo"><img src="../../static/img/logo2.png" class="logo_def" alt="" /><img src="../../static/img/retina/logo3.png" class="logo_retina" alt="" /></a>
                </div>
                <nav>
                    <ul class="menu">
                        <li class="current-menu-parent menu-item-has-children"><a href="/index.do">主页</a>
                        </li>
                        <li class="menu-item-has-children"><a href="#">功能查询</a>
                            <div class="sub-nav">
                                <ul class="sub-menu">
                                    <li><a href="/notice/noticeList.do?page=1">旅游应急信息</a></li>
                                    <li><a href="/hotel/showAll.do?page=1">星级酒店查询</a></li>
                                    <li><a href="/toVisit.do">旅游景点查询</a></li>
                                    <li><a href="/food/search.do?city=成都">餐饮娱乐查询</a></li>
                                    <li><a href="/performance/showAll.do?page=1">演出团体查询</a></li>
                                    <li><a href="http://www.weather.com.cn/weather/101270101.shtml" target="_blank">天气查询</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item-has-children"><a href="#">游客投诉</a>
                            <div class="sub-nav">
                                <ul class="sub-menu">
                                    <li><a href="/complaint/addInput.do">新建投诉</a></li>
                                    <li><a href="/complaint/showAllPublic.do?page=1">查看投诉</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="menu-item-has-children"><a href="/aboutus.do">关于我们</a>
                        </li>
                    </ul>
                </nav>
                <div class="clear"></div>
            </div>
        </header>
    </div>
</div>
    
    <div class="wrapper">
    	<div class="container">
        	<div class="page_title_block">
                <div class="bg_title">
                    <h2>旅游信息查询</h2>
                </div>
            </div>
        	<div class="content_block row no-sidebar">
            	<div class="fl-container">
                	<div class="posts-block">
                        <div class="contentarea">                        	
                            <div class="row">
                            	<div class="col-sm-12 module_cont pb20 animate" data-anim-type="fadeInLeft" data-anim-delay="300">
                                    <iframe src="http://map.baidu.com/" height="500px"></iframe>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </div>

<div class="footer">
    <div class="container">
        <div class="pre_footer">
            <div class="row">
                <div class="col-sm-3">
                    <div class="sidepanel widget_text">
                        <h4 class="title">联系我们</h4>
                        <p>四川大学软件学院</p>
                        <p>周绍龙  薛明峰  杨旭</p>
                        <p><span>手机:</span> 12345678901</p>
                        <p><span>地址:</span> 成都市双流县四川大学江安校区</p>
                        <p><span>邮箱:</span> <a href="mailto:#">info@scu.edu.cn</a></p>
                        <div class="footer_socials">
                            <ul>
                                <li><a href="javascript:void(0);" class="soc_fb"><i class="icon-facebook"></i></a></li>
                                <li><a href="javascript:void(0);" class="soc_tweet"><i class="icon-twitter"></i></a></li>
                                <li><a href="javascript:void(0);" class="soc_google"><i class="icon-google-plus"></i></a></li>
                                <li><a href="javascript:void(0);" class="soc_dribbble"><i class="icon-dribbble"></i></a></li>
                                <li><a href="javascript:void(0);" class="soc_pinterest"><i class="icon-pinterest"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="sidepanel widget_posts">
                        <h4 class="title">网站主程</h4>
                        <ul class="recent_posts">
                            <li class="with_img">
                                <div class="recent_posts_content">
                                    <img src="../../static/img/imgs/zhou.jpg" alt="" />
                                    <a href="javascript:void(0);" class="title">注册功能</a>
                                    <div class="recent_posts_info">2017-7-22  /  <a href="javascript:void(0);">2 days</a></div>
                                </div>
                            </li>
                            <li class="with_img">
                                <div class="recent_posts_content">
                                    <img src="../../static/img/imgs/shao.jpg" alt="" />
                                    <a href="javascript:void(0);" class="title">数据接口</a>
                                    <div class="recent_posts_info">2017-7-23  /  <a href="javascript:void(0);">2 day</a></div>
                                </div>
                            </li>
                            <li class="with_img">
                                <div class="recent_posts_content">
                                    <img src="../../static/img/imgs/long.jpg" alt="" />
                                    <a href="javascript:void(0);" class="title">应急功能</a>
                                    <div class="recent_posts_info">2017-7-25  /  <a href="javascript:void(0);">1 day</a></div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="sidepanel widget_posts">
                        <h4 class="title">网站主程</h4>
                        <ul class="recent_posts">
                            <li class="with_img">
                                <div class="recent_posts_content">
                                    <img src="../../static/img/imgs/xue1.jpg" alt="" />
                                    <a href="javascript:void(0);" class="title">登录功能</a>
                                    <div class="recent_posts_info">2017-7-22  /  <a href="javascript:void(0);">2 days</a></div>
                                </div>
                            </li>
                            <li class="with_img">
                                <div class="recent_posts_content">
                                    <img src="../../static/img/imgs/ming.jpg" alt="" />
                                    <a href="javascript:void(0);" class="title">投诉功能</a>
                                    <div class="recent_posts_info">2017-7-23  /  <a href="javascript:void(0);">2 days</a></div>
                                </div>
                            </li>
                            <li class="with_img">
                                <div class="recent_posts_content">
                                    <img src="../../static/img/imgs/feng.jpg" alt="" />
                                    <a href="javascript:void(0);" class="title">信息发布</a>
                                    <div class="recent_posts_info">2017-7-24  /  <a href="javascript:void(0);">1 day</a></div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="sidepanel widget_review">
                        <h4 class="title">布局&美工</h4>
                        <div class="last_review">
                            <p class="review_text">1.网站风格确定</p>
                            <p class="review_text">2.主界面UI设计</p>
                            <p class="review_text">3.界面连接设置</p>
                            <div class="clear"></div>
                            <div class="last_review_author">
                                <h5>Bright.Y</h5>
                                <h6>2017-7-24</h6>
                                <img src="../../static/img/imgs/yangxu.jpg" alt="" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer_bottom">
            <div class="copyright">Copyright 2017. All Rights Reserved by Software Engineering College, Premium HTML Template.</div>
            <div class="clear"></div>
        </div>
    </div>
</div>

<div class="fixed-menu"></div>

<script type="text/javascript" src="../../static/js/jquery.min.js"></script>
<script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../static/js/modules.js"></script>
<script type="text/javascript" src="../../static/js/theme.js"></script>
<script type="text/javascript" src="../../static/js/jquery.themepunch.plugins.min.js"></script>
<script type="text/javascript" src="../../static/js/jquery.themepunch.revolution.min.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        "use strict";
        jQuery('.fullscreen_slider').show().revolution({
            delay: 5000,
            startwidth: 1170,
            startheight: 765,
            fullWidth:"off",
            fullScreen:"on",
            navigationType:"bullet",
            fullScreenOffsetContainer: ".main_header",
            fullScreenOffset: ""
        });
    });
</script>

<!-- Portfolio -->
<script type="text/javascript" src="../../static/js/jquery.isotope.min.js"></script>
<script type="text/javascript" src="../../static/js/sorting.js"></script>
<script>
    items_set = [
        {src : 'static/img/portfolio/370_300/10.jpg', zoom : 'static/img/portfolio/370_300/10.jpg', url : 'portfolio_post_fullwidth.html', columnclass: 'col-sm-4', sortcategory: 'webui', title: 'Unde Sed ut', itemcategory: 'Print Design'},
        {src : 'static/img/portfolio/370_300/11.jpg', zoom : 'static/img/portfolio/370_300/11.jpg', url : 'portfolio_post_fullwidth.html', columnclass: 'col-sm-4', sortcategory: 'polygraphy', title: 'Tempore Nam Libero', itemcategory: 'Business'},
        {src : 'static/img/portfolio/370_300/12.jpg', zoom : 'static/img/portfolio/370_300/12.jpg', url : 'portfolio_post_fullwidth.html', columnclass: 'col-sm-4', sortcategory: 'textstyle', title: 'Dolores Magni', itemcategory: 'People'}
    ];
    jQuery('#list').portfolio_addon({
        type : 2, // 2-4 columns portfolio
        load_count : 3,
        items : items_set
    });
</script>
</body>
</html>