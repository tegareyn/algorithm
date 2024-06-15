package com.tegareyn.algorithm.leetcode.backtrack;

import com.tegareyn.algorithm.utils.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @author mocheng
 * @version 1.0
 * @see LC47
 * @since 2024/3/21 14:54
 **/
public class LC47 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums, 0, used, new LinkedList<>(), result);
        return result;
    }

    public static void backtracking(int[] nums, int begin, boolean[] used, LinkedList<Integer> path, List<List<Integer>> result) {
        if(begin >= nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：nums[i - 1] == nums[i]
            // 写：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            System.out.println(StringUtil.tabByLevel(begin) + "i: " + i + ", add:" + path + ", used: " + Arrays.toString(used));
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
            }
            backtracking(nums, begin + 1, used, path, result);
            path.removeLast();
            used[i] = false;
            System.out.println(StringUtil.tabByLevel(begin) + "i: " + i + ", rem:" + path + ", used: " + Arrays.toString(used));
        }
    }
}
