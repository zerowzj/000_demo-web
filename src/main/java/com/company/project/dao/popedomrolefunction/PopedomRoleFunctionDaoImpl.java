package com.company.project.dao.popedomrolefunction;

import com.company.db.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("popedomRoleFunctionDao")
public class PopedomRoleFunctionDaoImpl extends BaseDaoImpl<PopedomRoleFunctionEO> implements PopedomRoleFunctionDao {

    @Override
    public int insertBatch(List<PopedomRoleFunctionEO> prfEOLt) {
        return getSqlSession().insert(getSqlId("insertBatch"), prfEOLt);
    }

    @Override
    public int deleteBatch(Long prfPrId, Long prfPfId) {
        if(prfPrId == null && prfPfId == null){
            throw new IllegalArgumentException("参数不能同时为空");
        }
        Map<String, Object> params = new HashMap();
        params.put("prfPrId", prfPrId);
        params.put("prfPfId", prfPfId);
        return getSqlSession().delete(getSqlId("deleteBatch"), params);
    }
}
