package com.tegareyn.algorithm.leetcode.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 描述：滑动窗口最大值
 *
 * @author MoCheng
 * @version 1.0
 * @since 2023/8/14 12:51
 **/
public class LC239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,7,3,4,8,5,6,8,9};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 5)));
        System.out.println(Arrays.toString(solution(nums, 5)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
                pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]
        );
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public static int[] solution(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        int i = 0;
        for (; i < k; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        while (i < nums.length) {
            result[index++] = priorityQueue.peek()[0];
            priorityQueue.add(new int[]{nums[i], i});
            while(priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            i++;
        }
        result[index] = priorityQueue.poll()[0];
        return result;
    }

}
