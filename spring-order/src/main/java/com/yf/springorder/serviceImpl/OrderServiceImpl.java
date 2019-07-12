package com.yf.springorder.serviceImpl;

import com.yf.springorder.mapper.IOrder;
import com.yf.springorder.model.Order;
import com.yf.springorder.service.IOrderService;
import com.yf.springorder.utils.RedisClient;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author: yaofeng
 * @create:2019-07-11-15:32
 **/
@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private IOrder iOrder;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisClient redisClient;

    public void decrByRedis(String watchkeys,Order order){
        Long decr = redisClient.decr(watchkeys, 1);
        int valint = decr.intValue();
        if (valint>=0&&valint<=500){
            CorrelationData correlationData = new CorrelationData();
            correlationData.setId(order.getMessageId());
            rabbitTemplate.convertAndSend("order-exchange","order.or"
            ,order,correlationData);
        }
    }
    @Override
    public int insertOrder(Order order,String watchkeys) {
        int i = iOrder.insertOrder(order);
        if (i>0){
            decrByRedis(watchkeys,order);
            return i;
        }
        return 0;
    }
}
