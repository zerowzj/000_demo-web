package com.company.project.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 看门狗
 *
 * @author wangzhj
 */
public class WatchDogFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(WatchDogFilter.class);

    /** Session Key列表 */
    private List<String> sessionKeyLt = null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //设置跟踪NO
        MDC.put("id", String.valueOf(UUID.randomUUID().hashCode() & 0x7fffffff));

        logger.info("{}", request.getRequestURI());
        if (sessionKeyLt != null && !sessionKeyLt.isEmpty()) {
            //
            return;
        }
        for (String key : sessionKeyLt) {

        }

        //
        filterChain.doFilter(request, response);
    }

    public void setSessionKeyLt(List<String> sessionKeyLt) {
        this.sessionKeyLt = sessionKeyLt;
    }
}
