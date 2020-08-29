package com.zcy.feign;

import com.zcy.entity.AllVO;
import com.zcy.entity.Menu;
import com.zcy.entity.Type;
import com.zcy.hystrix.MenuHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 20:34
 * @description：
 * @modified By：
 * @version: $
 */


@FeignClient(value = "menu", fallbackFactory = MenuHystrix.class) // yaml要配置feign.hystrix.feign=true
public interface MenuFeign {

    @GetMapping("/menu/getMenus/{start}/{row}")
    public List<Menu> getMenus(@PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/menu/getTotalCounts")
    public Integer getTotalCounts();

    @GetMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") int id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    AllVO save(Menu menu);

    @PostMapping("/menu/update")
    AllVO update(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") int id);
}
