<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%
        String baseUrl = request.getContextPath();
    %>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>添加作业</title>
    <link href="<%=baseUrl%>/static/css/mine.css" type="text/css" rel="stylesheet">
    <link href="<%=baseUrl%>/static/validform/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="div_head">
            <span>
                <span style="float:left">当前位置是：作业管理 => 添加作业</span>
            </span>
</div>
<div></div>
<div style="font-size: 13px;margin: 10px 5px">
    <form id="_form" action="/job/add" method="post">
        <table border="1" width="100%" class="table_a">
            <tr>
                <td style="width:10%"><span class="need">*</span>作业名称</td>
                <td><input type="text" name="jbName"
                           datatype="zh_num"
                           nullmsg="请输入作业名称！" errormsg="汉字开头，可包含汉字、数字" sucmsg=" "
                           ajaxurl="/job/check/jobName"/></td>
            </tr>
            <tr>
                <td><span class="need">*</span>Job Group</td>
                <td>
                    <select name="jbJobGroup" datatype="*" nullmsg="请选择Job Group！" sucmsg=" ">
                        <option value="">请选择</option>
                        <option value="USER_SVR">user服务</option>
                        <option value="SOLR_SVR">solr服务</option>
                        <option value="ADMIN_SVR">admin服务</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><span class="need">*</span>Job Name</td>
                <td><input type="text" name="jbJobName"
                           datatype="ch_num"
                           nullmsg="请输入Job Name！" errormsg="字母开头，可包含字母、数字" sucmsg=" "/></td>
            </tr>
            <tr>
                <td><span class="need">*</span>执行对象</td>
                <td>
                    <input type="text" name="jbExeObject"
                           datatype="ch_num"
                           nullmsg="请输入执行对象！" errormsg="字母开头，可包含字母、数字" sucmsg=" "
                           ajaxurl="/job/check/bean"/>
                </td>
            </tr>
            <tr>
                <td><span class="need">*</span>执行方法</td>
                <td><input type="text" name="jbExeMethod"
                           datatype="ch_num"
                           nullmsg="请输入执行方法！" errormsg="字母开头，可包含字母、数字" sucmsg=" "/>
                </td>
            </tr>
            <tr>
                <td>执行方式</td>
                <td>
                    <input type="radio" name="jbExeMode" checked/>同步&nbsp;
                    <input type="radio" name="jbExeMode"/>异步
                </td>
            </tr>
            <tr>
                <td>描述</td>
                <td>
                    <textarea name="jbDesc" cols="40" rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="添加"> &nbsp;
                    <input type="button" value="返回" onclick="javascript:history.go(-1)">
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript" src="<%=baseUrl%>/static/lib/jquery.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>/static/validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>/static/validform/Validform_Datatype.js"></script>
<script type="text/javascript">
    $("#_form").Validform({
        tiptype: 3,
        tipSweep: false
    });
</script>
</body>
</html>