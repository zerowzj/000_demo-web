package com.noriental.jobweb.dao.jobschedulelog;

/**
 * 作业调度日志VO
 *
 * @author wangzhj
 */
public class JobScheduleLogVO extends JobScheduleLogEO {

    /** 作业名称 */
    private String jbName = null;

    public String getJbName() {
        return jbName;
    }

    public void setJbName(String jbName) {
        this.jbName = jbName;
    }
}
