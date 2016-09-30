package com.noriental.jobweb.dao.jobschedule;

import com.noriental.jobweb.common.db.BaseEO;

import java.util.Date;

/**
 * 作业调度EO
 *
 * @author wangzhj
 */
public class JobScheduleEO extends BaseEO {

    /** 调度编号 */
    private Long jsId = null;

    /** 作业编号 */
    private Long jsJbId = null;

    /** 调度状态 */
    private String jsStatus = null;
    /** 调度状态 - 未开始 */
    public static final String JS_STATUS_WAITING = "W";
    /** 调度状态 - 执行中 */
    public static final String JS_STATUS_RUNNING = "R";
    /** 调度状态 - 暂停中 */
    public static final String JS_STATUS_PAUSING = "P";

    /** Cron表达式 */
    private String jsCronExp = null;

    /** 下次执行时间 */
    private Date jsNextTime = null;

    /** 创建时间 */
    private Date jsBeginTime = null;

    /** 调度描述 */
    private String jsDesc = null;

    public String getJsStatusName(){
        if(JS_STATUS_WAITING.equals(jsStatus)){
            return "未开始";
        } else if(JS_STATUS_RUNNING.equals(jsStatus)){
            return "运行中";
        } else if(JS_STATUS_PAUSING.equals(jsStatus)){
            return "暂停中";
        } else {
            throw new IllegalStateException("JsStatus is illegal["+jsStatus+"]");
        }
    }

    public Date getJsBeginTime() {
        return jsBeginTime;
    }

    public void setJsBeginTime(Date jsBeginTime) {
        this.jsBeginTime = jsBeginTime;
    }

    public String getJsDesc() {
        return jsDesc;
    }

    public void setJsDesc(String jsDesc) {
        this.jsDesc = jsDesc;
    }

    public String getJsCronExp() {
        return jsCronExp;
    }

    public void setJsCronExp(String jsCronExp) {
        this.jsCronExp = jsCronExp;
    }

    public Long getJsId() {
        return jsId;
    }

    public void setJsId(Long jsId) {
        this.jsId = jsId;
    }

    public Long getJsJbId() {
        return jsJbId;
    }

    public void setJsJbId(Long jsJbId) {
        this.jsJbId = jsJbId;
    }

    public String getJsStatus() {
        return jsStatus;
    }

    public void setJsStatus(String jsStatus) {
        this.jsStatus = jsStatus;
    }

    public Date getJsNextTime() {
        return jsNextTime;
    }

    public void setJsNextTime(Date jsNextTime) {
        this.jsNextTime = jsNextTime;
    }
}
