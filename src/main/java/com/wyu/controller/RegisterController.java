package com.wyu.controller;

import com.wyu.util.Encryption;
import com.wyu.entity.User;
import com.wyu.service.UserService;
import com.wyu.util.MailSenderUtil;
import com.wyu.util.RandomCode;
import com.wyu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
public class RegisterController {

    @Autowired
    private UserService us;
    @Autowired
    private RedisUtil ru;
    @Autowired
    private MailSenderUtil msu;

    private User user = new User();

    @PostMapping("/register")
    public int register(@RequestBody User user) {

        this.user = user;
        if (us.searchByEmail(user.getUser_email()) != null)
            return 0;
        else {
            user.setCode(RandomCode.randomCode());
            ru.set(user.getUser_email(), user.getCode(), 5 * 60);
            msu.send(user.getUser_email(), user.getCode());
        }
        return 1;
    }

    @GetMapping("/verify")
    public int verify(@RequestBody Map<String,String> map){
        User user = this.user;
        if(!ru.get(user.getUser_email()).toString().equals(map.get("code")))
            return 0;
        user.setUser_password(Encryption.encipher(user.getUser_email(),user.getUser_password()));
        try {
            us.add(user);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }
}
