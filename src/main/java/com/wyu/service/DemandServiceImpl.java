package com.wyu.service;

import com.wyu.dao.DemandDao;
import com.wyu.entity.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandServiceImpl implements DemandService{

    @Autowired
    private DemandDao demandDao;

    @Override
    public void add(Demand demand) {
        demand.setDemand_state(Demand.demandState.SUBMITED);
        demandDao.save(demand);
    }

    @Override
    public int setState(long id, int state) {
        Demand.demandState s = null;
        switch (state) {
            case 1:
                s = Demand.demandState.SUBMITED;
                break;
            case 2:
                s = Demand.demandState.AUDIT;
                break;
            case 3:
                s = Demand.demandState.AUDITED;
                break;
            case 4:
                s = Demand.demandState.TEST;
                break;
            case 5:
                s = Demand.demandState.TESTED;
                break;
            case 6:
                s = Demand.demandState.FINISH;
                break;
        }
        return demandDao.setState(id,s);
    }
}
