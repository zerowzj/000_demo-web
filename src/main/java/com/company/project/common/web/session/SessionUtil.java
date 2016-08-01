package com.company.project.common.web.session;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 *
 * @author wangzhj
 */
public abstract class SessionUtil {

    private static final String SESSION_USER_INFO = "SESSION_USER_INFO";

    private static final String SESSION_PERMISSION_ID_LIST = "SESSION_PERMISSION_ID_LIST";

    /**
     * 设置用户信息
     *
     * @param request
     * @param userInfo
     */
    public static void setSessionUserInfo(HttpServletRequest request, SessionUserInfo userInfo) {
        request.getSession().setAttribute(SESSION_USER_INFO, userInfo);
    }
    /**
     * 获取用户信息
     *
     * @param request
     * @return SessionUserInfo
     */
    public static SessionUserInfo getSessionUserInfo(HttpServletRequest request) {
        SessionUserInfo userInfo = (SessionUserInfo) request.getSession().getAttribute(SESSION_USER_INFO);
        return userInfo;
    }


    /**
     * 设置许可编号列表
     *
     * @param request
     * @return SessionUserInfo
     */
    public static void setPermissionIdLt(HttpServletRequest request, List<Long> permissionIdLt) {
        request.getSession().setAttribute(SESSION_PERMISSION_ID_LIST, permissionIdLt);
    }
    /**
     * 获取许可编号列表
     *
     * @param request
     * @return List<Long>
     */
    public static List<Long> getPermissionIdLt(HttpServletRequest request) {
        List<Long> permissionIdLt = (List<Long>) request.getSession().getAttribute(SESSION_PERMISSION_ID_LIST);
        return permissionIdLt;
    }
}
