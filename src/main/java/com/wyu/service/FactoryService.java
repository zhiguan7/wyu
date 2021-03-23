package com.wyu.service;

import com.wyu.entity.Factory;

import java.util.List;

public interface FactoryService {
    void add(Factory factory);
    int update(Factory factory);
    List<Factory> searchAll();
    int deal(long id, boolean flag);
}
