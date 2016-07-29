package com.company.project.dao.popedomfunction;

import com.company.project.common.db.BaseDao;

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
     * @param prLevel 角色状态
     * @return List<PopedomFunctionEO>
     */
    public List<PopedomFunctionEO> getFunctionLt(Integer prLevel);

    /**
     * 获取功能列表
     *
     * @param prLevel 角色状态
     * @return List<PopedomFunctionEO>
     */
    public List<RoleFunctionConfVO> getRoleFunctionConfLt(Long prId);
}
