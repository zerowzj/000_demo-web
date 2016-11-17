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
public abstract class BaseAction<T> implements Action<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseAction.class);

    private HttpServletRequest request = null;

    @Override
    public final Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response, T param) {
        Map<String, Object> model = new HashMap<>();
        try {
            RequestContext requestContext = new RequestContext(request, response);
            checkData(requestContext, param);

            Map<String, Object> dataMap = execute(requestContext, param);

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
     * @param param
     */
    public abstract void checkData(RequestContext requestContext, T param);

    /**
     * 执行逻辑
     *
     * @param requestContext
     * @param param
     * @return Map<String, Object>
     */
    public abstract Map<String, Object> execute(RequestContext requestContext, T param);
}
