package com.wyu.service;

import com.wyu.dao.Orders_ItemDao;
import com.wyu.entity.Orders_Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Orders_ItemServiceImpl implements Orders_ItemService{

    @Autowired
    private Orders_ItemDao oid;

    @Override
    public Orders_Item add(Orders_Item orders_item) {
        return oid.save(orders_item);
    }
}
