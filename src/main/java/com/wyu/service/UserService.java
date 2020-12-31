package com.wyu.service;

import com.wyu.entity.User;

import java.util.List;

public interface UserService {

    List<User> searchUserAll();
    User searchByEmail(String Email);
    void add(User user);
    void update(User user);
}
