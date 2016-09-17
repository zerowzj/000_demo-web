package com.company.project.service.role;

import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

/**
 * 角色服务
 *
 * @author wangzhj
 */
public interface RoleService {

    /**
     * 查询角色
     *
     * @param prName   角色名称
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return PageList<PopedomRoleEO>
     */
    public PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize);

    /**
     * 新增角色
     *
     * @param prEO 角色信息
     */
    public void addRole(PopedomRoleEO prEO);

    /**
     * 添加功能
     *
     * @param prId 角色编号
     * @param pfIdLt 功能编号列表
     */
    public void addFunction(Long prId, List<Long> pfIdLt);
}
