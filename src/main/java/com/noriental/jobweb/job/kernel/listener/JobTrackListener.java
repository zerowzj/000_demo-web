package com.noriental.jobweb.job.kernel.listener;

import com.noriental.jobweb.common.email.SendEmail;
import com.noriental.jobweb.common.util.ExceptionUtil;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogDao;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogEO;
import com.noriental.jobweb.job.kernel.context.JobContext;
import com.noriental.jobweb.job.kernel.util.JobDetailUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 作业追踪监听
 *
 * @author wangzhj
 */
public class JobTrackListener implements JobListener {

    private Logger logger = LoggerFactory.getLogger(JobTrackListener.class);

    @Autowired
    private JobScheduleLogDao jobScheduleLogDao;
    @Autowired
    private SendEmail sendEmail;

    private static ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<Long>() {
    };

    @Override
    public String getName() {
        return "JobTrackListener";
    }

    /**
     * Job被否决时
     *
     * @param context
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        //获取日志编号
        Long jslId = null;
        try {
            jslId = JobDetailUtil.getJobTrackNo(context);
            //获取日志信息
            JobScheduleLogEO jslEO = jobScheduleLogDao.get(jslId);
            //设置信息
            jslEO.setJslExeResult("R"); //被否决
            jslEO.setJslExeRemark(JobDetailUtil.getJobResultRemark(context));
            jslEO.setJslTimeConsume(0L);
            jslEO.setJslEndTime(new Date());
            //更新信息
            jobScheduleLogDao.update(jslEO);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.warn("JOB被否决[{}]", jslId);
        }
    }

    /**
     * Job执行开始时
     *
     * @param context
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        //获取日志编号
        Long jslId = null;
        try {
            jslId = JobDetailUtil.getJobTrackNo(context);
            //设置开始时间
            startTimeThreadLocal.set(System.currentTimeMillis());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("Job开始[{}]", jslId);
        }
    }

    /**
     * Job执行结束时
     *
     * @param context
     * @param exception
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException exception) {
        //获取日志编号
        Long jslId = null;
        try {
            jslId = JobDetailUtil.getJobTrackNo(context);
            this.doJobWasExecuted(context, exception);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("Job结束[{}]", jslId);
        }
    }

    private void doJobWasExecuted(JobExecutionContext context, final JobExecutionException exception) {
        //获取日志编号
        Long jslId = JobDetailUtil.getJobTrackNo(context);
        //获取日志
        JobScheduleLogEO jslEO = jobScheduleLogDao.get(jslId);
        //计算耗时
        long starTime = startTimeThreadLocal.get();
        long timeConsume = System.currentTimeMillis() - starTime;
        jslEO.setJslEndTime(new Date());
        jslEO.setJslTimeConsume(timeConsume);
        //TODO 正常
        if (exception == null) {
            //设置日志
            jslEO.setJslExeResult("S"); //成功
        } else { //TODO 异常
            //设置日志
            jslEO.setJslExeResult("E");    //异常
            String detail = ExceptionUtil.getExceptionDetail(exception);
            jslEO.setJslExeRemark(detail); //备注
            //邮件通知
            JobContext jobContext = JobDetailUtil.getJobContext(context);
            sendEmailInternal(jobContext, detail);
        }
        //更新日志
        jobScheduleLogDao.update(jslEO);
    }

    private void sendEmailInternal(final JobContext jobContext, final String detail) {
        try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    StringBuffer sb = new StringBuffer();
                    sb.append("JOB[" + jobContext.getJbId())
                            .append(", " + jobContext.getJbName() + "]")
                            .append("异常！");
                    sendEmail.sendEmail(sb.toString(), detail);
                }
            });
            t.setDaemon(true);
            t.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

