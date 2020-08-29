package com.zcy.service;

import com.zcy.entity.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 17:21
 * @description：
 * @modified By：
 * @version: $
 */
public interface MenuService {

    List<Menu> findAll(@Param("start") int start, @Param("row") int row);

    Integer count();

    Menu findById(Integer id);

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(Integer id);
}
