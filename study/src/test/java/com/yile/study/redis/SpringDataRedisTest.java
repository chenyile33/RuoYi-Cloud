package com.yile.study.redis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author chenyile
 * @date 2024/3/19  23:12
 */
@SpringBootTest
public class SpringDataRedisTest {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("hello", "world");
        Object hello = redisTemplate.opsForValue().get("hello");
        System.out.println(hello);
    }

    @Test
    void testSaveUser() {
        User user = new User("yyq", 25);
        String key = "user:11";
        redisTemplate.opsForValue().set(key, user);
        User o = (User) redisTemplate.opsForValue().get(key);
        System.out.println(o);
    }
}

@AllArgsConstructor
@NoArgsConstructor //这里不加无参的构造函数，存redis时会报错
@Data
class User {
    private String name;
    private int age;
}


