/**
 * Chsi
 * Created on 2016年4月15日
 */
package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class CompleteTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<String>(executor);
        for (int i = 0; i < 10; i++) {
            final int taskId = i + 1;
            service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "a" + taskId;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(service.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
