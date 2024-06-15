package com.tegareyn.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Ref LC77
 * @Description 组合
 * @Author Spindrift
 * @Since 2022/12/3 15:06
 * @Version 1.0
 **/
/*
 * 回溯算法模版：
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 *
 *
 * 剪枝优化(有些情况是可以剪枝的)：
 * // i为本次搜索的起始位置；
 * // 范围剪枝优化点：n - (k - path.size()) + 1
 * // 组合 优化代码如下
 * for (int i = startIndex; i <= n - (k - path.size()) + 1; i++)
 */
public class LC77 {

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    public static void backtracking(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }





}
