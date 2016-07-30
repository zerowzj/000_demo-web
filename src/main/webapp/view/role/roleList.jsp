<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>角色列表</title>
</head>
<body>

<div class="div_search">
            <span>
                <form id="_form" action="/role/list" method="post">
                    角色名称：<input type="text" name="prName" value="${prName}" style="width: 120px;">
                    <input value="查询" type="submit"/>
                    <input type="hidden" id="_pageNo" name="pageNo">
                </form>
            </span>
</div>
<div style="font-size: 13px; margin: 10px 5px;">
    <table class="table_a" border="1" width="100%">
        <thead>
        <tr style="font-weight: bold;">
            <td>角色编号</td>
            <td>角色名称</td>
            <td>角色状态</td>
            <td>创建时间</td>
            <td>描述</td>
            <td align="center">操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dataLt}" var="prEO">
            <tr>
                <td>${prEO.prId}</td>
                <td>${prEO.prName}</td>
                <td>${prEO.prStatus}</td>
                <td>${prEO.prStatus}</td>
                <td>${prEO.prDesc}</td>
                <td><a href="#" role-id="${prEO.prId}" role-name="${prEO.prName}">分配功能</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>
            <td colspan="20" style="text-align: center;">
                <div id="page" class="m-pagination" align="center"></div>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript" src="/static/layer/layer.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("a[href='#']").on('click', function (event) {
            layer.open({
                type: 2,
                title: [$(this).attr("role-name"), 'font-size:16px;'],
                shadeClose: true, //点击遮罩关闭层
                area: ['500px', '530px'],
                fix: false, //不固定
                maxmin: true,
                content: '/role/toConf?prId=' + $(this).attr("role-id")
            });
        });
    });
</script>
</body>
</html>