package com.noriental.jobweb.manage.service.notify;

import com.noriental.jobweb.common.util.JsonUtil;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogDao;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogEO;
import com.noriental.jobweb.manage.web.form.NotifyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("notifyService")
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private JobScheduleLogDao jobScheduleLogDao;

    @Override
    public void handleNotify(NotifyForm notifyForm) {
        //获取调度日志
        Long jslId = Long.valueOf(notifyForm.getTrackNo());
        JobScheduleLogEO jslEO = jobScheduleLogDao.get(jslId);
        if(jslEO == null){
            throw new IllegalStateException("未获取到调度记录["+jslId+"]！");
        }
        //
        jslEO.setJslNotifyInfo(JsonUtil.toJson(notifyForm));
        jslEO.setJslNotifyTime(new Date());
        //
        jobScheduleLogDao.update(jslEO);
    }
}
