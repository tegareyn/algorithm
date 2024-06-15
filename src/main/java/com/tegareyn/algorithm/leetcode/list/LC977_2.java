package com.tegareyn.algorithm.leetcode.list;

/**
 * @Ref LCxx或NCxx
 * @Description 有序数组的平方
 * @Author Spindrift
 * @Since 2023/4/10 21:26
 * @Version 1.0
 **/
public class LC977_2 {

    public static int[] solution(int[] array) {
        int index = 0;
        for (int i = 0; i< array.length; i++) {
            if (array[i] >= 0) {
                index = i;
                break;
            }
        }
        int right = index;
        int left = index - 1;
        int[] result = new int[array.length];
        int move = 0;
        while (left >= 0 || right < array.length) {
            if (left < 0) {
                result[move] = array[right] * array[right++];
            } else if (right >= array.length) {
                result[move] = array[left] * array[left--];
            } else {
                int l = array[left] * array[left];
                int r = array[right] * array[right];
                if (l > r) {
                    result[move] = r;
                    right++;
                } else if (l < r) {
                    result[move] = l;
                    right++;
                } else {
                    result[move++] = r;
                    result[move] = l;
                    right++;
                    right++;
                }
                move++;
            }
        }
        return result;
    }

}
