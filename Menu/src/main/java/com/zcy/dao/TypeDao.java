package com.zcy.dao;

import com.zcy.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 22:01
 * @description：
 * @modified By：
 * @version: $
 */
@Repository
public interface TypeDao {
    public Type findById(Integer id);

    public List<Type> findAll();
}
