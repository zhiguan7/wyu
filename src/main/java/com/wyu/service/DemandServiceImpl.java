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
        demandDao.save(demand);
    }
}
