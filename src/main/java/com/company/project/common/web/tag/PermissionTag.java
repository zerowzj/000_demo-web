package com.company.project.common.web.tag;

import com.company.project.common.web.session.SessionUtil;

import javax.servlet.jsp.JspException;
import java.util.List;

/**
 * 许可标签
 *
 * @author wangzhj
 */
public class PermissionTag extends BaseTag {

    /** 许可ID */
    private Long pId = null;

    @Override
    public int doStartTag() throws JspException {
        List<Long> permissionIdLt = SessionUtil.getPermissionIdLt(getHttpServletRequest());
        if (permissionIdLt.contains(pId)) {

            return EVAL_BODY_INCLUDE;
        } else {
            write("禁止访问");
            return SKIP_BODY;
        }
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }
}
