package com.tegareyn.algorithm.facecode;

import java.util.Arrays;

/**
 * 描述：1、给定一个正整数数组，检查数组中是否存在满足规则X=Y+2Z的数字组合（用例保证最多只有一组解）。
 * 说明：数组元素可重复，但每个元素只能在结果算式中使用一次。
 * 如：数组成员为[0,0,1,5],0出现2次是允许的，但结果0=0+2*0虽然满足规则但不匀速，因为算式中使用了3个0.
 *
 * @author mocheng
 * @version 1.0
 * @see UniqueSolver
 * @since 2024/2/28 18:17
 **/
public class UniqueSolver {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 0};
        System.out.println(Math.pow(2, 3));
        Arrays.sort(array);
        System.out.println(Arrays.toString(solve(array)));
    }

    public static int[] solve(int[] array) {
        for (int left = 0, right = array.length - 2, aim = array.length - 1; left <= right;) {
            if (left == right) {
                left = 0;
                right--;
                aim--;
                continue;
            }
            if (array[aim] == array[right] + (int)Math.pow(2, array[left])) {
                return new int[]{array[aim], array[right], array[left]};
            } else if (array[aim] > array[right] + (int)Math.pow(2, array[left])) {
                if (array[aim] == (int)Math.pow(2, array[right]) + array[left]) {
                    return new int[]{array[aim], array[left], array[right]};
                }
                left++;
            } else {
                right--;
                left = 0;
            }
        }
        return null;
    }

}
