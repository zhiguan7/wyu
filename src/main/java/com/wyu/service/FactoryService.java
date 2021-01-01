package com.wyu.service;

import com.wyu.entity.Factory;

import java.util.List;

public interface FactoryService {
    void add(Factory factory);
    List<Factory> searchAll();
}
