package com.town.order.controller;

import com.town.order.controller.feign.ProductService;
import com.town.order.controller.feign.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/***
 * @Author town
 * @time  2022-09
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    StockService stockService;

    @Autowired
    ProductService productService;

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功!");

        // 直接像调用本地方法一样调用远程方法
        String msg = stockService.reduct();
        return "Hello World"+msg;
    }

    @RequestMapping("get")
    public String get() {
        String product = productService.get(new Random().nextInt());
        return "查询的商品详情为：" + product;
    }

}
