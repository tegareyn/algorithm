package com.tegareyn.algorithm.leetcode.string;

/**
 * @ClassName Main01
 * @Description 寻找第一个错误的版本
 * @Author mocheng
 * @Since 2022/11/11 15:20
 * @Version 1.0
 **/
public class LC278 {


    public static int findFirstBadVersion(int versionNum) {
        int left = 1;
        int right = versionNum;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid; // 在left和mid中
            } else {
                left = mid + 1;// 在mid + 1 和right中
            }
        }
        return left;
    }

    //内部函数
    public static boolean isBadVersion(int versionNO) {
        return versionNO / 2 == 0;
    }



}
