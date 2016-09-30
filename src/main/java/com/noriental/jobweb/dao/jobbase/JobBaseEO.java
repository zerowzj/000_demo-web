package com.noriental.jobweb.dao.jobbase;

import com.noriental.jobweb.common.db.BaseEO;

import java.util.Date;

/**
 * 作业信息EO
 *
 * @author wangzhj
 */
public class JobBaseEO extends BaseEO {

    /** 作业编号 */
    private Long jbId = null;
    /** 作业名称 */
    private String jbName = null;

    /** 作业JOB Group */
    private String jbJobGroup = null;
    /** 作业Job Name */
    private String jbJobName = null;

    /** 执行对象 */
    private String jbExeObject = null;
    /** 执行方法 */
    private String jbExeMethod = null;
    /** 执行方式 */
    private String jbExeMode = null;

    /** 是否可并行 */
    private String jbIsConcurrent = null;

    /** 创建时间 */
    private Date jbBeginTime = null;
    /** 作业描述 */
    private String jbDesc = null;

    public Date getJbBeginTime() {
        return jbBeginTime;
    }

    public void setJbBeginTime(Date jbBeginTime) {
        this.jbBeginTime = jbBeginTime;
    }

    public Long getJbId() {
        return jbId;
    }

    public void setJbId(Long jbId) {
        this.jbId = jbId;
    }

    public String getJbName() {
        return jbName;
    }

    public void setJbName(String jbName) {
        this.jbName = jbName;
    }

    public String getJbDesc() {
        return jbDesc;
    }

    public void setJbDesc(String jbDesc) {
        this.jbDesc = jbDesc;
    }

    public String getJbJobName() {
        return jbJobName;
    }

    public void setJbJobName(String jbJobName) {
        this.jbJobName = jbJobName;
    }

    public String getJbJobGroup() {
        return jbJobGroup;
    }

    public void setJbJobGroup(String jbJobGroup) {
        this.jbJobGroup = jbJobGroup;
    }

    public String getJbIsConcurrent() {
        return jbIsConcurrent;
    }

    public void setJbIsConcurrent(String jbIsConcurrent) {
        this.jbIsConcurrent = jbIsConcurrent;
    }

    public String getJbExeObject() {
        return jbExeObject;
    }

    public void setJbExeObject(String jbExeObject) {
        this.jbExeObject = jbExeObject;
    }

    public String getJbExeMethod() {
        return jbExeMethod;
    }

    public void setJbExeMethod(String jbExeMethod) {
        this.jbExeMethod = jbExeMethod;
    }

    public String getJbExeMode() {
        return jbExeMode;
    }

    public void setJbExeMode(String jbExeMode) {
        this.jbExeMode = jbExeMode;
    }
}
