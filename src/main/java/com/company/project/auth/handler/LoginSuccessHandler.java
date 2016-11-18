package com.company.project.auth.handler;

import com.company.project.auth.user.CustomUserDetails;
import com.company.project.common.web.menu.Menu;
import com.company.project.common.web.session.SessionUserInfo;
import com.company.project.common.web.session.SessionUtil;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 认证成功处理器
 *
 * @author wangzhj
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //获取认证信息
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        CustomUserDetails userDetails = (CustomUserDetails) token.getPrincipal();

        logger.info("用户[{}]登录系统成功!", userDetails.getUsername());

        //获取用户及功能列表
        SessionUserInfo userInfo = userDetails.getUserInfo();
        List<PopedomFunctionEO> pfEOLt = userInfo.getUserFuncLt();
        //用户信息
        SessionUtil.setSessionUserInfo(request, userInfo);
        //授权编号列表
        SessionUtil.setSessionAuthIdLt(request, getAuthIdLt(pfEOLt));
        //菜单信息
        SessionUtil.setSessionMenuInfo(request, transferMenuInfo(pfEOLt));

        //执行父逻辑
        super.onAuthenticationSuccess(request, response, authentication);
    }

    /**
     * 转换成菜单信息
     *
     * @param pfEOLt
     * @return String
     */
    private String transferMenuInfo(List<PopedomFunctionEO> pfEOLt) {
        List<Menu> menuLt = new ArrayList<>();
        Menu menu = null;
        for (PopedomFunctionEO pfEO : pfEOLt) {
            //仅将1、2级功能作为菜单
            int pfLevel = pfEO.getPfLevel();
            if (pfLevel != 1 && pfLevel != 2) {
                continue;
            }
            menu = new Menu();

            menu.setId(pfEO.getPfId());
            menu.setpId(pfEO.getPfParentId());
            menu.setName(pfEO.getPfName());
            menu.setUrl(pfEO.getPfPath());

            menuLt.add(menu);
        }
        return JsonUtil.toJson(menuLt);
    }
    /**
     * 获取授权编号列表
     *
     * @param pfEOLt
     * @return List<Long>
     */
    private List<Long> getAuthIdLt(List<PopedomFunctionEO> pfEOLt) {
        List<Long> authIdLt = new ArrayList<>();
        for (PopedomFunctionEO pfEO : pfEOLt) {
            authIdLt.add(pfEO.getPfId());
        }
        return authIdLt;
    }
}
