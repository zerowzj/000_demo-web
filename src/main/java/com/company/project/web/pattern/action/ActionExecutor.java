package com.company.project.web.pattern.action;

import com.company.project.common.SpringWebContext;
import com.company.util.HttpRequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action执行器
 *
 * @author wangzhj
 */
public abstract class ActionExecutor {

    /**
     * 执行Action
     *
     * @param request
     * @param response
     * @param clazz 执行类
     * @param param 请求参数
     * @return Map<String, Object>
     */
    public static <T> T execute(HttpServletRequest request, HttpServletResponse response,
                                              Class<? extends Action> clazz, Object param) {
        if (!SpringWebContext.containsBean(clazz)) {
            throw new IllegalStateException("");
        }
        Action action = SpringWebContext.getBean(clazz);
        return (T) action.doExecute(request, response, param);
    }

    /**
     * 执行Action
     *
     * @param request
     * @param response
     * @param clazz 执行类
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              Class<? extends Action> clazz) {
        if (!SpringWebContext.containsBean(clazz)) {
            throw new IllegalStateException("");
        }
        Action action = SpringWebContext.getBean(clazz);
        return action.doExecute(request, response, HttpRequestUtil.extractParam(request));
    }

}
