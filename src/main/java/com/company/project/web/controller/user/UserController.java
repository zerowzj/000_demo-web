package com.company.project.web.controller.user;

import com.company.project.dao.userbase.UserBaseEO;
import com.company.project.service.user.UserService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> model = new HashMap<>();

//        ZKUtil.print();
        String ubLoginName = request.getParameter("ubLoginName");
        String pageNo = request.getParameter("pageNo");
        if(StringUtils.trimToNull(pageNo) == null){
            pageNo = "1";
        }
        String pageSize = request.getParameter("pageSize");
        if(StringUtils.trimToNull(pageSize) == null){
            pageSize = "10";
        }

        PageList<UserBaseEO> ubEOLt = userService.getUserPageLt(StringUtils.trimToNull(ubLoginName), Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        model.put("ubEOLt", ubEOLt);
        model.put("pageNo", ubEOLt.getPaginator().getLimit());
        model.put("pageSize", ubEOLt.getPaginator().getPage());
        model.put("totalCount", ubEOLt.getPaginator().getTotalCount());
        return model;
    }
}
