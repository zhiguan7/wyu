package com.wyu.service;

import com.wyu.dao.FactoryDao;
import com.wyu.entity.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService{

    @Autowired
    private FactoryDao factoryDao;

    @Override
    public void add(Factory factory) {
        factory.setF_state(Factory.F_state.APPLY);
        factoryDao.save(factory);
    }

    @Override
    public List<Factory> searchAll() {
        return factoryDao.findAll();
    }

    @Override
    public int deal(int id, boolean flag) {
        int re = 0;
        if (flag){
            re = factoryDao.setState(id,Factory.F_state.SUCCESS);
        }else{
            re = factoryDao.setState(id,Factory.F_state.FAIL);
        }
        return re;
    }

}
