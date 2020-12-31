package com.wyu.dao;

import com.wyu.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandDao extends JpaRepository<Demand,Long> { }
