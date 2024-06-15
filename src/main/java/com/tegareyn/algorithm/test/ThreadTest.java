package com.tegareyn.algorithm.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see ThreadTest
 * @since 2023/12/19 17:48
 **/
public class ThreadTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newScheduledThreadPool(10);
        executorService.submit(() -> {

        });
        Thread thread = new Thread();
        thread.start();
    }
}
