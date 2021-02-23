package com.wyu.controller;

import com.wyu.entity.Factory;
import com.wyu.entity.Institution;
import com.wyu.entity.ReturnValue;
import com.wyu.service.FactoryService;
import com.wyu.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamineController {

    @Autowired
    private FactoryService fs;
    @Autowired
    private InstitutionService is;

    @PostMapping("/FactoryExamine")
    public ReturnValue<List<Factory>> findAll1(){

        List<Factory> f = fs.searchAll();
        List<Institution> i = is.searchAll();
        String msg = "查询出全部";
        int ret = 1;
        if(f==null){
            msg = "没有查询到工厂的数据";
            ret = -1;
        }
        return new ReturnValue<List<Factory>>(ret,msg,f);
    }

    @PostMapping("/InstitutionExamine")
    public ReturnValue<List<Institution>> findAll2(){
        List<Institution> i = is.searchAll();
        String msg = "查询出全部";
        int ret = 1;
        if(i==null){
            msg = "没有查询到机构的数据";
            ret = -1;
        }
        return new ReturnValue<List<Institution>>(ret,msg,i);
    }

    @PostMapping("/f_approval")
    public ReturnValue<Object> f_approval(@RequestBody int id){
        int i = fs.deal(id,true);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请成功",null);
    }

    @PostMapping("/f_reject")
    public ReturnValue<Object> f_reject(@RequestBody int id){
        int i = fs.deal(id,false);
        if(i==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"申请驳回",null);
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
