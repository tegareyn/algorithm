package com.tegareyn.algorithm.facecode;

/**
 * 描述：滑动窗口最大和
 * 有一个N个整数的数组,和一个长度为M的窗口,窗口从数组内的第一个数开始滑动直到窗口不能滑动为止,
 * 每次窗口滑动产生一个窗口和。求窗口滑动产生的所有窗口和的最大值
 *
 * @author mocheng
 * @version 1.0
 * @see MaxSumOfSlipWindow
 * @since 2024/1/24 10:45
 **/
public class MaxSumOfSlipWindow {

    public static void main(String[] args) {
        int[] array = new int[]{-21,2,3};
        int m = 1;
        System.out.println(solution(array, m));
    }

    public static int solution(int[] array, int m) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i <= array.length - m; i++) {
            if (i == 0) {
                for (int j = 0; j < m; j++) {
                    sum += array[j];
                }
                max = sum;
                continue;
            }
            sum -= array[i - 1];
            sum += array[i + m - 1];
            max = Math.max(max, sum);
        }
        return max;
    }

}
