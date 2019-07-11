package com.yf.springorder.serviceImpl;

import com.yf.springorder.mapper.IOrder;
import com.yf.springorder.model.Order;
import com.yf.springorder.service.IOrderService;
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


    public void decrByRedis(String watchkeys,Order order){
        Jedis jedis = new Jedis("192.168.1.100", 6379);
        Long aLong = jedis.decrBy(watchkeys, 1);
        int valint = aLong.intValue();
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
