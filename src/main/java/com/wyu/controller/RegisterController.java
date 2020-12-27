package com.wyu.controller;

import com.wyu.config.Encryption;
import com.wyu.pojo.User;
import com.wyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired private UserService us;
    @Autowired Encryption e;

    @PostMapping("/register")
    public boolean register(@RequestBody User user){
        user.setUser_password(e.encipher(user.getUser_name(),user.getUser_password()));
        try {
            us.add(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
