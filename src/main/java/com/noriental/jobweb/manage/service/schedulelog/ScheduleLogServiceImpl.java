package com.noriental.jobweb.manage.service.schedulelog;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogDao;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("scheduleLogService")
public class ScheduleLogServiceImpl implements ScheduleLogService {

    @Autowired
    private JobScheduleLogDao jobScheduleLogDao;

    @Override
    public PageList<JobScheduleLogVO> findScheduleLogLtWithJob(String jbName, String beginTime, String endTime, int pageNO, int pageSize) {
        PageList<JobScheduleLogVO> pageLt = jobScheduleLogDao.getScheduleLogLtWithJob(jbName, beginTime, endTime, pageNO, pageSize);
        return pageLt;
    }

    @Override
    public JobScheduleLogVO getScheduleLogWithJob(Long jslId) {
        return jobScheduleLogDao.getScheduleLogWithJob(jslId);
    }
}
