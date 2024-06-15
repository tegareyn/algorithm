package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述：电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author mocheng
 * @version 1.0
 * @see LC17
 * @since 2024/3/14 11:10
 **/
public class LC17 {


    public static void main(String[] args) {
        System.out.println(letterCombinations("89"));
    }

    public static List<String> letterCombinations(String digits) {
        if (null == digits || digits.trim().length() == 0) {
            return Collections.emptyList();
        }
        digits = digits.trim();
        int[] nums = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = Integer.parseInt(digits.charAt(i) + "");
        }
        List<String> result = new ArrayList<>();
        backtracking(nums, 0, new StringBuilder(), result);
        return result;
    }

    public static void backtracking(int[] nums, int index, StringBuilder path, List<String> result) {
        int num = nums[index];
        for (int i = 0; i < (num == 7 || num == 9 ? 4: 3); i++) {
            path.append((char)(3 * (num - 2) + 97 + i + (num > 7 ? 1 : 0)));
            if (index == nums.length - 1) {
                result.add(new String(path));
            } else {
                backtracking(nums, index + 1, path, result);
            }
            path.deleteCharAt(path.length() - 1);
        }
    }

}
