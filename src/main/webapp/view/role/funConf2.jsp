<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String baseUrl = request.getContextPath();
    %>
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="<%=baseUrl%>/static/jstree/themes/default/style.min.css"/>
    <script type="text/javascript" src="<%=baseUrl%>/static/jstree/jstree.min.js"></script>
    <script type="text/javascript">
        <!--
        $(document).ready(function () {
            var jsTree = $('#tree').jstree({
                'plugins': ["wholerow", "checkbox"],
                'core': {
                    'data': [
                        {"id": "1", "parent": "#", "text": "角色管理"},
                        {"id": "2", "parent": "#", "text": "用户管理"},
                        {"id": "3", "parent": "1", "text": "新增角色"},
                        {"id": "4", "parent": "1", "text": "角色列表"},
                        {"id": "5", "parent": "2", "text": "注册用户"},
                        {"id": "6", "parent": "2", "text": "用户列表"},
                    ]
                }
            });
            jsTree.on("enable_checkbox.jstree", function (e, data) {
                alert(data.node.id);
            });
        });
        //-->
    </script>
</head>
<body>
<form id="_form" action="#" method="post">
    <div id="tree">
    </div>
    <input type="submit" value="提交">
</form>
<script type="text/javascript">
    $(document).ready(function () {
        $("#_form").submit(function () {
            var formParam = $("#_form").serialize();
            alert(formParam);
            $.ajax({
                type: 'post',
                url: '/role/confFun',
                data: formParam,
                cache: false,
                dataType: 'json',
                success: function (data) {
                    alert(data);
                }
            });
        });
    });
</script>
</body>
</html>