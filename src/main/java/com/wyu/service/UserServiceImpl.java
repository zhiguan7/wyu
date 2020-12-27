package com.wyu.service;

import com.wyu.dao.UserDao;
import com.wyu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> searchUserAll() {
        return userDao.findAll();
    }

    @Override
    public User searchByName(String name) {
        return userDao.findByUserName(name);
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }
}
