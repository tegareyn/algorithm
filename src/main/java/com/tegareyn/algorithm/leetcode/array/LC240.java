package com.tegareyn.algorithm.leetcode.array;

/**
 * 描述：搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 *
 * @author mocheng
 * @version 1.0
 * @see LC240
 * @since 2024/3/2 10:23
 **/
public class LC240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println(searchMatrix(matrix, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            // 按行分割 二分查找
            if (bSearch(ints, target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean bSearch(int[] matrix, int left, int right, int target) {
        int mid = left + (right - left)/2;
        if (matrix[mid] == target) {
            return true;
        } else if (matrix[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        if (left > right) {
            return false;
        }
        return bSearch(matrix, left, right, target);
    }

    private static boolean bSearch(int[] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
