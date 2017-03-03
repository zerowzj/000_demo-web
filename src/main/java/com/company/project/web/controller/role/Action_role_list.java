package com.company.project.web.controller.role;

import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.company.project.service.role.RoleService;
import com.company.project.web.pattern.action.BaseAction;
import com.company.project.web.pattern.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by wangzhj on 2016/9/20.
 */
@Component
public class Action_role_list extends BaseAction<PopedomRoleEO> {

    @Autowired
    private RoleService roleService = null;

    @Override
    public void checkData(RequestContext requestContext, PopedomRoleEO param) {

    }

    @Override
    public Map<String, Object> execute(RequestContext requestContext, PopedomRoleEO param) {
        return null;
    }
}
