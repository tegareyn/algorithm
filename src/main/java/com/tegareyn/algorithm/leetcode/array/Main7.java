package com.tegareyn.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @ClassName Main7
 * @Description 找出有序述组中和为目标数的两个数
 * @Author mocheng
 * @Since 2022/11/16 16:49
 * @Version 1.0
 **/
public class Main7 {

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0};
        System.out.println(Arrays.toString(solution(nums, -1)));
    }

    public static int[] solution(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int r = nums[left] + nums[right];
            if (r == target) {
                return new int[] {++left, ++right};
            } else if (r < target) {
                left ++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

}
