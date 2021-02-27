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
        int i = os.update(orders);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/close")
    public ReturnValue<Object> close(@RequestBody Orders orders){
        int i = os.close(orders.getOrders_id());
        if(i==0){
            return new ReturnValue<Object>(-1,"关闭失败",null);
        }
        return new ReturnValue<Object>(1,"取消订单成功",null);
    }

    @PostMapping("/paid")
    public ReturnValue<Object> paid(@RequestBody Orders orders){
        int i = os.paid(orders.getOrders_id());
        if(i==0){
            return new ReturnValue<Object>(-1,"付款失败",null);
        }
        return new ReturnValue<Object>(1,"付款成功",null);
    }

    @PostMapping("/finish")
    public ReturnValue<Object> finish(@RequestBody Orders orders){
        int i = os.finish(orders.getOrders_id());
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"订单完成",null);
    }

    @PostMapping("/findAll")
    private ReturnValue<List<Orders>> findAll(){
        List<Orders> o = os.searchAll();
        String msg = "查询出全部";
        int ret = 1;
        if(o==null){
            msg = "没有查询到订单的数据";
            ret = 2;
        }
        return new  ReturnValue<List<Orders>>(ret,msg,o);
    }

    @PostMapping("/findById")
    private ReturnValue<Orders> findById(@RequestBody Orders orders){
        Orders o = os.searchById(orders.getOrders_id());
        String msg = "查询出结果";
        int ret = 1;
        if(o==null){
            msg = "没有查询到订单的数据";
            ret = 2;
        }
        return new  ReturnValue<Orders>(ret,msg,o);
    }

}
