package com.hzq.project.system.common.redis;

import redis.clients.jedis.Jedis;

/**
 * RedisFactory
 * Created by hzq on 16/9/20.
 */
public interface RedisFactory {
    Jedis getInstance();
}
