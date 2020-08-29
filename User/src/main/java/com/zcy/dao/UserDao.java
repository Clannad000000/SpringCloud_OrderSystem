package com.zcy.dao;

import com.zcy.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 17:24
 * @description：
 * @modified By：
 * @version: $
 */

@Repository
public interface UserDao {
    @Select("select * from t_user limit #{start}, #{row}")
    List<User> findAll(@Param("start") int start, @Param("row") int row);

    @Select("select * from t_user where id=#{id}")
    User findById(int id);

    @Select("select count(*) from t_user")
    int count();

    @Insert("insert into t_user(username, password, nickname, gender, telephone, registerdate, address) " +
            "values(#{username}, #{password}, #{nickname}, #{gender}, #{telephone}, #{registerdate}, #{address})")
    void save(User user);

    @Update("update t_user set username=#{username}, password=#{password}, gender=#{gender}, telephone=#{telephone}," +
            "registerdate=#{registerdate}, address=#{address} where id=#{id}")
    void update(User user);

    @Delete("delete from t_user where id=#{id}")
    void deleteById(int id);

}
