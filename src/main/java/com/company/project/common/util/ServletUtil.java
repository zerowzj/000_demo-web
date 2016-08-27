package com.company.project.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author wangzhj
 */
public class ServletUtil {

    private static final String CHARSET_UTF_8 = "UTF-8";

    /**
     * 写到客户端
     *
     * @param response
     * @param msg
     */
    public static void write(HttpServletResponse response, String msg) {
        write(response, msg, CHARSET_UTF_8);
    }
    /**
     * 写到客户端
     *
     * @param response
     * @param msg
     * @param charset
     */
    public static void write(HttpServletResponse response, String msg, String charset) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    /**
     * 写到客户端
     *
     * @param response
     * @param statusCode
     */
    public static void sendError(HttpServletResponse response, int statusCode) {
        try {
            response.sendError(statusCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
