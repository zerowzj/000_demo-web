package com.company.project.dao.popedomrolefunction;

import com.company.project.common.db.BaseDao;

import java.util.List;

/**
 * 角色功能Dao
 *
 * @author wangzhj
 */
public interface PopedomRoleFunctionDao extends BaseDao<PopedomRoleFunctionEO> {

    /**
     * 批量插入角色功能
     *
     * @param prfEOLt 配置列表
     * @return int
     */
    public int insertBatch(List<PopedomRoleFunctionEO> prfEOLt);

    /**
     * 删除角色功能
     *
     * @param prfPrId 角色编号
     * @param prfPfId 功能编号
     * @return int
     */
    public int deleteBatch(Long prfPrId, Long prfPfId);
}
