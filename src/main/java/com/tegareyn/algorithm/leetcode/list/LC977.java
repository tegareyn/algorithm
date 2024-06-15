package com.tegareyn.algorithm.leetcode.list;

/**
 * @ClassName Main4
 * @Description 有序数的平方 重新排序
 * @Author mocheng
 * @Since 2022/11/11 18:32
 * @Version 1.0
 **/
public class LC977 {

    // 方式一：平方后，再排序（各种排序）


    // 双指针+归并排序(归并一次后，移动对应双指针)：
    // 1.找到正负分界点坐标（分为两个有序序列）
    // 2.定义一个同等长度的新数组，用于存放平方后排序的结果
    // 3.从分界点处左右各定义一个指针，分别平方后再对比排序
    // 4.将较小的放入新队列中，并移动对应指针
    public static int[] resort(int[] nums) {
        int div = -1;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] < 0) {
                div = i;
            } else {
                break;
            }
        }
        int left = div, right = div + 1;
        int[] result = new int[nums.length];
        int pos = 0;
        while (left >= 0 || right < nums.length) {
            if (left < 0) {
                result[pos] = nums[right] * nums[right];
                right ++;
            } else if (right >= nums.length) {
                result[pos] = nums[left] * nums[left];
                left --;
            } else if (-nums[left] < nums[right]) {
                result[pos] = nums[left]*nums[left];
                left--;
            } else {
                result[pos] = nums[right]*nums[right];
                right++;
            }
            pos++;
        }
        return result;
    }

    // 双指针
    // 1.将双指针放在数组两端，指向的数平方后比较结果；2.将较大的数依次放入新数组最右边，并移动较小数的指针



}
