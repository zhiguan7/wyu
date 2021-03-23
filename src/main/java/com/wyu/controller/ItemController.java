package com.wyu.controller;

import com.wyu.entity.Ins_Item;
import com.wyu.entity.Item;
import com.wyu.entity.ReturnValue;
import com.wyu.entity.User;
import com.wyu.service.Ins_ItemService;
import com.wyu.service.ItemService;
import com.wyu.service.UserService;
import com.wyu.util.GetTimeUtils;
import com.wyu.util.GetInfoUtils;
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
    public ReturnValue<Object> createItem(Item item){

        try {
            Ins_Item ii = new Ins_Item();
            Item i = is.add(item);
            User user = us.searchById(GetInfoUtils.getUserId());
            ii.setInstitution(user.getInstitution());
            ii.setItem(i);
            ii.setOther(GetTimeUtils.getTime());
            iis.add(ii);
        } catch (Exception e) {
            return new ReturnValue<Object>(-1,"项目添加失败",null);
        }
        return new ReturnValue<Object>(1,"项目添加成功",null);
    }

    @RequestMapping("/delete")
    public ReturnValue<Object> delete(Item item){
        if(is.delete(item)==0){
            return new ReturnValue<Object>(-1,"删除失败",null);
        }
        return new ReturnValue<Object>(1,"下架成功",null);
    }

    @RequestMapping("/reUp")
    public ReturnValue<Object> reUp(Item item){
        if(is.upItem(item)==0){
            return new ReturnValue<Object>(-1,"上架失败",null);
        }
        return new ReturnValue<Object>(1,"上架成功",null);
    }

    @RequestMapping("/update")
    public ReturnValue<Object> update(Item item){
        if(GetInfoUtils.checkingItem(item)) return new ReturnValue<Object>(-1,"修改失败",null);
        if(is.update(item)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

}
