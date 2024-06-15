package com.tegareyn.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 描述：下一个更大元素 II
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1 。
 * @author mocheng
 * @version 1.0
 * @see LC503
 * @since 2024/3/3 11:03
 **/
public class LC503 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements2(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1;; j++) {
                int index = j %(nums.length);
                if (nums[i] < nums[index]) {
                    answer[i] = nums[index];
                    break;
                }
                if (index == i) {
                    break;
                }
            }
        }
        return answer;
    }

    public static int[] nextGreaterElements2(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < answer.length  * 2; i++) {
            int num = nums[i % answer.length];
            while (!stack.isEmpty() && nums[stack.peek() % answer.length] < num) {
                answer[stack.pop() % answer.length] = num;
            }
            stack.push(i);
        }
        return answer;
    }
}
