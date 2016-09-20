package com.company.project.web.controller.role;

import com.company.project.common.tree.JSTree;
import com.company.project.common.tree.ZTree;
import com.company.project.common.util.JsonUtil;
import com.company.project.dao.popedomfunction.RoleFunctionConfVO;
import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.company.project.service.function.FunctionService;
import com.company.project.service.role.RoleService;
import com.company.project.web.pattern.action.ActionExecutor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService = null;
    @Autowired
    private FunctionService functionService = null;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap();

        String pageNo = request.getParameter("pageNo");
        if (StringUtils.trimToNull(pageNo) == null) {
            pageNo = "1";
        }
        String pageSize = request.getParameter("pageSize");
        if (StringUtils.trimToNull(pageSize) == null) {
            pageSize = "10";
        }
        PageList<PopedomRoleEO> pageLt = roleService.getRolePageLt(null, Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        //
        model.put("prEOLt", pageLt);
        //
        model.put("pageNo", pageLt.getPaginator().getPage());
        model.put("pageSize", pageLt.getPaginator().getLimit());
        model.put("totalCount", pageLt.getPaginator().getTotalCount());
        //
        return new ModelAndView("/role/roleList", model);
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/role/roleAdd");
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, PopedomRoleEO prEO) {
        return ActionExecutor.execute(request, response, "Action_role_add", prEO);
    }

    @RequestMapping("/toConf")
    public ModelAndView toConf(HttpServletRequest request, HttpServletResponse response) {
        //
        Map<String, Object> model = new HashMap<>();

        String prId = request.getParameter("prId");
        List<RoleFunctionConfVO> confVOLt = functionService.getRoleFunctionConfLt(Long.valueOf(prId));
        List<ZTree> treeLt = new ArrayList<>();
        ZTree zTree = null;
        for (RoleFunctionConfVO confVO : confVOLt) {
            zTree = new ZTree();

            Long id = confVO.getPfId();
            zTree.setId(id);
            Long parentId = confVO.getPfParentId();
            if (parentId != null) {
                zTree.setpId(parentId);
            } else {
                zTree.setNocheck(true);
            }
            zTree.setName(confVO.getPfName());

            Long c = confVO.getPrfPfId();
            if (c != null) {
                zTree.setChecked(true);

            }
            if ("Y".equals(confVO.getPfIsDef())) {
                zTree.setChecked(true);
                zTree.setDoCheck(false);
            }
            treeLt.add(zTree);
        }

        model.put("tree", JsonUtil.toJson(treeLt));
        model.put("prId", prId);
        return new ModelAndView("/role/funConf", model);
    }

    @RequestMapping("/toConf2")
    public ModelAndView toConf2(HttpServletRequest request, HttpServletResponse response) {
        //
        Map<String, Object> model = new HashMap<>();

        String prId = request.getParameter("prId");
        List<RoleFunctionConfVO> confVOLt = functionService.getRoleFunctionConfLt(Long.valueOf(prId));
        List<JSTree> treeLt = new ArrayList<>();
        JSTree jsTree = null;
        for (RoleFunctionConfVO confVO : confVOLt) {
            jsTree = new JSTree();

            Long id = confVO.getPfId();
            jsTree.setId(String.valueOf(id));
            Long parentId = confVO.getPfParentId();
            if (parentId == null) {
                jsTree.setParent("#");
            } else {
                jsTree.setParent(String.valueOf(parentId));
            }
            jsTree.setText(confVO.getPfName());

            Long c = confVO.getPrfPfId();
            JSTree.State state = new JSTree.State();
            if (c != null) {
                state.setSelected(true);
                state.setOpened(true);
//                state.setDisabled(true);
            } else {
                state.setSelected(false);
                state.setOpened(false);
                state.setDisabled(false);
            }
            jsTree.setState(state);

            treeLt.add(jsTree);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            model.put("tree", mapper.writeValueAsString(treeLt));
        } catch (Exception ex) {
        }

        return new ModelAndView("/role/funConf2", model);
    }

    @RequestMapping("/conf")
    @ResponseBody
    public Map<String, Object> conf(HttpServletRequest request, @RequestBody Map<String, Object> params) {
        Map<String, Object> model = new HashMap();
        //获取参数
        String prId = params.get("prId").toString();
        List<Integer> pfIdLt = (List) params.get("pfIds");
        List<Long> ids = new ArrayList<>();
        for (Integer i : pfIdLt) {
            ids.add(Long.parseLong(i.toString()));
        }
        //
        roleService.addFunction(Long.valueOf(prId), ids);
        //
        return model;
    }
}
