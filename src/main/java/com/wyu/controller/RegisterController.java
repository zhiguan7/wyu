package com.wyu.controller;

import com.wyu.entity.ReturnValue;
import com.wyu.util.Encryption;
import com.wyu.entity.User;
import com.wyu.service.UserService;
import com.wyu.util.MailSenderUtils;
import com.wyu.util.CodeUtils;
import com.wyu.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private UserService us;
    @Autowired
    private RedisUtils ru;
    @Autowired
    private MailSenderUtils msu;

    @PostMapping("/register")
        public ReturnValue<Object> register(@RequestBody User user) {

            if (us.searchByEmail(user.getUser_email()) != null)
                return new ReturnValue<Object>(-1,"邮箱已被注册",null);
            else {
                user.setCode(CodeUtils.randomCode());
                ru.set(user.getUser_email(), user.getCode(), 5 * 60);
                msu.send(user.getUser_email(), user.getCode());
            }
            return new ReturnValue<Object>(1,"邮箱验证码已发送",null);
    }

    @PostMapping("/verify")
    public ReturnValue<Object> verify(@RequestBody User user){
        if(!ru.get(user.getUser_email()).toString().equals(user.getCode()))
            return new ReturnValue<Object>(-1,"验证码不符",null);
        user.setUser_password(Encryption.encipher(user.getUser_email(),user.getUser_password()));
        try {
            us.add(user);
        } catch (Exception e) {
            return new ReturnValue<Object>(-2,"注册失败",null);
        }
        return new ReturnValue<Object>(1,"注册成功",null);
    }
}
