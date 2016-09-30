package com.company.project.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Servlet Util
 *
 * @author wangzhj
 */
public abstract class ServletUtil {

    private static final String CHARSET_UTF_8 = "UTF-8";

    private static final String AJAX_HEADER = "X-Requested-With";

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
        checkNull(response);
        PrintWriter out = null;
        try {
            response.setContentType("text/plain;charset=" + charset);
            out = response.getWriter();
            out.write(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * @param response
     * @param statusCode
     */
    public static void sendError(HttpServletResponse response, int statusCode) {
        checkNull(response);
        try {
            response.sendError(statusCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 是否是ajax请求
     *
     * @param request
     * @return boolean
     */
    public static boolean isAjax(HttpServletRequest request) {
        checkNull(request);
        String xRequested = request.getHeader(AJAX_HEADER);
        if ("XMLHttpRequest".equals(xRequested)) {
            return true;
        }
        return false;
    }

    /**
     * 是否是同步请求
     *
     * @param request
     * @return boolean
     */
    public static boolean isSync(HttpServletRequest request) {
        checkNull(request);
        String xRequested = request.getHeader(AJAX_HEADER);
        if (xRequested == null) {
            return true;
        }
        return false;
    }

    private static void checkNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("request is null");
        }
    }

    /**
     * 提取HttpServletRequest参数
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> extractParam(HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String key = (String) enums.nextElement();
            String[] value = request.getParameterValues(key);
            if (value.length == 1) {
                map.put(key, value[0]);
            } else {
                map.put(key, Arrays.asList(value));
            }
        }
        return map;
    }
}
