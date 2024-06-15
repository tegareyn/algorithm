package com.tegareyn.algorithm.leetcode.string;

/**
 * 描述：回文素数
 * 求出大于或等于 N 的最小回文素数
 *
 * 素数：如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数
 * @author mocheng
 * @version 1.0
 * @see LC866
 * @since 2024/1/29 12:43
 **/
public class LC866 {

    public static void main(String[] args) {
        System.out.println(solution(9989900));
    }

    public static int solution(int n) {
        while (true) {
            n = Math.max(n, 2);
            if (isPrime(n) && isPalindrome(n + "")) {
                return n;
            }
            n++;
            // 10^7 < n < 10^8  人工干预 跳过 10^7～10^8 之间的判断
            if (10_000_000 < n && n < 100_000_000) {
                n = 100_000_000;
            }
        }
    }

    public static boolean reverse(int N, int M) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans == M;
    }


    public static boolean isPalindrome(String sentence) {
        if (sentence == null) {
            return false;
        }
        for (int i = 0, j = sentence.length() - 1; i < sentence.length() / 2; i++, j--) {
            if (sentence.charAt(i) != sentence.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
