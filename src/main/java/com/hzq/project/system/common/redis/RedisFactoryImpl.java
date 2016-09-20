package com.hzq.project.system.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * DefaultRedisFactory
 * Created by hzq on 16/9/20.
 */
@Component(value = "redisFactory")
public class RedisFactoryImpl implements RedisFactory {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public Jedis getInstance() {
        return jedisPool.getResource();
    }
}
