package com.tegareyn.algorithm.sort;

import java.util.Arrays;

import static com.tegareyn.algorithm.sort.BubbleSort.bubbleSort;
import static com.tegareyn.algorithm.sort.QuickSort.quickSort;
import static com.tegareyn.algorithm.sort.SelectSort.selectSort;

/**
 * @Description 请描述类的业务用途
 * @Author mocheng
 * @Since 2021/10/31 20:26
 * @Version 1.0
 **/
public class SortTest {
    private static final int[] array = new int[]{15,2,13,10,5,66,3,16,18,5,3,22,27};
    public static void main(String[] args) {

        int[] arraySort = Arrays.copyOf(array, array.length);
        Arrays.sort(arraySort);//算法：快排
        printArray("Arrays.sort，快排后", arraySort);

        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        bubbleSort(bubbleSortArray);
        printArray("冒泡排序后", bubbleSortArray);

        int[] selectSortArray = Arrays.copyOf(array, array.length);
        selectSort(selectSortArray);
        printArray("选择排序后", selectSortArray);

        int[] quickSortArray = Arrays.copyOf(array, array.length);
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        printArray("快速排序后", quickSortArray);
    }

    public static void printArray(String info, int[] arr) {
        System.out.print(info + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length-1 ? "": ", "));
        }
        System.out.println();
    }













}
