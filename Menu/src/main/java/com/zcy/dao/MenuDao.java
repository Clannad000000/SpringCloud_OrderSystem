package com.zcy.dao;

import com.zcy.entity.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 17:00
 * @description：
 * @modified By：
 * @version: $
 */

@Repository
public interface MenuDao {

//   @Select("select * from t_menu limit #{start}, #{row}")
    List<Menu> findAll(@Param("start") int start, @Param("row") int row);

//   @Select("select count(1) from t_menu")
    Integer count();

//  @Select("select * from t_menu where id=#{id}")
    Menu findById(Integer id);

    //@Insert("insert into t_menu(name, price, flavor) values(#{name}, #{price}, #{flavor})")
    void save(Menu menu);

    //@Update("update t_menu set name=#{name}, prices=#{price}, flavor=#{flavor} where id=#{id}")
    void update(Menu menu);

    //@Delete("delete from t_menu where id=#{id}")
    void deleteById(Integer id);

}
