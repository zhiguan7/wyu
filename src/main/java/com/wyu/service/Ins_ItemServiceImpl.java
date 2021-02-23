package com.wyu.service;

import com.wyu.dao.Ins_ItemDao;
import com.wyu.entity.Ins_Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ins_ItemServiceImpl implements Ins_ItemService{

    @Autowired
    private Ins_ItemDao iid;

    @Override
    public Ins_Item add(Ins_Item ins_item) {
        return iid.save(ins_item);
    }
}
