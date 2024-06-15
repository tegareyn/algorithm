package com.tegareyn.algorithm.leetcode.classics;

/**
 * 描述：斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
 *
 * @author mocheng
 * @version 1.0
 * @see LC509
 * @since 2024/2/29 10:52
 **/
public class LC509 {

    public static void main(String[] args) {
        System.out.println(f(6));
    }

    public static int f(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return f(n - 1) + f( n - 2);
        }
    }
}
