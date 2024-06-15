package com.tegareyn.algorithm.sort;

import static com.tegareyn.algorithm.utils.SortUtil.swap;

/**
 * 描述：选择排序
 * 步骤：
 *  1.长度为n的数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换
 *  2.第二次遍历n-2个数，找到最小的数值与第二个元素交换
 *  3.第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成
 *
 * @author mocheng
 * @version 1.0
 * @since 2021/11/18 22:22
 **/
public class SelectSort {

    public static int[] selectSort(int[] origin) {
        if (null != origin && origin.length > 1) {
            for(int start = 0; start < origin.length - 1; start ++) {
                int minIndex = start;//假设第一个位置为最小值
                //从无序列表中记录最小值的下标
                for (int select = start; select < origin.length; select++) {
                    if (origin[select] < origin[minIndex]) {
                        minIndex = select;//记录每次较小值的下标
                    }
                }
                if (minIndex != start) {//将比较后从无须列表中找到的最小值，追加在有链表表最后一个位置()
                    swap(origin, start, minIndex);
                }
            }
        }
        return origin;
    }

    public static int[] selectionSort(int[] arr) {
        if (arr.length < 2) return arr;
        for (int i = 0; i < arr.length - 1; i++) { // 当前 N-1 个元素排好后，最后一个元素无需执行，故 i < arr.length - 1
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) { // 找到本轮执行中最小的元素，将最小值下标赋值给 minIdx
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            swap(arr, i, minIdx);
        }
        return arr;
    }

    public int[] selectionSortDouble(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;
        for (int i = 0; i < n - 1 - i; i++) { // 每轮确定两个数字，因此上界也会动态变化
            int minIdx = i, maxIdx = i;
            for (int j = i + 1; j < n - i; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
                if(arr[j] > arr[maxIdx]) maxIdx = j;
            }
            if(minIdx == maxIdx) break; // 若本轮最大值等于最小值，说明未排序部分所有元素相等，无需再排序
            swap(arr, i, minIdx);
            if(maxIdx == i) maxIdx = minIdx; // 在交换 i 和 minIdx 时，有可能出现 i 即 maxIdx 的情况，此时需要修改 maxIdx 为 minIdx
            swap(arr, n - 1 - i, maxIdx);
        }
        return arr;
    }


}
