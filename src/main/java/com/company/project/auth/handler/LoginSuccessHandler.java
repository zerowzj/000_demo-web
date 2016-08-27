package com.company.project.auth.handler;

import com.company.project.auth.user.CustomUserDetails;
import com.company.project.common.tree.ZTree;
import com.company.project.common.util.JsonUtil;
import com.company.project.common.web.session.SessionUserInfo;
import com.company.project.common.util.SessionUtil;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
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

        //获取
        SessionUserInfo userInfo = userDetails.getUserInfo();
        List<PopedomFunctionEO> pfEOLt = userInfo.getUserFuncLt();

        SessionUtil.setSessionUserInfo(request, userInfo);
        SessionUtil.setPermissionIdLt(request, getPermissionIdLt(pfEOLt));
        SessionUtil.set(request, "SESSION_USER_INFO", JsonUtil.toJson(toMenu(pfEOLt)));

        //执行父逻辑
        super.onAuthenticationSuccess(request, response, authentication);
    }

    /**
     * 转换成菜单
     */
    private List<ZTree> toMenu(List<PopedomFunctionEO> pfEOLt) {
        List<ZTree> zTreeLt = new ArrayList<>();
        ZTree zTree = null;
        for (PopedomFunctionEO pfEO : pfEOLt) {
            //过滤掉非1 2级功能
            int pfLevel = pfEO.getPfLevel();
            if (pfLevel != 1 && pfLevel != 2) {
                continue;
            }
            zTree = new ZTree();

            zTree.setId(pfEO.getPfId());
            zTree.setpId(pfEO.getPfParentId());
            zTree.setName(pfEO.getPfName());
            zTree.setUrl(pfEO.getPfPath());

            zTreeLt.add(zTree);
        }
        return zTreeLt;
    }

    private List<Long> getPermissionIdLt(List<PopedomFunctionEO> pfEOLt) {
        List<Long> permissionIdLt = new ArrayList<>();
        for (PopedomFunctionEO pfEO : pfEOLt) {
            permissionIdLt.add(pfEO.getPfId());
        }
        return permissionIdLt;
    }
}
