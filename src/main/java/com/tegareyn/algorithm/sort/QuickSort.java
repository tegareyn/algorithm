package com.tegareyn.algorithm.sort;


import static com.tegareyn.algorithm.utils.SortUtil.swap;

/**
 * 描述：快速排序
 *
 * @author mocheng
 * @version 1.0
 * @since 2021/11/18 22:21
 **/
public class QuickSort {

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);//将数组按基准值分区，大于基准值的放右边，小于的放左边
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }
    //13,10,5,66,3,16,18,5,3,22,27
    private static int partition(int[] arr, int left, int right) {
        // 选一个值做基准值
        int pivotValue = arr[left];//13
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < pivotValue) {//比较得出较小值的下标
                swap(arr, i, index);//将较小的值和可交换的下标的值进行交换
                index++;//记录下次可替换的下标
            }
        }
        //13 10 5 3 66 13 16 18
        swap(arr, left, index - 1);//将基准值与比较结束后的(基准值)左边的最大值进行替换
//        printArray("快排分区", arr);
        return index - 1;
    }

    public static void quickSort1(int[] arr,int left,int right) {
        if(left>right)
            return;
        int pivot=arr[left];
        int i=left;
        int j=right;
        while(i!=j) {
            while (i<j && arr[j]>=pivot)
                j--;
            while(i<j && arr[i]<=pivot)
                i++;
            if(i<j) {
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        arr[left]=arr[i];
        arr[i]=pivot;

        quickSort1(arr,left,i-1);
        quickSort1(arr,i+1,right);
    }

}
