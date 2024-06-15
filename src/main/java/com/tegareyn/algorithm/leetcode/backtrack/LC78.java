package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @author mocheng
 * @version 1.0
 * @see LC78
 * @since 2024/3/15 09:43
 **/
public class LC78 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3 ,4};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (null == nums || nums.length ==0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        for (int i = 0; i < nums.length; i++) {
            backtrace(nums, i, new LinkedList<>(), result);
        }
        return result;
    }


    public static void backtrace(int[] nums, int index, LinkedList<Integer> path, List<List<Integer>> result) {
        if (index >= nums.length) {
            return;
        }
        path.add(nums[index]);
        result.add(new ArrayList<>(path));
        backtrace(nums, index+1, path, result);
        for (int i = index + 2; i < nums.length; i++) {
            backtrace(nums, i, path, result);
        }


        path.removeLast();
    }
}
