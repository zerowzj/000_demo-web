package com.noriental.jobweb.auth.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 *
 * @author wangzhj
 */
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        exception.printStackTrace();
        logger.info("登录失败...");
        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
            logger.info("用户名/密码错误");
            request.getSession().setAttribute("msg", "用户名或密码错误");
        } else {
            logger.info("未知错误", exception.getClass());
            request.setAttribute("msg", "系统错误，请联系管理员");
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
