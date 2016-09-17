package com.company.project.web.extend;

import com.company.project.common.util.ServletUtil;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        if (ex instanceof IllegalArgumentException) {
            //同步请求
            if (ServletUtil.isSync(request)) {
                return new ModelAndView();
            } else { //非同步请求
                ServletUtil.write(response, "");
                return null;
            }
        } else { //其他异常
            ServletUtil.sendError(response, 500);
            return null;
        }
    }
}
