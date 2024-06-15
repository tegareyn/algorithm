package com.tegareyn.algorithm.facecode;

import java.util.Arrays;

/**
 * @Ref LC2028
 * @Description 找出观测的缺失数据
 * @Author mocheng
 * @Since 2022/3/27 13:09
 * @Version 1.0
 **/
public class ObservedData {

    public static void main(String[] args) {

        int[] rolls = new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
        int mean = 2;
        int n = 53;
        int[] solution = solution(rolls, mean, n);
        System.out.println(Arrays.toString(solution));

    }

    private static int[] solution(int[] rolls, int mean, int n) {
        if (rolls != null && rolls.length > 0) {
            int total = 0;
            for (int i : rolls) {
                total += i;
            }
            total = mean * (n + rolls.length) - total;
            return solution(n, total);
        } else {
            return solution(n, mean * n);
        }
    }

    private static int[] solution(int n, int total) {
        int[] array = new int[n];
        if (n > 0 && total > 0) {
            int arM = total / n;
            int arS = total % n;
            //判断 余数 是否 > 0
            //  a.若有，则判断 商 是否 < 6
            //      若不小于， 则返回 空
            //      若小于，改变 arS 位的值 为arM+1
            //  b.若没有，则判断商是否 > 6
            //      若大于6，则返回 空
            //      若不大于，则每位值 为 arM
            if (arM <= 0 || (arS > 0 && arM >= 6) || (arS == 0 && arM > 6)) {
                return new int[0];
            }
            for (int i = 0; i < n; i++) {
                // 长度为10， 改变3位， 即从 10-1-3+1 = 7 的下标开始变更
                array[i] = arM + (i >= n - arS ? 1 : 0);
            }
        } else {
            return new int[0];
        }
        return array;
    }

}
