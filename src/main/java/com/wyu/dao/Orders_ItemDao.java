package com.wyu.dao;

import com.wyu.entity.Orders;
import com.wyu.entity.Orders_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface Orders_ItemDao extends JpaRepository<Orders_Item,Long> {

    @Query("select oi.item from Orders_Item oi where oi.orders = ?1")
    long[] findItem(Orders o);
}
