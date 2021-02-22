package com.wyu.service;

import com.wyu.dao.UserDao;
import com.wyu.entity.User;
import com.wyu.util.CodeUtil;
import com.wyu.util.GetTimeUtil;
import com.wyu.util.MailSenderUtil;
import com.wyu.util.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    public void add(User user) {
        user.setOther(GetTimeUtil.getTime());
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        user.setOther(GetTimeUtil.getTime());
        userDao.update(user);
    }


}
