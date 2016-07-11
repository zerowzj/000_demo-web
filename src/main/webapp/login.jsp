<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户登录</title>
    <link href="static/css/login.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<section class="container">
    <div class="login">
        <h3>用户登录</h3>

        <form action="login.html" method="post">
            <p><input type="text" name="loginName" value="" placeholder="用户名"></p>

            <p><input type="password" name="loginPwd" value="" placeholder="密码"></p>

            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember_me">
                    记住密码
                </label>
            </p>

            <p class="submit"><input type="submit" value="登录"></p>
        </form>
    </div>
    <div class="login-help">
        <p>忘记密码? <a href="index.html">点击修改</a>.</p>
    </div>
</section>
<div style="text-align:center;">
    <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>