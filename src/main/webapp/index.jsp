<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv=content-type content="text/html; charset=utf-8"/>
    <meta http-equiv=pragma content=no-cache/>
    <meta http-equiv=cache-control content=no-cache/>
    <meta http-equiv=expires content=-1000/>
    <script type="text/javascript" src="/static/lib/jquery.min.js"></script>
    <script type="text/javascript" src="/static/layout/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/static/layout/jquery.layout-latest.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('body').layout({ applyDemoStyles: true });
        });
    </script>
    <title>管理平台</title>
</head>
<div class="ui-layout-center">Center
    <p><a href="http://layout.jquery-dev.com/demos.html">Go to the Demos page</a></p>
    <p>* Pane-resizing is disabled because ui.draggable.js is not linked</p>
    <p>* Pane-animation is disabled because ui.effects.js is not linked</p>
</div>
<div class="ui-layout-north">North</div>
<div class="ui-layout-south">South</div>
<div class="ui-layout-east">East</div>
<div class="ui-layout-west">West</div>

</html>