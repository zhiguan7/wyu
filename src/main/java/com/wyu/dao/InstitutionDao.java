package com.wyu.dao;

import com.wyu.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionDao extends JpaRepository<Institution,Long> { }
