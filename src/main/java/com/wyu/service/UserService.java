package com.wyu.service;

import com.wyu.pojo.User;

import java.util.List;

public interface UserService {

    List<User> searchUserAll();
    User searchByName(String name);
    void add(User user);
}
