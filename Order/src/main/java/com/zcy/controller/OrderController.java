package com.zcy.controller;

import com.zcy.entity.AllVO;
import com.zcy.entity.Order;
import com.zcy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 15:07
 * @description：
 * @modified By：
 * @version: $
 */

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Value("${server.port}")
    private String port;

    @GetMapping("getPort")
    public String getPort(){
        return "port:"+this.port;
    }

    @GetMapping("findByUid/{uid}/{start}/{row}")
    public List<Order> findByUid(@PathVariable("uid") int uid, @PathVariable("start") int start, @PathVariable("row") int row){
        return orderService.findByUid(uid, start, row);
    }

    @PostMapping("save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderService.save(order);
    }

    @GetMapping("getTotalCountsByUid/{uid}")
    public int getTotalCountsByUid(@PathVariable("uid") int uid){
        return orderService.getTotalCountsByUid(uid);
    }

    @GetMapping("findByState/{start}/{row}")
    List<Order> findByState(@PathVariable("start") int start, @PathVariable("row") int row){
        List<Order> orders = orderService.findByState(start, row);
//        for (Order order : orders) {
//            System.out.println(order);
//        }
        return orders;
    }

    @GetMapping("getState0Count")
    int getState0Count(){
        return orderService.getState0Count();
    }

    @GetMapping("updateState/{id}")
    void updateState(@PathVariable("id") int id){
        orderService.updateState(id);
    }
}
