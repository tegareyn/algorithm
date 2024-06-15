package com.tegareyn.algorithm.facecode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName Main1
 * @Description 含有C个数字串的数组，有多少组连续下标的元素之和大于目标元素T
 * @Author mocheng
 * @Since 2022/7/28 16:48
 * @Version 1.0
 **/
public class FindContinueSequence {

    /**
     * 含有C个字符串的数组，有多少组连续下标的元素之和大于目标元素T
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            int length = Integer.parseInt(line[0]);
            int target = Integer.parseInt(line[1]);
            int num = 0;
            List<Integer> array = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            if (array.size() == length) {
                num = solutionIndex(target, array);
            }
            System.out.println(num);
        }
    }

    private static int solutionIndex(int target, List<Integer> array) {
        int num = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = array.get(leftIndex);
        while (leftIndex <= rightIndex) {
            if (sum >= target) {
                num ++;
            }
            if (rightIndex == array.size() - 1) {
                sum -= array.get(leftIndex);
                leftIndex ++;
            } else {
                rightIndex++;
                sum+= array.get(rightIndex);
            }
        }
        return num;
    }


}
