package com.noriental.jobweb.manage.service.schedulelog;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogVO;

/**
 * 作业调度日志服务
 *
 * @author wangzhj
 */
public interface ScheduleLogService {

    /**
     * 查询调度日志
     *
     * @param jbName
     * @param beginTime
     * @param endTime
     * @param pageNo
     * @param pageSize
     * @return PageList<JobScheduleLogVO>
     */
    public PageList<JobScheduleLogVO> findScheduleLogLtWithJob(String jbName, String beginTime, String endTime, int pageNo, int pageSize);

    /**
     * 获取调度日志
     *
     * @param jslId
     * @return JobScheduleLogVO
     */
    public JobScheduleLogVO getScheduleLogWithJob(Long jslId);
}
