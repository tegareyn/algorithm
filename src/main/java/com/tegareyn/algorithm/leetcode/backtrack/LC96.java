package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：复原 IP 地址
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是有效IP地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是无效IP地址。
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * @author mocheng
 * @version 1.0
 * @see LC96
 * @since 2024/3/18 12:49
 **/
public class LC96 {

    public static void main(String[] args) {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking(s, 0, 1, new LinkedList<>(), result);
        return result;
    }


    public static void backtracking(String s, int begin, int end, LinkedList<String> path, List<String> result) {
        if (end > s.length()) {
            return;
        }

        if (path.size() == 3) {
            end = s.length();
        }
        String num = s.substring(begin, end);
        if (num.length() > 3 || Integer.parseInt(num) > 255 || (num.length() > 1 && num.startsWith("0"))) {
            return;
        }
            path.add(num);
            if (path.size() == 4 && end == s.length()) {
                result.add(String.join(".", path));
            }
            backtracking(s, end, end + 1, path, result);
            path.removeLast();
            backtracking(s, begin, end + 1, path, result);

    }

}
