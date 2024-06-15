package com.tegareyn.algorithm.test;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see MathTest
 * @since 2024/3/22 12:23
 **/
public class MathTest {

    public static void main(String[] args) {
        System.out.println(7 & 2); // 二进制位运算： 与 运算； 0111 & 0010 = 0010  ===> 2
        System.out.println(3 << 1); // 无符号右移：0011 << 1 = 0110 ===> 6
        System.out.println(-3 << 1); // 无符号右移：1000 0000 0000 0000 0000 0000 0000 0011 << 1 = 0110 ===> 6
        System.out.println(-3 >>> 1);
    }
}
