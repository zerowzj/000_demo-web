package com.company.project.web.controller.function;

import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.company.project.service.function.FunctionService;
import com.company.project.service.role.RoleService;
import com.company.project.web.controller.role.FunctionTree;
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
 * 角色信息控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService = null;

    @RequestMapping("/toList")
    public ModelAndView toList(HttpServletRequest request, HttpServletResponse response) {
        //
        return new ModelAndView("/function/functionList");
    }

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap();


        List<PopedomFunctionEO> functionLt = functionService.getFunctionLt();
        //
        model.put("dataLt", functionLt);
        //
        return new ModelAndView("function/functionList", model);
    }
}
