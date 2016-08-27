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

    public static final String SESSION_ = "";

    /**  */
    private static final String SESSION_USER_INFO = "SESSION_USER_INFO";
    /**  */
    private static final String SESSION_PERMISSION_ID_LIST = "SESSION_PERMISSION_ID_LIST";

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
     * 设置许可编号列表
     *
     * @param request
     * @return SessionUserInfo
     */
    public static void setPermissionIdLt(HttpServletRequest request, List<Long> permissionIdLt) {
        set(request, SESSION_PERMISSION_ID_LIST, permissionIdLt);
    }
    /**
     * 获取许可编号列表
     *
     * @param request
     * @return List<Long>
     */
    public static List<Long> getPermissionIdLt(HttpServletRequest request) {
        List<Long> permissionIdLt = get(request, SESSION_PERMISSION_ID_LIST);
        return permissionIdLt;
    }
}
