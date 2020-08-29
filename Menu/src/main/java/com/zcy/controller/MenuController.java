package com.zcy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zcy.entity.AllVO;
import com.zcy.entity.Menu;
import com.zcy.entity.Type;
import com.zcy.service.MenuService;
import com.zcy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 15:46
 * @description：
 * @modified By：
 * @version: $
 */

@RestController
@RequestMapping("menu")
public class MenuController {

    @Value("${server.port}")
    private String port;


    @Autowired
    MenuService menuService;

    @Autowired
    TypeService typeService;

    @RequestMapping("getPort")
    public String getPort(){
        return "port:"+this.port;
    }


    @GetMapping("/getMenus/{start}/{row}")
    public List<Menu> getMenus(@PathVariable("start") int start, @PathVariable("row") int row){
        return menuService.findAll(start, row);
    }

    @GetMapping("getTotalCounts")
    public Integer getTotalCounts(){
        return menuService.count();
    }


    @GetMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        menuService.deleteById(id);
    }


    @GetMapping("findTypes")
    public List<Type> findTypes(){
        return typeService.findAll();
    }

    @PostMapping("save")
    public AllVO save(@RequestBody Menu menu){
        menuService.save(menu);
        return new AllVO().setCode(200).setMsg("添加成功");
    }

    @PostMapping("update")
    @HystrixCommand(fallbackMethod = "hystrixMethod") // 失败时调用指定方法
    public AllVO update(@RequestBody Menu menu){
        if(menu.getPrice()<0){
            System.out.println("-----Hystrix-------");
            throw new RuntimeException("价格不允许小于0");
        }
        menuService.update(menu);
        return new AllVO().setMsg("修改成功").setCode(200);
    }

    @GetMapping("findById/{id}")
    public Menu findById(@PathVariable("id") int id){
        return menuService.findById(id);
    }



    public AllVO hystrixMethod(@RequestBody Menu menu){
        return new AllVO().setMsg("服务熔断，价格不允许小于0！").setCode(499);
    }
}
