package com.wyu.service;

import com.wyu.entity.Orders;

public interface OrdersService {

   void add(Orders orders);
   void paid(long id);
   void finish(long id);
}
