package com.wyu.dao;

import com.wyu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Long> {

    @Query("select u from User u where u.user_email = ?1")
    User findByUserEmail(String email);

}
