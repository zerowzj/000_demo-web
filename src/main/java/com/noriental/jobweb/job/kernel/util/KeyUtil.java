package com.noriental.jobweb.job.kernel.util;

import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * Key Util
 *
 * @author wangzhj
 */
public abstract class KeyUtil {

    /**
     * 生成Job Key
     *
     * @param jbEO
     * @return JobKey
     */
    public static JobKey jobKey(JobBaseEO jbEO){
        String jobName = jbEO.getJbJobName();
        String jobGroup = jbEO.getJbJobGroup();

        return JobKey.jobKey(jobName, jobGroup);
    }

    /**
     * 生成Trigger Key
     *
     * @param jbEO
     * @param jsEO
     * @return TriggerKey
     */
    public static TriggerKey triggerKey(JobBaseEO jbEO, JobScheduleEO jsEO){
        String jobName = jbEO.getJbJobName();
        String triggerId = jsEO.getJsId().toString();
        String jobGroup = jbEO.getJbJobGroup();

       return triggerKey(jobName, triggerId, jobGroup);
    }
    /**
     * 生成Trigger Key
     *
     * @param jobName
     * @param triggerId
     * @param jobGroup
     * @return TriggerKey
     */
    public static TriggerKey triggerKey(String jobName, String triggerId, String jobGroup){
        String triggerName = jobName + "-" + triggerId;
        String triggerGroup = jobGroup;
        return TriggerKey.triggerKey(triggerName, triggerGroup);
    }
}
