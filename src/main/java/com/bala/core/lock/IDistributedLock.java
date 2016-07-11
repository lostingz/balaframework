/**
 * lostingz
 * Created on 2016年7月8日
 */
package com.bala.core.lock;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public interface IDistributedLock {
    /**
     * only one caller could get lock , if lock success return true,else in
     * timeoutMills return false
     */
    boolean lock(String key, int timeoutInMills);

    /**
     * get a lock, the lock will auto release in autoReleaseTimeInSecs ,if
     * success return true else return false
     */
    boolean tryLock(String key, int autoReleaseTimeInSecs);
    void unLock(String key);
}
