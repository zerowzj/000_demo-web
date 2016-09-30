package com.noriental.jobweb.dao.jobschedulelog;

import com.noriental.jobweb.common.db.BaseDao;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 作业调度日志Dao
 *
 * @author wangzhj
 */
public interface JobScheduleLogDao extends BaseDao<JobScheduleLogEO> {

    /**
     * @param jbName
     * @param beginTime
     * @param endTime
     * @param pageNo
     * @param pageSize
     *
     * @return List<JobScheduleLogVO>
     */
    public PageList<JobScheduleLogVO> getScheduleLogLtWithJob(String jbName, String beginTime, String endTime, int pageNo, int pageSize);

    /**
     * 获取调度日志
     *
     * @param jslId
     * @return JobScheduleLogVO
     */
    public JobScheduleLogVO getScheduleLogWithJob(Long jslId);
}
