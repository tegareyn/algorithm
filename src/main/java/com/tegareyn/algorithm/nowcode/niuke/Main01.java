package com.tegareyn.algorithm.nowcode.niuke;

import com.tegareyn.algorithm.utils.StringUtil;
/**
 * @Ref LC977
 * @Description 有序数组的平方
 * @Author Spindrift
 * @Since 2022/12/20 21:58
 * @Version 1.0
 **/
public class Main01 {

    public static void main(String[] args) {
        sortedSquares(StringUtil.string2IntArray("[-4,-1,0,3,10]"));
    }

    public static int[] sortedSquares(int[] nums) {
        // 2分查找正负数的位置
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                left = i;
            } else {
                break;
            }
        }
        int right = left + 1;
        int[] result = new int[nums.length];
        int pos = 0;
        while (left >= 0 || right < nums.length) {
            if (left < 0) {
                result[pos] = nums[right] * nums[right];
                right++;
            } else if (right >= nums.length || -nums[left] < nums[right]) {
                result[pos] = nums[left] * nums[left];
                left--;
            } else {
                result[pos] = nums[right] * nums[right];
                right++;
            }
            pos++;
        }
        return result;
    }
}
