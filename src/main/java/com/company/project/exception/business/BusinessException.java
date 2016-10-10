package com.company.project.exception.business;

import com.company.project.exception.BaseException;

/**
 * 业务异常
 *
 * @author wangzhj
 */
public class BusinessException extends BaseException {

    /** 对象名称 */
    private String objName = null;

    public BusinessException(String errorCode, String errorDesc, String objName){
        super(errorCode, errorDesc);
        this.objName = objName;
    }

    public String getObjName() {
        return objName;
    }
}
