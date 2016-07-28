package com.company.project.service.function;

import com.company.project.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
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
}
