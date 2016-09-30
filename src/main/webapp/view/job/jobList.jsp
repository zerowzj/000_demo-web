<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String baseUrl = request.getContextPath();
    %>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>作业列表</title>
    <link href="<%=baseUrl%>/static/css/mine.css" type="text/css" rel="stylesheet"/>
    <link href="<%=baseUrl%>/static/pagination/pagination.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="div_head">
            <span>
                <span style="float: left;">当前位置是：作业管理 => 作业列表</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                </span>
            </span>
</div>
<div></div>
<div class="div_search">
            <span>
                <form id="_form" action="/job/list" method="post">
                    作业名称：<input type="text" name="jbName" value="${jbName}" style="width: 150px;">
                    <input value="查询" type="submit"/>
                    <input type="hidden" id="_pageNo" name="pageNo">
                </form>
            </span>
</div>
<div style="font-size: 13px; margin: 10px 5px;">
    <table class="table_a" border="1" width="100%">
        <tbody>
        <tr style="font-weight: bold;">
            <td>作业编号</td>
            <td>作业名称</td>
            <td>Job Group</td>
            <td>Job Name</td>
            <td>执行对象</td>
            <td>执行方法</td>
            <td>执行方式</td>
            <td>并发性</td>
            <td>调度数量</td>
            <td>描述</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${jbVOLt}" var="jbVO" varStatus="index">
            <tr>
                <td><c:out value="${jbVO.jbId}"/></td>
                <td><c:out value="${jbVO.jbName}"/></td>
                <td><c:out value="${jbVO.jbJobGroup}"/></td>
                <td><c:out value="${jbVO.jbJobName}"/></td>
                <td><c:out value="${jbVO.jbExeObject}" default="-"/></td>
                <td><c:out value="${jbVO.jbExeMethod}" default="-"/></td>
                <td>
                    <c:choose>
                        <c:when test="${jbVO.jbExeMode == 'S'}">同步</c:when>
                        <c:otherwise>异步</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${jbVO.jbIsConcurrent}">可</c:when>
                        <c:otherwise>不可</c:otherwise>
                    </c:choose>
                </td>
                <td><c:out value="${jbVO.scheduleNum}" default="0"/></td>
                <td><c:out value="${jbVO.jbDesc}" default="-"/></td>
                <td><fmt:formatDate value="${jbVO.jbBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <c:if test="${jbVO.scheduleNum == null}">
                        <a href="/schedule/toAdd?jobId=${jbVO.jbId}">添加调度</a>
                    </c:if>
                    <c:if test="${jbVO.scheduleNum > 0}">
                        &nbsp;&nbsp;-&nbsp;
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="20" style="text-align: center;">
                <div id="page" class="m-pagination" align="center"></div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script src="<%=baseUrl%>/static/lib/jquery.min.js"></script>
<script src="<%=baseUrl%>/static/pagination/pagination.js"></script>
<script>
    $("#page").pagination({
        pageIndex: ${pageNo - 1},
        pageSize: ${pageSize},
        total: ${totalCount},
        pageBtnCount: 11,
        showInfo: true,
        infoFormat: '共{total}条',
        noInfoText: '查询结果为空'
    }).on("pageClicked", function (event, data) {
        $("#_pageNo").val(data.pageIndex + 1);
        $("#_form").submit();
    });
</script>
</body>
</html>