package com.company.project.service.role;

import com.company.project.dao.popedomrole.PopedomRoleDao;
import com.company.project.dao.popedomrole.PopedomRoleEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PopedomRoleDao popedomRoleDao = null;

    @Override
    public PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize) {
        return popedomRoleDao.getRolePageLt(prName, pageNo, pageSize);
    }

    @Override
    public void addRole(PopedomRoleEO prEO) {

    }
}
