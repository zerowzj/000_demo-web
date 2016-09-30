package com.noriental.jobweb.job.kernel.context;

import java.io.Serializable;

/**
 * 作业上下文
 *
 * @author wangzhj
 */
public class JobContext implements Serializable {

    /** 作业编号 */
    private Long jbId = null;
    /** 作业名称 */
    private String jbName = null;

    /** 调度编号 */
    private Long jsId = null;

    /** 执行对象 */
    private String exeObject = null;
    /** 执行方法 */
    private String exeMethod = null;
    /** 执行方式 */
    private String exeMode = null;

    /** 表达式 */
    private String cronExp = null;

    public Long getJbId() {
        return jbId;
    }

    public void setJbId(Long jbId) {
        this.jbId = jbId;
    }

    public Long getJsId() {
        return jsId;
    }

    public void setJsId(Long jsId) {
        this.jsId = jsId;
    }

    public String getJbName() {
        return jbName;
    }

    public void setJbName(String jbName) {
        this.jbName = jbName;
    }

    public String getCronExp() {
        return cronExp;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    public String getExeObject() {
        return exeObject;
    }

    public void setExeObject(String exeObject) {
        this.exeObject = exeObject;
    }

    public String getExeMethod() {
        return exeMethod;
    }

    public void setExeMethod(String exeMethod) {
        this.exeMethod = exeMethod;
    }

    public String getExeMode() {
        return exeMode;
    }

    public void setExeMode(String exeMode) {
        this.exeMode = exeMode;
    }
}
