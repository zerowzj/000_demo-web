package com.company.project.service.function;

import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.dao.popedomfunction.RoleFunctionConfVO;

import java.util.List;

/**
 * @author wangzhj
 */
public interface FunctionService {

    /**
     *
     *
     * @param
     * @return List<PopedomFunctionEO>
     */
    public List<PopedomFunctionEO> getFunctionLt();

    public List<RoleFunctionConfVO> getRoleFunctionConfLt(Long prId);
}
