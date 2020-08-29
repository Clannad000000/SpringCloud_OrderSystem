package com.zcy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 15:46
 * @description：
 * @modified By：
 * @version: $
 */

@SpringBootApplication
@MapperScan("com.zcy.dao")
@EnableCircuitBreaker  // 服务熔断机制
public class MenuApp {
    public static void main(String[] args) {
        SpringApplication.run(MenuApp.class, args);
    }
}
