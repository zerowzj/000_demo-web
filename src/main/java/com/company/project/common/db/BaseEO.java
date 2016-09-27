package com.company.project.common.db;

import com.company.project.common.util.JsonUtil;

import java.io.Serializable;

/**
 * 基础EO
 *
 * @author wangzhj
 */
public class BaseEO implements Serializable {

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
