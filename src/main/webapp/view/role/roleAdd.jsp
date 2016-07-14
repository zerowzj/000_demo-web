<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/layer/skin/layer.css"/>
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
<script type="text/javascript">
    $(document).ready(function () {
        var loading;
        var ajaxOptions = {
            target: '',
            url: '/role/add',
            type: 'POST',
            clearForm: false,
            beforeSubmit: function (formData, jqForm, options) {
                loading = layer.load(2);
                return true;
            },
            success: function (responseText, statusText, xhr, $form) {
                layer.close(loading);
                layer.msg('成功', {icon: 1});
            }
        };
        $('#_form').ajaxForm(ajaxOptions);
    });
</script>
</body>
</html>