package com.zcy.dao;

import com.zcy.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 9:54
 * @description：
 * @modified By：
 * @version: $
 */

@Repository
public interface UserDao {

    @Select("select * from t_user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);
}
