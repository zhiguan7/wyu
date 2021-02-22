package com.wyu.dao;

import com.wyu.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InstitutionDao extends JpaRepository<Institution,Long> {

    @Modifying
    @Transactional
    @Query("update Institution i set i.i_state = :#{#state},i.other = :#{#other} where i.id = :#{#id}")
    int setState(@Param("id")int id, @Param("state") Institution.I_state state, long other);
}
