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
    /** 功能状态 */
    private String pfStatus = null;
    /** 功能级别 */
    private Integer pfLevel = null;
    /** 功能路径 */
    private String pfPath = null;

    /**  */
    private List<PopedomFunctionEO> children = null;
}
