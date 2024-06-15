package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Ref LC784
 * @Description 字母大小写全排列
 * @Author Spindrift
 * @Since 2022/12/4 13:05
 * @Version 1.0
 **/
public class LC784 {

    public static void main(String[] args) {
        String s = "3z4";
        char a = 'A';
        a^=32;
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new LinkedList<>();
        res.add(s);
        dfs(res, s.toCharArray(), 0);
        return res;
    }

    public static void dfs(List<String> res, char[] s, int startIndex) {
        for (int i = startIndex; i < s.length; i++) {
            if (!Character.isLetter(s[i])) {
                continue;
            }
            s[i]^=32;
            res.add(new String(s));
            dfs(res, s, i + 1);
            s[i]^=32;
        }
    }

    // index 一定不会超限
    private static void turnCase(char[] s, int index) {
        char c = s[index];
        s[index] = ('a' <= c && c <= 'z') ? (char)(c - 32) :(char)(c + 32);// 与s[index]^=32等同
    }

}
