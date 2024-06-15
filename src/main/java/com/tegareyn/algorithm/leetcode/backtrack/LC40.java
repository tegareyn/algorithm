package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：组合总和 II
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * @author mocheng
 * @version 1.0
 * @see LC40
 * @since 2024/3/14 15:36
 **/
public class LC40 {

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target, 0, new LinkedList<>(), result);
        return result;
    }

    public static void backtracking(int[] candidates, int target, int begin, LinkedList<Integer> path, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) { // 贼牛逼的想法
                continue;
            }
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1, path, result);
            path.removeLast();
        }
    }
}
