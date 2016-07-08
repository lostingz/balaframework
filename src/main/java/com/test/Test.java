/**
 * Chsi
 * Created on 2016年4月15日
 */
package com.test;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
class Task {
    private String id;

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "task[" + this.id + "]";
    }
}

class Producer implements Runnable {

    private BlockingQueue<Task> taskQueue;

    public Producer(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Task task = new Task();
                taskQueue.put(task);
                System.out.println(Thread.currentThread().getName() + task.toString() + "add to queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Task> taskQueue;

    public Consumer(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }
    @Override
    public void run() {
        while (true) {
            Task task;
            try {
                task = taskQueue.take();
                System.out.println(Thread.currentThread().getName() + task.toString() + " take from queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        BlockingQueue<Task> queue = new ArrayBlockingQueue<Task>(10);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            Producer p = new Producer(queue);
            executor.submit(p);
        }
        for (int i = 0; i < 3; i++) {
            Consumer c = new Consumer(queue);
            executor.submit(c);
        }

    }
}
