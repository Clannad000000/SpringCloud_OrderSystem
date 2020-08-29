package com.zcy.hystrix;

import com.zcy.entity.AllVO;
import com.zcy.entity.Menu;
import com.zcy.entity.Type;
import com.zcy.feign.MenuFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/28 23:18
 * @description：
 * @modified By：
 * @version: $
 */

@Component
public class MenuHystrix implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new MenuFeign() {
            @Override
            public List<Menu> getMenus(int start, int row) {
                return null;
            }

            @Override
            public Integer getTotalCounts() {
                return null;
            }

            @Override
            public void deleteById(int id) {

            }

            @Override
            public List<Type> findTypes() {
                return null;
            }

            @Override
            public AllVO save(Menu menu) {
                return new AllVO().setCode(499).setMsg("服务降级，现在不允许添加菜单，请稍后再试！");
            }

            @Override
            public AllVO update(Menu menu) {
                return null;
            }

            @Override
            public Menu findById(int id) {
                return null;
            }
        };
    }
}


/*
  如果是按照下面的写法，feign中需要指定的是fallback而不是fallbackFactory
 */
//@Component
//public class MenuHystrix implements MenuFeign{
//
//    @Override
//    public List<Menu> getMenus(int start, int row) {
//        return null;
//    }
//
//    @Override
//    public Integer getTotalCounts() {
//        return null;
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//    }
//
//    @Override
//    public List<Type> findTypes() {
//        return null;
//    }
//
//    @Override
//    public AllVO save(Menu menu) {
//        return null;
//    }
//
//    @Override
//    public AllVO update(Menu menu) {
//        return null;
//    }
//
//    @Override
//    public Menu findById(int id) {
//        return null;
//    }
//}
