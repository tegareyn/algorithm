package com.tegareyn.algorithm.test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述：
 *
 * @author MoCheng
 * @version 1.0
 * @since 2023/8/27 20:38
 **/
public class LTTest {


    public static void main(String[] args) {
        int i = 9;
        System.out.println(i >>> 1);
        System.out.println(i);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair));
        pq.offer(10);
        pq.offer(2);
        pq.offer(5);
        pq.offer(7);
        pq.offer(99);
        pq.offer(1);
        pq.offer(4);
    }

}
