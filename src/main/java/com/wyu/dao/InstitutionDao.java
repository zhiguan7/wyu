package com.wyu.dao;

import com.wyu.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionDao extends JpaRepository<Institution,Long> { }
