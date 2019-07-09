package com.yf.springbuy.interfaced;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: yaofeng
 * @create:2019-07-09-14:54
 **/
@FeignClient(value = "order-service")
public interface OrderService {

}
