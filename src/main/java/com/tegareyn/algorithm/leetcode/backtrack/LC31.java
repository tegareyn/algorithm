package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 * @author mocheng
 * @version 1.0
 * @see LC31
 * @since 2024/3/15 10:15
 **/
public class LC31 {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        System.out.println(partition("aabbc"));

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        splitForPalindrome(s, 0, 0, new LinkedList<>(), result);
        return result;
    }

    public static void splitForPalindrome(String s, int begin, int end, LinkedList<String> path, List<List<String>> result) {
        if (end > s.length()) {
            return;
        }
        String substring = s.substring(begin, end);
        if (isPalindrome(substring)) {
            path.add(substring);
            if (end == s.length()) {
                result.add(new ArrayList<>(path));
            }
            splitForPalindrome(s, end, end + 1, path, result);
            path.removeLast();
        }
        splitForPalindrome(s, begin, end + 1, path, result);
    }


    public static boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }
        for (int l = 0, r = s.length() - 1; l < r; l++, r-- ) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
