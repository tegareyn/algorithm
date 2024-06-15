package com.tegareyn.algorithm.facecode;

/**
 * 描述：最长子字符串的长度
 * 给你一个字符串s,字符串s首尾相连成一个环形,请你在环中找出'o'字符出现了偶数次最长子字符串的长度
 *
 * @author mocheng
 * @version 1.0
 * @see MaxLengthOfChildString
 * @since 2024/1/24 11:06
 **/
public class MaxLengthOfChildString {

    public static void main(String[] args) {
        String line = "abolololloo";
        char aim = 'o';
        System.out.println(solution(line, aim));
    }

    public static int solution(String line, char aim) {
        int max = -1;
        char[] array = line.toCharArray();
        for (int i = 0; i < array.length - 1; i++) {
            int right = i + 1;
            int aimCount = 0;
            int length = 1;
            if (array[i] == aim) {
                aimCount++;
            }
            while (right != i) {
                length++;
                if (array[right] == aim) {
                    ++aimCount;
                }
                if (aimCount != 0 && aimCount % 2 == 0) {
                    max = Math.max(max, length);
                }
                right = right < (array.length - 1) ? ++right : 0;
            }
        }
        return max;
    }

}
