package com.example.redisson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p></p>
 *
 * @Description:
 */
@Slf4j
@SpringBootTest
public class RedissonTest {

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void addData(){
        RBucket<Object> bucket = redissonClient.getBucket("security.aa");
        bucket.set("our monitor is xigou");
    }

    @Test
    public void foundedKeys(){
        RBucket<Object> bucket = redissonClient.getBucket("security.aa");
        log.info("--获得值："+bucket.get());
    }

    @Test
    public void deleteKeys(){
        //获得所有keys
        RKeys keys = redissonClient.getKeys();
        long flag = keys.delete("security.aa1","security.aa");
        log.info("删除key:security.aa {}",flag);
    }

}