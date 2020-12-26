package com.wyu.repository;

import com.wyu.pojo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> { }
