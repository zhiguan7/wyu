package com.wyu.dao;

import com.wyu.entity.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryDao extends JpaRepository<Factory,Long> { }
