package com.janwes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes
 * @date 2021/7/20 17:08
 * @description
 */
@SpringBootApplication
@EnableCaching  // 开启redis缓存注解
@MapperScan("com.janwes.mapper")
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}