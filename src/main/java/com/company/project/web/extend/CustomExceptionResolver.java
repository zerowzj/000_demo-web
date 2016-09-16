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
        if (ex instanceof IllegalArgumentException) { //自定义异常
            if (ServletUtil.isSync(request)) { //同步
                return null;
            } else {
                return null;
            }
        } else {
            ServletUtil.sendError(response, 500);
            return null;
        }
    }
}
