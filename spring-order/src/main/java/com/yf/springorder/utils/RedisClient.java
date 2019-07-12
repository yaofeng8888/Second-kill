package com.yf.springorder.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: yaofeng
 * @create:2019-07-12-10:01
 **/
@Component
public class RedisClient {

    @Autowired
    private JedisPool jedisPool;

    public void set(String key,String value)throws Exception{
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key,value);
        }finally {
            jedis.close();
        }
    }

    public String get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }finally {
            jedis.close();
        }
    }

    public Long decr(String key,int value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.decrBy(key,value);
        }finally {
            jedis.close();
        }
    }
}
