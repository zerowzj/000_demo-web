package com.company.project.web.pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础控制器
 *
 * @author wangzhj
 */
public abstract class BaseController implements MyController {

    @Override
    @RequestMapping
    @ResponseBody
    public Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<>();
        try {
            RequestContext requestContext = new RequestContext(request, response);

            checkData(requestContext);

            Map<String, Object> dataMap = execute(requestContext);

            editData(requestContext, dataMap);

            model.put("result_code", "0000");
            model.put("result_desc", "成功");
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
     */
    public abstract void checkData(RequestContext requestContext);

    /**
     * 执行
     *
     * @param requestContext
     * @return Map<String, Object>
     */
    public abstract Map<String, Object> execute(RequestContext requestContext);

    /**
     * 编辑数据
     *
     * @param requestContext
     * @param dataMap
     */
    public abstract void editData(RequestContext requestContext, Map<String, Object> dataMap);
}
