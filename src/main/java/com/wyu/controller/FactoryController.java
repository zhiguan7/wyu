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

    @PostMapping("/update")
    public ReturnValue<Object> update(@RequestBody Factory factory){
        int i = fs.update(factory);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }
}
