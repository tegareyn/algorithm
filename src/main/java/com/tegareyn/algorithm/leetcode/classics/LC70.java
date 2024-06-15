package com.tegareyn.algorithm.leetcode.classics;

/**
 * @Ref LC70
 * @Description 爬楼梯
 * @Author Spindrift
 * @Since 2022/12/4 15:55
 * @Version 1.0
 **/
public class LC70 {
    public static void main(String[] args) {
        System.out.println(climbStairs2(2));
    }

    /**
     * f(0) = 1;
     * f(1) = 1;
     * f(2) = 2;
     * f(3) = f(1) + f(2) = 3;
     * f(4) = f(3) + f(2) = 5;
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] way = new int[n + 1];
        way[0] = 1;
        way[1] = 1;
        int i = 2;
        while (i <= n) {
            way[i] = way[i - 1] + way[i++ - 2]; // f(x) = f(x-1) + f(x-2);
        }
        return way[n];
    }

    public static int climbStairs2(int n) {
        if (n < 2) {
            return 1;
        }
        int w0 = 1, w1 = 1, w2 = 0;
        int i = 2;
        while (i <= n) {
            w2 = w0 + w1; // f(x) = f(x-1) + f(x-2);
            w0 ^= w1 ^ w0;
            w1 = w2;
            i++;
        }
        return w2;
    }


}
