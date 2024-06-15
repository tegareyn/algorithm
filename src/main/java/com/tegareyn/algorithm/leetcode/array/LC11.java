package com.tegareyn.algorithm.leetcode.array;

/**
 * 描述：盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量
 *
 * @author mocheng
 * @version 1.0
 * @see LC11
 * @since 2024/2/29 14:11
 **/
public class LC11 {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,18,17,6};
        System.out.println(solution(array));
    }

    public static int solution(int[] height) {
        int maxArea = 0;
        for (int left = 0, right = height.length - 1; left < right;) {
            int high = Math.min(height[left], height[right]);
            int wide = right - left;
            int area = high * wide;
            maxArea = Math.max(maxArea, area);
            // 较小的那格向内移动一格
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
