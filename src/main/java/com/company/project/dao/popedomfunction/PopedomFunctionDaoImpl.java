package com.company.project.dao.popedomfunction;

import com.company.project.common.db.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("popedomFunctionDao")
public class PopedomFunctionDaoImpl extends BaseDaoImpl<PopedomFunctionEO> implements PopedomFunctionDao {

    @Override
    public List<PopedomFunctionEO> getFunctionLt(Integer prLevel) {
        Map<String, Object> params = new HashMap<>();
        params.put("prLevel", prLevel);
        return getSqlSession().selectList(getSqlId("getFunctionLt"), params);
    }

    @Override
    public List<RoleFunctionConfVO> getRoleFunctionConfLt(Long prId) {
        Map<String, Object> params = new HashMap<>();
        params.put("prId", prId);
        return getSqlSession().selectList(getSqlId("getRoleFunctionConfLt"), params);
    }

    @Override
    public List<PopedomFunctionEO> getRoleFunctionLt(Long prId, Integer[] pfLevelArr) {
        Map<String, Object> params = new HashMap<>();
        params.put("prId", prId);
        params.put("pfLevelArr", pfLevelArr);
        return getSqlSession().selectList(getSqlId("getRoleFunctionLt"), params);
    }

    @Override
    public List<PopedomFunctionEO> getFunctionChildLt(Long pfParentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("pfParentId", pfParentId);
        return getSqlSession().selectList(getSqlId("getFunctionChildLt"), params);
    }
}
