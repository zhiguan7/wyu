package com.wyu.service;

import com.wyu.dao.DemandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandServiceImpl implements DemandService{

    @Autowired
    private DemandDao demandDao;
}
