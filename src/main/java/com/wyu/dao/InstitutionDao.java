package com.wyu.dao;

import com.wyu.pojo.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionDao extends JpaRepository<Institution,Long> { }
