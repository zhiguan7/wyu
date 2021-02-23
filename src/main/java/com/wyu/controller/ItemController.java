package com.wyu.controller;

import com.wyu.entity.Ins_Item;
import com.wyu.entity.Item;
import com.wyu.entity.User;
import com.wyu.service.Ins_ItemService;
import com.wyu.service.ItemService;
import com.wyu.service.UserService;
import com.wyu.util.GetTimeUtil;
import com.wyu.util.GetUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService is;
    @Autowired
    private UserService us;
    @Autowired
    private Ins_ItemService iis;

    @RequestMapping("/add")
    public int createItem(Item item){
        Ins_Item ii = new Ins_Item();
        Item i = is.add(item);
        User user = us.searchById(GetUserUtil.getId());
        ii.setInstitution(user.getInstitution());
        ii.setItem(i);
        ii.setOther(GetTimeUtil.getTime());
        iis.add(ii);
        return 0;
    }

}
