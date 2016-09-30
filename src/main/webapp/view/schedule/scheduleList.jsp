<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>调度列表</title>
    <link href="../../static/css/mine.css" type="text/css" rel="stylesheet"/>
    <link href="../../static/pagination/pagination.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="div_head">
            <span>
                <span style="float: left;">当前位置是：调度管理 => 调度列表</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                </span>
            </span>
</div>
<div></div>
<div class="div_search">
            <span>
                <form id="_form" action="/schedule/list" method="get">
                    作业名称：<input type="text" name="jbName" value="${jbName}" style="width: 150px;">
                    调度状态：<select name="jsStatus">
                    <option value="" <c:if test="${jsStatus == null || jsStatus == ''}">selected="selected"</c:if>>全部
                    </option>
                    <option value="W" <c:if test="${jsStatus == 'W'}">selected="selected"</c:if>>未开始</option>
                    <option value="R" <c:if test="${jsStatus == 'R'}">selected="selected"</c:if>>运行中</option>
                    <option value="P" <c:if test="${jsStatus == 'P'}">selected="selected"</c:if>>暂停中</option>
                </select>
                    <input value="查询" type="submit"/>
                    <input type="hidden" id="_pageNo" name="pageNo">
                </form>
            </span>
</div>
<div style="font-size: 13px; margin: 10px 5px;">
    <table class="table_a" border="1" width="100%">
        <tbody>
        <tr style="font-weight: bold;">
            <td>调度编号</td>
            <td>作业编号</td>
            <td>作业名称</td>
            <td>调度状态</td>
            <td>Cron表达式</td>
            <td>创建时间</td>
            <td>Trigger状态</td>
            <td>下次触发时间</td>
            <td align="center">操作</td>
        </tr>
        <c:forEach items="${jsVOLt}" var="jsVO" varStatus="index">
            <tr>
                <td><c:out value="${jsVO.jsId}"/></td>
                <td><c:out value="${jsVO.jsJbId}"/></td>
                <td><c:out value="${jsVO.jbName}"/></td>
                <td>
                    <c:choose>
                    <c:when test="${jsVO.jsStatus == 'R'}"><font color="red"></c:when>
                    <c:when test="${jsVO.jsStatus == 'P'}"><font color="blue"></c:when>
                        <c:otherwise><font></c:otherwise>
                            </c:choose>
                            <c:out value="${jsVO.jsStatusName}"/>
                        </font>
                </td>
                <td><c:out value="${jsVO.jsCronExp}"/></td>
                <td><fmt:formatDate value="${jsVO.jsBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><c:out value="${jsVO.triggerStatus}"/></td>
                <td><fmt:formatDate value="${jsVO.jsNextTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <a href="/schedule/toModify?jsId=${jsVO.jsId}">修改</a> |
                    <c:if test="${jsVO.jsStatus == 'W'}">
                        <a href="#" link="/scheduleAction/start?jsId=${jsVO.jsId}" name="${jsVO.jbName}">开始执行</a>
                    </c:if>
                    <c:if test="${jsVO.jsStatus == 'R'}">
                        <a href="#" link="/scheduleAction/pause?jsId=${jsVO.jsId}" name="${jsVO.jbName}">暂停执行</a>
                    </c:if>
                    <c:if test="${jsVO.jsStatus == 'P'}">
                        <a href="#" link="/scheduleAction/resume?jsId=${jsVO.jsId}" name="${jsVO.jbName}">恢复执行</a>
                    </c:if>
                    <a href="#" link="/scheduleAction/remove?jsId=${jsVO.jsId}" name="${jsVO.jbName}">停止执行</a>
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
<script type="text/javascript" src="../../static/lib/jquery.min.js"></script>
<script type="text/javascript" src="../../static/pagination/pagination.js"></script>
<script type="text/javascript" src="../../static/layer/layer.js"></script>
<script type="text/javascript">
    //分页显示
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
    //操作询问
    $("a[href='#']").on('click', function (event) {
        var op = $(this).html();
        var link = $(this).attr("link");
        var jbName = $(this).attr("name");
        layer.confirm('您确定【' + op + '】作业【' + jbName + '】吗？',
                {offset: '80px', btn: ['确定', '取消']},
                function (index, layero) {
                    window.location.href = link;
                },
                function () {
                });
    });
</script>
</body>
</html>