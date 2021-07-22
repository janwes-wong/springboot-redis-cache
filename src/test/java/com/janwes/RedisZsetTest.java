package com.janwes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes
 * @date 2021/5/20 17:36
 * @description zset在Redis中内部实现排序
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisZsetTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * zset add操作
     */
    @Test
    public void testAdd() {
        redisTemplate.opsForZSet().add("new", "jack", 55);
        redisTemplate.opsForZSet().add("new", "lucy", 78);
        redisTemplate.opsForZSet().add("new", "andy", 61);
        redisTemplate.opsForZSet().add("new", "judy", 42);
        redisTemplate.opsForZSet().add("new", "alan", 85);
    }

    @Test
    public void testGet() {
        // 查询集合中指定顺序的值  zrevrange 返回有序的集合中，score从大到小排序 降序
        Set<String> desc = redisTemplate.opsForZSet().reverseRange("new", 0, -1);
        System.out.println(desc);

        // score从小到大排序 升序
        Set<String> asc = redisTemplate.opsForZSet().range("new", 0, -1);
        System.out.println(asc);
    }

    @Test
    public void testOther() {
        //   获取score分数区间值的个数
        Long count = redisTemplate.opsForZSet().count("new", 0, 80);
        System.out.println(count);

        // 获取变量中元素的索引,下标开始位置为0
        Long index = redisTemplate.opsForZSet().rank("new", "alan");
        System.out.println("key为new的元素alan的索引为：" + index);
    }
}