package com.yf.springsaveorder.serviceImpl;

import com.yf.springsaveorder.mapper.IOrder;
import com.yf.springsaveorder.model.Order;
import com.yf.springsaveorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author: yaofeng
 * @create:2019-07-11-15:32
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrder iOrder;

    @Override
    public int updateOrder(String key) {
        return iOrder.updateOrder(key);
    }
}
