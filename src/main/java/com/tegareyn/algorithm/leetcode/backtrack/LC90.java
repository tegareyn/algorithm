package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.*;

/**
 * 描述：子集II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * @author mocheng
 * @version 1.0
 * @see LC90
 * @since 2024/3/15 10:29
 **/
public class LC90 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (null == nums || nums.length ==0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            backtrace(nums, i, new LinkedList<>(), "", map, result);
        }
        return result;
    }


    public static void backtrace(int[] nums, int index, LinkedList<Integer> path, String key, Map<String, List<Integer>> map, List<List<Integer>> result){
        if (index >= nums.length) {
            return;
        }
        path.add(nums[index]);
        if (!map.containsKey(key + nums[index])) {
            ArrayList<Integer> value = new ArrayList<>(path);
            map.put(key + nums[index], value);
            result.add(value);
        }
        backtrace(nums, index+1, path, key + nums[index], map, result);
        for (int i = index + 2; i < nums.length; i++) {
            backtrace(nums, i, path, key + nums[index], map, result);
        }
        path.removeLast();
    }
}
