package com.zcy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 20:33
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@EnableFeignClients
public class ClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
    }
}
