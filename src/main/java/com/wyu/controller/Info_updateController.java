package com.wyu.controller;

import com.wyu.entity.ReturnValue;
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

    @PostMapping("/user")
    public ReturnValue<Object> userUpdate(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        User u = (User) subject.getPrincipal();
        user.setUser_id(u.getUser_id());
        user.setOther(GetTimeUtil.getTime());
        if(user.getUser_email()!=null&&user.getUser_password()!=null){
            if(us.searchByEmail(user.getUser_email()) != null) return new ReturnValue<Object>(-1,"邮箱已被注册",null);
            user.setCode(CodeUtil.randomCode());
            ru.set(user.getUser_email(), user.getCode(), 5 * 60);
            msu.send(user.getUser_email(), user.getCode());
        }else{
            if(user.getUser_email()!=null){
                if(us.searchByEmail(user.getUser_email()) != null) return new ReturnValue<Object>(-1,"邮箱已被注册",null);
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
                    int i = us.update(u);
                    if(i==0){
                        return new ReturnValue<Object>(-1,"修改失败",null);
                    }
                    return new ReturnValue<Object>(1,"修改成功",null);
                }
            }
        }
        return new ReturnValue<Object>(2,"等待验证码",null);
    }

    @GetMapping("/verify")
    public ReturnValue<Object> verify(@RequestBody User user){
        if(!ru.get(user.getUser_email()).toString().equals(user.getCode()))
            return new ReturnValue<Object>(-1,"验证码不符",null);
        if (user.getUser_password()!=null){
            user.setUser_password(Encryption.encipher(user.getUser_email(),user.getUser_password()));
        }
        try {
            us.update(user);
        } catch (Exception e) {
            return new ReturnValue<Object>(-2,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setRoleUser")
    public ReturnValue<Object> setRole_User(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.USER);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setRoleService")
    public ReturnValue<Object> setRole_Service(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.CUSTOMER_SERVICE);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setRoleFactory")
    public ReturnValue<Object> setRole_Factory(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.FACTORY);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setRoleIns")
    public ReturnValue<Object> setRole_Ins(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.INSTITUTION);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setRoleDouble")
    public ReturnValue<Object> setRole_Double(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_role(User.Role.DOUBLE);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setStateActive")
    public ReturnValue<Object> setState_Active(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_state(User.State.ACTIVE);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setStateClose")
    public ReturnValue<Object> setState_Close(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_state(User.State.CLOSE);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @GetMapping("/setStateBan")
    public ReturnValue<Object> setState_Ban(@RequestBody User user){
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setUser_state(User.State.BAN);
        int i = us.change(u);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

}
