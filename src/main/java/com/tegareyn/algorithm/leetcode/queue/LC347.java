package com.tegareyn.algorithm.leetcode.queue;

import java.util.*;

/**
 * 描述：前K个高频元素
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/27 21:37
 **/
public class LC347 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,2,3,1,5,6,7,4,3,1,2,3,4,5,6,7,8,9,4,3,6,7,4,2,4};
        solution(nums, 3);
    }

    public static int[] solution(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Map<Integer, Integer> statistic = statistic(nums);
        Iterator<Integer> iterator = statistic.keySet().iterator();
        int i = 0;
        while(iterator.hasNext()) {
            Integer num = iterator.next();
            Integer times = statistic.get(num);
            int[] e = {num, times};
            if (i < k) {
                priorityQueue.offer(e);
                i++;
            } else {
                int[] peek = priorityQueue.peek();
                if (peek[1] < times) {
                    priorityQueue.poll();
                    priorityQueue.offer(e);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (priorityQueue.size()>0) {
            result[index++] = priorityQueue.poll()[0];
        }
        return result;
    }

    public static Map<Integer, Integer> statistic(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
        }
        return map;
    }




}
