package com.zcy.service;

import com.zcy.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 17:37
 * @description：
 * @modified By：
 * @version: $
 */
public interface UserService {

    List<User> findAll(@Param("start") int start, @Param("row") int row);

    User findById(int id);

    int count();

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
