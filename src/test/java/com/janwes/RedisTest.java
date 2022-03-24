package com.janwes;

import com.janwes.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes
 * @date 2021/3/25 22:33
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void get() {
        String key = "user_key";
        String value = "10";
        redisTemplate.opsForValue().set(key, value);
        // 自减
        Long decrement = redisTemplate.opsForValue().decrement(key, 1);
        System.out.println(decrement);
        redisTemplate.opsForHash().put("ABC", "user", "258");
    }

    @Test
    public void testInsert() {
        for (int i = 0; i < 10000; i++) {
            redisTemplate.opsForValue().set("kk", "" + i);
        }
    }

    @Test
    public void add() {
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("张三", "meal"));
        userInfos.add(new UserInfo("李四", "meal"));
        userInfos.add(new UserInfo("王五", "meal"));
        userInfos.add(new UserInfo("赵六", "meal"));

        redisTemplate.opsForValue().set("userInfo", userInfos, 10, TimeUnit.MINUTES);
        Object o = redisTemplate.opsForValue().get("userInfo");
        List<UserInfo> userInfoList = (List<UserInfo>) o;
        System.out.println(o);
        System.out.println(userInfoList);
    }
}
