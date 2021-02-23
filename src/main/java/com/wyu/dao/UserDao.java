package com.wyu.dao;

import com.wyu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    @Query("select u from User u where u.user_email = ?1")
    User findByUserEmail(String email);

    @Query("select u from User u where u.user_id = ?1")
    User findByUserId(long user_id);

    @Modifying
    @Transactional
    @Query( "update User u set " +
            "u.institution = case when :#{#user.institution} is null then u.institution else :#{#user.institution} end , " +
            "u.factory = case when :#{#user.factory} is null then u.factory else :#{#user.factory} end , " +
            "u.user_gender = case when :#{#user.user_gender} is null then u.user_gender else :#{#user.user_gender} end , " +
            "u.user_name = case when :#{#user.user_name} is null then u.user_name else :#{#user.user_name} end , " +
            "u.user_password = case when :#{#user.user_password} is null then u.user_password else :#{#user.user_password} end , " +
            "u.user_tel = case when :#{#user.user_tel} is null then u.user_tel else :#{#user.user_tel} end , " +
            "u.user_address = case when :#{#user.user_address} is null then u.user_address else :#{#user.user_address} end , " +
            "u.user_faces = case when :#{#user.user_faces} is null then u.user_faces else :#{#user.user_faces} end , " +
            "u.user_email = case when :#{#user.user_email} is null then u.user_email else :#{#user.user_email} end , " +
            "u.other = :#{#user.other} where u.user_id = :#{#user.user_id}")
    int update(@Param("user") User user);

    @Modifying
    @Transactional
    @Query( "update User u set " +
            "u.user_role = case when :#{#user.user_role} is null then u.user_role else :#{#user.user_role} end , " +
            "u.user_state = case when :#{#user.user_state} is null then u.user_state else :#{#user.user_state} end , " +
            "u.other = :#{#user.other} where u.user_id = :#{#user.user_id}")
    int change(@Param("user") User user);
}
