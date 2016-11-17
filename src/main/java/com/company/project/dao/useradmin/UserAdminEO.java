package com.company.project.dao.useradmin;

import com.company.db.dao.BaseEO;

import java.util.Date;

/**
 * 用户基本信息EO
 *
 * @author wangzhj
 */
public class UserAdminEO extends BaseEO {

    /** 用户编号 */
    private Long uaId = null;
    /** 用户登录名 */
    private String uaLoginName = null;
    /** 用户登录密码 */
    private String uaLoginPwd = null;
    /** 用户状态 */
    private String uaStatus = null;
    /** 用户姓名 */
    private String uaName = null;
    /** 创建时间 */
    private Date uaBeginTime = null;
    /** 角色编号 */
    private Long uaPrId = null;

    public Long getUaId() {
        return uaId;
    }

    public void setUaId(Long uaId) {
        this.uaId = uaId;
    }

    public String getUaLoginName() {
        return uaLoginName;
    }

    public void setUaLoginName(String uaLoginName) {
        this.uaLoginName = uaLoginName;
    }

    public String getUaLoginPwd() {
        return uaLoginPwd;
    }

    public void setUaLoginPwd(String uaLoginPwd) {
        this.uaLoginPwd = uaLoginPwd;
    }

    public String getUaStatus() {
        return uaStatus;
    }

    public void setUaStatus(String uaStatus) {
        this.uaStatus = uaStatus;
    }

    public String getUaName() {
        return uaName;
    }

    public void setUaName(String uaName) {
        this.uaName = uaName;
    }

    public Date getUaBeginTime() {
        return uaBeginTime;
    }

    public void setUaBeginTime(Date uaBeginTime) {
        this.uaBeginTime = uaBeginTime;
    }

    public Long getUaPrId() {
        return uaPrId;
    }

    public void setUaPrId(Long uaPrId) {
        this.uaPrId = uaPrId;
    }
}
