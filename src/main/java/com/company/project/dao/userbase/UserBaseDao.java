package com.company.project.dao.userbase;

import com.company.db.dao.BaseDao;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 用户基本信息Dao
 *
 * @author wangzhj
 */
public interface UserBaseDao extends BaseDao<UserBaseEO> {

    /**
     * 获取用户信息
     *
     * @param ubLoginName 登录名
     * @return UserBaseEO
     */
    public UserBaseEO getUserByLoginName(String ubLoginName);

    /**
     * 获取用户信息
     *
     * @param ubLoginName 登录名
     * @return UserBaseEO
     */
    public PageList<UserBaseEO> getUserPageLt(String ubLoginName, int pageNo, int pageSize);
}
