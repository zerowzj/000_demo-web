package com.noriental.jobweb.common.db;

import com.noriental.jobweb.common.util.StringUtil;

import java.io.Serializable;

/**
 * 基础EO
 *
 * @author wangzhj
 */
public class BaseEO implements Serializable {

    @Override
    public String toString() {
        return StringUtil.toString(this);
    }
}
