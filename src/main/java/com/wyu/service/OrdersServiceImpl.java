package com.wyu.service;

import com.wyu.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl {

    @Autowired
    private OrdersDao ordersDao;


}
