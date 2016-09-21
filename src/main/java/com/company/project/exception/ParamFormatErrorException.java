package com.company.project.exception;

/**
 * 参数格式错误异常
 *
 * @author wangzhj
 */
public class ParamFormatErrorException extends ParamException {

    public ParamFormatErrorException(String paramName, Object paramValue){
        super("1002", "参数格式错误[{0}]", paramName, paramValue);
    }
}
