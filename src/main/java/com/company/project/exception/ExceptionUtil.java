package com.company.project.exception;

import java.text.MessageFormat;

/**
 * Created by wangzhj on 2016/9/20.
 */
public class ExceptionUtil {

    public static String parseParamException(BaseException baseEx) {
        ParamException paramEx = (ParamException) baseEx;
        String errorCode = paramEx.getErrorCode();
        String errorDesc = paramEx.getErrorDesc();
        String paramName = paramEx.getParamName();
        Object paramValue = paramEx.getParamValue();

        String value = null;
        if (paramEx instanceof ParamEmptyValueException) {
            value = MessageFormat.format(errorDesc, paramName);
        } else if (paramEx instanceof ParamFormatErrorException) {


        } else if (paramEx instanceof ParamValueIllegalException) {


        }

        return value;
    }
}
