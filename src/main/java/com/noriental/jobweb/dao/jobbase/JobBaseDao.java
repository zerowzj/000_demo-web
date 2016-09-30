package com.noriental.jobweb.dao.jobbase;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.common.db.BaseDao;

import java.util.List;

/**
 * 作业Dao
 *
 * @author wangzhj
 */
public interface JobBaseDao extends BaseDao<JobBaseEO> {

    /**
     * 获取作业列表
     *
     * @return List<JobBaseEO>
     */
//    public List<JobBaseEO> getJobLt();

    /**
     * 获取作业列表
     *
     * @param jbName
     * @param pageNo
     * @param pageSize
     * @return PageList<JobBaseVO>
     */
    public PageList<JobBaseVO> getJobLtWithSchedule(String jbName, int pageNo, int pageSize);

    /**
     * 获取作业信息
     *
     * @param jbName
     * @param jbJobGroup
     * @param jbJobName
     * @param jbBeanId
     * @param jbBeanMethod
     * @return JobBaseEO
     */
    public List<JobBaseEO> getJobLt(String jbName, String jbJobGroup, String jbJobName, String jbBeanId, String jbBeanMethod);
}
