package com.company.project.web.controller.router.user;

import com.company.project.service.user.UserService;
import com.company.project.web.controller.action.user.Action_user_list;
import com.company.project.web.pattern.action.ActionExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户信息路由器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/user")
public class UserRouter {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/toList")
    public ModelAndView toList(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("/user/userList");
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response){
        return ActionExecutor.execute(request, response, Action_user_list.class);
    }
}
