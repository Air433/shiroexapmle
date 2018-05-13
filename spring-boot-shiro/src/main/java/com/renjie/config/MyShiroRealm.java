package com.renjie.config;

import com.renjie.entity.SysRole;
import com.renjie.entity.UserInfo;
import com.renjie.service.IUserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Air on 2018/5/12.
 */
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private IUserInfoService userInfoService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        UserInfo userInfo = (UserInfo)principals.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()) {
            //authenticationInfo.
        }


        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserInfo userInfo = userInfoService.findByUsername(username);

        if (userInfo == null){
            return null;
        }
        if (userInfo.getState()==1){
            throw new LockedAccountException();
        }
        return null;
    }
}
