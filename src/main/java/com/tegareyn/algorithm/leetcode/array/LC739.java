package com.tegareyn.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 描述：每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * @author mocheng
 * @version 1.0
 * @see LC739
 * @since 2024/3/3 10:27
 **/
public class LC739 {

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int days = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                days++;
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = days;
                    break;
                }
            }
        }
        return answer;
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
           int[] item = new int[]{i, temperatures[i]};
            while (!stack.isEmpty() && stack.peek()[1] < item[1]) {
                int[] pop = stack.pop();
                int days = item[0] - pop[0];
                answer[pop[0]] = days;
            }
            stack.push(item);
        }
        return answer;
    }

}
