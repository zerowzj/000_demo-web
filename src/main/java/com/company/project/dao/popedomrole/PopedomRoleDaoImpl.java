package com.company.project.dao.popedomrole;

import com.company.project.common.db.BaseDaoImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("popedomRoleDao")
public class PopedomRoleDaoImpl extends BaseDaoImpl<PopedomRoleEO> implements PopedomRoleDao {

    @Override
    public PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("prName", prName);
        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
        return (PageList) getSqlSession().selectList(getSqlId("getRolePageLt"), params, pageBounds);
    }
}
