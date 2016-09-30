package com.noriental.jobweb.manage.web.form;

import java.io.Serializable;

/**
 * 通知参数
 *
 * @author wangzhj
 */
public class NotifyForm implements Serializable {

    /** 跟踪号 */
    private String trackNo = null;
    
    /** 执行结果 */
    private String exeResult = null;
    /** 执行数据数 */
    private String exeDataCount = null;

    /** 备注 */
    private String remark = null;

    public String getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(String trackNo) {
        this.trackNo = trackNo;
    }

    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
    }

    public String getExeDataCount() {
        return exeDataCount;
    }

    public void setExeDataCount(String exeDataCount) {
        this.exeDataCount = exeDataCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
