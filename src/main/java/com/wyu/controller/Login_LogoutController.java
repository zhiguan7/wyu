package com.wyu.controller;

import com.wyu.entity.ReturnValue;
import com.wyu.entity.User;
import com.wyu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Login_LogoutController {

    @Autowired
    private UserService us;

    @PostMapping("/login")
    public ReturnValue<User> login(@RequestBody User user) {

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUser_email(),user.getUser_password());
//        token.setRememberMe(rememberMe);
        if(!currentUser.isAuthenticated()){
            try {
                currentUser.login(token);
                User u=(User)SecurityUtils.getSubject().getPrincipal();
                if (null != currentUser.getSession())
                {
                    String sessionId = (String)currentUser.getSession().getId();
                    return  new ReturnValue<User>(1,"登陆成功",new User(u.getUser_id(),u.getUser_email(),u.getUser_name(),u.getUser_role(),sessionId));
                }
                return new ReturnValue<User>(1,"登陆成功",new User(u.getUser_id(),u.getUser_email(),u.getUser_name(),u.getUser_role(),null));
            } catch (UnknownAccountException e) {
                return new ReturnValue<User>(-1,"用户名不存在",null);
            } catch (IncorrectCredentialsException e) {
                return new ReturnValue<User>(-1,"密码错误",null);
            }
        }else {
            return new ReturnValue<User>(-1,"用户已登陆",null);
        }
    }

    @PostMapping("/logout")
    public ReturnValue<Object> logout() {
        SecurityUtils.getSubject().logout();
        return new ReturnValue<Object>(1,"退出登陆",null);
    }
}
