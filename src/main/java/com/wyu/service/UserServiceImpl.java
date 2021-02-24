package com.wyu.service;

import com.wyu.dao.UserDao;
import com.wyu.entity.User;
import com.wyu.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisUtil ru;
    @Autowired
    private MailSenderUtil msu;

    @Override
    public List<User> searchUserAll() {
        return userDao.findAll();
    }

    @Override
    public User searchByEmail(String email) {
        return userDao.findByUserEmail(email);
    }

    @Override
    public User searchById(long id) {
        return userDao.findByUserId(id);
    }

    @Override
    public void add(User user) {
        user.setOther(GetTimeUtil.getTime());
        user.setUser_role(User.Role.USER);
        user.setUser_state(User.State.ACTIVE);
        userDao.save(user);
    }

    @Override
    public int update(User user) {
        user.setUser_id(GetInfoUtil.getUserId());
        user.setOther(GetTimeUtil.getTime());
        return userDao.update(user);
    }

    @Override
    public int change(User user) {
        user.setOther(GetTimeUtil.getTime());
        return userDao.change(user);
    }


}
