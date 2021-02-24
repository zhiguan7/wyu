package com.wyu.service;

import com.wyu.dao.InstitutionDao;
import com.wyu.entity.Institution;
import com.wyu.util.GetInfoUtil;
import com.wyu.util.GetTimeUtil;
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
        institution.setOther(GetTimeUtil.getTime());
        institutionDao.save(institution);
    }

    @Override
    public int update(Institution institution) {
        institution.setInstitution_id(GetInfoUtil.getInsId());
        institution.setOther(GetTimeUtil.getTime());
        return institutionDao.update(institution);
    }

    @Override
    public int update_qualifications(Institution institution) {
        return institutionDao.setQualifications(institution.getInstitution_id(),institution.getQualifications(),GetTimeUtil.getTime());
    }

    @Override
    public List<Institution> searchAll() {
        return institutionDao.findAll();
    }

    @Override
    public int deal(int id, boolean flag) {
        int re = 0;
        if (flag){
            re = institutionDao.setState(id, Institution.I_state.SUCCESS, GetTimeUtil.getTime());
        }else{
            re = institutionDao.setState(id, Institution.I_state.FAIL,GetTimeUtil.getTime());
        }
        return re;
    }
}
