package com.zcy.service;

import com.zcy.dao.UserDao;
import com.zcy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 17:37
 * @description：
 * @modified By：
 * @version: $
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll(int start, int row) {
        return userDao.findAll(start, row);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }
}
