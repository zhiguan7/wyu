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

    @PostMapping("/i_approval")
    public ReturnValue<Object> i_approval(@RequestBody int id){
        int i = is.deal(id,true);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请成功",null);
    }

    @PostMapping("/i_reject")
    public ReturnValue<Object> i_reject(@RequestBody int id){
        int i = is.deal(id,false);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请驳回",null);
    }
}
