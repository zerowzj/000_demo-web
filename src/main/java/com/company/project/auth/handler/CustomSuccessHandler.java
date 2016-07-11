package com.company.project.auth.handler;

import com.company.project.auth.CustomUserDetails;
import com.company.project.common.util.ServletUtil;
import com.company.project.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.web.SessionUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 认证成功处理器
 *
 * @author wangzhj
 */
public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomSuccessHandler.class);

    @Autowired
    private PopedomFunctionDao popedomFunctionDao = null;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //获取认证信息
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        CustomUserDetails userDetails = (CustomUserDetails) token.getPrincipal();
        //受保护的URL
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getFunctionLt(2);
        request.getSession().setAttribute("PPP", this.makeUrlLt(pfEOLt));
        //用户可访问的URL
        List<SimpleGrantedAuthority> grantedAuthLt = userDetails.getAuthorities();
        request.getSession().setAttribute("UUU", this.makeUserUrlLt(grantedAuthLt));

        SessionUserInfo userInfo = userDetails.getUserInfo();
        userInfo.setLoginTime(new Date());
        userInfo.setLoginIp(request.getRemoteAddr());
        ServletUtil.setSessionUserInfo(request, userInfo);

        //执行父逻辑
        super.onAuthenticationSuccess(request, response, authentication);
    }

    private List<String> makeUrlLt(List<PopedomFunctionEO> pfEOLt){
        List<String> urlLt = new ArrayList<>();
        for(PopedomFunctionEO pfEO : pfEOLt){
            urlLt.add(pfEO.getPfUrl());
        }
        return urlLt;
    }

    private List<String> makeUserUrlLt(List<SimpleGrantedAuthority> grantedAuthLt ){
        List<String> urlLt = new ArrayList<>();
        for(SimpleGrantedAuthority grantedAuth : grantedAuthLt){
            urlLt.add(grantedAuth.getAuthority());
        }
        return urlLt;
    }
}
