package com.company.project.common.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;

public abstract class BaseDaoImpl<E extends BaseEO> extends SqlSessionDaoSupport implements BaseDao<E>{

    @Override
    public final int insert(E entity) {
        String sqlId = getDefaultSqlId(SqlType.INSERT);
        int count = getSqlSession().insert(sqlId, entity);
        return count;
    }

    @Override
    public final int delete(Serializable id) {
        String sqlId = getDefaultSqlId(SqlType.DELETE);
        int count = getSqlSession().delete(sqlId, id);
        return count;
    }

    @Override
    public final int update(E entity) {
        String sqlId = getDefaultSqlId(SqlType.UPDATE);
        int count = getSqlSession().update(sqlId, entity);
        return count;
    }

    @Override
    public final E get(Serializable id) {
        String sqlId = getDefaultSqlId(SqlType.GET);
        E entity = getSqlSession().selectOne(sqlId, id);
        return entity;
    }

    /**
     * 获取默认sqlId
     */
    private String getDefaultSqlId(SqlType sqlType) {
        return getNamespace() + "." + sqlType.getValue();
    }

    /**
     * 获取sqlId
     */
    protected final String getSqlId(String sqlId) {
        return getNamespace()+"."+sqlId;
    }

    /**
     * 获取命名空间
     */
    protected final String getNamespace() {
        String packageName = this.getClass().getPackage().getName();
        return packageName;
    }

    @Override
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    private enum SqlType {

        INSERT("insert"), DELETE("delete"), UPDATE("update"), GET("get"), ;

        private String value = null;

        private SqlType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
