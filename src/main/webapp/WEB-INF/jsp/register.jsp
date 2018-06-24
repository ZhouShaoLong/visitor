<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2017/7/21
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册</title>
    <link rel="stylesheet" media="screen" href="../../static/css/user/zzsc.css"/>
</head>
<body>
<form action="/user/register.do" method="post" id="msform">
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">创建你的账户</h2>
        <h3 class="fs-subtitle">第一步</h3>
        <input type="text" name="name" placeholder="昵称"/>
        <input type="email" name="email" placeholder="邮箱"/>
        <input type="password" name="password" placeholder="密码"/>
        <input type="password" name="cpassword" placeholder="确认密码"/>
        <input type="button" name="next" class="next action-button" value="下一页"/>
    </fieldset>
    <fieldset>
        <h2 class="fs-title">个人信息</h2>
        <h3 class="fs-subtitle">第二步</h3>
        <input type="date" name="birthday" placeholder="生日"/>
        <input type="number" name="phone" placeholder="电话"/>
        <input type="number" name="qq" placeholder="QQ"/>
        <input type="text" name="address" placeholder="地址"/>
        <input type="button" name="previous" class="previous action-button" value="上一页"/>
        <input type="submit" name="1" class="action-button" value="提交"/>
    </fieldset>
</form>

<script src="../../static/js/jquery.min.js"></script>
<script src="../../static/js/user/jquery.easing.min.js" type="text/javascript"></script>
<script src="../../static/js/user/zzsc.js" type="text/javascript"></script>
</body>
</html>
