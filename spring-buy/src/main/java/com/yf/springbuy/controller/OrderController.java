package com.yf.springbuy.controller;

import com.yf.springbuy.interfaced.OrderService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @author: yaofeng
 * @create:2019-07-10-12:47
 **/
@RestController
public class OrderController {

    private final OrderService orderService;
    private final String watchkeys = "watchkeys";
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/getorder")
    public String order(){
        String string1 = UUID.randomUUID().toString().replaceAll("-", "");
        String string = orderService.updateOrder(watchkeys,string1.substring(0,10));
        return string;
    }
}
