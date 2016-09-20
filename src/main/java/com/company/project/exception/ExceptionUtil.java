package com.company.project.exception;

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

        StringBuffer sb = new StringBuffer();
        if (paramEx instanceof ParamEmptyValueException) {
            sb.append(errorDesc).append("[").append(paramName).append("]");
        } else if (paramEx instanceof ParamFormatErrorException) {
            sb.append(errorDesc).append("[").append(paramName).append("]["+ paramValue+"]");
        } else if (paramEx instanceof ParamValueIllegalException) {
            sb.append(errorDesc).append("[").append(paramName).append("]["+ paramValue+"]");
        }

        return sb.toString();
    }
}
