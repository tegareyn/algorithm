package com.tegareyn.algorithm.leetcode.array;

/**
 * @Ref LC35
 * @Description 搜索插入位置
 * @Author Spindrift
 * @Since 2023/4/3 22:19
 * @Version 1.0
 **/
public class LC35 {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left < right) {
            mid = left + (right-left)/2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        if (nums[left] < target) {
            return left+1;
        } else {
            return left == 0? 0:left -1;
        }
    }
}
