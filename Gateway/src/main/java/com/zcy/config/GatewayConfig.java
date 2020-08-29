package com.zcy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ：zcy
 * @date ：Created in 2020/8/28 14:25
 * @description：  自定义全局filter
 * @modified By：
 * @version: $
 */

//@Configuration
@Slf4j
public class GatewayConfig implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入自定义的Filter");
        if(exchange.getRequest().getQueryParams().get("username")!=null){
            log.info("用户信息合法");
            return chain.filter(exchange);
        }else{
            log.info("用户信息不合法");
        }
        return exchange.getResponse().setComplete();
    }


    /**
     *
     * @author zcy
     * @date 2020/8/28 14:26
     * @param
     * @return 0 - ~ 的优先级 -数字越低表示最先执行， -1表示最先执行
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
