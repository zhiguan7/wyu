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
    @Query("update Institution i set i.i_state = :#{#state},i.other = :#{#other} where i.institution_id = :#{#id}")
    int setState(@Param("id")long id, @Param("state") Institution.I_state state, long other);

    @Modifying
    @Transactional
    @Query("update Institution i set i.qualifications = :#{#state},i.other = :#{#other} where i.institution_id = :#{#id}")
    int setQualifications(@Param("id")long id, @Param("qualifications") String qualifications, long other);

    @Modifying
    @Transactional
    @Query( "update Institution i set " +
            "i.institution_name = case when :#{#institution.institution_name} is null then i.institution_name else :#{#institution.institution_name} end , " +
            "i.institution_address = case when :#{#institution.institution_address} is null then i.institution_address else :#{#institution.institution_address} end , " +
            "i.contacts_id = case when :#{#institution.contacts_id} is null then i.contacts_id else :#{#institution.contacts_id} end , " +
            "i.institution_info = case when :#{#institution.institution_info} is null then i.institution_info else :#{#institution.institution_info} end , " +
            "i.institution_contacts = case when :#{#institution.institution_contacts} is null then i.institution_contacts else :#{#institution.institution_contacts} end , " +
            "i.contacts_tel = case when :#{#institution.contacts_tel} is null then i.contacts_tel else :#{#institution.contacts_tel} end , " +
            "i.institution_email = case when :#{#institution.institution_email} is null then i.institution_email else :#{#institution.institution_email} end , " +
            "i.other = :#{#institution.other} where i.institution_id = :#{#institution.institution_id}")
    int update(@Param("institution") Institution institution);


}
