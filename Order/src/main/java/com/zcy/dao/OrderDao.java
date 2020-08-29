package com.zcy.dao;


import com.zcy.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 11:33
 * @description：
 * @modified By：
 * @version: $
 */

@Repository
public interface OrderDao {

    @Insert("insert into t_order(uid, mid, date, state) values(#{user.id}, #{menu.id}, #{date}, 0)")
    void save(Order order);

//    @Select("select id, uid, mid, date, state from t_order limit #{start}, #{row}")
    List<Order> findByUid(@Param("uid") int uid, @Param("start") int start, @Param("row") int row);

    @Select("select count(1) from t_order where uid=#{uid}")
    int getTotalCountsByUid(int uid);

    List<Order> findByState(@Param("start") int start, @Param("row") int row);

    @Select("select count(1) from t_order where state=0")
    int getState0Count();

    @Update("update t_order set state=1 where id=#{id}")
    void updateState(int id);

}
