package com.noriental.jobweb.manage.service.scheduleaction;

import com.noriental.jobweb.job.kernel.util.JobDetailUtil;
import com.noriental.jobweb.job.kernel.util.KeyUtil;
import com.noriental.jobweb.job.kernel.util.TriggerUtil;
import com.noriental.jobweb.dao.jobbase.JobBaseDao;
import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleDao;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("scheduleActionService")
public class ScheduleActionServiceImpl implements ScheduleActionService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleActionServiceImpl.class);

    @Autowired
    private JobBaseDao jobBaseDao;

    @Autowired
    private JobScheduleDao jobScheduleDao;

    @Autowired
    private Scheduler scheduler;

    @Override
    public void startTrigger(Long jsId) {
        //作业&调度信息
        JobScheduleEO jsEO = getScheduleInternal(jsId);
        JobBaseEO jbEO = getJobInternal(jsEO.getJsJbId());
        //Job&Trigger Key
        JobKey jobKey = KeyUtil.jobKey(jbEO);
        TriggerKey triggerKey = KeyUtil.triggerKey(jbEO, jsEO);

        try {
            //
            if (scheduler.checkExists(jobKey)) {
                if (!scheduler.checkExists(triggerKey)) {
                    Trigger trigger = TriggerUtil.build(jbEO, jsEO);
                    scheduler.scheduleJob(trigger);
                } else {

                }
            } else {
                JobDetail jobDetail = JobDetailUtil.build(jbEO, jsEO);
                Trigger trigger = TriggerUtil.build(jbEO, jsEO);
                scheduler.scheduleJob(jobDetail, trigger);
            }
            //运行中
            jsEO.setJsStatus(JobScheduleEO.JS_STATUS_RUNNING);
            jobScheduleDao.update(jsEO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void pauseTrigger(Long jsId) {
        //作业&调度信息
        JobScheduleEO jsEO = getScheduleInternal(jsId);
        JobBaseEO jbEO = getJobInternal(jsEO.getJsJbId());
        //Job&Trigger Key
        JobKey jobKey = KeyUtil.jobKey(jbEO);
        TriggerKey triggerKey = KeyUtil.triggerKey(jbEO, jsEO);

        try {
            //
            /*if (!scheduler.checkExists(triggerKey)) {
                logger.warn("调度[{}]不存在！", jsId);
                return;
            }*/
            scheduler.pauseTrigger(triggerKey);
            //暂停中
            jsEO.setJsStatus(JobScheduleEO.JS_STATUS_PAUSING);
            jobScheduleDao.update(jsEO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void resumeTrigger(Long jsId) {
        //作业&调度信息
        JobScheduleEO jsEO = getScheduleInternal(jsId);
        JobBaseEO jbEO = getJobInternal(jsEO.getJsJbId());
        //Job&Trigger Key
        JobKey jobKey = KeyUtil.jobKey(jbEO);
        TriggerKey triggerKey = KeyUtil.triggerKey(jbEO, jsEO);

        try {
            //
            /*if (!scheduler.checkExists(triggerKey)) {
                logger.warn("调度[{}]不存在！", jsId);
                return;
            }*/
            scheduler.resumeTrigger(triggerKey);
            //运行中
            jsEO.setJsStatus(JobScheduleEO.JS_STATUS_RUNNING);
            jobScheduleDao.update(jsEO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeTrigger(Long jsId) {
        //作业&调度信息
        JobScheduleEO jsEO = getScheduleInternal(jsId);
        JobBaseEO jbEO = getJobInternal(jsEO.getJsJbId());
        //Job&Trigger Key
        JobKey jobKey = KeyUtil.jobKey(jbEO);
        TriggerKey triggerKey = KeyUtil.triggerKey(jbEO, jsEO);

        try {
            //
            /*if (!scheduler.checkExists(triggerKey)) {
                logger.warn("调度[{}]不存在！", jsId);
                return;
            }*/
            scheduler.unscheduleJob(triggerKey);
            //未开始
            jsEO.setJsStatus(JobScheduleEO.JS_STATUS_WAITING);
            jobScheduleDao.update(jsEO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取调度信息
     */
    private JobScheduleEO getScheduleInternal(Long jsId) {
        JobScheduleEO jsEO = jobScheduleDao.get(jsId);
        if (jsEO == null) {
            throw new IllegalStateException("");
        }
        return jsEO;
    }

    /**
     * 获取作业信息
     */
    private JobBaseEO getJobInternal(Long jbId) {
        JobBaseEO jbEO = jobBaseDao.get(jbId);
        if (jbEO == null) {
            throw new IllegalStateException("");
        }
        return jbEO;
    }
}
