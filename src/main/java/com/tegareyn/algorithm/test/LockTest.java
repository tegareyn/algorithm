package com.tegareyn.algorithm.test;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see LockTest
 * @since 2024/1/30 14:07
 **/
public class LockTest {

    private int num = 0;
    private boolean flag = true;
    public TreeNode lockTest = new TreeNode(0);
    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        for (int i = 0; i < 10; i++) {
            lockTest.test();
        }
    }
    public static void cyclicBarrierTest2() {
        int THREAD_COUNT = 10;

        CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(THREAD_COUNT  ,
                () -> System.out.println("======>我是导游，本次点名结束，准备走下一个环节!")
        );
        for(int i = 0 ; i < 10 ; i++) {
            new Thread(String.valueOf(i)) {
                public void run() {
                    try {
                        System.out.println("我是线程：" + this.getName() + " 我们达到旅游地点！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我开始骑车！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们开始爬山！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们回宾馆休息！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们开始乘车回家！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们到家了！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
    public static void cyclicBarrierTest() {
        CyclicBarrier barrier = new CyclicBarrier(3);
        System.out.println("主线程开始工作。。。");
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1完成前置任务");
            try {
                System.out.println("线程1准备await，numberWaiting:" + barrier.getNumberWaiting());
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Parties:" + barrier.getParties() + "，线程1 开始后置任务");
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2完成前置任务");
            try {
                System.out.println("线程2准备await，numberWaiting:" + barrier.getNumberWaiting());
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Parties:" + barrier.getParties() + "，线程2 开始后置任务");
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3完成前置任务");
            try {
                System.out.println("线程3准备await，numberWaiting:" + barrier.getNumberWaiting());
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Parties:" + barrier.getParties() + "，线程3 开始后置任务");
        }).start();
        System.out.println("主线程继续执行。。。");
    }

    public static void countDownLunchTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println("主线程开始工作。。。");
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1完成任务");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程2完成任务");
            countDownLatch.countDown();
            System.out.println("线程2 countDown 后，count:" + countDownLatch.getCount());
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3完成任务");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                System.out.println("线程4准备 await");
                Thread.sleep(100);
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程4等待 countDown 全部完成。继续执行");
        }).start();
        System.out.println("主线程准备await。。。");
        countDownLatch.await();
        System.out.println("全部完成任务，主线程继续执行。。。");
    }

    public void test() {
        new Thread(this::syncTest).start();
        new Thread(() -> {
            try{
                while (flag) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ": " + lockTest.val++);
                }
            } catch (InterruptedException ignored) {
            }
        }).start();
    }

    public void syncTest() {
        try{
            System.out.println(Thread.currentThread().getName() +  " begin lock...");
            Thread.sleep(100000);
            synchronized (lockTest) {
                System.out.println(Thread.currentThread().getName() + " - unlock: " + lockTest.val);
                flag = false;
            }
        } catch (InterruptedException ignored) {

        }
    }

}
