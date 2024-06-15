package com.tegareyn.algorithm.leetcode.classics;

import java.util.LinkedList;
import java.util.List;

/**
 * @Ref LC46
 * @Description 全排列
 * @Author Spindrift
 * @Since 2022/12/3 22:11
 * @Version 1.0
 **/
public class LC46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        System.out.println(permute(nums));
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(result, path, nums);
        return result;
    }

    public static void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            backtracking(result, path, nums);
            // backtrack(回溯)：状态撤销，回到最初
            path.removeLast();
        }
    }

}
