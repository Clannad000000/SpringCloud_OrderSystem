package com.zcy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/22 17:13
 * @description：
 * @modified By：
 * @version: $
 */

@SpringBootApplication
@MapperScan("com.zcy.dao")
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}
