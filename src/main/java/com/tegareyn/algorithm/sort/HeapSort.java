package com.tegareyn.algorithm.sort;

import static com.tegareyn.algorithm.utils.SortUtil.swap;

/**
 * 描述：堆排序
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/28 11:55
 **/
public class HeapSort {
    // 堆排序
    public int[] heapSort(int[] arr) {
        if (arr.length < 2) return arr;
        heapify(arr, arr.length - 1); // 构建大顶堆
        for (int i = arr.length - 1; i > 0; i--) { // i > 0 即可，无需写成 i >= 0，当 N-1 个元素排序时，最后一个元素也已排序
            swap(arr, 0, i); // 交换堆顶和当前未排序部分最后一个元素
            siftDown(arr, 0, i - 1); // i - 1 是未排序部分最后一个元素下标，传入此参数确保下滤不会超过此范围
        }
        return arr;
    }

    // 堆化方法
    private void heapify(int[] arr, int r) {
        for (int hole = (r - 1) / 2; hole >= 0; hole--) { // (r - 1) / 2 为最后一个叶子节点的父节点下标
            siftDown(arr, hole, r);
        }
    }

    // 下滤方法
    private void siftDown(int[] arr, int hole, int r) {
        int target = arr[hole], child = hole * 2 + 1; // target 是要下滤的结点的值
        while(child <= r) { // child 最大为 r
            if (child < r && arr[child + 1] > arr[child]) child++; // #1
            if (arr[child] > target) { // 若 child 大于 target
                arr[hole] = arr[child]; // 则 arr[child] 上移到下标 hole 处
                hole = child; // hole 更新为 child (下滤)
                child = hole * 2 + 1; // 更新 child ，也可以写成 child = child * 2 + 1
            } else break; // 若 arr[child] <= target ，说明下标 hole 处已经满足堆序，退出 while
        }
        arr[hole] = target; // 将 target 填 入hole 中
    }

}
