package com.zcy.service;
import com.zcy.entity.Order;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 11:41
 * @description：
 * @modified By：
 * @version: $
 */
public interface OrderService {

    void save(Order order);

    List<Order> findByUid(int uid, int start, int row);

    int getTotalCountsByUid(int uid);

    List<Order> findByState(int start, int row);

    int getState0Count();

    void updateState(int id);
}
