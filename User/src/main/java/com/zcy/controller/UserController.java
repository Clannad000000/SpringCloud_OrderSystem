package com.zcy.controller;

import com.zcy.entity.User;
import com.zcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 17:14
 * @description：
 * @modified By：
 * @version: $
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("getPort")
    public String getPort(){
        return this.port;
    }

    @Autowired
    UserService userService;

    @GetMapping("findAll/{start}/{row}")
    public List<User> findAll(@PathVariable("start") int start, @PathVariable("row") int row){
        return userService.findAll(start, row);
    }

    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @GetMapping("getTotalCounts")
    public int getTotalCounts(){
        return userService.count();
    }

    @PostMapping("save")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PostMapping("update")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @GetMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        userService.deleteById(id);
    }
}
