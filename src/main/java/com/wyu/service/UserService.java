package com.wyu.service;

import com.wyu.entity.User;

import java.util.List;

public interface UserService {

    User searchByEmail(String Email);
    User searchById(long id);
    void add(User user);
    int update(User user);
    int change(User user);

}
