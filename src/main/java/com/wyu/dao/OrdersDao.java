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
    @Query("update Orders o set o.payment = :#{#payment},o.other = :#{#other} where o.orders_id = :#{#id}")
    int setState(@Param("id")long id, @Param("payment") Orders.Payment payment, @Param("other")long other);

    @Modifying
    @Transactional
    @Query( "update Orders o set " +
            "o.sundries = case when :#{#orders.sundries} is null then o.sundries else :#{#orders.sundries} end , " +
            "o.orders_remarks = case when :#{#orders.orders_remarks} is null then o.orders_remarks else :#{#orders.orders_remarks} end , " +
            "o.type = case when :#{#orders.type} is null then o.type else :#{#orders.type} end , " +
            "o.sundries = case when :#{#orders.sundries} is null then o.sundries else :#{#orders.sundries} end , " +
            "o.other = :#{#orders.other} where o.orders_id = :#{#orders.orders_id}")
    int update(@Param("orders") Orders orders);
}
