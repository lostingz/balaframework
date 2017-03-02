/**
 * lostingz
 * Created on 2016年7月8日
 */
package com.bala.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.bala.user.model.User;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$dd
 */
public class RedisTest {
    private StringRedisTemplate stringRedisTemplate;
    private RedisTemplate redisTemplate;

    @SuppressWarnings("resource")
    @Before
    public void before() {
        stringRedisTemplate = (StringRedisTemplate) new ClassPathXmlApplicationContext("spring.xml", "spring-hibernate.xml",
                "spring-mvc.xml")
                .getBean("stringRedisTemplate");
        redisTemplate = (RedisTemplate) new ClassPathXmlApplicationContext("spring.xml", "spring-hibernate.xml",
                "spring-mvc.xml")
                .getBean("redisTemplate");
        for (int i = 0; i < 10; i++) {
            stringRedisTemplate.opsForValue().set("a" + i, "heheda");
        }
        List<User> list=new ArrayList<>();
        list.add(new User("111","ad","d"));
        list.add(new User("112","ad","d"));
        list.add(new User("113","ad","d"));
        list.add(new User("114","ad","d"));
        redisTemplate.opsForValue().set("list",list);
    }

    @Test
    public void testRedis() {
        Assert.assertEquals("heheda", stringRedisTemplate.opsForValue().get("a2"));
        Assert.assertEquals("heheda", stringRedisTemplate.opsForValue().get("a8"));
        List<User> list= (List<User>) redisTemplate.opsForValue().get("list");
        Assert.assertEquals(4,list.size());
        
    }
}