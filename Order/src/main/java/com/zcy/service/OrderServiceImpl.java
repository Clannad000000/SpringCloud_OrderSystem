package com.zcy.service;

import com.zcy.dao.OrderDao;
import com.zcy.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 11:41
 * @description：
 * @modified By：
 * @version: $
 */

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> findByUid(int uid, int start, int row) {
        return orderDao.findByUid(uid, start, row);
    }

    @Override
    public int getTotalCountsByUid(int uid) {
        return orderDao.getTotalCountsByUid(uid);
    }

    @Override
    public List<Order> findByState(int start, int row) {
        return orderDao.findByState(start, row);
    }

    @Override
    public int getState0Count() {
        return orderDao.getState0Count();
    }

    @Override
    public void updateState(int id) {
        orderDao.updateState(id);
    }

}
