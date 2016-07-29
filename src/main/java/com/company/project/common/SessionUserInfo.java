package com.company.project.common;

/**
 * Session用户信息
 *
 * @author wangzhj
 */
public class SessionUserInfo {

    /** 用户编号 */
    private Long ubId = null;

    private String ubName = null;

    public Long getUbId() {
        return ubId;
    }

    public void setUbId(Long ubId) {
        this.ubId = ubId;
    }

    public String getUbName() {
        return ubName;
    }

    public void setUbName(String ubName) {
        this.ubName = ubName;
    }
}
