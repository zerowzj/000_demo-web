package com.company.project.dao.popedomrole;

import com.company.project.common.db.BaseEO;

import java.util.Date;

/**
 * 角色信息EO
 *
 * @author wangzhj
 */
public class PopedomRoleEO extends BaseEO {

    /** 角色编号 */
    private Long prId = null;

    /** 角色名称 */
    private String prName = null;

    /** 角色状态 */
    private String prStatus = null;

    /** 角色类型 */
    private String prType = null;

    /** 创建时间 */
    private Date prBeginTime = null;

    /** 角色描述 */
    private String prDesc = null;

    public Long getPrId() {
        return prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public String getPrStatus() {
        return prStatus;
    }

    public void setPrStatus(String prStatus) {
        this.prStatus = prStatus;
    }

    public String getPrType() {
        return prType;
    }

    public void setPrType(String prType) {
        this.prType = prType;
    }

    public String getPrDesc() {
        return prDesc;
    }

    public void setPrDesc(String prDesc) {
        this.prDesc = prDesc;
    }

    public Date getPrBeginTime() {
        return prBeginTime;
    }

    public void setPrBeginTime(Date prBeginTime) {
        this.prBeginTime = prBeginTime;
    }
}
