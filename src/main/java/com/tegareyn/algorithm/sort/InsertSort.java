package com.tegareyn.algorithm.sort;


import java.util.Arrays;

/**
 * 描述： 插入排序
 * 步骤：
 * 1.将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/3/15 15:26
 **/
public class InsertSort {

    // 折半插入排序
    public int[] insertSortBinary(int[] arr) {
        if (arr.length < 2) return arr;
        // n - 1 轮次执行
        for (int i = 1; i < arr.length; i++) {
            // 通过二分查找得到插入位置
            int target = arr[i];
            int pos = Arrays.binarySearch(arr, 0, i - 1, target);// 从有序序列中找到插入位置
            for (int j = i; j > pos; j--) { // 将插入位置pos后 的 元素 进行移动
                arr[j] = arr[j - 1];
            }
            arr[pos] = target; // 插入
        }
        return arr;
    }


    /*插入排序：从小到大排序，类似于打扑克牌*/
    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int now = arr[i]; //刚抓的手牌
            int j = i - 1; //现有最后一张手牌的位置
            //刚抓的手牌小于手上现有的
            while (j >= 0 && now < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = now;
        }
    }

}
