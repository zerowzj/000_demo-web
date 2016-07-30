<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="/static/layer/skin/layer.css"/>
</head>
<body>
<form id="_form" action="#" method="post">
    <div id="fun_tree" class="ztree">
    </div>
    <input type="button" id="_submit" value="提交">
</form>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/ztree/jquery.ztree.excheck.min.js"></script>--%>
<script type="text/javascript" src="/static/layer/layer.js"></script>
<script type="text/javascript">
    var funTreeSetting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        check: {
            enable: true,
            chkStyle: "checkbox",
            chkboxType: {"Y": "p", "N": "s"}
        },
        callback: {
            onCheck: function (event, treeId, treeNode) {
            }
        },
        view: {
            showIcon: false,
            fontCss: function (treeId, treeNode) {
                return treeNode.checked ? {} : {};
            }
        }
    };
    var prId = ${prId};
    var funTreeNode = ${tree};
    $(document).ready(function () {
        //生成树
        var zTreeObj = $.fn.zTree.init($("#fun_tree"), funTreeSetting, funTreeNode);
        //提交
        $("#_submit").click(function () {
            var nodes = zTreeObj.getCheckedNodes(true);
            var ids = new Array();
            for (var i = 0; i < nodes.length; i++) {
                ids.push(nodes[i].id);
            }
            var json = {prId: prId, pfIds: ids};
            $.ajax({
                url: '/role/conf',
                type: 'post',
                data: JSON.stringify(json),
                contentType: "application/json",
                dataType: 'json',
                success: function (data, textStatus) {
                    if(textStatus == 'success'){
                        layer.msg('成功', {offset: 0});
                    } else {

                    }
                }
            });
        });
    });
</script>
</body>
</html>