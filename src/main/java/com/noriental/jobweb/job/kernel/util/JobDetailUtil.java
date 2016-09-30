package com.noriental.jobweb.job.kernel.util;

import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import com.noriental.jobweb.job.kernel.BaseJob;
import com.noriental.jobweb.job.kernel.SerialJob;
import com.noriental.jobweb.job.kernel.context.JobContext;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;

/**
 * JobDetail Util
 *
 * @author wangzhj
 */
public abstract class JobDetailUtil {

    private static final String KEY_JOB_CONTEXT = "JobDetailUtil.KEY_JOB_CONTEXT";

    private static final String KEY_JOB_TRACK_NO = "JobDetailUtil.KEY_JOB_TRACK_NO";

    private static final String KEY_JOB_RESULT_REMARK = "JobDetailUtil.KEY_JOB_RESULT_REMARK";

    /**
     * 构造JobDetail
     *
     * @param jbEO 作业信息
     * @param jsEO 调度信息
     * @return JobDetail
     */
    public static JobDetail build(JobBaseEO jbEO, JobScheduleEO jsEO) {
        JobBuilder jobBuilder = null;
        //Job Class
        String isConcurrent = jbEO.getJbIsConcurrent();
        if("Y".equals(isConcurrent)){
            jobBuilder = JobBuilder.newJob(BaseJob.class);
        } else {
            jobBuilder = JobBuilder.newJob(SerialJob.class);
        }
        //Job Key
        JobKey jobKey = KeyUtil.jobKey(jbEO);
        jobBuilder.withIdentity(jobKey);
        //数据
        JobDataMap dataMap = new JobDataMap();
        dataMap.put(KEY_JOB_CONTEXT, makeJobContext(jbEO, jsEO));
        jobBuilder.usingJobData(dataMap);
        //
        jobBuilder.requestRecovery(true);

        return jobBuilder.build();
    }

    private static JobContext makeJobContext(JobBaseEO jbEO, JobScheduleEO jsEO) {
        JobContext jobContext = new JobContext();

        jobContext.setJbId(jbEO.getJbId());     //作业编号
        jobContext.setJbName(jbEO.getJbName()); //作业名称
        jobContext.setJsId(jsEO.getJsId()); //调度编号
        jobContext.setExeObject(jbEO.getJbExeObject()); //执行对象
        jobContext.setExeMethod(jbEO.getJbExeMethod()); //执行方法
        jobContext.setExeMode(jbEO.getJbExeMode()); //执行方法

        return jobContext;
    }

    /**
     * 获取JobContext
     *
     * @param context
     * @return JobContext
     */
    public static JobContext getJobContext(JobExecutionContext context){
       JobDataMap dataMap =  context.getMergedJobDataMap();
        return (JobContext) dataMap.get(KEY_JOB_CONTEXT);
    }

    /**
     * 设置作业跟踪号
     *
     * @param context
     * @param trackNo
     */
    public static void setJobTrackNo(JobExecutionContext context, Long trackNo){
        JobDataMap dataMap =  context.getMergedJobDataMap();
        dataMap.put(KEY_JOB_TRACK_NO, trackNo);
    }
    /**
     * 获取作业跟踪号
     *
     * @param context
     * @return Long
     */
    public static Long getJobTrackNo(JobExecutionContext context){
        JobDataMap dataMap =  context.getMergedJobDataMap();
        return (Long) dataMap.get(KEY_JOB_TRACK_NO);
    }

    /**
     * 设置作业结果备注
     *
     * @param context
     * @param remark
     */
    public static void setJobResultRemark(JobExecutionContext context, String remark){
        JobDataMap dataMap =  context.getMergedJobDataMap();
        dataMap.put(KEY_JOB_RESULT_REMARK, remark);
    }
    /**
     * 获取作业结果备注
     *
     * @param context
     * @return String
     */
    public static String getJobResultRemark(JobExecutionContext context){
        JobDataMap dataMap =  context.getMergedJobDataMap();
        return (String) dataMap.get(KEY_JOB_RESULT_REMARK);
    }
}
