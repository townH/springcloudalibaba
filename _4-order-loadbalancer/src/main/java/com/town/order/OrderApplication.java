package com.town.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/***
 * 使用 LoadBalancer 的负载均衡算法
 *
 * - 在nacos 总剔除Ribbon。（新版的SpringCloud 好像是默认剔除了
 * - 在yml 配置文件中禁用ribbon 负载均衡机制
 * - 加入 LoadBalancer 依赖
 * - 在RestTemplate 加上@LoadBalance 注解
 * - 使用@LoadBalancerClients 指定负载均衡算法的配置类
 */
@SpringBootApplication
//可以指定 LoadBalance de 负载均衡算法
//@LoadBalancerClients(value = {
//        @LoadBalancerClient(name = )
//})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();

        return restTemplate;
    }
}
