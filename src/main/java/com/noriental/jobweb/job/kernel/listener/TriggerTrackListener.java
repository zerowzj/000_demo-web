package com.noriental.jobweb.job.kernel.listener;

import com.noriental.jobweb.common.SpringContext;
import com.noriental.jobweb.common.util.ReflectUtil;
import com.noriental.jobweb.common.util.StringUtil;
import com.noriental.jobweb.dao.jobschedule.JobScheduleDao;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogDao;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogEO;
import com.noriental.jobweb.job.kernel.context.JobContext;
import com.noriental.jobweb.job.kernel.util.JobDetailUtil;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 触发器追踪监听
 *
 * @author wangzhj
 */
public class TriggerTrackListener implements TriggerListener {

    private static final Logger logger = LoggerFactory.getLogger(TriggerTrackListener.class);

    @Autowired
    private JobScheduleLogDao jobScheduleLogDao = null;
    @Autowired
    private JobScheduleDao jobScheduleDao = null;

    @Override
    public String getName() {
        return "TriggerTrackListener";
    }

    /**
     * 否决Job执行
     *
     * @param trigger
     * @param context
     */
    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        logger.info("vetoJobExecution...");
        //获取JobContext
        JobContext jobContext = JobDetailUtil.getJobContext(context);
        Long jbId = jobContext.getJbId();
        String jbName = jobContext.getJbName();

        //对象是否存在
        String exeObject = jobContext.getExeObject();
        if (StringUtil.trimToNull(exeObject) == null) {
            StringBuffer sb = new StringBuffer();
            sb.append("作业[" + jbId + "," + jbName + "]执行对象未配置！");
            JobDetailUtil.setJobResultRemark(context, sb.toString());
            return true;
        }
        if (!SpringContext.containsBean(exeObject)) {
            StringBuffer sb = new StringBuffer();
            sb.append("作业执行对象[" + exeObject + "]不存在！");
            JobDetailUtil.setJobResultRemark(context, sb.toString());
            return true;
        }
        Object targetObject = SpringContext.getBean(exeObject);
        //方法是否存在
        String methodName = jobContext.getExeMethod();
        if (StringUtil.trimToNull(methodName) == null) {
            StringBuffer sb = new StringBuffer();
            sb.append("作业[" + jbId + "," + jbName + "]执行方法未配置！");
            JobDetailUtil.setJobResultRemark(context, sb.toString());
            return true;
        }
        if (!ReflectUtil.checkExist(targetObject, methodName)) {
            StringBuffer sb = new StringBuffer();
            sb.append("作业执行对象[" + exeObject + "]的执行方法[" + methodName + "]不存在！");
            JobDetailUtil.setJobResultRemark(context, sb.toString());
            return true;
        }

        return false;
    }

    /**
     * Trigger错过时
     *
     * @param trigger
     */
    @Override
    public void triggerMisfired(Trigger trigger) {
        //获取TriggerKey
        TriggerKey triggerKey = trigger.getKey();
        logger.warn("Trigger[{}, {}]Misfired!", triggerKey.getGroup(), triggerKey.getName());
    }

    /**
     * Trigger开始时
     *
     * @param trigger
     * @param context
     */
    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        Long jslId = null;
        try {
            //生成日志
            jslId = this.makeLog(context);
            JobDetailUtil.setJobTrackNo(context, jslId);

            //获取JobContext
            JobContext jobContext = JobDetailUtil.getJobContext(context);
            //更新调度信息
            Long jsId = jobContext.getJsId();
            JobScheduleEO jsEO = jobScheduleDao.get(jsId);
            jsEO.setJsNextTime(context.getNextFireTime());
            jobScheduleDao.update(jsEO);


/*            if (true) {
                throw new IllegalStateException("triggerFired时异常！！！");
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("Trigger开始[{}]", jslId);
        }
    }

    /**
     * Trigger完成时
     *
     * @param trigger
     * @param context
     */
    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        //获取日志编号
        Long jslId = null;
        try {
            jslId = JobDetailUtil.getJobTrackNo(context);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("Trigger结束[{}]", jslId);
        }
    }

    private Long makeLog(JobExecutionContext context) {
        //获取数据
        JobContext jobContext = JobDetailUtil.getJobContext(context);

        //生成日志数据
        JobScheduleLogEO jslEO = new JobScheduleLogEO();
        //作业
        jslEO.setJslJbId(jobContext.getJbId());
        //调度
        jslEO.setJslJsId(jobContext.getJsId());
        //时间
        jslEO.setJslFireTime(context.getFireTime());
        jslEO.setJslPreFireTime(context.getPreviousFireTime());
        jslEO.setJslNextFireTime(context.getNextFireTime());
        jslEO.setJslBeginTime(new Date());

        jobScheduleLogDao.insert(jslEO);

        return jslEO.getJslId();
    }
}
