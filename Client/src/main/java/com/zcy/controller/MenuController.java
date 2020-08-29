package com.zcy.controller;

import com.zcy.entity.AllVO;
import com.zcy.entity.Menu;
import com.zcy.entity.Msg;
import com.zcy.entity.Type;
import com.zcy.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 20:38
 * @description：
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/client/menu")
public class MenuController {

    @Autowired
    MenuFeign menuFeign;


    @GetMapping("getMenus")
    @ResponseBody
    public AllVO getMenus(@RequestParam("page") int page, @RequestParam("limit") int limit){
        List<Menu> menus = menuFeign.getMenus((page - 1) * limit, limit);
        return new AllVO(0, "", menuFeign.getTotalCounts(), menus);
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        menuFeign.deleteById(id);
        return "redirect:/menu_manage.html";
    }

    @GetMapping("findTypes")
    @ResponseBody
    public Msg findTypes(Model model){
        List<Type> types = menuFeign.findTypes();
        return Msg.success().add("types", types);
    }

    // 这里仅仅是测试服务降级，因为前台没用ajax提交，所以这里没法将消息响应给前端
    @PostMapping("save")
    public String save(Menu menu){
        AllVO vo = menuFeign.save(menu);
        System.out.println(vo.getCode());
        if(vo.getCode()==200){
            return "redirect:/menu_manage.html";
        }else{
            System.out.println(vo.getMsg());
            return "redirect:/user_manage.html"; //指向另外一个页面，以区分成功时的页面
        }
    }


    @GetMapping("findById/{id}")
    @ResponseBody
    public Msg findById(@PathVariable("id") int id){
        Menu menu = menuFeign.findById(id);
        return Msg.success().add("oneMenu",menu);
    }

    /*修改菜品*/
    @PostMapping("/update")
    @ResponseBody
    public Msg update(Menu menu){
        AllVO vo = menuFeign.update(menu);
        if(vo.getCode()==200){
            return Msg.success().add("msg", vo.getMsg());
        }else{
            return Msg.fail().add("msg", vo.getMsg());
        }
    }

}
