package com.yf.springorder.service;

import com.yf.springorder.model.Order;

public interface IOrderService {
    int insertOrder(Order order,String watchkeys);
}
