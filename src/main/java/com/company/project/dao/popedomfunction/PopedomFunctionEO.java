package com.company.project.dao.popedomfunction;

import com.company.project.common.db.BaseEO;

/**
 * 功能信息EO
 *
 * @author wangzhj
 */
public class PopedomFunctionEO extends BaseEO {

    /** 功能编号 */
    private Long pfId = null;
    /** 父功能编号 */
    private Long pfParentId = null;

    /** 功能名称 */
    private String pfName = null;
    /** 功能状态 */
    private String pfStatus = null;
    /** 功能级别 */
    private Integer pfLevel = null;
    /** 功能路径 */
    private String pfPath = null;

    public Long getPfId() {
        return pfId;
    }

    public void setPfId(Long pfId) {
        this.pfId = pfId;
    }

    public Long getPfParentId() {
        return pfParentId;
    }

    public void setPfParentId(Long pfParentId) {
        this.pfParentId = pfParentId;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPfStatus() {
        return pfStatus;
    }

    public void setPfStatus(String pfStatus) {
        this.pfStatus = pfStatus;
    }

    public Integer getPfLevel() {
        return pfLevel;
    }

    public void setPfLevel(Integer pfLevel) {
        this.pfLevel = pfLevel;
    }

    public String getPfPath() {
        return pfPath;
    }

    public void setPfPath(String pfPath) {
        this.pfPath = pfPath;
    }
}
