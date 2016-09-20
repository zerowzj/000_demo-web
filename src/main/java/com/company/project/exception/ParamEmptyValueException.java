package com.company.project.exception;

/**
 * 参数空值异常
 *
 * @author wangzhj
 */
public class ParamEmptyValueException extends ParamException {

    public ParamEmptyValueException(String paramName){
        super("10001", "参数为空", paramName);
    }
}
