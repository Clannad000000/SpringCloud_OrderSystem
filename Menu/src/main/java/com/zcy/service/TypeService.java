package com.zcy.service;

import com.zcy.entity.Type;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 10:37
 * @description：
 * @modified By：
 * @version: $
 */
public interface TypeService {
    public Type findById(Integer id);

    public List<Type> findAll();
}
