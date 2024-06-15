package com.tegareyn.algorithm.facecode;

/**
 * 描述：最大总分数
 * 1、给定一个长度为n的整型数组，每个元素代表分数，索引从0开始。
 * 初始总分数为0，依次遍历数组，每次必须根据特定规则更新总分数。
 * 规则：若选择当前元素，则总分数加上该元素值；若不选择当前元素，则总分数还原为三次更新前的总分数（若当前元素索引小于3则将总分数置为0）。
 * 请计算遍历结束后可以得到的最大总分数
 *
 * @author mocheng
 * @version 1.0
 * @see MaxScore
 * @since 2024/2/28 17:20
 **/
public class MaxScore {

    public static void main(String[] args) {
        int[] score = {2,-2,5,3,-10,67,43};
        int[] sumScore = new int[score.length];
        System.out.println(score(score, sumScore));
    }

    // 规则：若选择当前元素，则总分数加上该元素值；
    // 若不选择当前元素，则总分数还原为三次更新前的总分数（若当前元素索引小于3则将总分数置为0）。
    public static int score(int[] score, int[] sumScore) {
        int maxScore = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] < 0) {
                if (i == 0) {
                    sumScore[i] = 0;
                } else if (i <= 3) {
                    sumScore[i] = Math.max(score[i] + sumScore[i - 1], 0);
                } else {
                    sumScore[i] = Math.max(sumScore[i - 1] + score[i], sumScore[i - 3]);
                }
            } else {
                sumScore[i] = (i >= 1 ? sumScore[i - 1] : 0) + score[i];
            }
            maxScore = Math.max(maxScore, sumScore[i]);
        }
        return maxScore;
    }
}
