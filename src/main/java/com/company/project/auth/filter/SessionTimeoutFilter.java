package com.company.project.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 会话过期过滤器
 *
 * @author wangzhj
 */
public class SessionTimeoutFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(SessionTimeoutFilter.class);

    /** Session Key列表 */
    private List<String> sessionKeyLt = null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("======>" + request.getRequestURI());
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
