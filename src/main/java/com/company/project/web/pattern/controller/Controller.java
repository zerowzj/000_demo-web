package com.company.project.web.pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 控制器
 *
 * @author wangzhj
 */
public interface Controller {

    /**
     * 模板方法
     *
     * @param request
     * @param response
     * @return Map<String, Object>
     */
    public Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response, Map<String, Object> params);
}
