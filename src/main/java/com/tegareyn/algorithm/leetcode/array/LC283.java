package com.tegareyn.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 描述：移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @Author mocheng
 * @Since 2022/11/16 14:01
 * @Version 1.0
 **/
public class LC283 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 3, 0, 0, 5};
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZero(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void moveZero1(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[slow];
                nums[slow++] = nums[i];
                nums[i] = tmp;
            }
        }



    }


}
