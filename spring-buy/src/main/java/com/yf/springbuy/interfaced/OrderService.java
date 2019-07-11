package com.yf.springbuy.interfaced;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: yaofeng
 * @create:2019-07-09-14:54
 **/
@FeignClient(value = "order-service")
public interface OrderService {

    @RequestMapping("/order")
    public String updateOrder(@RequestParam("key") String watchkeys,@RequestParam("user") String user);
}
