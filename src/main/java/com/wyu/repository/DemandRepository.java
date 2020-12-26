package com.wyu.repository;

import com.wyu.pojo.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand,Long> { }
