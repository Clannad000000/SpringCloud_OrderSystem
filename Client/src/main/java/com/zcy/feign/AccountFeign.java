package com.zcy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 10:11
 * @description：
 * @modified By：
 * @version: $
 */

@FeignClient("account")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);
}
