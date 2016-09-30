package com.noriental.jobweb.job.kernel.util;

import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

/**
 * Trigger Util
 * @author wangzhj
 */
public abstract class TriggerUtil {

    /**
     * 构造Trigger
     *
     * @param jbEO 作业信息
     * @param jsEO 调度信息
     * @return Trigger 触发器
     */
    public static Trigger build(JobBaseEO jbEO, JobScheduleEO jsEO) {
        //生成 Key
        JobKey jobKey = KeyUtil.jobKey(jbEO);
        TriggerKey triggerKey = KeyUtil.triggerKey(jbEO, jsEO);
        //Trigger Builder
        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey);
        //执行时间区间
        /*if(jsEO.getJsStartAt() != null){
            triggerBuilder.startAt(jsEO.getJsStartAt());
        }
        if(jsEO.getJsEndAt() != null){
            triggerBuilder.endAt(jsEO.getJsEndAt());
        }*/
        //调度规则
        ScheduleBuilder scheduleBuilder = null;
        scheduleBuilder = CronScheduleBuilder.cronSchedule(jsEO.getJsCronExp()).withMisfireHandlingInstructionDoNothing();
        triggerBuilder.withSchedule(scheduleBuilder);

        //构造并返回
        return triggerBuilder.build();
    }
}
