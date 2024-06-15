package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案
 * @author mocheng
 * @version 1.0
 * @see LC77_4
 * @since 2024/2/22 10:42
 **/
public class LC77_4 {


    public static void main(String[] args) {
        LC77_4 lc77_4 = new LC77_4();
        System.out.println(lc77_4.combine(5, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTracing(n, k, 0, new LinkedList<>(), result);
        return result;
    }

    public void backTracing(int n, int k, int startIndex, LinkedList<Integer> path, List<List<Integer>> result) {
        for (int i = startIndex; i < n && path.size() < k; i++) {
            path.add(i+1);
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
            } else {
                backTracing(n, k, ++startIndex, path, result);
            }
            path.pollLast();
        }
    }
}
