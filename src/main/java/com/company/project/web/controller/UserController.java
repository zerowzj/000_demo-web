package com.company.project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangzhj
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public ModelAndView list(){


        return new ModelAndView("/user/userList");
    }
}
