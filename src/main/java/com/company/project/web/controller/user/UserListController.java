package com.company.project.web.controller.user;

import com.company.project.dao.userbase.UserBaseEO;
import com.company.project.exception.ParamEmptyValueException;
import com.company.project.exception.ParamFormatErrorException;
import com.company.project.service.user.UserService;
import com.company.project.web.pattern.BaseController;
import com.company.project.web.pattern.RequestContext;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhj on 2016/9/20.
 */
@Controller
@RequestMapping("/user/list")
public class UserListController extends BaseController{

    @Autowired
    private UserService userService = null;

    @Override
    public void checkData(RequestContext requestContext) {
        if(true){
            throw new ParamFormatErrorException("ubLoginName", "wangzhj");
        }
    }

    @Override
    public Map<String, Object> execute(RequestContext requestContext) {
        Map<String, Object> data = new HashMap<>();

        String ubLoginName = requestContext.getRequest().getParameter("ubLoginName");
        String pageNo = requestContext.getRequest().getParameter("pageNo");
        if(StringUtils.trimToNull(pageNo) == null){
            pageNo = "1";
        }
        String pageSize = requestContext.getRequest().getParameter("pageSize");
        if(StringUtils.trimToNull(pageSize) == null){
            pageSize = "10";
        }

        PageList<UserBaseEO> ubEOLt = userService.getUserPageLt(StringUtils.trimToNull(ubLoginName), Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        data.put("ubEOLt", ubEOLt);
        data.put("pageNo", ubEOLt.getPaginator().getPage());
        data.put("pageSize", ubEOLt.getPaginator().getLimit());
        data.put("totalCount", ubEOLt.getPaginator().getTotalCount());
        return data;
    }

    @Override
    public void editData(RequestContext requestContext, Map<String, Object> dataMap) {
    }
}
