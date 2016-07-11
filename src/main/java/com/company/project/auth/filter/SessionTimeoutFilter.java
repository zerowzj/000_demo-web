package com.company.project.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangzhj
 */
public class SessionTimeoutFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(SessionTimeoutFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURI();
        logger.info(url);
        if(url.startsWith("/static") || url.startsWith("/view") || url.startsWith("/")){
            //
            filterChain.doFilter(request, response);
            return;
        }
        //
        Object target = request.getSession().getAttribute("PPP");
        if (target != null) {
//            ServletUtil.sendRedirect(response, "/login.jsp?msg=session_timeout");
            return;
        }
        //
        filterChain.doFilter(request, response);
    }
}
