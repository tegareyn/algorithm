package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：递增子序列
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * @author mocheng
 * @version 1.0
 * @see LC491
 * @since 2024/3/18 13:19
 **/
public class LC491 {

    public static HashSet<String> dump = new HashSet<>();
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,8,8};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public static void backtracking(int[] nums, int used, LinkedList<Integer> path, List<List<Integer>> result) {
        if (used >= nums.length) {
            return;
        }
        if (path.size() == 0 || nums[used] >= path.getLast()) {
            path.add(nums[used]);
            if (path.size() > 1) {
                if (dump.add(path.toString())) {
                    result.add(new ArrayList<>(path));
                }
            }
        }

//        System.out.println("add: " + path);
        backtracking(nums, used + 1, path, result);
//        System.out.println("pre remove: " + path);
        if (path.size() > 0) {
            path.removeLast();
//            System.out.println("post remove: " + path);
        }
        if (used < nums.length - 1 && nums[used] == nums[used + 1]){
            return;
        }
        backtracking(nums, used + 1, path, result);
//        System.out.println("add new: " + path);
    }

    // [[1, 2], [1, 2, 3], [1, 2, 3, 8], [1, 2, 3, 8, 8], [1, 2, 8], [1, 2, 8, 8],
    // [1, 3], [1, 3, 8], [1, 3, 8, 8], [1, 8], [1, 8, 8],
    // [2, 3], [2, 3, 8], [2, 3, 8, 8], [2, 8], [2, 8, 8],
    // [3, 8], [3, 8, 8], [8, 8]]

}
