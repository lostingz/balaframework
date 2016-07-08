/**
 * Chsi
 * Created on 2016年4月15日
 */
package com.test;

import java.util.concurrent.Callable;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Calculate implements Callable<String> {

    @Override
    public String call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
