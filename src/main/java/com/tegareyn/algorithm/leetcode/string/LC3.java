package com.tegareyn.algorithm.leetcode.string;

/**
 * 描述：无重复字符的最长子串
 *
 * @author mocheng
 * @version 1.0
 * @see LC3
 * @since 2024/2/29 16:33
 **/
public class LC3 {

    public static void main(String[] args) {
        String line = "abba";
        System.out.println(solution(line));
    }

    public static int solution(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < 128; i++) {
            arr[i] = -1;
        }
        int max = 0;
        int left = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i< array.length; i++) {
            left = Math.max(left, arr[array[i]] + 1);
            max = Math.max(max, i - left + 1);
            arr[array[i]] = i;
        }
        return max;
    }
}
