package com.wyu.service;

import com.wyu.dao.InstitutionDao;
import com.wyu.entity.Institution;
import com.wyu.util.GetInfoUtils;
import com.wyu.util.GetTimeUtils;
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
        institution.setOther(GetTimeUtils.getTime());
        institutionDao.save(institution);
    }

    @Override
    public int update(Institution institution) {
        institution.setInstitution_id(GetInfoUtils.getInsId());
        institution.setOther(GetTimeUtils.getTime());
        return institutionDao.update(institution);
    }

    @Override
    public int update_qualifications(Institution institution) {
        return institutionDao.setQualifications(institution.getInstitution_id(),institution.getQualifications(), GetTimeUtils.getTime());
    }

    @Override
    public List<Institution> searchAll() {
        return institutionDao.findAll();
    }

    @Override
    public int deal(int id, boolean flag) {
        int re = 0;
        if (flag){
            re = institutionDao.setState(id, Institution.I_state.SUCCESS, GetTimeUtils.getTime());
        }else{
            re = institutionDao.setState(id, Institution.I_state.FAIL, GetTimeUtils.getTime());
        }
        return re;
    }
}
