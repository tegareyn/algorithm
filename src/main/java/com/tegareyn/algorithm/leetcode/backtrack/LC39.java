package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * @author mocheng
 * @version 1.0
 * @see LC39
 * @since 2024/3/14 13:08
 **/
public class LC39 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target, 0, new LinkedList<>(), result);
        return result;
    }


    public static void backtracking(int[] candidates, int target, int begin, LinkedList<Integer> path, List<List<Integer>> result) {
        if (0 == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            path.add(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            backtracking(candidates, target - candidates[i], i, path, result);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }
}
