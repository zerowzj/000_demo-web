package com.company.project.common.util;

import com.company.project.common.web.session.SessionUserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Session Util
 *
 * @author wangzhj
 */
public abstract class SessionUtil {

    /** 用户信息 Session Key */
    private static final String SESSION_USER_INFO = "SESSION_USER_INFO";
    /** 授权编号列表 Session Key */
    private static final String SESSION_AUTH_ID_LT = "SESSION_AUTH_ID_LT";

    /**
     * 设置信息
     *
     * @param request
     * @param key
     * @param obj
     */
    public static <T> void set(HttpServletRequest request, String key, T obj){
        request.getSession().setAttribute(key, obj);
    }
    /**
     * 获取信息
     *
     * @param request
     * @param key
     * @return T
     */
    public static <T> T get(HttpServletRequest request, String key){
        T obj = (T) request.getSession().getAttribute(key);
        return obj;
    }

    /**
     * 设置用户信息
     *
     * @param request
     * @param userInfo
     */
    public static void setSessionUserInfo(HttpServletRequest request, SessionUserInfo userInfo) {
        set(request, SESSION_USER_INFO, userInfo);
    }
    /**
     * 获取用户信息
     *
     * @param request
     * @return SessionUserInfo
     */
    public static SessionUserInfo getSessionUserInfo(HttpServletRequest request) {
        SessionUserInfo userInfo = get(request, SESSION_USER_INFO);
        return userInfo;
    }

    /**
     * 设置授权编号列表
     *
     * @param request
     */
    public static void setAuthIdLt(HttpServletRequest request, List<Long> authIdLt) {
        set(request, SESSION_AUTH_ID_LT, authIdLt);
    }
    /**
     * 获取授权编号列表
     *
     * @param request
     * @return List<Long>
     */
    public static List<Long> getAuthIdLt(HttpServletRequest request) {
        List<Long> permissionIdLt = get(request, SESSION_AUTH_ID_LT);
        return permissionIdLt;
    }
}
