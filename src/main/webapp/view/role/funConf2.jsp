<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath()%>/static/jstree/themes/default/style.min.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/jstree/jstree.min.js"></script>
    <script type="text/javascript">
        <!--
        $(document).ready(function () {
            $('#tree').jstree({ 'plugins' : ["wholerow", "checkbox"],
                'core': {
                    'data': [
                        {"id": "1", "parent": "#", "text": "Simple root node"},
                        {"id": "2", "parent": "#", "text": "Root node 2"},
                        {"id": "3", "parent": "1", "text": "Child 1"},
                        {"id": "4", "parent": "1", "text": "Child 2"},
                        {"id": "5", "parent": "2", "text": "Child 2"},
                        {"id": "6", "parent": "2", "text": "Child 2"},
                    ]
                }
            });
        });
        //-->
    </script>
</head>
<body>
<form id="_form" action="#" method="post">
    <div id="tree">
    </div>
    <input type="submit" value="提22交">
</form>
<script type="text/javascript">
    $(document).ready(function () {
        $("#_form").submit(function () {
            var formParam = $("#_form").serialize();//序列化表格内容为字符串
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