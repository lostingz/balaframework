/**
 * Chsi
 * Created on 2016年4月15日
 */
package com.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class TestFuture {
    public static void main(String[] args) {
        Calculate cal = new Calculate();
        FutureTask<String> task = new FutureTask<String>(cal);
        new Thread(task).start();
        try {
            while (!task.isDone()) {
                System.out.println("not finish");
            }
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
