package com.wyu.controller;

import com.wyu.entity.*;
import com.wyu.service.OrdersService;
import com.wyu.service.Orders_ItemService;
import com.wyu.service.UserService;
import com.wyu.util.GetTimeUtil;
import com.wyu.util.GetUserUtil;
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
    public int addOrder(@RequestBody Orders orders, @RequestBody User user, @RequestBody List<Item> items){
        Orders_Item oi = new Orders_Item();
        orders.setInstitution(us.searchById(GetUserUtil.getId()).getInstitution());
        orders.setUser(us.searchById(user.getUser_id()));
        Orders o = os.add(orders);
        oi.setOrders(o);
        oi.setOther(GetTimeUtil.getTime());
        Iterator<Item> it = (Iterator<Item>) items.iterator();
        while (it.hasNext()){
            Item i = it.next();
            oi.setItem(i);
            ois.add(oi);
        }
        return 0;
    }

    @PostMapping("/paid")
    public int paid(@RequestBody Orders orders){
        os.paid(orders.getOrders_id());
        return 0;
    }

    @PostMapping("/finish")
    public int finish(@RequestBody Orders orders){
        os.finish(orders.getOrders_id());
        return 0;
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
