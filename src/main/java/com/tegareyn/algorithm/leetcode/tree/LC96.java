package com.tegareyn.algorithm.leetcode.tree;

/**
 * 描述：不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数
 * @author mocheng
 * @version 1.0
 * @see LC96
 * @since 2024/2/29 17:15
 **/
public class LC96 {

    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static int solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (dp(i - 1) * dp(n - i));
        }
        return sum;
    }

    public static int dp(int n) {
        if(n == 0) {
          return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return dp(n - 1) * dp(n - 2);
        }
    }
}
