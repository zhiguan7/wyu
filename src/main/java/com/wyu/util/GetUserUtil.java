package com.wyu.util;

import com.wyu.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class GetUserUtil {

    public static long getId(){
        Subject subject = SecurityUtils.getSubject();
        User u = (User) subject.getPrincipal();
        return u.getUser_id();
    }
}
