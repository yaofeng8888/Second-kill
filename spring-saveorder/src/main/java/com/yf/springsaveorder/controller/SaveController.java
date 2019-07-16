package com.yf.springsaveorder.controller;

import com.rabbitmq.client.Channel;
import com.yf.springsaveorder.model.Order;
import com.yf.springsaveorder.serviceImpl.CommodityServiceImpl;
import com.yf.springsaveorder.serviceImpl.OrderServiceImpl;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.thymeleaf.util.ObjectUtils;

import java.util.Map;

/**
 * @author: yaofeng
 * @create:2019-07-16-12:56
 **/
@Controller
public class SaveController {

    @Autowired
    private CommodityServiceImpl commodityService;
    @Autowired
    private OrderServiceImpl orderService;


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order-queue"),exchange =
    @Exchange(value = "order-exchange",durable = "true",type = "topic")))

    @RabbitHandler
    public void saveOrder(@Payload Order order, @Headers Map<String, Object> map,
                          Channel channel)throws Exception{
        int num = orderService.updateOrder(order.getId());
        if (num>0){
            commodityService.updateinventory();
        }
    }

}
