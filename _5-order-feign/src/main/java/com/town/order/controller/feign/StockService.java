package com.town.order.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 定义服务调用的接口和方法
 */
@FeignClient(name = "stock-service",path = "/stock")
public interface StockService {
    @RequestMapping("/reduct")
    String reduct();
}
