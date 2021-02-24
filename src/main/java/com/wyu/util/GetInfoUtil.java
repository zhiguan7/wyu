package com.wyu.util;

import com.wyu.dao.Ins_ItemDao;
import com.wyu.dao.OrdersDao;
import com.wyu.dao.UserDao;
import com.wyu.entity.Item;
import com.wyu.entity.Orders;
import com.wyu.entity.Orders_Item;
import com.wyu.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class GetInfoUtil {

    @Autowired
    private static UserDao userDao;
    @Autowired
    private static Ins_ItemDao ins_itemDao;
    @Autowired
    private static OrdersDao ordersDao;

    public static long getUserId(){
        Subject subject = SecurityUtils.getSubject();
        User u = (User) subject.getPrincipal();
        return u.getUser_id();
    }

    public static long getFactoryId(){
        return userDao.findByUserId(getUserId()).getFactory().getFactory_id();
    }

    public static long getInsId(){
        return userDao.findByUserId(getUserId()).getInstitution().getInstitution_id();
    }

    public static boolean checkingItem(Item item){
        return ins_itemDao.findByIns(item,userDao.findByUserId(getUserId()).getInstitution());
    }

    public static boolean checkingOrders(Orders orders){
        return ordersDao.findInsById(orders.getOrders_id()).getInstitution().getInstitution_id() == getInsId();
    }
}
