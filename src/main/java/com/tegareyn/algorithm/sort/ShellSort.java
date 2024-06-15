package com.tegareyn.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：希尔排序
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/28 11:52
 **/
public class ShellSort {

    // 希尔排序：采用Shell增量 N / 2^k
    public int[] shellSortShell(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) { // gap 初始为 n/2，缩小gap直到1
            for(int start = 0; start < gap; start++) { // 步长增量是gap，当前增量下需要对gap组序列进行简单插入排序
                for (int i = start + gap; i < n; i += gap) { // 此for及下一个for对当前增量序列执行简单插入排序
                    int target = arr[i], j = i - gap;
                    for (; j >= 0; j -= gap) {
                        if (target < arr[j]) arr[j + gap] = arr[j];
                        else break;
                    }
                    arr[j + gap] = target;
                }
            }
        }
        return arr;
    }


    // 希尔排序： 采用Hibbard增量 {1, 3, 7, 15,...}
    public int[] shellSortHibbard(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length, gap = 1;
        while (gap < n / 2) gap = gap * 2 + 1; // 初始化gap (Hibbard增量序列)
        for (; gap > 0; gap /= 2) { // 缩小gap直到1
            for(int start = 0; start < gap; start++) { // 步长增量是gap，当前增量下需要对gap组序列进行简单插入排序
                for (int i = start + gap; i < arr.length; i += gap) { // 此for及下一个for对当前增量序列执行简单插入排序
                    int target = arr[i], j = i - gap;
                    for (; j >= 0; j -= gap) {
                        if (target < arr[j]) arr[j + gap] = arr[j];
                        else break;
                    }
                    arr[j + gap] = target;
                }
            }
        }
        return arr;
    }


    // 希尔排序： 采用Knuth增量 {1, 4, 13, 40,...}
    public int[] shellSortKnuth(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length, gap = 1;
        while (gap < n / 3) gap = gap * 3 + 1; // 初始化gap (Knuth增量序列)
        for (; gap > 0; gap /= 3) { // 缩小gap直到1
            for(int start = 0; start < gap; start++) { // 步长增量是gap，当前增量下需要对gap组序列进行简单插入排序
                for (int i = start + gap; i < arr.length; i += gap) { // 此for及下一个for对当前增量序列执行简单插入排序
                    int target = arr[i], j = i - gap;
                    for (; j >= 0; j -= gap) {
                        if (target < arr[j]) arr[j + gap] = arr[j];
                        else break;
                    }
                    arr[j + gap] = target;
                }
            }
        }
        return arr;
    }


    public int[] shellSortSedgewick(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length, gap = 1;
        List<Integer> gaps = new ArrayList<>();
        gaps.add(gap);
        for(int k = 1; gap < n; k++){ // 计算增量序列
            gap = (int) (Math.pow(4, k) + 3 * Math.pow(2, k - 1) + 1);
            gaps.add(gap);
        }
        for (int idx = gaps.size() - 1; idx >= 0; --idx) { // 缩小 gap 直到 1
            gap = gaps.get(idx);
            for(int start = 0; start < gap; start++) { // 步长增量是 gap ，当前增量下需要对 gap 组序列进行简单插入排序
                for (int i = start + gap; i < n; i += gap) { // 此 for 及下一个 for 对当前增量序列执行简单插入排序
                    int target = arr[i], j = i - gap;
                    for (; j >= 0; j -= gap) {
                        if (target < arr[j]) arr[j + gap] = arr[j];
                        else break;
                    }
                    arr[j + gap] = target;
                }
            }
        }
        return arr;
    }

}
