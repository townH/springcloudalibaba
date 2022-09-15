package com.tulingxueyuan.order;

import com.tulingxueyuan.ribbon.RibbonRandomRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义 Ribbon 的负载均衡算法
 * 局部配置：
 *  -  使用 配置类的方式
 *     配置类不能被 SpringBoot 扫描组件 扫描到。（ 不指定扫描路径额情况下，@SpringBootApplication 默认扫描该注解所在的类的路径 及其子路径）
 *
 *  -  使用配置文件的方式
 *
 * 全局配置：所欲服务都使用同一种 算法
 *
 *
 * 自己定义负载均衡算法：
 *     实现 AbstractLoadBalancerRule
 */
@SpringBootApplication
//@EnableDiscoveryClient

// 使用配置文件的方式,需要注释掉这里
//@RibbonClients(value = {
//        @RibbonClient(name="stock-service",configuration = RibbonRandomRuleConfig.class)
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
