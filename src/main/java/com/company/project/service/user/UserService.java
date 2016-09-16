package com.company.project.service.user;

import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.company.project.dao.userbase.UserBaseEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 用户信息服务
 *
 * @author wangzhj
 */
public interface UserService {

    /**
     * 查询角色
     *
     * @param ubLoginName   角色名称
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return PageList<PopedomRoleEO>
     */
    public PageList<UserBaseEO> getUserPageLt(String ubLoginName, int pageNo, int pageSize);
}
