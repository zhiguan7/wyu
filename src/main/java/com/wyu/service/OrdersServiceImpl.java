package com.wyu.service;

import com.wyu.dao.OrdersDao;
import com.wyu.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public void add(Orders orders) {
        orders.setPayment(Orders.Payment.UNPAID);
        ordersDao.save(orders);
    }

    @Override
    public void paid(long id) {
        ordersDao.setState(id,Orders.Payment.PAID);
    }

    @Override
    public void finish(long id) {
        ordersDao.setState(id,Orders.Payment.FINISH);
    }
}
