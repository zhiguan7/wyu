package com.wyu.service;

import com.wyu.dao.FactoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryServiceImpl implements FactoryService{

    @Autowired
    private FactoryDao factoryDao;
}
