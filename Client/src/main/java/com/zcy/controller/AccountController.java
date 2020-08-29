package com.zcy.controller;

import com.zcy.entity.Admin;
import com.zcy.entity.Msg;
import com.zcy.entity.User;
import com.zcy.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 10:11
 * @description：
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping("/client/account")
public class AccountController {

    @Autowired
    AccountFeign accountFeign;

    @PostMapping("login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
                        @RequestParam("type")String type, HttpSession session) throws ParseException {
        Object login = accountFeign.login(username, password, type);  // login这里是LinkedHashMap，不是Object类型了
        Map<String, Object> map = (LinkedHashMap)login;
        if(login!=null){
            if("user".equals(type)){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                User user = new User();
                user.setId((Integer) map.get("id")).setUsername((String)map.get("username")).setPassword((String)map.get("password"))
                        .setNickname((String)map.get("nickname")).setGender((String)map.get("gender")).setTelephone((String)map.get("telephone"))
                        .setRegisterdate(simpleDateFormat.parse((String)map.get("registerdate"))).setAddress((String)map.get("address"));
//                User user = (User) login;  // 还不如Account不用多态，admin和user用2个登录方式  date还转不过来
                session.setAttribute("user", user);
                return "redirect:/index.html";
            }else if("admin".equals(type)){
                Admin admin = new Admin();
                admin.setId((Integer) map.get("id")).setUsername((String)map.get("username")).setPassword((String)map.get("password"));
//                Admin admin = (Admin) login;
                session.setAttribute("admin", admin);
                return "redirect:/main.html";
            }
        }
        return "redirect:/login.html";
    }


    @GetMapping("getUsername")
    @ResponseBody
    public Msg getUsername(HttpSession session){
        User user = (User) session.getAttribute("user");
        Admin admin = (Admin) session.getAttribute("admin");
        return Msg.success().add("user",user).add("admin",admin);
    }


    @GetMapping("/logout/{type}")
    public String logout(@PathVariable("type")String type,HttpSession session){
        switch (type){
            case "user":
                session.removeAttribute("user");
                break;
            case "admin":
                session.removeAttribute("admin");
                break;
        }
        return "redirect:/login.html";
    }
}
