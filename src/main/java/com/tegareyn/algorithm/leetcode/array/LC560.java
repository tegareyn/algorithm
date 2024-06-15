package com.tegareyn.algorithm.leetcode.array;

/**
 * 描述：和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列
 * @author mocheng
 * @version 1.0
 * @see LC560
 * @since 2024/3/8 16:57
 **/
public class LC560 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    size++;
                }
            }
        }
        return size;
    }

}
