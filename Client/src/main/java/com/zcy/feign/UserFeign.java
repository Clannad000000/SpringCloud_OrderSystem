package com.zcy.feign;

import com.zcy.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 17:51
 * @description：
 * @modified By：
 * @version: $
 */
@FeignClient("user")
public interface UserFeign {

    @GetMapping("/user/findAll/{start}/{row}")
    public List<User> findAll(@PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") int id);

    @GetMapping("/user/getTotalCounts")
    public int getTotalCounts();

    @PostMapping("/user/save")
    public void save(User user);

    @PostMapping("/user/update")
    public void update(User user);

    @GetMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id);
}
