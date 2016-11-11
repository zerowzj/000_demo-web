package com.company.project.web.pattern.action;

import com.company.project.web.pattern.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础Action
 *
 * @author wangzhj
 */
public abstract class BaseAction implements Action {

    private static final Logger logger = LoggerFactory.getLogger(BaseAction.class);

    @Override
    public final Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response, Map<String, Object> paramMap) {
        Map<String, Object> model = new HashMap<>();
        try {
            RequestContext requestContext = new RequestContext(request, response);
            checkData(requestContext, paramMap);

            Map<String, Object> dataMap = execute(requestContext, paramMap);

            model.put("code", "0000");
            model.put("desc", "成功");
            model.put("data", dataMap);
        } catch (Exception ex) {
            throw ex;
        }
        return model;
    }

    /**
     * 验证参数
     *
     * @param requestContext
     * @param paramMap
     */
    public abstract void checkData(RequestContext requestContext, Map<String, Object> paramMap);

    /**
     * 执行逻辑
     *
     * @param requestContext
     * @param paramMap
     * @return Map<String, Object>
     */
    public abstract Map<String, Object> execute(RequestContext requestContext, Map<String, Object> paramMap);
}
