<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><sitemesh:write property='title'/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script type="text/javascript" src="/static/lib/jquery.min.js"></script>
    <sitemesh:write property='head'/>
</head>
<body>


<!-- 北部 -->
<div class="ui-layout-north">
    北
</div>
<!-- 西部 -->
<div class="ui-layout-west">
    <a href="/user/list">用户列表</a>
    <a href="/role/list">角色列表</a>
    <a href="/role/toFunConf">权限配置</a>
    <a href="/view/role/funConf.jsp">权限配置2</a>
</div>
<!-- 中部 -->
<div class="ui-layout-center">
    <sitemesh:write property='body'/>
</div>
<!-- 东部 -->
<div class="ui-layout-east">
    东
</div>
<!-- 南部 -->
<div class="ui-layout-south">
    南
</div>


<script type="text/javascript" src="/static/layout/jquery-ui.min.js"></script>
<script type="text/javascript" src="/static/layout/jquery.layout-latest.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('body').layout({
            applyDefaultStyles: true,
            scrollToBookmarkOnLoad: true,
            defaults: {},
            north: {
                applyDefaultStyles: true,
                size: "auto",
                spacing_open: 0,
                closable: false,
                resizable: false
            },
            west: {
                applyDefaultStyles: true,
                size: 250,
                spacing_closed: 22,
                togglerLength_open: 200,
                togglerLength_closed: 200,
                togglerAlign_open: "center",
                togglerAlign_closed: "center",
                togglerContent_closed: "你好",
                togglerTip_closed: "Open Pin Contents",
                sliderTip: "Slide Open Contents"
            }
        });
    });
</script>
</body>
</html>