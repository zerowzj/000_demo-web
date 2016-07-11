<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户登录</title>
    <link href="static/layout/layout-default-latest.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="ui-layout-center">Center
    <p><a href="http://layout.jquery-dev.com/demos.html">Go to the Demos page</a></p>

    <p>* Pane-resizing is disabled because ui.draggable.js is not linked</p>

    <p>* Pane-animation is disabled because ui.effects.js is not linked</p>
</div>
<div class="ui-layout-north">North</div>
<div class="ui-layout-south">South</div>
<div class="ui-layout-east">East</div>
<div class="ui-layout-west">West</div>

<script type="text/javascript" src="static/lib/jquery.min.js"></script>
<script type="text/javascript" src="static/layout/jquery.layout-latest.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('body').layout({
            scrollToBookmarkOnLoad: false // handled by custom code so can 'unhide' section first
            , defaults: {}
            , north: {
                size: "auto"
                , spacing_open: 0
                , closable: false
                , resizable: false
            }
            , west: {
                size: 250,
                spacing_closed: 22,
                togglerLength_closed: 140
                , togglerAlign_closed: "top"
                , togglerContent_closed: "你好\<BR\>"
                , togglerTip_closed: "Open & Pin Contents"
                , sliderTip: "Slide Open Contents"
                , slideTrigger_open: "mouseover"
            }
        });
    });
</script>
</body>
</html>