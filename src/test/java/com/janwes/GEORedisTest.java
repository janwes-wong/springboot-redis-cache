package com.janwes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes
 * @date 2021/5/19 22:54
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GEORedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void addGEO() {
        Long add1 = redisTemplate.opsForGeo().add("location", new Point(113.925339, 22.587478), "兴东地铁站");
        System.out.println(add1);
        Long add2 = redisTemplate.opsForGeo().add("location", new Point(113.950414, 22.586132), "留仙洞地铁站");
        System.out.println(add2);
        Distance distance = redisTemplate.opsForGeo().distance("location",
                "兴东地铁站",
                "留仙洞地铁站",
                RedisGeoCommands.DistanceUnit.METERS); // 距离单位
        System.out.println(distance);
        System.out.println("两地之间的距离：" + distance.getValue() + " " + distance.getUnit());
    }
}
