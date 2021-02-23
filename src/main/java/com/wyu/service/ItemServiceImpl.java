package com.wyu.service;

import com.wyu.dao.ItemDao;
import com.wyu.entity.Item;
import com.wyu.util.GetTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public Item add(Item item) {
        item.setOther(GetTimeUtil.getTime());
        return itemDao.save(item);
    }
}
