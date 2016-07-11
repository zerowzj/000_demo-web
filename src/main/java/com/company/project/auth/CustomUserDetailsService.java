package com.company.project.auth;

import com.company.project.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.dao.userbase.UserBaseDao;
import com.company.project.dao.userbase.UserBaseEO;
import com.company.project.web.SessionUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证服务
 *
 * @author wangzhj
 */
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserBaseDao userBaseDao = null;

    @Autowired
    private PopedomFunctionDao popedomFunctionDao = null;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取用户信息
        UserBaseEO ubEO = userBaseDao.getUserByLoginName(username);
        if(ubEO == null){
            throw new UsernameNotFoundException("用户名/密码错误");
        }
        //
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getRoleFunctionLt(ubEO.getUbPrId());
        //生成用户详情
        CustomUserDetails userDetails = new CustomUserDetails(username, ubEO.getUbLoginPwd(), this.makeGrantedAuthority(pfEOLt));

        SessionUserInfo userInfo = new SessionUserInfo();
        userInfo.setUbId(ubEO.getUbId());
        userInfo.setUbLoginName(ubEO.getUbLoginName());
        userInfo.setUbName(ubEO.getUbName());
        userInfo.setUbBeginTime(ubEO.getUbBeginTime());
        userDetails.setUserInfo(userInfo);

        return userDetails;
    }


    private List<SimpleGrantedAuthority> makeGrantedAuthority(List<PopedomFunctionEO> pfEOLt){

        List<SimpleGrantedAuthority> grantedAuthLt = new ArrayList<SimpleGrantedAuthority>();
        SimpleGrantedAuthority grantedAuth = null;
        for(PopedomFunctionEO pfEO : pfEOLt){
            //
            String path = pfEO.getPfUrl();
            if(path == null || "".equals(path)){
                continue;
            }

            grantedAuth = new SimpleGrantedAuthority(path);
            grantedAuthLt.add(grantedAuth);
        }

        return grantedAuthLt;
    }
}
