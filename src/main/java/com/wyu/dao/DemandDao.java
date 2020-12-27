package com.wyu.dao;

import com.wyu.pojo.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandDao extends JpaRepository<Demand,Long> { }
