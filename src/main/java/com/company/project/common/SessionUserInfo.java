package com.company.project.common;

import com.company.project.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;

import java.util.List;

/**
 * Session用户信息
 *
 * @author wangzhj
 */
public class SessionUserInfo {

    /** 用户编号 */
    private Long ubId = null;
    /** 用户姓名 */
    private String ubName = null;

    /** 用户功能列表 */
    private List<PopedomFunctionEO> userFuncLt = null;

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

    public List<PopedomFunctionEO> getUserFuncLt() {
        return userFuncLt;
    }

    public void setUserFuncLt(List<PopedomFunctionEO> userFuncLt) {
        this.userFuncLt = userFuncLt;
    }
}
