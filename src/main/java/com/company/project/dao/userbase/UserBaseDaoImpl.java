package com.company.project.dao.userbase;

import com.company.db.dao.BaseDaoImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userBaseDao")
public class UserBaseDaoImpl extends BaseDaoImpl<UserBaseEO> implements UserBaseDao {

//    @Override
//    public UserBaseEO getUserByLoginName(String ubLoginName) {
//        return getSqlSession().selectOne(getSqlId("getUserByLoginName"), ubLoginName);
//    }
//
//    @Override
//    public PageList<UserBaseEO> getUserPageLt(String ubLoginName, int pageNo, int pageSize) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("ubLoginName", ubLoginName);
//        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
//        return (PageList) getSqlSession().selectList(getSqlId("getUserPageLt"), params, pageBounds);
//    }
}
