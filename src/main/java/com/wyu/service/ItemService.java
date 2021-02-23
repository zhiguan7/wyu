package com.wyu.service;

import com.wyu.entity.Item;

public interface ItemService {
    Item add(Item item);
    int update(Item item);
    int delete(Item item);
    int upItem(Item item);
}
