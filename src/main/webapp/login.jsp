<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" buffer="128kb" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户登录</title>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-theme.min.css">
    <script type="javascript" src="/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="form row">
        <form action="/login.html" method="post" class="form-horizontal col-sm-offset-6 col-md-offset-5"
              id="login_form">
            <h3 class="form-title">000000000</h3>

            <div class="col-sm-6 col-md-4">
                <div class="form-group">
                    <i class="fa fa-user fa-lg">1111111111</i>
                    <input class="form-control required" type="text" placeholder="请输入用户名" name="loginName"
                           autofocus="autofocus" maxlength="20"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg">22222222222</i>
                    <input class="form-control required" type="password" placeholder="Password" name="loginPwd"
                           maxlength="8"/>
                </div>
                <div class="form-group">
                    <label class="checkbox">
                        <input type="checkbox" name="remember" value="1"/> Remember me
                    </label>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success pull-right" value="登录"/>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>