package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Ref LC77
 * @Description 组合
 * @Author Spindrift
 * @Since 2022/12/3 19:11
 * @Version 1.0
 **/
public class LC77_2 {

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> result = new LinkedList<>();
        backtracking(result, new LinkedList<>(), 1, n, k);
        System.out.println(result);
    }

    public static void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int startNum, int n, int k) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int j = startNum; j <= n - (k - path.size()) + 1 // 剪枝优化
                ; j++) {
            path.add(j);
            backtracking(result, path, ++startNum, n, k);
            path.removeLast();
        }
    }

}
