package com.noriental.jobweb.dao.jobbase;

/**
 * 作业信息VO
 *
 * @author wangzhj
 */
public class JobBaseVO extends JobBaseEO {

    /** 调度数量 */
    private Integer scheduleNum = null;

    public Integer getScheduleNum() {
        return scheduleNum;
    }

    public void setScheduleNum(Integer scheduleNum) {
        this.scheduleNum = scheduleNum;
    }
}
