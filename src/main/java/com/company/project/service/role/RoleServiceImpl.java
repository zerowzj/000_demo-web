package com.company.project.service.role;

import com.company.project.dao.popedomrole.PopedomRoleDao;
import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.company.project.dao.popedomrolefunction.PopedomRoleFunctionDao;
import com.company.project.dao.popedomrolefunction.PopedomRoleFunctionEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PopedomRoleDao popedomRoleDao = null;
    @Autowired
    private PopedomRoleFunctionDao popedomRoleFunctionDao = null;

    @Override
    public PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize) {
        return popedomRoleDao.getRolePageLt(prName, pageNo, pageSize);
    }

    @Override
    public void addRole(PopedomRoleEO prEO) {

    }

    @Override
    public void addFunction(Long prId, List<Long> pfIdLt) {
        //删除
        popedomRoleFunctionDao.deleteBatch(prId, null);
        //生成
        List<Long> rootIdLt = new ArrayList<>();
        List<PopedomRoleFunctionEO> prfEOLt = new ArrayList<>();
        PopedomRoleFunctionEO prfEO = null;
        for (Long pfId : pfIdLt) {
            prfEO = new PopedomRoleFunctionEO();
            prfEO.setPrfPrId(prId);
            prfEO.setPrfPfId(pfId);
            prfEOLt.add(prfEO);

            Long t = (pfId / 1000) * 1000;
            if (!rootIdLt.contains(t)) {
                rootIdLt.add(t);
            }
        }

        for (Long rootId : rootIdLt) {
            prfEO = new PopedomRoleFunctionEO();
            prfEO.setPrfPrId(prId);
            prfEO.setPrfPfId(rootId);
            prfEOLt.add(prfEO);
        }

        popedomRoleFunctionDao.insertBatch(prfEOLt);
    }
}
