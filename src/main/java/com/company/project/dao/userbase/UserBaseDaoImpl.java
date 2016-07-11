package com.company.project.dao.userbase;

import com.company.project.common.db.BaseDaoImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userBaseDao")
public class UserBaseDaoImpl extends BaseDaoImpl<UserBaseEO> implements UserBaseDao {

    @Override
    public UserBaseEO getUserByLoginName(String ubLoginName) {
        return getSqlSession().selectOne(getSqlId("getUserByLoginName"), ubLoginName);
    }
}
