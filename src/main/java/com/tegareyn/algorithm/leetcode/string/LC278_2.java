package com.tegareyn.algorithm.leetcode.string;

/**
 * @Ref LC278
 * @Description 第一个错误的版本
 * @Author Spindrift
 * @Since 2023/4/3 22:01
 * @Version 1.0
 **/
public class LC278_2 {


    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int left = 0;
        int right  = n;
        int mid;
        while(left < right) {
            mid = left + (right - left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static boolean isBadVersion(int mid) {
        return false;
    }
}
