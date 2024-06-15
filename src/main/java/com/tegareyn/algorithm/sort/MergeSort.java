package com.tegareyn.algorithm.sort;

import static com.tegareyn.algorithm.utils.SortUtil.swap;

/**
 * 描述：归并排序
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/3/15 15:26
 **/
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    // 非原地合并
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++) {
            arr[m] = temp[m];
        }
    }


    /**
     * 自顶向下非原地合并
     */
    public int[] mergeSort1(int[] arr) {
        if (arr.length < 2) return arr;
        int[] tmpArr = new int[arr.length];
        mergeSort1(arr, tmpArr, 0, arr.length - 1);
        return arr;
    }
    // mergeSort 递归方法
    private void mergeSort1(int[] arr, int[] tmpArr, int l, int r) {
        if(l < r) {
            int c = l + (r - l) / 2;
            mergeSort1(arr, tmpArr, l, c);
            mergeSort1(arr, tmpArr, c + 1, r);
            merge(arr, tmpArr, l, c, r);
        }
    }
    // 非原地合并方法
    private void merge(int[] arr, int[] tmpArr, int l, int c, int r) {
        int lh = l, rh = c + 1, h = l; // lh: left head, rh: right head, h: tmpArr head
        while (lh <= c && rh <= r) {
            tmpArr[h++] = arr[lh] <= arr[rh] ? arr[lh++] : arr[rh++];
        }
        while (lh <= c) tmpArr[h++] = arr[lh++]; // 左半边还有剩余，加入 tmpArr 末尾
        while (rh <= r) tmpArr[h++] = arr[rh++]; // 右半边还有剩余，加入 tmpArr 末尾
        for(; l <= r; l++) arr[l] = tmpArr[l]; // 将 tmpArr 拷回 arr 中
    }


    /**
     * 自顶向下原地合并
     * */
    public int[] mergeSort2(int[] arr) {
        if (arr.length < 2) return arr;
        mergeSort2(arr, 0, arr.length - 1);
        return arr;
    }
    // mergeSort 递归方法
    private void mergeSort2(int[] arr, int l, int r) {
        if(l < r) {
            int c = l + (r  - l) / 2;
            mergeSort2(arr, l, c);
            mergeSort2(arr, c + 1, r);
            merge2(arr, l, c, r);
        }
    }
    // 原地归并（手摇算法）
    private void merge2(int[] arr, int l, int c, int r) {
        int i = l, j = c + 1; // #1
        while(i < j && j <= r) {
            while(i < j && arr[i] <= arr[j]) i++; // #2
            int index = j; // #3
            while(j <= r && arr[j] < arr[i]) j++; // #4 注意是 arr[j] < arr[i]，即找到j使得arr[j] 为第一个大于等于 arr[i]值
            exchange(arr, i, index - 1, j - 1); // #5
        }
    }
    // 三次翻转实现交换
    private void exchange(int[] arr, int l, int c, int r) {
        reverse(arr, l, c);
        reverse(arr, c + 1, r);
        reverse(arr, l, r);
    }
    // 原地翻转
    private void reverse(int[] arr, int l, int r) {
        while(l < r) {
            swap(arr, l++, r--);
        }
    }



}
