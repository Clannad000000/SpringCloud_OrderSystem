package com.zcy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/23 9:51
 * @description：
 * @modified By：
 * @version: $
 */

@SpringBootApplication
@MapperScan("com.zcy.dao")
public class AccountApp {
    public static void main(String[] args) {
        SpringApplication.run(AccountApp.class, args);
    }
}
