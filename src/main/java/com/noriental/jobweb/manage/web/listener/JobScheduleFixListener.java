package com.noriental.jobweb.manage.web.listener;

import com.noriental.jobweb.common.SpringContext;
import com.noriental.jobweb.dao.jobschedule.JobScheduleDao;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * 调度状态修正
 *
 * @author wangzhj
 */
public class JobScheduleFixListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.fixSchedule();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.fixSchedule();
    }

    /**
     * 修正调度状态
     */
    private void fixSchedule(){
        JobScheduleDao jobScheduleDao = SpringContext.getBean(JobScheduleDao.class);
        List<JobScheduleEO> jsEOLt = jobScheduleDao.getScheduleLt();
        for(JobScheduleEO jsEO : jsEOLt){
            if(JobScheduleEO.JS_STATUS_WAITING.equals(jsEO.getJsStatus())){
                continue;
            }
            //未开始
            jsEO.setJsStatus(JobScheduleEO.JS_STATUS_WAITING);
            jobScheduleDao.update(jsEO);
        }
    }
}
