package com.tegareyn.algorithm.facecode;

import java.util.Arrays;

/**
 * 描述：参考 LT16 最接近的三数之和
 * 给定一个正整数数组 A 和一个目标值 k，从数组中选择三个数字使其和尽可能地接近k (小于等于k)，请计算可选择的最大的三数之和，若不存在返回-1。
 * 其中，A的长度<100， 1≤A 中元素＜1000; 0≤k≤100000
 * @author mocheng
 * @version 1.0
 * @see MostMinCloser
 * @since 2024/2/29 09:37
 **/
public class MostMinCloser {

    public static void main(String[] args) {
        int[] array = new int[]{-1,2,1,-4};
        Arrays.sort(array);
        System.out.println(solution(array, -72));
    }

    public static int solution(int[] array, int k) {
        int closer = Integer.MIN_VALUE;
        for (int left = 0, mid = array.length - 2, right = array.length - 1; left <= mid && mid < right && left >=0;) {
            if (left == mid) {
                right--;
                mid--;
                left = 0;
                continue;
            }
            int sum = array[left] + array[mid] + array[right];
            if (sum == k) {
                return sum;
            } else if (sum < k) {
                closer = minCloser(closer, sum, k);
                left++;
            } else {
                mid--;
                left = 0;
            }
        }
        return closer == Integer.MIN_VALUE ? -1 : closer;
    }


    // current <= k
    public static int minCloser(int closer, int current, int k) {
        if (current > k) {
            return closer;
        }
        return Math.max(current, closer);
    }

    public static int maxCloser(int closer, int current, int k) {
        if (current < k) {
            return closer;
        }
        return Math.min(current, closer);
    }

    public static int closer(int closer, int current, int k) {
        return Math.abs(k - current) < Math.abs(k - closer) ? current : closer;
    }

}
