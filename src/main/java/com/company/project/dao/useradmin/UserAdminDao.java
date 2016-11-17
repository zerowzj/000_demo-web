package com.company.project.dao.useradmin;

import com.company.db.dao.BaseDao;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 用户基本信息Dao
 *
 * @author wangzhj
 */
public interface UserAdminDao extends BaseDao<UserAdminEO> {

    /**
     * 获取用户信息
     *
     * @param uaLoginName 登录名
     * @return UserAdminEO
     */
    public UserAdminEO getAdminByLoginName(String uaLoginName);

    /**
     * 获取用户信息
     *
     * @param uaLoginName 登录名
     * @return PageList<UserAdminEO>
     */
    public PageList<UserAdminEO> getAdminPageLt(String uaLoginName, int pageNo, int pageSize);
}
