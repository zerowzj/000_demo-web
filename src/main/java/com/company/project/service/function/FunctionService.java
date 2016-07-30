package com.company.project.service.function;

import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.dao.popedomfunction.RoleFunctionConfVO;

import java.util.List;

/**
 * 功能信息服务
 *
 * @author wangzhj
 */
public interface FunctionService {

    /**
     * 获取功能列表
     *
     * @return List<PopedomFunctionEO>
     */
    public List<PopedomFunctionEO> getFunctionLt();

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
     * @return List<PopedomFunctionEO>
     */
    public List<PopedomFunctionEO> getRoleFunctionLt(Long prId);
}
