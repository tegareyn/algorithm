package com.tegareyn.algorithm.leetcode.array;

/**
 * @ClassName Main2
 * @Description 寻找插入位置(寻找第一个大于等于目标值的下标)
 * @Author mocheng
 * @Since 2022/11/11 16:03
 * @Version 1.0
 **/
public class Main2 {
    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 2) + left;
            if (nums[mid] < target) {
                left = mid + 1; // 在mid的右边
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
