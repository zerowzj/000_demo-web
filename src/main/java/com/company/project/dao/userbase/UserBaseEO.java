package com.company.project.dao.userbase;

import com.company.project.common.db.BaseEO;

import java.util.Date;

/**
 * 用户基本信息EO
 *
 * @author wangzhj
 */
public class UserBaseEO extends BaseEO {

    /** 用户编号 */
    private Long ubId = null;
    /** 用户登录名 */
    private String ubLoginName = null;
    /** 用户登录密码 */
    private String ubLoginPwd = null;
    /** 用户类型 */
    private String ubType = null;
    /** 用户状态 */
    private String ubStatus = null;
    /** 用户姓名 */
    private String ubName = null;
    /** 创建时间 */
    private Date ubBeginTime = null;
    /** 角色编号 */
    private Long ubPrId = null;

    public Long getUbPrId() {
        return ubPrId;
    }

    public void setUbPrId(Long ubPrId) {
        this.ubPrId = ubPrId;
    }

    public Date getUbBeginTime() {
        return ubBeginTime;
    }

    public void setUbBeginTime(Date ubBeginTime) {
        this.ubBeginTime = ubBeginTime;
    }

    public String getUbStatus() {
        return ubStatus;
    }

    public void setUbStatus(String ubStatus) {
        this.ubStatus = ubStatus;
    }

    public Long getUbId() {
        return ubId;
    }

    public void setUbId(Long ubId) {
        this.ubId = ubId;
    }

    public String getUbLoginName() {
        return ubLoginName;
    }

    public void setUbLoginName(String ubLoginName) {
        this.ubLoginName = ubLoginName;
    }

    public String getUbLoginPwd() {
        return ubLoginPwd;
    }

    public void setUbLoginPwd(String ubLoginPwd) {
        this.ubLoginPwd = ubLoginPwd;
    }

    public String getUbType() {
        return ubType;
    }

    public void setUbType(String ubType) {
        this.ubType = ubType;
    }

    public String getUbName() {
        return ubName;
    }

    public void setUbName(String ubName) {
        this.ubName = ubName;
    }
}
