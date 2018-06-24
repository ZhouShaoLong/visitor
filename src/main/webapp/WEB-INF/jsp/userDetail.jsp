<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>用户详情</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="nurealam sabbir">
    <meta content="width=device-width,initial-scale=1" name="viewport">
    <link rel="shortcut icon" href="../../static/img/userDetail/favicon.png">
    <link rel="apple-touch-icon" href="../../static/img/userDetail/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="../../static/img/userDetail/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="../../static/img/userDetail/apple-touch-icon-114x114.png">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css"> 
    <link rel="stylesheet" type="text/css" href="../../static/css/userDetail/style.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/css/userDetail/simpletextrotator.css">
    
    <script src="../../static/js/userDetail/jquery.min.js"></script> <!-- JQUERY -->
</head>
<body>

    <div class="loading-screen"></div>
    <div id="frontpage">
        <div class="shadow-img"></div> 
        <img src="../../static/img/userDetail/front-image.jpg" class="front-img img-responsive" alt ="Front-image"><!--IMAGE FOR FRONT SCREEN-->
        <h1><span class="invert">${user.getName()}</span></h1><!--PROFILE NAME-->
        <h3 class="invert" style="margin-top: -10px; margin-bottom: 10px;">为了：<span class="rotate">舒适, 便捷, 安全</span></h3> <!--SUBTITLE IN PROFILE-->
        <div class="frontclick"><img src="../../static/img/userDetail/click.png" alt="" class="img-responsive"><span class="pulse"></span></div>
    </div>
    <!--FRONT PAGE/ SPLASH SCREEN SECTION ENDS-->
    <!--container-->
    <div class="container">
        <div id="content" class="row hidden">
            <div class="col-sm-4">
                <!--namecard-->
                <div id="namecard" class="namecard">
                    <div class="shadow-img"></div>
                    <h1 class="maintitle"><span class="invert">${user.getName()}</span></h1><!--PROFILE NAME-->
                    <h3 class="invert sub-maintitle">为了：
                        <span class="rotate">舒适, 便捷, 安全</span><!--SUBTITLE AFTET NAME-->
                    </h3>
                    <img id="profile-img" class="profile-img transparent" src="../../static/img/userDetail/profile-thum.png" alt="profile-image"/><!--PROFILE IMAGE-->
                </div><!--/#namecard-->
                <!--menu-->
                <div id="menu-container">
                    <!--PAGE MENU-->
                    <ul class="nav-menu no-padding">
                        <li class="nav-btn selected" title="Home" data-page="home">
                            <div class="hover-background"></div>
                            <span>信息</span><i class="fa fa-user fa-fw"></i>
                        </li>
                        <li class="nav-btn" id="resume-btn" title="Resume"  data-page="resume">
                            <div class="hover-background"></div>
                            <span>投诉</span><i class="fa fa-file-text fa-fw"></i>
                        </li>
                        <li class="nav-btn" title="Contact" id="contact-link" data-page="contact">
                            <div class="hover-background"></div>
                            <span>联系</span><i class="fa fa-paper-plane fa-fw"></i>
                        </li>
                    </ul><!--/.nav-menu __PAGE MENU ENDS-->

                    <!--SOCIAL NAV MENU-->
                    <div class="social-menu-container">
                        <ul class="social-menu no-padding">                     
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#"><i class="fa fa-leaf"></i></a></li>
                            <li><a href="#"><i class="fa fa-pinterest-p"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                    </div><!--/.social-menu-container-->
                </div><!--#menu-container-->
            </div>
            <div class="col-sm-8 page-segment">
                <ul class="page-container no-padding">
                    <!--信息-->
                    <li id="home" class="selected">
                        <div class="title-container hidden">
                            <div class="shadow-img"></div> 
                            <h2 class="rotate-out">欢迎 </h2><!--HOME TITLE-->
                        </div>
                        <div class="description hidden">
                            <div class="watermark-home"></div> 

                            <div class="fade-text transparent">
                                <!--DESCRIPTION ON HOME-->
                                <div class="strong-text">欢迎使用<span>游客服务系统</span></div>
                                <div class="focus-text"><span>希望你能 </span><span>找到最适合自己的旅程</span></div>
                                <p class="large-paragraph">如果喜欢我们。可以给我们建议，让我们一起变得更好！</p>
                                <!--DESCRIPTION ON HOME ENDS-->
                            </div>

                            <!--ALL PERSONAL DETAILS-->
                            <h3 class="personal-info-title title">个人信息</h3>
                            <ul class="personal-info">
                                <li class="rotate-out rotated"><label>ID</label><span>${user.getId()}</span></li>
                                <li class="rotate-out rotated"><label>昵称</label><span>${user.getName()}</span></li>
                                <li class="rotate-out rotated"><label>邮箱</label><span>${user.getEmail()}</span></li>
                                <li class="rotate-out rotated"><label>电话</label><span>${user.getPhone()}</span></li>
                            </ul><!--/ul.personal-info-->
                        </div>
                    </li><!--/#home-->

                    <!--投诉页-->
                    <li id="resume" class="hidden">
                        <div class="title-container">
                            <div class="shadow-img"></div>
                            <h2 class="rotate-out rotated"><span class="invert">您的投诉</span></h2> <!--RESUME TITLE-->
                        </div>
                        <div class="description">

                            <div class='tabs tabs_animate'>
                                <!--TAB-->
                                <ul class='horizontal no-padding'>
                                    <li><a href="#tab-1" class="icon-bg icon-skills"><div>全部</div></a></li>
                                    <li><a href="#tab-2" class="icon-bg icon-education"><div>已处理</div></a></li>
                                    <li><a href="#tab-3" class="icon-bg icon-employment"><div>未处理</div></a></li>
                                </ul><!--RESUME TAB LISTS ENDS-->

                                <!--FIRST TAB/SKILL TAB DETAILS-->
                                <div id='tab-1'>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>投诉标题</th>
                                            <th>是否处理</th>
                                            <th>评价星级</th>
                                            <th>日期</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${complaints}" var="complaint" begin="0" end="5">
                                            <tr>
                                                <td><a href="<c:url value="/complaint/detail.do?complaint_id="/>${complaint.getId()}">${complaint.getTitle()}</a></td>
                                                <td>
                                                    <c:if test="${complaint.getHandleStatus()==0}">
                                                        <c:out value="否"/>
                                                    </c:if>
                                                    <c:if test="${complaint.getHandleStatus()==1}">
                                                        <c:out value="是"/>
                                                    </c:if>
                                                </td>
                                                <td>${complaint.getStar()}</td>
                                                <td>${complaint.getSetTime()}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <a href="/complaint/showAll.do?page=1">更多</a>
                                </div><!--RESUME FIRST TAB/SKILL TAB DETAILS ENDS-->
                                
                                <!--SECOND TAB/EDUCATION TAB DETAILS-->
                                <div id='tab-2'>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>投诉标题</th>
                                            <th>处理时间</th>
                                            <th>评价星级</th>
                                            <th>日期</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${handledComplaints}" var="complaint" begin="0" end="5">
                                            <tr>
                                                <td><a href="<c:url value="/complaint/detail.do?complaint_id="/>${complaint.getId()}">${complaint.getTitle()}</a></td>
                                                <td>${complaint.getHandleTime()}</td>
                                                <td>${complaint.getStar()}</td>
                                                <td>${complaint.getSetTime()}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <a href="/complaint/showAll.do?page=1">更多</a>
                                </div><!--RESUME SECOND TAB/EDUCATION TAB DETAILS ENDS-->
                                <!--THIRD TAB/EMPLYMENT TAB DETAILS ENDS-->
                                <div id='tab-3'>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>投诉标题</th>
                                            <th>评价星级</th>
                                            <th>日期</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${unHandledComplaints}" var="complaint" begin="0" end="5">
                                            <tr>
                                                <td><a href="<c:url value="/complaint/detail.do?complaint_id="/>${complaint.getId()}">${complaint.getTitle()}</a></td>
                                                <td>${complaint.getStar()}</td>
                                                <td>${complaint.getSetTime()}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <a href="/complaint/showAll.do?page=1">更多</a>
                                </div><!--THIRD TAB/EMPLYMENT TAB DETAILS ENDS-->
                            </div>
                        </div>
                    </li>

                    <!--联系-->
                    <li id="contact" class="hidden">
                        <div class="title-container" >
                            <div class="shadow-img"></div>               
                           <h2 class="rotate-out rotated">联系我们</h2><!--CONTACT PAGE TITLE-->
                        </div>
                        <div class="description">                           
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="map-container">
                                        <div id="map" style="width:100%;height:325px;"></div><!--GOOGLE MAP-->
                                    </div>
                                </div>

                                <div class="col-sm-5">
                                    <!--CONTACT DESCRIPTION-->
                                    <h3 class="title">联系信息</h3>
                                    <h6 class="sm-title"><span class="address-icon"><i class="fa fa-map-marker"></i></span>四川大学软件学院</h6>
                                    <h6 class="sm-title"><span class="address-icon"><i class="fa fa-phone"></i></span>+1234567890</h6>
                                    <h6 class="sm-title"><span class="address-icon"><i class="fa fa-envelope"></i></span>info</h6>
                                    <!--/CONTACT DESCRIPTION ENDS-->
                                </div>
                                <div class="col-sm-7">

                                    <div class="mail-container">
                                        <h3 class="title invert">别忘了联系我们，并留下您的联系方式。</h3>
                                        <!--CONTACT FORM-->
                                        <form action="#" class="form-horizontal" id="contact-form">
                                            <div class="form-group">
                                                <input name="name" class="form-control required" placeholder="姓名" data-placement="top" type="text">
                                            </div>                                    
                                            <div class="form-group">
                                                <input name="email" class="form-control email" placeholder="邮箱" type="text">
                                            </div>                   
                                            <div class="form-group">
                                                <textarea name="message" class="form-control" placeholder="留言" rows="3"></textarea>
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-success">发送</button>
                                            </div>

                                        </form><!--/#contact-form-->
                                    </div>                      
                                    
                                </div>                          
                                
                            </div>
                        </div>
                    </li><!--/#contact-->
                </ul> 

                <div class="row mobile-nav-container">
                    <!--SOCIAL NAV FOR MOBILE-->
                    <ul class="mobile-social no-padding">
                        <li>Connect With Me</li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest-p"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    </ul><!--/.mobile-social-->
                </div>               
            </div><!--/.page-segment -->
            <!--  <h6 class="copyright-text">Copyright © 2015 Li Dada</h6> --> <!--if anyone wants copyright Texts--> 
        </div>
    </div><!--/.container -->

    <script type="text/javascript" src="../../static/js/userDetail/jQueryTween-aio-min.js"></script> <!-- JQUERY Tween Plugin -->
    <script type="text/javascript" src="../../static/js/userDetail/jquery.tabslet.min.js"></script> <!-- JQUERY Tab plugin-->
    <script type="text/javascript" src="../../static/js/userDetail/progressbar.min.js"></script> <!-- JQUERY Progressbar Plugin-->
    <script type="text/javascript" src="../../static/js/userDetail/jquery.simple-text-rotator.min.js"></script> <!-- JQUERY Text Rotator-->
    <script type="text/javascript" src="../../static/js/userDetail/bootstrap.min.js"></script> <!-- Bootstrap file-->
    <script src="../../static/js/ditu.js"></script>
    <script type="text/javascript" src='../../static/js/userDetail/isotope.pkgd.min.js'></script> <!--SCRIPTS FOR PORTFOLIO IMAGE'S ANIMATION-->
    <script type="text/javascript" src="../../static/js/userDetail/custom.js"></script>
</body>
</html>