<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="http://www.company.com/tag" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="/static/pagination/mricode.pagination.css" rel="stylesheet"/>
    <title>用户列表</title>
</head>
<body>
<div class="div_search">
            <span>
                <form id="_form" action="#">
                    登录名：<input type="text" name="ubLoginName" style="width: 120px;">
                    <div id="city_china">所在地区
                        <select class="province" data-first-title="选择省份" disabled="disabled" name="province"></select>
                        <select class="city" disabled="disabled" data-first-title="选择城市" name="city"></select>
                        <select class="area" disabled="disabled" data-first-title="选择地区" name="area"></select>
                    </div>
                    <input value="查询" id="_button" type="button"/>
                </form>
            </span>
</div>
<div style="font-size: 13px; margin: 10px 5px;">
    <table class="table_a" border="1" width="100%">
        <thead>
        <tr style="font-weight: bold;">
            <td>用户编号</td>
            <td>登录名</td>
            <td>用户姓名</td>
            <td>用户类型</td>
            <td>用户状态</td>
            <td>创建时间</td>
            <td align="center">操作</td>
        </tr>
        </thead>
        <tbody id="dataLt">
        </tbody>
        <tr>
            <td colspan="20" style="text-align: center;">
                <div id="page" class="m-pagination" align="center"></div>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript" src="/static/pagination/mricode.pagination.js"></script>
<script type="text/javascript" src="/static/layer/layer.js"></script>
<script type="text/javascript" src="/static/jsrender/jsrender.min.js"></script>
<script type="text/javascript" src="/static/form/jquery.form.min.js"></script>
<script type="text/javascript" src="/static/cxselect/jquery.cxselect.min.js"></script>
<script id="theTmpl" type="text/x-jsrender">
    {{for ubEOLt}}
        <tr>
            <td>{{:ubId}}</td>
            <td>{{:ubLoginName}}</td>
            <td>{{:ubName}}</td>
            <td>{{:ubStatus}}</td>
            <td>{{:ubType}}</td>
            <td>{{:ubType}}</td>
            <td></td>
        </tr>
    {{/for}}

</script>
<script type="text/javascript">
    $(document).ready(function () {
        //
        $('#city_china').cxSelect({
            url: '/static/cxselect/cityData.json',
            selects: ['province', 'city', 'area'],
            emptyStyle: 'none'
        });
        //分页
        $("#page").pagination({
            pageBtnCount: 11,
            showFirstLastBtn: false,
            firstBtnText: "首页",
            lastBtnText: "尾页",
            prevBtnText: "上一页",
            nextBtnText: "下一页",
            loadFirstPage: true,
            pageElementSort: ['$page', '$size', '$jump', '$info'],
            showInfo: true,
            infoFormat: '共{total}条',
            noInfoText: '查询结果为空',
            showJump: false,
            jumpBtnText: '跳转',
            showPageSizes: true,
            pageSizeItems: [5, 10, 15, 20],
            debug: true,
            remote: {
                url: '/user/list',
                params: $('form').serialize(),
                pageParams: function (data) {
                    return {
                        pageNo: data.pageIndex + 1,
                        pageSize: data.pageSize
                    };
                },
                pageIndexName: 'pageNo',
                pageSizeName: 'pageSize',
                totalName: 'totalCount',
                traditional: false,
                success: function (data) {
                    //渲染数据
                    $("#dataLt").html($.templates("#theTmpl").render(data));
                },
                beforeSend: function () {
                },
                complete: function () {
                }
            }
        });
        //查询
        $("#_button").click(function () {
            //设置当前页
            $("#page").pagination('setPageIndex', 0);
            //设置查询参数
            $("#page").pagination('setParams', $('form').serialize());
            //请求
            $("#page").pagination('remote');
        });
    });
</script>
</body>
</html>