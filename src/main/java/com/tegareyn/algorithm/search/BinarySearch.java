package com.tegareyn.algorithm.search;

/**
 * @ClassName BinarySearch
 * @Description 二分查找
 * @Author mocheng
 * @Since 2021/11/18 22:27
 * @Version 1.0
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,6,9,12,14,22,27,33,38,41,45};
        System.out.println(solution(array, 35));
    }

    public static int solution(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[mid] > target) {
            right = mid - 1;
        } else if (array[mid] < target) {
            left = mid + 1;
        } else {
            return mid; // array[mid]
        }
        if (right < left) {
            return -1; // 没找到
        }
        return binarySearch(array, target, left, right);
    }
}
