package com.wyu.controller;

import com.wyu.entity.Factory;
import com.wyu.entity.ReturnValue;
import com.wyu.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factory")
public class FactoryController {

    @Autowired
    private FactoryService fs;

    @PostMapping("/f_approval")
    public ReturnValue<Object> f_approval(@RequestBody Factory factory){
        if(fs.deal(factory.getFactory_id(),true)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请成功",null);
    }

    @PostMapping("/f_reject")
    public ReturnValue<Object> f_reject(@RequestBody Factory factory){
        if(fs.deal(factory.getFactory_id(),false)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请驳回",null);
    }

    @PostMapping("/update")
    public ReturnValue<Object> update(@RequestBody Factory factory){
        if(fs.update(factory)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }
}
