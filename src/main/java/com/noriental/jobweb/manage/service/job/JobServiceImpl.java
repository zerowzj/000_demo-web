package com.noriental.jobweb.manage.service.job;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.common.SpringContext;
import com.noriental.jobweb.common.util.ReflectUtil;
import com.noriental.jobweb.dao.jobbase.JobBaseDao;
import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobbase.JobBaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private JobBaseDao jobBaseDao;

    @Override
    public PageList<JobBaseVO> findJobLtWithSchedule(String jbName, int pageNo, int pageSize) {
        return jobBaseDao.getJobLtWithSchedule(jbName, pageNo, pageSize);
    }

    @Override
    public JobBaseEO getJob(Long jobId) {
        return getJobInternal(jobId);
    }

    /**
     * 获取作业信息
     */
    private JobBaseEO getJobInternal(Long jobId) {
        JobBaseEO jbEO = jobBaseDao.get(jobId);
        if (jbEO == null) {
            throw new IllegalStateException("job is not exist");
        }
        return jbEO;
    }

    @Override
    public void addJob(JobBaseEO jbEO) {
        //重复job名称
        String jobGroup = jbEO.getJbJobGroup();
        String jobName = jbEO.getJbJobName();
        List<JobBaseEO> checkLt1 = jobBaseDao.getJobLt(null, jobGroup, jobName, null, null);
        if (checkLt1 != null && !checkLt1.isEmpty()) {
            throw new IllegalStateException("JobGroup[" + jobGroup + "]下JobName[" + jobName + "]已存在！");
        }
        //重复方法
        String exeObject = jbEO.getJbExeObject();
        String exeMethod = jbEO.getJbExeMethod();
        List<JobBaseEO> checkLt2 = jobBaseDao.getJobLt(null, null, null, exeObject, exeMethod);
        if (checkLt2 != null && !checkLt2.isEmpty()) {
            throw new IllegalStateException("作业执行对象[" + exeObject + "]执行方法[" + exeMethod + "]已存在！");
        }
        Object obj = SpringContext.getBean(exeObject);
        if (!ReflectUtil.checkExist(obj, exeMethod)) {
            throw new IllegalStateException("作业执行对象[" + exeObject + "]无方法[" + exeMethod + "]！");
        }
        //创建时间
        jbEO.setJbBeginTime(new Date());
        //插入
        jobBaseDao.insert(jbEO);
    }

    @Override
    public boolean checkJobNameIsExist(String jobName) {
        List<JobBaseEO> jbEOLt = jobBaseDao.getJobLt(jobName, null, null, null, null);
        return jbEOLt == null || jbEOLt.isEmpty() ? false : true;
    }
}
