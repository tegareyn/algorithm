package com.tegareyn.algorithm.facecode;

/**
 * 描述：整数对最小和
 * 给定两个整数数组array1, array2 ,数组元素按升序排列,
 * 假设从arayt, array2中分别取出一个元素可构成一对元素,
 * 现在需要取出对元素,并对取出的所有元素 求和,计算和的最小值
 *
 * @author mocheng
 * @version 1.0
 * @see IntPairMinSum
 * @since 2024/1/24 14:51
 **/
public class IntPairMinSum {

    public static void main(String[] args) {
        int[] array1 = new int[]{1,1,2};
        int[] array2 = new int[]{1,2,3};
        int k = 2;
        System.out.println(Math.min(solution(array1, array2, k), solution(array2, array1, k)));
    }
    public static int solution(int[] array1, int[] array2, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array1.length; i++) {
            min = Math.min(min, resolve(i, array1, array2, k));
        }
        return min;
    }

    public static int resolve(int start, int[] array1, int[] array2, int k) {
        int sum = 0;
        int count = 0;
        for (int i = start; i < array1.length; i++) {
            for (int value : array2) {
                sum += (array1[i] + value);
                count++;
                if (count == k) {
                    System.out.println(sum);
                    return sum;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
