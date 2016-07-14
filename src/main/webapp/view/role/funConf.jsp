<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/ztree/css/zTreeStyle/zTreeStyle.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/jquery.ztree.core.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/jquery.ztree.excheck.min.js"></script>
    <script type="text/javascript">
        <!--
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            check: {
                enable: true,
                chkStyle: "checkbox"
            }
        };
        var zNodes = [
            {
                name: "父节点1 - 展开", open: true,
                children: [
                    {
                        name: "父节点11 - 折叠",
                        children: [
                            {name: "叶子节点111"},
                            {name: "叶子节点112"},
                            {name: "叶子节点113"},
                            {name: "叶子节点114"}
                        ]
                    },
                    {
                        name: "父节点12 - 折叠",
                        children: [
                            {name: "叶子节点121"},
                            {name: "叶子节点122"},
                            {name: "叶子节点123"},
                            {name: "叶子节点124"}
                        ]
                    },
                    {name: "父节点13 - 没有子节点", isParent: true}
                ]
            },
            {
                name: "父节点2 - 折叠",
                children: [
                    {
                        name: "父节点21 - 展开", open: true,
                        children: [
                            {name: "叶子节点211"},
                            {name: "叶子节点212"},
                            {name: "叶子节点213"},
                            {name: "叶子节点214"}
                        ]
                    },
                    {
                        name: "父节点22 - 折叠",
                        children: [
                            {name: "叶子节点221"},
                            {name: "叶子节点222"},
                            {name: "叶子节点223"},
                            {name: "叶子节点224"}
                        ]
                    },
                    {
                        name: "父节点23 - 折叠",
                        children: [
                            {name: "叶子节点231"},
                            {name: "叶子节点232"},
                            {name: "叶子节点233"},
                            {name: "叶子节点234"}
                        ]
                    }
                ]
            },
            {name: "父节点3 - 没有子节点", isParent: true}

        ];

        var zTreeObj;
        $(document).ready(function () {
            zTreeObj = $.fn.zTree.init($("#tree"), setting, zNodes);

            $("#s").click(function(){
                var nodes = zTreeObj.getCheckedNodes(true);
                var msg = "name--id--pid\n";
                for (var i = 0; i < nodes.length; i++) {
                    msg += nodes[i].name+"--"+nodes[i].id+"--"+nodes[i].pId+"\n";
                }
                alert(msg);
            });
        });


        //-->
    </script>
</head>
<body>
<form id="_form" action="#" method="post">
<div id="tree" class="ztree">
</div>
    <input id="s" type="submit" value="提交">
</form>
<script type="text/javascript">
    $(document).ready(function(){
        $("#_form").submit(function(){
            var formParam = $("#_form").serialize();//序列化表格内容为字符串
            $.ajax({
                type: 'post',
                url: '/role/confFun',
                data: formParam,
                cache: false,
                dataType: 'json',
                success: function (data) {
                    alert(data);
                }
            });
        });
    });
</script>
</body>
</html>