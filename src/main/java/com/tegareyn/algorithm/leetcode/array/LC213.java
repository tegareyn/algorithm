package com.tegareyn.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 描述：打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
 * @author mocheng
 * @version 1.0
 * @see LC213
 * @since 2024/3/1 15:37
 **/
public class LC213 {
    // todo 未完成
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {2,3,2},
                {1,2,3,1},
                {7,6,4,3,1},
                {1}
        };
        for (int[] arr : array) {
            System.out.println(solution(arr));
        }
    }

    public static int solution(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] array = Arrays.copyOf(nums, nums.length);
            int sum = 0;
            for (int j = i; j < array.length && array[j] != -1;) {
                sum += array[j];
                array[j] = -1;
                j += 2;
                j = array.length - 1 - j < 0 ? Math.abs(array.length - 1 - j - 1) : j;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

}
