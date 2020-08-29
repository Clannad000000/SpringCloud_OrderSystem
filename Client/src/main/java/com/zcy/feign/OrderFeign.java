package com.zcy.feign;

import com.zcy.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 11:52
 * @description：
 * @modified By：
 * @version: $
 */

@FeignClient("order")
public interface OrderFeign {


    @PostMapping("/order/save")
    public void save(Order order);

    @GetMapping("/order/findByUid/{uid}/{start}/{row}")
    public List<Order> findByUid(@PathVariable("uid") int uid, @PathVariable("start") int start, @PathVariable("row") int row);


    @GetMapping("/order/getTotalCountsByUid/{uid}")
    public int getTotalCountsByUid(@PathVariable("uid") int uid);

    @GetMapping("/order/findByState/{start}/{row}")
    List<Order> findByState(@PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/order/getState0Count")
    int getState0Count();

    @GetMapping("/order/updateState/{id}")
    void updateState(@PathVariable("id") int id);
}
