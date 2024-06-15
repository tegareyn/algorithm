package com.tegareyn.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 描述：在排序数组中查找元素的第一个和最后一个位置
 *
 * @author mocheng
 * @version 1.0
 * @see LC34
 * @since 2023/12/21 11:45
 **/
public class LC34 {

    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(Arrays.toString(solution(nums, 2)));
    }

    public static int[] solution(int[] nums, int target) {
        int index = search(nums, target, 0, nums.length - 1);
        int l = index, r = index;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            l = i;
        }
        for (int i = index + 1; i <= nums.length - 1; i++) {
            if (nums[i] != target) {
                break;
            }
            r = i;
        }
        return new int[]{l, r};
    }

    public static int search(int[]nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right && nums[left] == target) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, target, left, mid - 1);
        } else {
            return search(nums, target, mid + 1, right);
        }
    }
}
