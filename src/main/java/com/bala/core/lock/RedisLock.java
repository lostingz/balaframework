/**
 * lostingz
 * Created on 2016年7月8日
 */
package com.bala.core.lock;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public class RedisLock implements IDistributedLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final String LOCK_VAL = "redisLock";

    @Override
    public boolean lock(String key, int timeoutInMills) {
        return false;
    }

    @Override
    public boolean tryLock(String key, int autoReleaseTime) {
        try {
            boolean isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, LOCK_VAL);
            if (isLocked) {
                stringRedisTemplate.expire(key, autoReleaseTime, TimeUnit.SECONDS);
            } else if (stringRedisTemplate.getExpire(key) == -1) {
                stringRedisTemplate.expire(key, autoReleaseTime, TimeUnit.SECONDS);
            }
            return isLocked;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }

    @Override
    public void unLock(String key) {
        stringRedisTemplate.delete(key);
    }

}
