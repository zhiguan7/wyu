package com.wyu.service;

import com.wyu.entity.Demand;

public interface DemandService {
    void add(Demand demand);
    int setState(long id,int state);
}
