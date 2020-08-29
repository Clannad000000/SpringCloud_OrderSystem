package com.zcy.service;

import com.zcy.dao.TypeDao;
import com.zcy.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 10:37
 * @description：
 * @modified By：
 * @version: $
 */

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public Type findById(Integer id) {
        return typeDao.findById(id);
    }

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }
}
