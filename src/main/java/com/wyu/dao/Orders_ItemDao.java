package com.wyu.dao;

import com.wyu.entity.Orders_Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orders_ItemDao extends JpaRepository<Orders_Item,Long> {
}
