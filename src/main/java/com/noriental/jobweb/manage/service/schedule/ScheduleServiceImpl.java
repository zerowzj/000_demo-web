package com.noriental.jobweb.manage.service.schedule;

import com.noriental.jobweb.dao.jobbase.JobBaseDao;
import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleDao;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleVO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.job.kernel.util.KeyUtil;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private JobScheduleDao jobScheduleDao;
    @Autowired
    private JobBaseDao jobBaseDao;
    @Autowired
    private Scheduler scheduler;

    @Override
    public PageList<JobScheduleVO> findScheduleLtWithJob(String jbName, String jsStatus, int pageNo, int pageSize) {
        PageList<JobScheduleVO> jsVOLt = jobScheduleDao.getScheduleLtWithJob(jbName, jsStatus, pageNo, pageSize);
        for (JobScheduleVO jsVO : jsVOLt) {
            JobBaseEO jbEO = jobBaseDao.get(jsVO.getJsJbId());
            Trigger.TriggerState state = null;
            try {
                state = scheduler.getTriggerState(KeyUtil.triggerKey(jbEO, jsVO));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            jsVO.setTriggerStatus(state.toString());
        }
        return jsVOLt;
    }

    @Override
    public void addSchedule(JobScheduleEO jsEO) {
        jsEO.setJsBeginTime(new Date());
        jobScheduleDao.insert(jsEO);
    }

    @Override
    public void modifySchedule(JobScheduleEO jsEO) {
        jobScheduleDao.update(jsEO);
    }

    @Override
    public JobScheduleEO getSchedule(Long jsId) {
        JobScheduleEO jsEO = jobScheduleDao.get(jsId);
        if (jsEO == null) {
            throw new IllegalStateException("");
        }
        return jsEO;
    }
}
