package com.town.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 使用 feign 进行远程方法调用
 * 1、 导入 openfeign 依赖
 * 2、 启动类 加上注解 @EnableFeignClients
 * 3、 定义远程服务的接口和方法
 * 4、 像调用本地方法一样调用服务
 */
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
