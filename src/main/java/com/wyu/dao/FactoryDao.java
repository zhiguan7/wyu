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
    @Query("update Factory f set f.f_state = :#{#state}, f.other = :#{#other} where f.factory_id = :#{#id}")
    int setState(@Param("id")long id, @Param("state") Factory.F_state state, @Param("other")long other);


    @Modifying
    @Transactional
    @Query( "update Factory f set " +
            "f.factory_contacts = case when :#{#factory.factory_contacts} is null then f.factory_contacts else :#{#factory.factory_contacts} end , " +
            "f.contacts_tel = case when :#{#factory.contacts_tel} is null then f.contacts_tel else :#{#factory.contacts_tel} end , " +
            "f.factory_email = case when :#{#factory.factory_email} is null then f.factory_email else :#{#factory.factory_email} end , " +
            "f.contacts_id = case when :#{#factory.contacts_id} is null then f.contacts_id else :#{#factory.contacts_id} end , " +
            "f.factory_address = case when :#{#factory.factory_address} is null then f.factory_address else :#{#factory.factory_address} end , " +
            "f.factory_name = case when :#{#factory.factory_name} is null then f.factory_name else :#{#factory.factory_name} end , " +
            "f.factory_info = case when :#{#factory.factory_info} is null then f.factory_info else :#{#factory.factory_info} end , " +
            "f.other = :#{#factory.other} where f.factory_id = :#{#factory.factory_id}")
    int update(@Param("factory") Factory factory);
}
