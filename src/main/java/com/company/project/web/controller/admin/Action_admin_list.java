package com.company.project.web.controller.admin;

import com.company.project.dao.useradmin.UserAdminEO;
import com.company.project.service.admin.AdminService;
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
@Component
public class Action_admin_list extends BaseAction<Map<String, Object>> {

    @Autowired
    private AdminService adminService = null;

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

        PageList<UserAdminEO> uaEOLt = adminService.getAdminPageLt(StringUtils.trimToNull(ubLoginName), Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        data.put("ubEOLt", uaEOLt);
        data.put("pageNo", uaEOLt.getPaginator().getPage());
        data.put("pageSize", uaEOLt.getPaginator().getLimit());
        data.put("totalCount", uaEOLt.getPaginator().getTotalCount());
        return data;
    }
}
