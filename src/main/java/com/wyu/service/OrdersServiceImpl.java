package com.wyu.service;

import com.wyu.dao.OrdersDao;
import com.wyu.entity.Orders;
import com.wyu.util.GetTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public Orders add(Orders orders) {
        orders.setPayment(Orders.Payment.UNPAID);
        orders.setOther(GetTimeUtils.getTime());
        return ordersDao.save(orders);
    }

    @Override
    public int close(long id) {
        return ordersDao.setState(id,Orders.Payment.CLOSE, GetTimeUtils.getTime());
    }

    @Override
    public int paid(long id) {
        return ordersDao.setState(id,Orders.Payment.PAID, GetTimeUtils.getTime());
    }

    @Override
    public int finish(long id) {
        return ordersDao.setState(id,Orders.Payment.FINISH, GetTimeUtils.getTime());
    }

    @Override
    public int update(Orders orders) {
        orders.setOther(GetTimeUtils.getTime());
        return ordersDao.update(orders);
    }

    @Override
    public List<Orders> searchAll() {
        return ordersDao.findAll();
    }

    @Override
    public Orders searchById(long orders_id) {
        ordersDao.getOne(orders_id);
        return null;
    }
}
