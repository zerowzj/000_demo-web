package com.company.project.service.function;

import com.company.project.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.dao.popedomfunction.RoleFunctionConfVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

    @Autowired
     private PopedomFunctionDao popedomFunctionDao;

    @Override
    public List<PopedomFunctionEO> getFunctionLt() {
        return popedomFunctionDao.getFunctionLt(null);
    }

    @Override
    public List<RoleFunctionConfVO> getRoleFunctionConfLt(Long prId) {
        return popedomFunctionDao.getRoleFunctionConfLt(prId);
    }
}
