package com.wyu.dao;

import com.wyu.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrdersDao extends JpaRepository<Orders,Long> {

    @Modifying
    @Transactional
    @Query("update Orders o set o.payment = :#{#payment} where o.orders_id = :#{#id}")
    int setState(@Param("id")long id, @Param("payment") Orders.Payment payment);
}
