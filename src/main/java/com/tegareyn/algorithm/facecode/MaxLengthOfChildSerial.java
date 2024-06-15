package com.tegareyn.algorithm.facecode;

/**
 * 描述：最长连续子序列
 * 有N个正整数组成一个序列。给定整数sum,求长度最长的连续子序列,使他们的和等于sum，返回此子序列的长度,如果没有满足要求的序列,返回-1
 * @author mocheng
 * @version 1.0
 * @see MaxLengthOfChildSerial
 * @since 2024/1/23 23:07
 **/
public class MaxLengthOfChildSerial {

    public static void main(String[] args) {
        String sentence = "1,2,3,1,1,1,1,1,4,2";
        int sum = 5;
        System.out.println(solution(sentence, sum));
    }

    public static int solution(String sentence, int sum) {
        int max = -1;
        if (sentence == null || sentence.length() == 0 || sum <= 0) {
            return max;
        }
        String[] nums = sentence.split(",");
        int left = 0, right = 0;
        int add = Integer.parseInt(nums[left]);
        while (left < nums.length) {
            if (add == sum) {
                max = Math.max(max, right - left + 1);
                if (++left == nums.length || ++right == nums.length) {
                    break;
                }
                add += (Integer.parseInt(nums[right]) - Integer.parseInt(nums[left -1]));
            } else if (add < sum) {
                if (++right == nums.length) {
                    break;
                }
                add += Integer.parseInt(nums[right]);

            } else {
                if (++left == nums.length) {
                    break;
                }
                add -=  Integer.parseInt(nums[left -1]);
            }
        }
        return max;
    }

}
