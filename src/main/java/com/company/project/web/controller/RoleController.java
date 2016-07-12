package com.company.project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 角色信息控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/list")
    public ModelAndView list(){

        return new ModelAndView("/role/roleList");
    }
}
