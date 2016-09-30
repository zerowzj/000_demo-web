package com.noriental.jobweb.dao.jobschedulelog;

import com.noriental.jobweb.common.db.BaseEO;

import java.util.Date;

/**
 * 作业调度日志EO
 *
 * @author wangzhj
 */
public class JobScheduleLogEO extends BaseEO {

    /** 日志编号 */
    private Long jslId = null;

    /** 作业编号 */
    private Long jslJbId = null;
    /** 调度编号 */
    private Long jslJsId = null;

    /** 触发时间 */
    private Date jslFireTime = null;
    /** 上次触发时间 */
    private Date jslPreFireTime = null;
    /** 下次触发时间 */
    private Date jslNextFireTime = null;

    /** 开始时间 */
    private Date jslBeginTime = null;
    /** 结束时间 */
    private Date jslEndTime = null;
    /** 耗时 */
    private Long jslTimeConsume = null;
    /** 执行结果 */
    private String jslExeResult = null;
    /** 执行备注 */
    private String jslExeRemark = null;

    /** 通知信息 */
    private String jslNotifyInfo = null;
    /** 通知时间 */
    private Date jslNotifyTime = null;

    public Long getJslId() {
        return jslId;
    }

    public void setJslId(Long jslId) {
        this.jslId = jslId;
    }

    public Long getJslJbId() {
        return jslJbId;
    }

    public void setJslJbId(Long jslJbId) {
        this.jslJbId = jslJbId;
    }

    public Long getJslJsId() {
        return jslJsId;
    }

    public void setJslJsId(Long jslJsId) {
        this.jslJsId = jslJsId;
    }

    public Date getJslFireTime() {
        return jslFireTime;
    }

    public void setJslFireTime(Date jslFireTime) {
        this.jslFireTime = jslFireTime;
    }

    public Date getJslPreFireTime() {
        return jslPreFireTime;
    }

    public void setJslPreFireTime(Date jslPreFireTime) {
        this.jslPreFireTime = jslPreFireTime;
    }

    public Date getJslNextFireTime() {
        return jslNextFireTime;
    }

    public void setJslNextFireTime(Date jslNextFireTime) {
        this.jslNextFireTime = jslNextFireTime;
    }

    public String getJslExeResult() {
        return jslExeResult;
    }

    public void setJslExeResult(String jslExeResult) {
        this.jslExeResult = jslExeResult;
    }

    public String getJslExeRemark() {
        return jslExeRemark;
    }

    public void setJslExeRemark(String jslExeRemark) {
        this.jslExeRemark = jslExeRemark;
    }

    public Long getJslTimeConsume() {
        return jslTimeConsume;
    }

    public void setJslTimeConsume(Long jslTimeConsume) {
        this.jslTimeConsume = jslTimeConsume;
    }

    public Date getJslBeginTime() {
        return jslBeginTime;
    }

    public void setJslBeginTime(Date jslBeginTime) {
        this.jslBeginTime = jslBeginTime;
    }

    public Date getJslEndTime() {
        return jslEndTime;
    }

    public void setJslEndTime(Date jslEndTime) {
        this.jslEndTime = jslEndTime;
    }

    public String getJslNotifyInfo() {
        return jslNotifyInfo;
    }

    public void setJslNotifyInfo(String jslNotifyInfo) {
        this.jslNotifyInfo = jslNotifyInfo;
    }

    public Date getJslNotifyTime() {
        return jslNotifyTime;
    }

    public void setJslNotifyTime(Date jslNotifyTime) {
        this.jslNotifyTime = jslNotifyTime;
    }
}
