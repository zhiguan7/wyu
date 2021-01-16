package com.wyu.controller;

import com.wyu.entity.User;
import com.wyu.service.UserService;
import com.wyu.util.CodeUtil;
import com.wyu.util.Encryption;
import com.wyu.util.MailSenderUtil;
import com.wyu.util.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/update")
public class Info_updateController {

    @Autowired
    private UserService us;
    @Autowired
    private RedisUtil ru;
    @Autowired
    private MailSenderUtil msu;

    private User user = new User();

    @CrossOrigin
    @PostMapping("/user")
    public int userUpdate(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        User u = (User) subject.getPrincipal();
        user.setUser_id(u.getUser_id());
        if(user.getUser_email()!=null&&user.getUser_password()!=null){
            if(us.searchByEmail(user.getUser_email()) != null) return 0;
            user.setCode(CodeUtil.randomCode());
            ru.set(user.getUser_email(), user.getCode(), 5 * 60);
            msu.send(user.getUser_email(), user.getCode());
        }else{
            if(user.getUser_email()!=null){
                if(us.searchByEmail(user.getUser_email()) != null) return 0;
                user.setCode(CodeUtil.randomCode());
                ru.set(user.getUser_email(), user.getCode(), 5 * 60);
                msu.send(user.getUser_email(), user.getCode());
            }else{
                if(user.getUser_password()!=null){
                    user.setCode(CodeUtil.randomCode());
                    user.setUser_email(u.getUser_email());
                    ru.set(u.getUser_email(), user.getCode(), 5 * 60);
                    msu.send(u.getUser_email(), user.getCode());
                }else{
                    us.update(user);
                    return 2;
                }
            }
        }
        this.user = user;
        return 1;
    }

    @CrossOrigin
    @GetMapping("/verify")
    public int verify(@RequestBody Map<String,String> map){
        User user = this.user;
        if(!ru.get(user.getUser_email()).toString().equals(map.get("code")))
            return 0;
        if (user.getUser_password()!=null){
            user.setUser_password(Encryption.encipher(user.getUser_email(),user.getUser_password()));
        }
        try {
            us.update(user);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }
}
