package com.wyu.controller;

import com.wyu.entity.*;
import com.wyu.service.OrdersService;
import com.wyu.service.Orders_ItemService;
import com.wyu.service.UserService;
import com.wyu.util.GetTimeUtils;
import com.wyu.util.GetInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService os;
    @Autowired
    private UserService us;
    @Autowired
    private Orders_ItemService ois;

    @PostMapping("/add")
    public ReturnValue<Object> addOrder(@RequestBody Orders orders, @RequestBody User user, @RequestBody List<Item> items){
        try {
            Orders_Item oi = new Orders_Item();
            orders.setInstitution(us.searchById(GetInfoUtils.getUserId()).getInstitution());
            orders.setUser(us.searchById(user.getUser_id()));
            Orders o = os.add(orders);
            oi.setOrders(o);
            oi.setOther(GetTimeUtils.getTime());
            Iterator<Item> it = (Iterator<Item>) items.iterator();
            while (it.hasNext()){
                Item i = it.next();
                oi.setItem(i);
                ois.add(oi);
            }
        } catch (Exception e) {
            return new ReturnValue<Object>(-1,"订单创建失败",null);
        }
        return new ReturnValue<Object>(1,"订单创建成功",null);
    }

    @RequestMapping("/update")
    public ReturnValue<Object>update(@RequestBody Orders orders){
        if(GetInfoUtils.checkingOrders(orders)) return new ReturnValue<Object>(-1,"修改失败",null);
        if(os.update(orders)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/close")
    public ReturnValue<Object> close(@RequestBody Orders orders){
        if(os.close(orders.getOrders_id())==0){
            return new ReturnValue<Object>(-1,"关闭失败",null);
        }
        return new ReturnValue<Object>(1,"取消订单成功",null);
    }

    @PostMapping("/paid")
    public ReturnValue<Object> paid(@RequestBody Orders orders){
        if(os.paid(orders.getOrders_id())==0){
            return new ReturnValue<Object>(-1,"付款失败",null);
        }
        return new ReturnValue<Object>(1,"付款成功",null);
    }

    @PostMapping("/finish")
    public ReturnValue<Object> finish(@RequestBody Orders orders){
        if(os.finish(orders.getOrders_id())==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"订单完成",null);
    }

}
