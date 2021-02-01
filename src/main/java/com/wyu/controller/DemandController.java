package com.wyu.controller;

import com.wyu.entity.Demand;
import com.wyu.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demand")
public class DemandController {

    @Autowired
    private DemandService ds;

    @CrossOrigin
    @PostMapping("/setSubmited")
    public int setSubmited(Demand demand){
        return ds.setState(demand.getDemand_id(),1);
    }

    @CrossOrigin
    @PostMapping("/setAudit")
    public int setAudit(Demand demand){
        return ds.setState(demand.getDemand_id(),2);
    }

    @CrossOrigin
    @PostMapping("/setAudited")
    public int setAudited(Demand demand){
        return ds.setState(demand.getDemand_id(),3);
    }

    @CrossOrigin
    @PostMapping("/setTest")
    public int setTest(Demand demand){
        return ds.setState(demand.getDemand_id(),4);
    }

    @CrossOrigin
    @PostMapping("/setTested")
    public int setTested(Demand demand){
        return ds.setState(demand.getDemand_id(),5);
    }

    @CrossOrigin
    @PostMapping("/setFinish")
    public int setFinish(Demand demand){
        return ds.setState(demand.getDemand_id(),6);
    }

}
