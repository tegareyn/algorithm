package com.tegareyn.algorithm.leetcode.array;

/**
 * 描述：买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润
 *
 * @author mocheng
 * @version 1.0
 * @see LC122
 * @since 2024/3/1 14:46
 **/
public class LC122 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {7,1,5,3,6,4},
                {1,2,3,4,5},
                {7,6,4,3,1},
                {3,2,6,5,0,3}
        };
        for (int[] arr : array) {
            System.out.println(solution2(arr));
        }
    }

    public static int solution(int[] prices) {
        int cur, next;
        int sum = 0;
        int in = -1;
        if (prices == null || prices.length < 2) {
            return sum;
        }
        cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            next = prices[i];
            if (next < cur) {
                // 卖出
                sum += (in == -1) ? 0 : cur - in;
                in = -1;
            } else if (in == -1 && next > cur) {
                // 买入
                in = cur;
            }
            cur = next;
        }
        if (in != -1) {
            sum += prices[prices.length - 1] - in;
        }
        return sum;
    }

    public static int solution2(int[] prices) {
        int sum = 0;
        if (prices == null || prices.length < 2) {
            return sum;
        }

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                sum += diff;
            }
        }
        return sum;
    }

}
