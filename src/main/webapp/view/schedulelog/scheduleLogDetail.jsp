<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String baseUrl = request.getContextPath();
    %>
    <title>调度日志</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <link href="<%=baseUrl%>/static/css/mine.css" type="text/css" rel="stylesheet">
    <style>
        textarea {
            border: 0;
            background-color: transparent;
            /*scrollbar-arrow-color:yellow;
            scrollbar-base-color:lightsalmon;
            overflow: hidden;*/
            color: #000000;
            height: auto;
        }
    </style>
</head>
<body>
<div class="div_head">
            <span>
                <span style="float:left">当前位置是：调度管理 => 调度日志 => 详情</span>
            </span>
</div>
<div></div>
<div style="font-size: 13px;margin: 10px 5px">
    <table border="1" width="100%" class="table_a">
        <tr>
            <td style="width:10%;font-weight: bold;">日志编号</td>
            <td><c:out value="${jslVO.jslId}" default="-"/></td>
            <td style="width:10%;font-weight: bold;">调度编号</td>
            <td><c:out value="${jslVO.jslJsId}" default="-"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold;">作业编号</td>
            <td><c:out value="${jslVO.jslJbId}" default="-"/></td>
            <td style="font-weight: bold;">作业名称</td>
            <td><c:out value="${jslVO.jbName}" default="-"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold;">上次触发时间</td>
            <td><fmt:formatDate value="${jslVO.jslPreFireTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td style="font-weight: bold;">下次触发时间</td>
            <td><fmt:formatDate value="${jslVO.jslNextFireTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold;">本次触发时间</td>
            <td><fmt:formatDate value="${jslVO.jslFireTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td style="font-weight: bold;">开始时间</td>
            <td><fmt:formatDate value="${jslVO.jslBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold;">结束时间</td>
            <td><fmt:formatDate value="${jslVO.jslEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td style="font-weight: bold;">耗时</td>
            <td><c:out value="${jslVO.jslTimeConsume}" default="-"/> ms</td>
        </tr>
        <tr>
            <td style="font-weight: bold;">通知信息</td>
            <td><c:out value="${jslVO.jslNotifyInfo}" default="-"/></td>
            <td style="font-weight: bold;">通知时间</td>
            <td><fmt:formatDate value="${jslVO.jslNotifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold;">执行结果</td>
            <td colspan="3">
                <c:choose>
                    <c:when test="${jslVO.jslExeResult == 'S'}">成功</c:when>
                    <c:when test="${jslVO.jslExeResult == 'R'}">被否决</c:when>
                    <c:when test="${jslVO.jslExeResult == 'E'}">异常</c:when>
                    <c:otherwise>-</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td style="font-weight: bold;">结果信息</td>
            <td colspan="4"><textarea cols="120" rows="18" disabled><c:out value="${jslVO.jslExeRemark}"/></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="返回" onclick="javascript:history.go(-1)">
            </td>
        </tr>
    </table>
</div>
</body>
</html>