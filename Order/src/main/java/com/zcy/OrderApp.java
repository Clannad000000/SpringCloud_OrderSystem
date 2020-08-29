package com.zcy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 15:07
 * @description：
 * @modified By：
 * @version: $
 */

@SpringBootApplication
@MapperScan("com.zcy.dao")
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
