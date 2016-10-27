package com.company.project.dao.popedomfunction;


import com.company.db.dao.BaseDao;

import java.util.List;

/**
 * 功能Dao
 *
 * @author wangzhj
 */
public interface PopedomFunctionDao extends BaseDao<PopedomFunctionEO> {

    /**
     * 获取功能列表
     *
     * @param pfLevel 功能级别
     * @return List<PopedomFunctionEO>
     */
    public List<PopedomFunctionEO> getFunctionLt(Integer pfLevel);

    /**
     * 获取功能列表
     *
     * @param pfParentId
     * @return List<PopedomFunctionEO>
     */
    public List<PopedomFunctionEO> getFunctionChildLt(Long pfParentId);

    /**
     * 获取角色的功能配置列表
     *
     * @param prId 角色编号
     * @return List<RoleFunctionConfVO>
     */
    public List<RoleFunctionConfVO> getRoleFunctionConfLt(Long prId);

    /**
     * 获取角色的功能列表
     *
     * @param prId 角色编号
     * @return List<RoleFunctionConfVO>
     */
    public List<PopedomFunctionEO> getRoleFunctionLt(Long prId, Integer[] pfLevelArr);
}
