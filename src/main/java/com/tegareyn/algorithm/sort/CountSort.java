package com.tegareyn.algorithm.sort;

/**
 * 描述：计数排序
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/28 11:55
 **/
public class CountSort {
    public static int[] countSort(int[] arr) {
        int minNum=0,maxNum=0;
        // 先求出数组中的最大值和最小值
        for (int num : arr) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        // 开辟一个新数组：计数数组
        int[] count = new int[maxNum-minNum+1];

        // 遍历原数组，对应计数数组索引值++
        for(int num:arr) {
            count[num-minNum]++;
        }
        // 开始将计数数组输出
        int index=0;
        for(int i=0;i<count.length;i++) {
            while(count[i]>0) {
                arr[index++] = i;
                count[i]--;
            }
        }
        return arr;
    }

    public int[] countingSort(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length, min = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) { // 确定 min 和 max
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int[] countArr = new int[max - min + 1]; // arr 最多有 max-min+1 种数字
        for (int j : arr) { // 计数
            countArr[j - min]++; // arr[i] 的值出现一次，则 countArr[arr[i]-min] 加 1
        }

        for (int i = 1; i < countArr.length; i++) { // 变形
            countArr[i] += countArr[i - 1];
        }
        int[] sortedArr = new int[n]; // 根据 sortedArr, arr, countArr 三者关系完成 sortedArr 的输出
        for (int i = n - 1; i >= 0; i--) { // 逆序输出保持稳定性
            int countIdx = arr[i] - min; // arr[i] 元素对应 countArr 中的下标
            int sortedIdx = countArr[countIdx] - 1; // 在排序后数组中的下标
            sortedArr[sortedIdx] = arr[i]; // 在排序后数组中填入值
            countArr[countIdx]--; // countArr[countIdx] 已排序一位，下一个该位置的数的排位要靠前一位
        }
        return sortedArr;
    }

}
