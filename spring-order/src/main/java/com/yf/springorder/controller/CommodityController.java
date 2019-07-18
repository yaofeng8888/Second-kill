package com.yf.springorder.controller;

import com.yf.springorder.model.Order;
import com.yf.springorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * @author: yaofeng
 * @create:2019-07-10-12:31
 **/
@Controller
@RequestMapping(value = "/")
public class CommodityController {
    private final IOrderService iOrderService;

    @Autowired
    public CommodityController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @RequestMapping(value = "insertorder")
    public String updateOrder(String watchkeys,String user){
        Order order = new Order();
        order.setId(System.currentTimeMillis()+"");
        order.setStatus(0);
        order.setName(user);
        order.setMessageId(UUID.randomUUID().toString().replaceAll("-","")+"$"+System.currentTimeMillis());
        int i = iOrderService.insertOrder(order,watchkeys);
        if (i>0){
            return "{\"status\":\"success\"}";
        }
        return "{\"status\":\"fail\"}";
    }
}
