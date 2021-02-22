package com.wyu.controller;

import com.wyu.entity.Institution;
import com.wyu.entity.Orders;
import com.wyu.entity.ReturnValue;
import com.wyu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService os;

    @PostMapping("/add")
    public int addOrder(@RequestBody Orders orders){
        os.add(orders);
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
