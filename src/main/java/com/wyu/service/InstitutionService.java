package com.wyu.service;

import com.wyu.entity.Institution;

import java.util.List;

public interface InstitutionService {
    void add(Institution institution);
    int update(Institution institution);
    int update_qualifications(Institution institution);
    int deal(long id, boolean flag);
}
