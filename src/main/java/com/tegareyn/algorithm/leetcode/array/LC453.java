package com.tegareyn.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 描述：最小操作次数使数组元素相等
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * 每次操作将会使 n - 1 个元素增加 1  等效于 每次操作将会使 1 个元素减少 1
 *
 * @author mocheng
 * @version 1.0
 * @see LC453
 * @since 2024/1/30 16:27
 **/
public class LC453 {

    public static int solution(int[] nums) {
        int result = 0;
        int min = Arrays.stream(nums).min().getAsInt();
        for (int num : nums) {
            result += (num - min);
        }
        return result;
    }

}
