package com.wyu.dao;

import com.wyu.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DemandDao extends JpaRepository<Demand,Long> {
    @Modifying
    @Transactional
    @Query("update Demand d set d.demand_state = :#{#state}, d.other = :#{#other} where d.demand_id = :#{#id}")
    int setState(@Param("id")long id, @Param("state") Demand.demandState state, long other);

    /*
        需求不可以修改，需要时，请撤回需求，再重新提交
     */

}
