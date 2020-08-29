package com.zcy.service;

import com.zcy.dao.MenuDao;
import com.zcy.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 17:22
 * @description：
 * @modified By：
 * @version: $
 */

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> findAll(int start, int row) {
        return menuDao.findAll(start, row);
    }

    @Override
    public Integer count() {
        return menuDao.count();
    }

    @Override
    public Menu findById(Integer id) {
        return menuDao.findById(id);
    }

    @Override
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    public void update(Menu menu) {
        menuDao.update(menu);
    }

    @Override
    public void deleteById(Integer id) {
        menuDao.deleteById(id);
    }
}
