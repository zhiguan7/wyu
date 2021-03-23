package com.wyu.util;

import com.wyu.dao.Ins_ItemDao;
import com.wyu.dao.OrdersDao;
import com.wyu.dao.UserDao;
import com.wyu.entity.Item;
import com.wyu.entity.Orders;
import com.wyu.entity.Orders_Item;
import com.wyu.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class GetInfoUtils {

    @Autowired
    private static Ins_ItemDao ins_itemDao;
    @Autowired
    private static OrdersDao ordersDao;

    public static long getUserId(){
        try {
            Subject subject = SecurityUtils.getSubject();
            User u = (User) subject.getPrincipal();
            return u.getUser_id();
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean getUser(){
        try {
            Subject subject = SecurityUtils.getSubject();
            User u = (User) subject.getPrincipal();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static User getUser1(){
        try {
            Subject subject = SecurityUtils.getSubject();
            User u = (User) subject.getPrincipal();
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    public static long getFactoryId(){
        try {
            return getUser1().getFactory().getFactory_id();
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getInsId(){
        try {
            return getUser1().getInstitution().getInstitution_id();
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean checkingItem(Item item){
        return ins_itemDao.findByIns(item,getUser1().getInstitution());
    }

    public static boolean checkingOrders(Orders orders){
        return ordersDao.findInsById(orders.getOrders_id()).getInstitution().getInstitution_id() == getInsId();
    }
}
