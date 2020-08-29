package com.zcy.controller;

import com.zcy.entity.*;
import com.zcy.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 11:52
 * @description：
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/client/order")
public class OrderController {


    @Autowired
    OrderFeign orderFeign;

    /*根据用户id查询订单*/
    @GetMapping("/findByUid")
    @ResponseBody
    public AllVO findAllByUid(@RequestParam("page")int page, @RequestParam("limit")int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderFeign.findByUid(user.getId(), (page - 1) * limit, limit);
        return new AllVO(0,"",orderFeign.getTotalCountsByUid(user.getId()), orders);
    }

    @PostMapping("save/{mid}")
    @ResponseBody
    public Msg save(@PathVariable("mid")int mid, HttpSession session){
        User user = (User)session.getAttribute("user");
        Order order = new Order();
        order.setUser(user).setMenu(new Menu().setId(mid));
        orderFeign.save(order);
        return Msg.success();
    }

    @GetMapping("findByState")
    @ResponseBody
    public AllVO findByState(@RequestParam("page")int page, @RequestParam("limit")int limit){
        List<Order> orders = orderFeign.findByState((page-1)*limit, limit);
        return new AllVO(0, "", orderFeign.getState0Count(), orders);
    }

    @GetMapping("updateState/{id}")
    @ResponseBody
    public Msg updateState(@PathVariable("id") int id){
        orderFeign.updateState(id);
        return Msg.success();
    }
}
