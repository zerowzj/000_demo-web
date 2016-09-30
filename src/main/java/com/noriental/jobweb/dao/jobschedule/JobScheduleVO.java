package com.noriental.jobweb.dao.jobschedule;

/**
 * 作业调度VO
 *
 * @author wangzhj
 */
public class JobScheduleVO extends JobScheduleEO {

    /** 作业名称 */
    private String jbName = null;

    /** 触发器状态 */
    private String triggerStatus = null;

    public String getJbName() {
        return jbName;
    }

    public void setJbName(String jbName) {
        this.jbName = jbName;
    }

    public String getTriggerStatus() {
        return triggerStatus;
    }

    public void setTriggerStatus(String triggerStatus) {
        this.triggerStatus = triggerStatus;
    }
}
