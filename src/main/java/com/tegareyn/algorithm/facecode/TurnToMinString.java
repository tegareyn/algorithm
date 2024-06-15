package com.tegareyn.algorithm.facecode;

import java.util.Arrays;

/**
 * 描述：字符串变换最小字符串
 * 给定一个字符串s,最多只能进行一次变换,返回变换后能得到的最小字符串(按照字典序进行比较). 变换规则:交换字符串中任意两个不同位置的字符
 *
 * @author mocheng
 * @version 1.0
 * @see TurnToMinString
 * @since 2024/1/24 14:06
 **/
public class TurnToMinString {

    public static void main(String[] args) {
        String line = "abcdcefa";
        System.out.println(solution(line));
    }
    public static String solution(String line) {
        return findMinChars(new StringBuilder(""), line.toCharArray(), 0);
    }

    public static String findMinChars(StringBuilder pre, char[] array, int start) {
        char minChar = 123;
        int index = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < minChar) {
                minChar = array[i];
                index = i;
            }
        }
        if (start == array.length) {
            return pre.toString();
        }
        if (index > start) {
            array[start] ^= array[index];
            array[index] ^= array[start];
            array[start] ^= array[index];
            char[] chars = Arrays.copyOfRange(array, start, array.length);
            return pre.append(chars).toString();
        } else {
            return findMinChars(pre.append(array[start]), array, start + 1);
        }
    }

}
