package com.wyu.config;

import com.wyu.pojo.User;
import com.wyu.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————————————授权————————————");

        SimpleAuthorizationInfo Info = new SimpleAuthorizationInfo();

//        Info.addStringPermission("1");
//
//        Subject subject = SecurityUtils.getSubject();
//
//        User principal = (User) subject.getPrincipal();
//
//        Info.addStringPermission(principal.getUser_role().toString());

        return Info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————————————认证————————————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.searchByName(token.getUsername());
        if(user==null) return null;
        ByteSource salt = ByteSource.Util.bytes(user.getUser_name());
        return new SimpleAuthenticationInfo(user,user.getUser_password(),salt,this.getName());
    }
}
