package com.tegareyn.algorithm.utils;

/**
 * 描述：质数
 *
 * @author mocheng
 * @version 1.0
 * @see NumUtil
 * @since 2024/1/24 18:10
 **/
public class NumUtil {



    public static boolean isPrime(int num) {
        if (num < 2) return false;
        int x = (int)Math.sqrt(num);
        for (int i = 2; i <= x; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
