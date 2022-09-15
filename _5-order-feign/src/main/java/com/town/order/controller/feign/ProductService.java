package com.town.order.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调用有路径变量的远程服务
 * 每个形参都要指定具体的路径变量名，哪怕只有一个变量并且变量与路径变量一致
 */
@FeignClient(name = "product-service",path = "/product")
public interface ProductService {
    @RequestMapping("/{id}")
    String get(@PathVariable("id") int id);
}
