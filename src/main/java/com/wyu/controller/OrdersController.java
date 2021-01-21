package com.wyu.controller;

import com.wyu.entity.Orders;
import com.wyu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService os;

    @CrossOrigin
    @PostMapping("/add")
    public int addOrder(@RequestBody Orders orders){
        os.add(orders);
        return 0;
    }

    @CrossOrigin
    @PostMapping("/paid")
    public int paid(@RequestBody Orders orders){
        os.paid(orders.getOrders_id());
        return 0;
    }

    @CrossOrigin
    @PostMapping("/finish")
    public int finish(@RequestBody Orders orders){
        os.finish(orders.getOrders_id());
        return 0;
    }
}
