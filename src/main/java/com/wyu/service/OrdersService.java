package com.wyu.service;

import com.wyu.entity.Orders;

import java.util.List;

public interface OrdersService {

   void add(Orders orders);
   void paid(long id);
   void finish(long id);
   List<Orders> searchAll();
   Orders searchById(long orders_id);
}
