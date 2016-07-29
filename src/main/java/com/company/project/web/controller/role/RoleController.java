package com.company.project.web.controller.role;

import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.company.project.service.function.FunctionService;
import com.company.project.service.role.RoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/toList")
    public ModelAndView toList(HttpServletRequest request, HttpServletResponse response) {
        //
        return new ModelAndView("/role/roleList");
    }

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap();
        PageList<PopedomRoleEO> pageLt = roleService.getRolePageLt(null, 1, 10);
        //
        model.put("dataLt", pageLt);
        model.put("page", pageLt.getPaginator());
        //
        return new ModelAndView("role/roleList", model);
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/role/roleAdd");
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response, PopedomRoleEO prEO) {
        Map<String, Object> model = new HashMap();
        try {
            Thread.currentThread().sleep(5 * 1000);
        } catch (Exception ex) {
        }


        model.put("success", "okkkkkkkkkkkk");
        return model;
    }

    @RequestMapping("/toConf")
    public ModelAndView toConfFun(HttpServletRequest request, HttpServletResponse response) {
        //
        Map<String, Object> model = new HashMap<>();

        List<PopedomFunctionEO> pfEOLt = functionService.getFunctionLt();
        List<FunctionTree> treeLt = new ArrayList<>();
        FunctionTree tree = null;
        for (PopedomFunctionEO pfEO : pfEOLt) {
            tree = new FunctionTree();

            Long id = pfEO.getPfId();
            tree.setId(String.valueOf(id));
            Long parentId = pfEO.getPfParentId();
            if (parentId == null) {
                tree.setParent("#");
            } else {
                tree.setParent(String.valueOf(parentId));
            }

            tree.setText(pfEO.getPfName());

            treeLt.add(tree);
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            model.put("tree", mapper.writeValueAsString(treeLt));
        } catch (Exception ex) {
        }

        return new ModelAndView("/role/funConf2", model);
    }

    @RequestMapping("/confFun")
    @ResponseBody
    public Map<String, Object> confFun(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap();

        return model;
    }
}
