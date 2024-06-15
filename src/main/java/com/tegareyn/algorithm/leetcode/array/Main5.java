package com.tegareyn.algorithm.leetcode.array;

/**
 * @ClassName Main5
 * @Description 将数组向右旋转k次
 * @Author mocheng
 * @Since 2022/11/16 13:34
 * @Version 1.0
 **/
public class Main5 {

    public static void main(String[] args) {

    }


    public static void solution(int[] arr, int k) {
//        if (k < arr.length) {
//
//        } else if (k == arr.length) {
//            return;
//        } else {
//            k = k%arr.length;
//        }
        k = k%arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

}
