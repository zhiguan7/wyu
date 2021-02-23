package com.wyu.service;

import com.wyu.entity.Orders;

import java.util.List;

public interface OrdersService {

   Orders add(Orders orders);
   int paid(long id);
   int finish(long id);
   List<Orders> searchAll();
   Orders searchById(long orders_id);
}
