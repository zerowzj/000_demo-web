package com.noriental.jobweb.dao.jobschedule;

import com.noriental.jobweb.common.db.BaseDao;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

/**
 * 作业调度Dao
 *
 * @author wangzhj
 */
public interface JobScheduleDao extends BaseDao<JobScheduleEO> {

    /**
     * 获取作业列表
     *
     * @return List<JobScheduleEO>
     */
    public List<JobScheduleEO> getScheduleLt();

    /**
     * 获取作业列表
     *
     * @param jbName
     * @param jsStatus
     * @param pageNo
     * @param pageSize
     * @return PageList<JobScheduleVO>
     */
    public PageList<JobScheduleVO> getScheduleLtWithJob(String jbName, String jsStatus, int pageNo, int pageSize);
}
