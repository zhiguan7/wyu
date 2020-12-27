package com.wyu.service;

import com.wyu.dao.InstitutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionServiceImpl implements InstitutionService{

    @Autowired
    private InstitutionDao institutionDao;


}
