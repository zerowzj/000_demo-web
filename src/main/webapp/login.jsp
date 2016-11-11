<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" buffer="128kb" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户登录</title>
</head>
<body>
<form action="/login.html" method="post">
    <div align="center" style="margin-top: 60px">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="loginName" maxlength="20"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="loginPwd"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>