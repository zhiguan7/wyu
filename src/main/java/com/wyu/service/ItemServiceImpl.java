package com.wyu.service;

import com.wyu.dao.ItemDao;
import com.wyu.entity.Item;
import com.wyu.util.GetInfoUtil;
import com.wyu.util.GetTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public Item add(Item item) {
        item.setItem_state(Item.Item_state.ON);
        item.setOther(GetTimeUtil.getTime());
        return itemDao.save(item);
    }

    @Override
    public int update(Item item) {
        item.setOther(GetTimeUtil.getTime());
        return itemDao.update(item);
    }

    @Override
    public int delete(Item item) {
        return itemDao.changeState(item.getItem_id(),Item.Item_state.OFF,GetTimeUtil.getTime());
    }

    @Override
    public int upItem(Item item) {
        return itemDao.changeState(item.getItem_id(),Item.Item_state.ON,GetTimeUtil.getTime());
    }

}
