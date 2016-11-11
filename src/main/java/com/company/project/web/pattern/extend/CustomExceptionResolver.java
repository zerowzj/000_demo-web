package com.company.project.web.pattern.extend;

import com.company.exception.BaseException;
import com.company.util.HttpRequestUtil;
import com.company.util.HttpWriteUtil;
import com.company.util.JsonUtil;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常解析器
 *
 * @author wangzhj
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        //自定义异常
        if (ex instanceof BaseException) {
            //获取异常信息
            BaseException baseEx = (BaseException) ex;
            baseEx.getErrorCode();
            baseEx.getErrorDesc();
            //同步请求
            if (HttpRequestUtil.isSync(request)) {
                Map<String, Object> model = new HashMap<>();
//                model.put("message", ExceptionUtil.parseParamException(baseEx));
                return new ModelAndView("message", model);
            } else { //非同步请求
                Map<String, Object> model = new HashMap<>();
                model.put("result_code", baseEx.getErrorCode());
//                model.put("result_desc", ExceptionUtil.parseParamException(baseEx));
                HttpWriteUtil.write(response, JsonUtil.toJson(model));
                return null;
            }
        } else { //其他异常
//            ServletUtil.sendError(response, 500);
            return null;
        }
    }
}
