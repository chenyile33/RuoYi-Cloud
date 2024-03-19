package com.yile.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author chenyile
 * @date 2024/3/19  22:55
 */
public class JedisConnectionFactory {
    private static final JedisPool JEDIS_POOL;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        JEDIS_POOL = new JedisPool(poolConfig, "192.168.182.138", 6379, 1000, "root");
    }

    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }
}
