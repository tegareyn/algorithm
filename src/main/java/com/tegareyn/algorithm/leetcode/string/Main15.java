package com.tegareyn.algorithm.leetcode.string;

/**
 * @ClassName Main15
 * @Description 反转字符串中的单词
 * @Author mocheng
 * @Since 2022/11/27 13:32
 * @Version 1.0
 **/
public class Main15 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        int left=0,right;
        char[] line = s.toCharArray();
        for(int i=0; i<line.length; i++) {
            if (' '== line[i] || i == line.length - 1) {
                // 重置右指针
                right = i == line.length - 1 ? i : i-1;
                // 反转
                while (left < right) {
                    char tmp = line[left];
                    line[left++] = line[right];
                    line[right--] = tmp;
                }
                // 重置左指针
                left = i+1;
            }
        }
        return new String(line);
    }

}
