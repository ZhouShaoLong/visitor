<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" media="screen" href="../../static/css/user/zzsc.css"/>
</head>
<form id="msform" action="/user/login.do" method="post">
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">登陆你的账户</h2>
        <h3 class="fs-subtitle">体验更多精彩</h3>
        <input type="email" name="email" placeholder="Email"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="submit" name="login" class="action-button" value="登录"/>
        <input type="button" name="register" class="action-button" value="注册"
               onclick="window.open('/user/toRegister.do')"/>
    </fieldset>
</form>

<script src="../../static/js/jquery.min.js"></script>
<script src="../../static/js/user/jquery.easing.min.js" type="text/javascript"></script>
<script src="../../static/js/user/zzsc.js" type="text/javascript"></script>

</html>