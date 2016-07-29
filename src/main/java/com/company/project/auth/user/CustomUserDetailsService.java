package com.company.project.auth.user;

import com.company.project.common.SessionUserInfo;
import com.company.project.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.dao.userbase.UserBaseDao;
import com.company.project.dao.userbase.UserBaseEO;
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
        if (ubEO == null) {
            throw new UsernameNotFoundException("用户名/密码错误");
        }

        //获取用户功能权限
        Long prId = ubEO.getUbPrId();
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getRoleFunctionLt(prId);

        //生成用户详情
        CustomUserDetails userDetails = new CustomUserDetails(username, ubEO.getUbLoginPwd(), this.toGrantedAuthority(pfEOLt));
        //设置SessionUserInfo
        SessionUserInfo userInfo = new SessionUserInfo();
        userInfo.setUbId(ubEO.getUbId());     //用户编号
        userInfo.setUbName(ubEO.getUbName()); //用户姓名
        userDetails.setUserInfo(userInfo);

        //返回
        return userDetails;
    }

    private List<SimpleGrantedAuthority> toGrantedAuthority(List<PopedomFunctionEO> pfEOLt) {
        List<SimpleGrantedAuthority> grantedLt = new ArrayList<>();
        SimpleGrantedAuthority granted = null;
        for(PopedomFunctionEO pfEO : pfEOLt){
            String path = pfEO.getPfPath();
            granted = new SimpleGrantedAuthority(path);
            grantedLt.add(granted);
        }
        return grantedLt;
    }
}
