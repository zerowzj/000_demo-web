package com.company.project.web.controller.user;

import com.company.project.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/toList")
    public ModelAndView toList(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("/user/userList");
    }
}
