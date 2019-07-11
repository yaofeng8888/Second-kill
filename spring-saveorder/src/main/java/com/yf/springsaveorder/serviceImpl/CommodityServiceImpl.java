package com.yf.springsaveorder.serviceImpl;

import com.yf.springsaveorder.mapper.ICommodity;
import com.yf.springsaveorder.service.ICommodtityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author: yaofeng
 * @create:2019-07-10-12:30
 **/
@Service
public class CommodityServiceImpl implements ICommodtityService {

    @Override
    public int updateinventory(String watchkeys,String user) {
       return 0;
    }
}
