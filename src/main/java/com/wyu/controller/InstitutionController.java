package com.wyu.controller;

import com.wyu.entity.Institution;
import com.wyu.entity.ReturnValue;
import com.wyu.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    private InstitutionService is;

    @PostMapping("/update")
    public ReturnValue<Object> update(@RequestBody Institution institution){
        int i = is.update(institution);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/update_qualifications")
    public ReturnValue<Object> update_qualifications(@RequestBody Institution institution){
        int i = is.update_qualifications(institution);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }
}
