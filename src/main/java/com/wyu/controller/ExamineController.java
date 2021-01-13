package com.wyu.controller;

import com.wyu.entity.Factory;
import com.wyu.entity.Institution;
import com.wyu.entity.ReturnValue;
import com.wyu.service.FactoryService;
import com.wyu.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin
    @PostMapping("/examine")
    public ReturnValue<List<Factory>, List<Institution>> findAll(){

        List<Factory> f = fs.searchAll();
        List<Institution> i = is.searchAll();
        String msg = "查询出全部";
        int ret = 1;
        if(f==null){
            msg = "没有查询到工厂的数据";
            ret = 2;
        }
        if(i==null){
            msg = "没有查询到机构的数据";
            ret = 3;
        }
        if (f==null&&i==null) {
            msg = "没有查询到数据";
            ret = 4;
        }
        return new ReturnValue<List<Factory>, List<Institution>>(ret,msg,f,i);
    }

    @CrossOrigin
    @PostMapping("/f_approval")
    public int f_approval(@RequestBody int id){
        fs.deal(id,true);
        return 0;
    }

    @CrossOrigin
    @PostMapping("/f_reject")
    public int f_reject(@RequestBody int id){
        fs.deal(id,false);
        return 0;
    }

    @CrossOrigin
    @PostMapping("/i_approval")
    public int i_approval(@RequestBody int id){
        is.deal(id,true);
        return 0;
    }

    @CrossOrigin
    @PostMapping("/i_reject")
    public int i_reject(@RequestBody int id){
        is.deal(id,false);
        return 0;
    }
}
