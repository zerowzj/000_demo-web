package com.company.project.auth.user;

import com.company.project.common.SessionUserInfo;
import com.company.project.dao.userbase.UserBaseDao;
import com.company.project.dao.userbase.UserBaseEO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 认证服务
 *
 * @author wangzhj
 */
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserBaseDao userBaseDao = null;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取用户信息
        UserBaseEO ubEO = userBaseDao.getUserByLoginName(username);
        if(ubEO == null){
            throw new UsernameNotFoundException("用户名/密码错误");
        }

        //生成用户详情
        CustomUserDetails userDetails = new CustomUserDetails(username, ubEO.getUbLoginPwd(), null);
        //设置SessionUserInfo
        SessionUserInfo userInfo = new SessionUserInfo();
        userInfo.setUbId(ubEO.getUbId());     //用户编号
        userInfo.setUbName(ubEO.getUbName()); //用户姓名
        userDetails.setUserInfo(userInfo);

        //返回
        return userDetails;
    }
}
