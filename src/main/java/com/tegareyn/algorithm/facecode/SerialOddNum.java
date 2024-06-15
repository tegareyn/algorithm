package com.tegareyn.algorithm.facecode;

/**
 * 描述：三个连续数字为奇数
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/14 16:56
 **/
public class SerialOddNum {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 23};
        System.out.println(threeConsecutiveOdds(nums));
    }
    public static boolean threeConsecutiveOdds(int[] arr) {
        if(arr == null || arr.length < 3) {
            return false;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            boolean flag = true;
            for (int j = i; j < i + 3; j++) {
                if (arr[j] % 2 == 0) {
                    i = j;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
