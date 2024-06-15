package com.tegareyn.algorithm.leetcode.backtrack;

import com.tegareyn.algorithm.utils.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author mocheng
 * @version 1.0
 * @see LC46
 * @since 2024/3/19 14:29
 **/
public class LC46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            backtracking(nums, i, result);
        }
        System.out.println(result.size());
        return result;
    }

    public static void backtracking(int[] nums, int used, List<List<Integer>> result) {
        if (used >= nums.length) {
            return;
        }
        if (result.size() == 0) {
            ArrayList<Integer> e = new ArrayList<>();
            e.add(nums[used]);
            result.add(e);
        } else {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> order = result.get(i);
                order.add(nums[used]);
                for (int j = 0; j < order.size() - 1; j++) {
                    List<Integer> change = new ArrayList<>(order);
                    Integer right = change.get(change.size() - 1);
                    change.set(change.size() - 1, change.get(j));
                    change.set(j, right);
                    System.out.println("used: " + used + "size: " + order.size()+ ", change:" + change);
                    result.add(change);
                }
            }
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking2(nums, 0, used, new LinkedList<>(), result);
        return result;
    }

    public static void backtracking2(int[] nums, int begin, boolean[] used, LinkedList<Integer> path, List<List<Integer>> result) {
        if(begin >= nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            System.out.println(StringUtil.tabByLevel(begin) + "i: " + i + ", add:" + path + ", used: " + Arrays.toString(used));
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
            }
            backtracking2(nums, begin + 1, used, path, result);
            path.removeLast();
            used[i] = false;
            System.out.println(StringUtil.tabByLevel(begin) + "i: " + i + ", rem:" + path + ", used: " + Arrays.toString(used));
        }
    }

    public static String tabByLevel(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
