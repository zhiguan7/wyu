package com.wyu.dao;

import com.wyu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Long> {

    @Query("select u from User u where u.user_name = ?1")
    User findByUserName(String name);

}
