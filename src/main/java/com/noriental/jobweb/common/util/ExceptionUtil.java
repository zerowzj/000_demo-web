package com.noriental.jobweb.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Exception Util
 *
 * @author wangzhj
 */
public abstract class ExceptionUtil {

    /**
     * 取得异常详细信息
     *
     * @param exception
     * @return String
     */
    public static String getExceptionDetail(Throwable exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        //
        exception.printStackTrace(pw);
        //
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
