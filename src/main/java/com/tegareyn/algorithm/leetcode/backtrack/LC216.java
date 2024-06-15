package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回
 * @author mocheng
 * @version 1.0
 * @see LC216
 * @since 2024/2/22 11:14
 **/
public class LC216 {

    public static void main(String[] args) {
        LC216 lc216 = new LC216();
        System.out.println(lc216.combinationSum3(4, 10));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(k, n, 1, 0, new LinkedList<>(), result);
        return result;
    }

    public void backtracking(int k, int n, int startIndex, int sum, LinkedList<Integer> path, List<List<Integer>> result) {
        for (int i = startIndex; sum < n && i <= 9 && path.size() < k; i++) {
            path.add(i);
            sum += i;
            if (path.size() == k && sum == n) {
                result.add(new ArrayList<>(path));
            } else {
                backtracking(k, n, ++startIndex, sum, path, result);
            }
            sum -= i;
            path.pollLast();
        }
    }
}
