package com.zcy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/21 14:41
 * @description：   启动之后，访问http://localhost:yaml中eureka配置的端口号， 看监控页面
 * @modified By：
 * @version: $
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp.class, args);
    }
}
