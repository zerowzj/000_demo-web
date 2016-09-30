package com.noriental.jobweb.job.kernel;

import com.noriental.jobweb.common.SpringContext;
import com.noriental.jobweb.job.kernel.context.JobContext;
import com.noriental.jobweb.job.kernel.util.JobDetailUtil;
import net.vidageek.mirror.dsl.Mirror;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础Job
 *
 * @author wangzhj
 */
public class BaseJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(BaseJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            //获取JobContext
            JobContext jobContext = JobDetailUtil.getJobContext(context);

            //获取执行对象
            String exeObj = jobContext.getExeObject();
            final Object exeObject = SpringContext.getBean(exeObj);
            //获取执行方法
            final String exeMethod = jobContext.getExeMethod();
            //生成作业参数
            Long jslId = JobDetailUtil.getJobTrackNo(context);
            final String trackNo = String.valueOf(jslId);

            //执行作业
            String exeMode = jobContext.getExeMode();
            if("".equals(exeMode)){
                new Mirror().on(exeObject).invoke().method(exeMethod).withArgs(trackNo);
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new Mirror().on(exeObject).invoke().method(exeMethod).withArgs(trackNo);
                    }
                }).start();
            }
        } catch (Exception ex) {
            JobExecutionException jobEx = new JobExecutionException(ex);
            throw jobEx;
        }
    }
}
