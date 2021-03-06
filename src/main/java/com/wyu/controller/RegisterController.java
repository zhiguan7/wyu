package com.wyu.controller;

import com.wyu.util.Encryption;
import com.wyu.entity.User;
import com.wyu.service.UserService;
import com.wyu.util.MailSenderUtil;
import com.wyu.util.CodeUtil;
import com.wyu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private UserService us;
    @Autowired
    private RedisUtil ru;
    @Autowired
    private MailSenderUtil msu;

    private User user = new User();

    @CrossOrigin
    @PostMapping("/register")
        public int register(@RequestBody User user) {

            if (us.searchByEmail(user.getUser_email()) != null)
                return 0;
            else {
                user.setCode(CodeUtil.randomCode());
                ru.set(user.getUser_email(), user.getCode(), 5 * 60);
                msu.send(user.getUser_email(), user.getCode());
            }
            return 1;
    }

    @CrossOrigin
    @PostMapping("/verify")
    public int verify(@RequestBody User user){
        if(!ru.get(user.getUser_email()).toString().equals(user.getCode()))
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
