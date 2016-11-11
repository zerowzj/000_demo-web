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
     * @param clazz
     *         执行类
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              Class<? extends Action> clazz, Object param) {
        if (!SpringWebContext.containsBean(clazz)) {
            throw new IllegalStateException("未包含类型的" + clazz.getName() + "Bean");
        }
        Action action = SpringWebContext.getBean(clazz);
        return action.doExecute(request, response, param);
    }

    /*
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
        Map<String, Object> paramMap = HttpRequestUtil.extractParam(request);
        return action.doExecute(request, response, paramMap);
    }
}
