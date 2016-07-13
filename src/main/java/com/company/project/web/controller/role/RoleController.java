package com.company.project.web.controller.role;

import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.company.project.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 角色信息控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService = null;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {

        return new ModelAndView("/role/roleList");
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/role/roleAdd");
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response, PopedomRoleEO prEO) {
        return new ModelAndView("/role/roleList");
    }
}
