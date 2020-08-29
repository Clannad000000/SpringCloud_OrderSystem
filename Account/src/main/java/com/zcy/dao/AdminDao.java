package com.zcy.dao;

import com.zcy.entity.Admin;
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
public interface AdminDao {

    @Select("select * from t_admin where username=#{username} and password=#{password}")
    Admin login(@Param("username") String username, @Param("password") String password);
}
