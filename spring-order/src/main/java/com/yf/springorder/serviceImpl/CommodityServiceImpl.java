package com.yf.springorder.serviceImpl;

import com.yf.springorder.mapper.ICommodity;
import com.yf.springorder.service.ICommodtityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

/**
 * @author: yaofeng
 * @create:2019-07-10-12:30
 **/
@Service
public class CommodityServiceImpl implements ICommodtityService {

    @Autowired
    private ICommodity iCommodity;

    @Override
    public int updateinventory(String watchkeys,String user) {
        Jedis jedis = new Jedis("192.168.1.100", 6379);
        Long aLong = jedis.decrBy(watchkeys, 1);
        int valint = aLong.intValue();
        if (valint<=500 && valint>=0){
            int updateinventory = iCommodity.updateinventory();
            return updateinventory;
        }else {
            return 0;
        }
    }
}
