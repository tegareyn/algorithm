package com.tegareyn.algorithm.facecode;

import com.tegareyn.algorithm.utils.NumUtil;
import com.tegareyn.algorithm.utils.StringUtil;


/**
 * 描述：回文素数
 * 给定一个整数N,生成不大于N的所有回文素数,
 * 输出的第一个数字是素数的个数,之后是生成的素数,素数按从小到大的顺序排列,
 * 如果没有生成任何素数,则输出0.
 * 如果一个数从左往右读与从右往左读是一样的,那么这个数是回文数,例如101是回文数
 *
 * @author mocheng
 * @version 1.0
 * @see PalindromePrimeNumber
 * @since 2024/1/24 17:26
 **/
public class PalindromePrimeNumber {


    public static void main(String[] args) {
        int num = 50;
        System.out.println(solution(num));
    }

    public static String solution(int num) {
        StringBuilder result = new StringBuilder("");
        int count = 0;
        if (num < 2) {
            return count + "";
        }
        for (int i = 2 ; i <= num; i++) {
            if (NumUtil.isPrime(i)) {
                if (StringUtil.isPalindrome(i + "")) {
                    result.append(",").append(i);
                    count++;
                }
            }
        }
        return count + result.toString();
    }

}
