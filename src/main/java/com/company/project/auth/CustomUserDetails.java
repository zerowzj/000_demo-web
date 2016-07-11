package com.company.project.auth;

import com.company.project.web.SessionUserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 用户详情
 *
 * @author wangzhj
 */
public class CustomUserDetails implements UserDetails {

    /** 登录名 */
    private String loginName = null;
    /** 登录密码 */
    private String loginPwd = null;
    /** 授权 */
    private List<SimpleGrantedAuthority> grantedAuthLt = null;

    /** 用户信息 */
    private SessionUserInfo userInfo = null;

    public CustomUserDetails(String loginName, String loginPwd, List<SimpleGrantedAuthority> grantedAuthLt) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.grantedAuthLt = grantedAuthLt;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return this.grantedAuthLt;
    }

    @Override
    public String getPassword() {
        return this.loginPwd;
    }

    @Override
    public String getUsername() {
        return this.loginName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public SessionUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(SessionUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
