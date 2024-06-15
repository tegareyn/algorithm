package com.tegareyn.algorithm.leetcode.array;

/**
 * 描述：最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @author mocheng
 * @version 1.0
 * @see LC1004
 * @since 2024/3/8 14:35
 **/
public class LC1004 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int max = 0;
        int len = 0, zero = 0;
        for (int left = 0, right = 0; right < nums.length && left <= right;) {
            if (nums[right] == 0) {
                zero++;
                if (zero > k) {
                    left = findNextZero(nums, left);
                    zero--;
                    left++;
                    len = right - left + 1;
                    right++;
                    to(left, right, nums);
                    continue;
                }
            }
            to(left, right, nums);
            len++;
            right++;
            max = Math.max(max, len);
        }
        return max;
    }

    public static int findNextZero(int[] nums, int begin) {
        for (; begin < nums.length; begin++) {
            if (nums[begin] == 0) {
                break;
            }
        }
        return begin;
    }

    public static void to(int left, int right, int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(left).append(", ").append(right).append("]");
//        for (; left <= right; left++) {
//            sb.append(nums[left]).append(", ");
//        }
        System.out.println(sb);
    }
}
