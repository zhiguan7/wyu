package com.wyu.controller;

import com.wyu.entity.User;
import com.wyu.service.UserService;
import com.wyu.util.*;
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

    @PostMapping("/user")
    public int userUpdate(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        User u = (User) subject.getPrincipal();
        user.setUser_id(u.getUser_id());
        user.setOther(GetTimeUtil.getTime());
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

    @GetMapping("/setRoleUser")
    public int setRole_User(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.USER);
        us.update(u);
        return 0;
    }

    @GetMapping("/setRoleService")
    public int setRole_Service(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.CUSTOMER_SERVICE);
        us.update(u);
        return 0;
    }

    @GetMapping("/setRoleFactory")
    public int setRole_Factory(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.FACTORY);
        us.update(u);
        return 0;
    }

    @GetMapping("/setRoleIns")
    public int setRole_Ins(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.INSTITUTION);
        us.update(u);
        return 0;
    }

    @GetMapping("/setRoleDouble")
    public int setRole_Double(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.DOUBLE);
        us.update(u);
        return 0;
    }

    @GetMapping("/setStateActive")
    public int setState_Active(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_state(User.State.ACTIVE);
        us.update(u);
        return 0;
    }

    @GetMapping("/setStateClose")
    public int setState_Close(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_state(User.State.CLOSE);
        us.update(u);
        return 0;
    }

    @GetMapping("/setStateBan")
    public int setState_Ban(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_state(User.State.BAN);
        us.update(u);
        return 0;
    }

}
