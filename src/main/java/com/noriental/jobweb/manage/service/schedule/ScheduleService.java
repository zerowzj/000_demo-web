package com.noriental.jobweb.manage.service.schedule;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleVO;

/**
 * 作业调度服务
 *
 * @author wangzhj
 */
public interface ScheduleService {

    /**
     * 查询调度列表
     *
     * @param jbName
     * @param jsStatus
     * @param pageNo
     * @param pageSize
     * @return List<JobScheduleVO>
     */
    public PageList<JobScheduleVO> findScheduleLtWithJob(String jbName, String jsStatus, int pageNo, int pageSize);

    /**
     * 添加调度
     *
     * @param jsEO
     */
    public void addSchedule(JobScheduleEO jsEO);

    /**
     * 修改调度
     *
     * @param jsEO
     */
    public void modifySchedule(JobScheduleEO jsEO);

    /**
     * 获取调度信息
     *
     * @param jsId
     * @return JobScheduleEO
     */
    public JobScheduleEO getSchedule(Long jsId);
}
