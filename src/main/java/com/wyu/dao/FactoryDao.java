package com.wyu.dao;

import com.wyu.entity.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FactoryDao extends JpaRepository<Factory,Long> {

    @Modifying
    @Transactional
    @Query("update Factory f set f.f_state = :#{#state} where f.id = :#{#id}")
    int setState(@Param("id")int id, @Param("state") Factory.F_state state);
}
