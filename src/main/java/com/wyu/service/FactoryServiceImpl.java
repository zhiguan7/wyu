package com.wyu.service;

import com.wyu.dao.FactoryDao;
import com.wyu.entity.Factory;
import com.wyu.util.GetInfoUtils;
import com.wyu.util.GetTimeUtils;
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
        factory.setOther(GetTimeUtils.getTime());
        factory.setCreate_time(GetTimeUtils.getTime());
        factoryDao.save(factory);
    }

    @Override
    public int update(Factory factory) {
        factory.setFactory_id(GetInfoUtils.getFactoryId());
        factory.setOther(GetTimeUtils.getTime());
        return factoryDao.update(factory);
    }

    @Override
    public List<Factory> searchAll() {
        return factoryDao.findAll();
    }

    @Override
    public int deal(long id, boolean flag) {
        int re = 0;
        if (flag){
            re = factoryDao.setState(id,Factory.F_state.SUCCESS, GetTimeUtils.getTime());
        }else{
            re = factoryDao.setState(id,Factory.F_state.FAIL, GetTimeUtils.getTime());
        }
        return re;
    }

}
