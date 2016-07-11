package com.company.project.dao.userbase;

import com.company.project.common.db.BaseDao;

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
}
