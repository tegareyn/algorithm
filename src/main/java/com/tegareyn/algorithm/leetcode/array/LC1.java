package com.tegareyn.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：两数之和
 * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案
 *
 * @author mocheng
 * @version 1.0
 * @see LC1
 * @since 2024/1/8 15:52
 **/
public class LC1 {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (result.containsKey(target - num)) {
                return new int[]{result.get(target - num), i};
            }
            result.put(num, i);
        }
        return new int[]{};
    }

}
