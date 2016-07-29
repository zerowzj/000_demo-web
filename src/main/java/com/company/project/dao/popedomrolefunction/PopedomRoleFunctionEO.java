package com.company.project.dao.popedomrolefunction;

import com.company.project.common.db.BaseEO;

/**
 * 角色功能EO
 *
 * @author wangzhj
 */
public class PopedomRoleFunctionEO extends BaseEO {

    /** 角色编号 */
    private Long prfPrId = null;
    /** 功能编号 */
    private Long prfPfId = null;

    public Long getPrfPrId() {
        return prfPrId;
    }

    public void setPrfPrId(Long prfPrId) {
        this.prfPrId = prfPrId;
    }

    public Long getPrfPfId() {
        return prfPfId;
    }

    public void setPrfPfId(Long prfPfId) {
        this.prfPfId = prfPfId;
    }
}
