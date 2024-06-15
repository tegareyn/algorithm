package com.tegareyn.algorithm.leetcode.array;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see LC724
 * @since 2024/3/8 16:45
 **/
public class LC724 {

    public static void main(String[] args) {

    }

    public static int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i : nums) {
            right+=i;
        }
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (right == left) {
                return i;
            }
            left += nums[i];
        }
        return index;
    }
}
