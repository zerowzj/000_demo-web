package com.company.project.web.pattern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action
 *
 * @author wangzhj
 */
public interface Action<T> {

    /**
     * 执行
     *
     * @param request
     * @param response
     * @param params
     * @return Map<String, Object>
     */
    public Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response, T params);
}
