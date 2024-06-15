package com.tegareyn.algorithm.leetcode.string;


/**
 * @Description 最长不重复连续字串的长度
 * @Author mocheng
 * @Since 2022/11/19 18:34
 * @Version 1.0
 **/
public class Main10 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // asic码表总长度128
        int[] exist = new int[128];
        for (int i = 0; i < 128; i++) {
            exist[i] = -1;
        }
        int max = 0; // 记录最大长度
        int left = 0;// 字符串的窗口左边的index
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 字符c
            left = Math.max(left, exist[c] + 1); // 改变窗口左边下标
            max = Math.max(max, i - left + 1);
            exist[c] = i;
        }
        return max;
    }



}
