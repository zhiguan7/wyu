package com.wyu.service;

import com.wyu.dao.DemandDao;
import com.wyu.entity.Demand;
import com.wyu.util.GetTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandServiceImpl implements DemandService{

    @Autowired
    private DemandDao demandDao;

    @Override
    public void add(Demand demand) {
        demand.setDemand_state(Demand.demandState.SUBMITED);
        demand.setOther(GetTimeUtils.getTime());
        demand.setCreate_time(GetTimeUtils.getTime());
        demandDao.save(demand);
    }

    @Override
    public int setState(long id, int state) {
        Demand.demandState s = null;
        switch (state) {
            case 0:
                s = Demand.demandState.WITHDRAW;
                break;
            case 1:
                s = Demand.demandState.SUBMIT;
                break;
            case 2:
                s = Demand.demandState.SUBMITED;
                break;
            case 3:
                s = Demand.demandState.AUDIT;
                break;
            case 4:
                s = Demand.demandState.AUDITED;
                break;
            case 5:
                s = Demand.demandState.TEST;
                break;
            case 6:
                s = Demand.demandState.TESTED;
                break;
            case 7:
                s = Demand.demandState.FINISH;
                break;
        }
        return demandDao.setState(id,s, GetTimeUtils.getTime());
    }
}
