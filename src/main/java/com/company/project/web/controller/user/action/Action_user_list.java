package com.company.project.web.controller.user.action;

import com.company.project.dao.userbase.UserBaseEO;
import com.company.project.exception.ParamEmptyValueException;
import com.company.project.service.user.UserService;
import com.company.project.web.pattern.action.BaseAction;
import com.company.project.web.pattern.context.RequestContext;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户列表Action
 *
 * @author wangzhj
 */
@Component("Action_user_list")
public class Action_user_list extends BaseAction<Map<String, Object>> {

    @Autowired
    private UserService userService = null;

    @Override
    public void checkData(RequestContext requestContext, Map<String, Object> param) {
       /* if (true) {
            throw new ParamEmptyValueException("ubLoginName");
        }*/
    }

    @Override
    public Map<String, Object> execute(RequestContext requestContext, Map<String, Object> param) {
        Map<String, Object> data = new HashMap<>();

        String ubLoginName = requestContext.getRequest().getParameter("ubLoginName");
        String pageNo = requestContext.getRequest().getParameter("pageNo");
        if (StringUtils.trimToNull(pageNo) == null) {
            pageNo = "1";
        }
        String pageSize = requestContext.getRequest().getParameter("pageSize");
        if (StringUtils.trimToNull(pageSize) == null) {
            pageSize = "10";
        }

        PageList<UserBaseEO> ubEOLt = userService.getUserPageLt(StringUtils.trimToNull(ubLoginName), Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        data.put("ubEOLt", ubEOLt);
        data.put("pageNo", ubEOLt.getPaginator().getPage());
        data.put("pageSize", ubEOLt.getPaginator().getLimit());
        data.put("totalCount", ubEOLt.getPaginator().getTotalCount());
        return data;
    }
}
