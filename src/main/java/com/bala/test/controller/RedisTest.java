/**
 * lostingz
 * Created on 2016年7月8日
 */
package com.bala.test.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$dd
 */
public class RedisTest {
    private StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("resource")
    @Before
    public void before() {
        stringRedisTemplate = (StringRedisTemplate) new ClassPathXmlApplicationContext("spring.xml", "spring-hibernate.xml",
                "spring-mvc.xml")
                .getBean("stringRedisTemplate");
        for (int i = 0; i < 10; i++) {
            stringRedisTemplate.opsForValue().set("a" + i, "heheda");
        }
    }

    @Test
    public void testRedis() {
        Assert.assertEquals("heheda", stringRedisTemplate.opsForValue().get("a2"));
        Assert.assertEquals("heheda", stringRedisTemplate.opsForValue().get("a8"));
    }
}