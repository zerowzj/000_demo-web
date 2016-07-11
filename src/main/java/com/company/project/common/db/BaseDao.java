package com.company.project.common.db;

import java.io.Serializable;

/**
 * 基础Dao
 *
 * @author wangzhj
 */
public interface BaseDao<E extends BaseEO> {

    /**
     *  新增实体
     *
     * @param entity 实体
     * @return int
     */
    public int insert(E entity);

    /**
     *  删除实体
     *
     * @param id
     * @return int
     */
    public int delete(Serializable id);

    /**
     *  更新实体
     *
     * @param entity 实体
     * @return int
     */
    public int update(E entity);

    /**
     *  获取实体
     *
     * @param id
     * @return E
     */
    public E get(Serializable id);
}
