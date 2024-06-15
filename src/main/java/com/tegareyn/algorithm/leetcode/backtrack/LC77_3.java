package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：组合
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/8 12:15
 **/
public class LC77_3 {


    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(4, 2, 1, result, new LinkedList<>());
        System.out.println(result);
    }

    public static void backtracking(int n, int k, int start, List<List<Integer>> result, LinkedList<Integer> combiner) {
        if (combiner.size() == k) {
            result.add(new ArrayList<>(combiner));
            return;
        }
        for (int i = start; i <= n; i++) {
            combiner.add(i);
            backtracking(n, k, ++start, result, combiner);
            combiner.removeLast();
        }
    }
}
