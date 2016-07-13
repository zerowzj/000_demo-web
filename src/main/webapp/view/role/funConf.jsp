<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>角色列表</title>
    <link type="text/css" href="<%=request.getContextPath()%>/static/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
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

        $(document).ready(function () {
            $.fn.zTree.init($("#tree"), setting, zNodes);
        });
        //-->
    </script>
</head>
<body>
<div id="tree" class="ztree" >
</div>

</body>
</html>