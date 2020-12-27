package com.wyu.dao;

import com.wyu.pojo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDao extends JpaRepository<Orders,Long> { }
