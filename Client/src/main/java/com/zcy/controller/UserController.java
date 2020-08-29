package com.zcy.controller;

import com.zcy.entity.AllVO;
import com.zcy.entity.User;
import com.zcy.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 17:53
 * @description：
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/client/user")
public class UserController {

    @Autowired
    UserFeign userFeign;


    @GetMapping("findAll")
    @ResponseBody
    public AllVO findAll(@RequestParam("page") int start, @RequestParam("limit") int row){
        List<User> users = userFeign.findAll((start - 1) * row, row);
        return new AllVO(0, "", userFeign.getTotalCounts(), users);
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") int id){
        return userFeign.findById(id);
    }

    @GetMapping("getTotalCounts")
    public int getTotalCounts(){
        return userFeign.getTotalCounts();
    }

    @PostMapping("save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user_manage.html";
    }

    @PostMapping("update")
    public void update(User user){
        userFeign.update(user);
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        userFeign.deleteById(id);
        return "redirect:/user_manage.html";
    }
}
