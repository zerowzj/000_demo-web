package com.company.project.web.pattern.action;

import com.company.project.common.SpringContext;
import com.company.project.common.util.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action执行器
 *
 * @author wangzhj
 */
public class ActionExecutor {

    /**
     * 执行Action
     *
     * @param request
     * @param response
     * @param actionName
     * @param param
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response, String actionName, Object param) {
        if (!SpringContext.containsBean(actionName)) {
            throw new IllegalStateException("ssssssssssssssss");
        }
        Action action = SpringContext.getBean(actionName);
        return action.doExecute(request, response, param);
    }

    /**
     * 执行Action
     *
     * @param request
     * @param response
     * @param clazz
     * @param param
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response, Class<? extends Action> clazz, Object param) {
        if (!SpringContext.containsBean(clazz)) {
            throw new IllegalStateException("ssssssssssssssss");
        }
        Action action = SpringContext.getBean(clazz);
        return action.doExecute(request, response, param);
    }

    /**
     * 执行Action
     *
     * @param request
     * @param response
     * @param actionName
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response, String actionName) {
        if (!SpringContext.containsBean(actionName)) {
            throw new IllegalStateException("ssssssssssssssss");
        }
        Action action = SpringContext.getBean(actionName);
        return action.doExecute(request, response, ServletUtil.extractParam(request));
    }
    /**
     * 执行Action
     *
     * @param request
     * @param response
     * @param clazz
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response, Class<? extends Action> clazz) {
        if (!SpringContext.containsBean(clazz)) {
            throw new IllegalStateException("ssssssssssssssss");
        }
        Action action = SpringContext.getBean(clazz);
        return action.doExecute(request, response, ServletUtil.extractParam(request));
    }

}
