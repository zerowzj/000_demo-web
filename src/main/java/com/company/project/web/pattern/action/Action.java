package com.company.project.web.pattern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action
 *
 * @author wangzhj
 */
public interface Action {

    /**
     * 执行
     *
     * @param request
     * @param response
     * @param paramMap 参数Map
     * @return Map<String, Object>
     */
    public Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response, Map<String, Object> paramMap);
}
