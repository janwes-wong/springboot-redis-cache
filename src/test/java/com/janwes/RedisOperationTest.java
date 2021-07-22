package com.janwes;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes
 * @date 2021/7/20 16:58
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisOperationTest {

    @Autowired
    private RedisTemplate redisTemplate;


}
