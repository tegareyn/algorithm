package com.tegareyn.algorithm.leetcode.array;

/**
 * 描述：非递减数列
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * @author mocheng
 * @version 1.0
 * @see LC665
 * @since 2024/1/30 16:36
 **/
public class LC665 {

    public static boolean checkPossibility(int[] nums) {
        int check = 0;
        for (int left = 0; left < nums.length - 1; left++) {
            if (nums[left] > nums[left + 1]) {
                check++;
                if (check > 1) {
                    return false;
                }
                nums[left - 1] = nums[left];
            }
        }
        return true;
    }
}
