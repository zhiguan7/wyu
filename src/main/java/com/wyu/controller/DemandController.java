package com.wyu.controller;

import com.wyu.entity.Demand;
import com.wyu.entity.ReturnValue;
import com.wyu.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demand")
public class DemandController {

    @Autowired
    private DemandService ds;

    @PostMapping("/setWithdraw")
    public ReturnValue<Object> setWithdraw(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),0)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/setSubmit")
    public ReturnValue<Object> setSubmit(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),1)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/setSubmited")
    public ReturnValue<Object> setSubmited(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),2)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/setAudit")
    public ReturnValue<Object> setAudit(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),3)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/setAudited")
    public ReturnValue<Object> setAudited(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),4)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/setTest")
    public ReturnValue<Object> setTest(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),5)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/setTested")
    public ReturnValue<Object> setTested(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),6)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

    @PostMapping("/setFinish")
    public ReturnValue<Object> setFinish(@RequestBody Demand demand){
        if(ds.setState(demand.getDemand_id(),7)==0){
            return new ReturnValue<Object>(-1,"修改失败",null);
        }
        return new ReturnValue<Object>(1,"修改成功",null);
    }

}
