package com.wyu.controller;

import com.wyu.entity.User;
import com.wyu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAndLogoutController {

    @Autowired
    private UserService us;

    @PostMapping("/login")
    public int login(@RequestBody User user) {

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUser_email(),user.getUser_password());

//        token.setRememberMe(rememberMe);
        if(!currentUser.isAuthenticated()){
            try {
                currentUser.login(token);
                User u=(User)SecurityUtils.getSubject().getPrincipal();
                return 1;
            } catch (UnknownAccountException e) {
                return -1; //用户名不存在
            } catch (IncorrectCredentialsException e) {
                return -2; //密码错误
            }
        }else {
            return 0; //用户已登陆
        }
    }

    @RequestMapping("/logout")
    public int logout() {
        return 0;
    }
}
