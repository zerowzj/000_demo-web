<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String baseUrl = request.getContextPath();
    %>
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="<%=baseUrl %>/static/layer/skin/layer.css"/>
</head>
<body>
<form id="_form" action="#">
    <table>
        <tr>
            <td>角色名称</td>
            <td><input type="text" name=""></td>
        </tr>
        <tr>
            <td>角色名称</td>
            <td><textarea name=""></textarea></td>
        </tr>
        <tr>
            <td><input type="button" value="返回"></td>
            <td><input type="submit" value="新增"></td>
        </tr>
    </table>
</form>

<script type="text/javascript" src="/static/form/jquery.form.min.js"></script>
<script type="text/javascript" src="/static/layer/layer.js"></script>
<script type="text/javascript" src="/static/js/global.js"></script>
<script type="text/javascript" src="/static/js/role.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        latte.role.add();
    });
</script>
</body>
</html>