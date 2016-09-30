package com.noriental.jobweb.manage.service.job;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobbase.JobBaseVO;

import java.util.List;

/**
 * 作业信息服务
 *
 * @author wangzhj
 */
public interface JobService {

    /**
     * 查询作业列表
     *
     *@param jbName
     *@param pageNo
     *@param pageSize
     * @return JobBaseVO
     */
    public PageList<JobBaseVO> findJobLtWithSchedule(String jbName, int pageNo, int pageSize);

    /**
     * 获取作业信息
     *
     * @param jobId
     * @return JobBaseEO
     */
    public JobBaseEO getJob(Long jobId);

    /**
     * 添加作业
     *
     * @param jbEO
     */
    public void addJob(JobBaseEO jbEO);

    /**
     * 添加作业
     *
     * @param jobName
     */
    public boolean checkJobNameIsExist(String jobName);
}
