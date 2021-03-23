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
        if(is.update(institution)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/update_qualifications")
    public ReturnValue<Object> update_qualifications(@RequestBody Institution institution){
        if(is.update_qualifications(institution)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/i_approval")
    public ReturnValue<Object> i_approval(@RequestBody Institution institution){
        if(is.deal(institution.getInstitution_id(),true)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请成功",null);
    }

    @PostMapping("/i_reject")
    public ReturnValue<Object> i_reject(@RequestBody Institution institution){
        if(is.deal(institution.getInstitution_id(),false)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请驳回",null);
    }
}
