package com.wyu.service;

import com.wyu.dao.InstitutionDao;
import com.wyu.entity.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService{

    @Autowired
    private InstitutionDao institutionDao;


    @Override
    public void add(Institution institution) {
        institution.setI_state(Institution.I_state.APPLY);
        institutionDao.save(institution);
    }

    @Override
    public List<Institution> searchAll() {
        return institutionDao.findAll();
    }
}
