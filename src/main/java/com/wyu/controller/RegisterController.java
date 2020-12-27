package com.wyu.controller;

import com.wyu.config.Encryption;
import com.wyu.pojo.User;
import com.wyu.service.UserService;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {

    @Autowired private UserService us;
    @Autowired Encryption e;

    @RequestMapping("/register")
    public boolean register(@RequestBody Map<String, String> user){
        User u = new User();
        u.setUser_name(user.get("user_name"));
        u.setUser_password(e.encipher(user.get("user_name"),user.get("user_password")));
        try {
            us.add(u);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}