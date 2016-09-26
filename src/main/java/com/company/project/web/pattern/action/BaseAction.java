package com.company.project.web.pattern.action;

import com.company.project.common.util.JsonUtil;
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

    @Override
    public final Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response, T param) {
        logger.info("==========>");
        logger.info("==========>{}", JsonUtil.toJson(param));
        logger.info("==========>");
        Map<String, Object> model = new HashMap<>();
        try {
            RequestContext requestContext = new RequestContext(request, response);

            checkData(requestContext, param);

            Map<String, Object> dataMap = execute(requestContext, param);

            editData(requestContext, dataMap);

            model.put("result_code", "0000");
            model.put("result_desc", "成功");
            model.put("data", dataMap);
        } catch (Exception ex) {
            throw ex;
        }
        logger.info("<==========");
        logger.info("<=========={}", JsonUtil.toJson(model));
        logger.info("<==========");
        return model;
    }

    /**
     * 验证参数
     *
     * @param requestContext
     */
    public abstract void checkData(RequestContext requestContext, T param);

    /**
     * 执行逻辑
     *
     * @param requestContext
     * @return Map<String, Object>
     */
    public abstract Map<String, Object> execute(RequestContext requestContext, T param);

    /**
     * 编辑数据
     *
     * @param requestContext
     * @param dataMap
     */
    public void editData(RequestContext requestContext, Map<String, Object> dataMap){}
}