package com.yile.study.redis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author chenyile
 * @date 2024/3/19  22:37
 */
public class MainTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //jedis = new Jedis("192.168.182.138", 6379);
        jedis = JedisConnectionFactory.getJedis();
        jedis.auth("root");
        jedis.select(0);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

    @Test
    public void testGet() {
        String hello = jedis.get("hello");
        System.out.println(hello);
    }

    @Test
    void testHash() {
        String key = "user:1";
        jedis.hset(key, "name", "cyl");
        jedis.hset(key, "age", "26");
        Map<String, String> map = jedis.hgetAll(key);
        System.out.println(map);
    }

}
