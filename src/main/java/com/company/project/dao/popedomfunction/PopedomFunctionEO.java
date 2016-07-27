package com.company.project.dao.popedomfunction;

import com.company.project.common.db.BaseEO;

import java.util.List;

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

    /** 功能级别 */
    private Integer pfLevel = null;

    private String pfUrl = null;

    /**  */
    private List<PopedomFunctionEO> children = null;

    public String getPfUrl() {
        return pfUrl;
    }

    public void setPfUrl(String pfUrl) {
        this.pfUrl = pfUrl;
    }

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

    public List<PopedomFunctionEO> getChildren() {
        return children;
    }

    public void setChildren(List<PopedomFunctionEO> children) {
        this.children = children;
    }

    public Integer getPfLevel() {
        return pfLevel;
    }

    public void setPfLevel(Integer pfLevel) {
        this.pfLevel = pfLevel;
    }
}
