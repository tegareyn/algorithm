package com.tegareyn.algorithm.leetcode.array;

import com.tegareyn.algorithm.utils.StringUtil;

/**
 * @Ref LC704或NCxx
 * @Description 二分查找
 * @Author Spindrift
 * @Since 2023/4/2 22:53
 * @Version 1.0
 **/
public class LC704 {

    public static void main(String[] args) {
        int[] nums = StringUtil.string2IntArray("[-1,0,3,5,9,12]");
        System.out.println(search(nums, 12));
    }

    public static int search(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left)/2 + left;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }

}
