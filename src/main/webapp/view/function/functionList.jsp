<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>角色列表</title>
    <link rel="stylesheet" href="/static/treetable/css/jquery.treetable.css"/>
    <link rel="stylesheet" href="/static/treetable/css/jquery.treetable.theme.default.css"/>
</head>
<body>
<div class="div_search">
            <span>
                <form id="_form" action="#" method="post">
                    角色名称：<input type="text" name="prName" value="${prName}" style="width: 120px;">
                    <input value="查询" type="submit"/>
                    <input type="hidden" id="_pageNo" name="pageNo">
                </form>
            </span>
</div>
<div style="font-size: 13px; margin: 10px 5px;">
    <table class="table_a" id="tree" border="1" width="100%">
        <thead>
        <tr style="font-weight: bold;">
            <td>功能名称</td>
            <td>功能级别</td>
            <td>功能状态</td>
            <td>功能路径</td>
            <td>功能描述</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dataLt}" var="pfEO">
            <tr data-tt-id='${pfEO.pfId}' data-tt-parent-id='${pfEO.pfParentId}'>
                <td>${pfEO.pfName}</td>
                <td>${pfEO.pfLevel}</td>
                <td>${pfEO.pfStatus}</td>
                <td>${pfEO.pfPath}</td>
                <td>${pfEO.pfPath}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>
            <%--<td colspan="20" style="text-align: center;">
                <div id="page" class="m-pagination" align="center"></div>
            </td>--%>
        </tr>
    </table>
</div>
<script type="text/javascript" src="/static/treetable/jquery.treetable.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var options = {
            expandable: true,
            initialState: 'expanded',
            nodeIdAttr: 'ttId',
            parentIdAttr: 'ttParentId'
        };
        $("#tree").treetable(options);
    });
</script>
</body>
</html>